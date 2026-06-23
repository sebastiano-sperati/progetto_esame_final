package it.unicam.cs.mpgc.rpg129546.Ui.Controller;

import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Combat.Battle;
import it.unicam.cs.mpgc.rpg129546.Game.Game;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.TargetType;
import it.unicam.cs.mpgc.rpg129546.Ui.SceneManager;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteAnimation;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BattleController {

    private Game game;
    private Battle battle;

    private Action selectedAction;

    private final List<SpriteAnimation> animations = new ArrayList<>();

    private final Map<Entity, ImageView> entitySprites = new HashMap<>();
    private final Map<Entity, SpriteAnimation> activeAnimations = new HashMap<>();

    @FXML private ImageView DpsSprite;
    @FXML private Label DpsName;
    @FXML private Label DpsHp;
    @FXML private Label DpsAp;

    @FXML private ImageView TankSprite ;
    @FXML private Label TankName;
    @FXML private Label TankHp;
    @FXML private Label TankAp;

    @FXML private ImageView MageSprite;
    @FXML private Label MageName;
    @FXML private Label MageHp;
    @FXML private Label MageAp;

    @FXML private ImageView HealerSprite;
    @FXML private Label HealerName;
    @FXML private Label HealerHp;
    @FXML private Label HealerAp;

    @FXML private FlowPane EnemyPane;
    @FXML private VBox ActionSelectionPane;
    @FXML private FlowPane FinalSelectionPane;
    @FXML private Text LogPane;

    public void setGame(Game game) {
        this.game = game;
        this.battle = game.getCurrentBattle();

        registerheroSprites();
        loadHeroAnimations();

        refresh();
        loadActionMenu();

        writeLog("Battaglia iniziata. Tocca a " + battle.getCurrentHero().getNome());
    }

    private void registerheroSprites(){
        var heroes = battle.getHeroes();

        entitySprites.put(heroes.get(0), DpsSprite);
        entitySprites.put(heroes.get(1), TankSprite);
        entitySprites.put(heroes.get(2), MageSprite);
        entitySprites.put(heroes.get(3), HealerSprite);
        setUpSpriteView(DpsSprite);
        setUpSpriteView(TankSprite);
        setUpSpriteView(MageSprite);
        setUpSpriteView(HealerSprite);

    }

    private void loadActionMenu() {
        ActionSelectionPane.getChildren().clear();

        Button abilities = new Button("Abilità");
        Button items = new Button("Oggetti");
        Button squad = new Button("Squadra");

        abilities.setOnAction(e -> showAbilities());
        items.setOnAction(e -> showItems());
        squad.setOnAction(e -> showSquad());

        ActionSelectionPane.getChildren().addAll(abilities, items, squad);
    }

    private void showAbilities() {
        FinalSelectionPane.getChildren().clear();

        Hero hero = battle.getCurrentHero();

        if (hero == null) {
            return;
        }

        for (Action action : hero.getAzioni()) {
            Button button = new Button(action.getName());

            boolean unusable = hero.getStatusManager().getAp() < action.getCost();

            if (action instanceof Ultimate ultimate && !ultimate.isReady()) {
                unusable = true;
            }

            button.setDisable(unusable);

            button.setOnAction(e -> {
                selectedAction = action;

                if (action.getTargetType() == TargetType.SELF) {
                    executeAction(hero);
                } else {
                    showTargetsFor(action);
                }
            });

            FinalSelectionPane.getChildren().add(button);
        }
    }

    private void showTargetsFor(Action action) {
        FinalSelectionPane.getChildren().clear();

        if (action.getTargetType() == TargetType.ENEMY) {
            for (Enemy enemy : battle.getEnemies()) {
                if (!enemy.getStatusManager().isAlive()) {
                    continue;
                }

                Button button = new Button(enemy.getNome());
                button.setOnAction(e -> executeAction(enemy));
                FinalSelectionPane.getChildren().add(button);
            }
        }

        if (action.getTargetType() == TargetType.ALLY) {
            for (Hero hero : battle.getHeroes()) {
                if (!hero.getStatusManager().isAlive()) {
                    continue;
                }

                Button button = new Button(hero.getNome());
                button.setOnAction(e -> executeAction(hero));
                FinalSelectionPane.getChildren().add(button);
            }
        }
    }

    private void executeAction(Entity target) {
        Hero source = battle.getCurrentHero();

        AnimationType animationType = chooseAnimation(selectedAction);

        Action actionToExecute = selectedAction;

        playAnimation(source, animationType, false, () -> {

            battle.executeHeroAction(actionToExecute, target);

            if (source.getStatusManager().isAlive()) {
                playAnimation(source, AnimationType.IDLE, true, null);
            }

            playTargetReaction(target, () -> {
                writeLog("Azione eseguita.");
                afterPlayerAction();
            });
        });
    }

    private AnimationType chooseAnimation(Action selectedAction){
       if(selectedAction instanceof Ultimate) return AnimationType.ULTIMATE;
       switch (selectedAction.getAttackType()){
           case MELE -> {
               return AnimationType.MELEATTACK;
           }
           case MAGIC -> {
               return AnimationType.MAGICATTACK;
           }
           case SELFBUFF -> {
               return AnimationType.USEITEM;
           }
       }
        return null;
    }

    private void playTargetReaction(Entity target, Runnable onFinished) {

        if (!entitySprites.containsKey(target)) {
            onFinished.run();
            return;
        }

        if (!target.getStatusManager().isAlive()) {
            playAnimation(target, AnimationType.DEATH, false, onFinished);
            return;
        }

        playAnimation(target, AnimationType.HIT, false, () -> {
            playAnimation(target, AnimationType.IDLE, true, null);
            onFinished.run();
        });
    }

    private void showItems() {
        FinalSelectionPane.getChildren().clear();

        Hero hero = battle.getCurrentHero();

        if (hero == null) {
            return;
        }

        hero.getInventoryManager().getInventario().forEach(item -> {Button button = new Button(item.getNome() + " x" + item.getQta());

            button.setOnAction(e -> {
                selectedAction = null;

                if (item.getTipo().name().equals("POTION")) {
                    battle.useItem(item, hero);
                    afterPlayerAction();
                } else {
                    showItemTargets(item);
                }
            });

            FinalSelectionPane.getChildren().add(button);
        });
    }

    private void showItemTargets(it.unicam.cs.mpgc.rpg129546.Items.Consumables.Item item) {
        FinalSelectionPane.getChildren().clear();

        for (Enemy enemy : battle.getEnemies()) {
            if (!enemy.getStatusManager().isAlive()) {
                continue;
            }

            Button button = new Button(enemy.getNome());
            button.setOnAction(e -> {
                battle.useItem(item, enemy);
                afterPlayerAction();
            });

            FinalSelectionPane.getChildren().add(button);
        }
    }

    private void showSquad() {
        FinalSelectionPane.getChildren().clear();

        for (Hero hero : battle.getHeroes()) {
            Label label = new Label(hero.getNome() + " | LVL " + hero.getStatusManager().getLvl()+ " | HP " + hero.getStatusManager().getHp() + "/" + hero.getStatsManager().getScaledMaxHP());

            FinalSelectionPane.getChildren().add(label);
        }
    }

    private void afterPlayerAction() {
        selectedAction = null;
        refresh();

        if (battle.isFinished()) {
            finishBattle();
            return;
        }

        if (battle.allHeroesPlayed()) {
            battle.executeEnemyTurn();
            refresh();

            if (battle.isFinished()) {
                finishBattle();
                return;
            }

            battle.startNewRound();
            writeLog("Nuovo turno. Tocca a " + battle.getCurrentHero().getNome());
        } else {
            writeLog("Tocca a " + battle.getCurrentHero().getNome());
        }

        FinalSelectionPane.getChildren().clear();
    }

    private void finishBattle() {
        if (battle.heroesWon()) {
            game.finishBattle();
            game.nextFloor();

            if (game.isGameWon()) {
                SceneManager.showGameOver();
            } else {
                game.getShop().refreshStock();
                SceneManager.showReward(game);
            }
        }
    }

    private void refresh() {
        loadHeroes();
        loadEnemies();
    }

    private void loadHeroes() {
        if (battle == null) {
            return;
        }

        var heroes = battle.getHeroes();

        setHeroLabels(heroes.get(0),DpsName, DpsHp, DpsAp);
        setHeroLabels(heroes.get(1),TankName, TankHp, TankAp);
        setHeroLabels(heroes.get(2),MageName, MageHp, MageAp);
        setHeroLabels(heroes.get(3),HealerName, HealerHp, HealerAp);
    }


    private void setHeroLabels(Hero hero, Label name, Label hp, Label ap) {
        name.setText(hero.getNome());
        hp.setText("HP " + hero.getStatusManager().getHp() + "/" + hero.getStatsManager().getScaledMaxHP());
        ap.setText("AP " + hero.getStatusManager().getAp() + "/" + hero.getStatsManager().getScaledMaxAp());
    }

    private void loadHeroAnimations() {
        for (Hero hero : battle.getHeroes()) {
            playAnimation(hero, AnimationType.IDLE, true, null);
        }
    }

    private void playAnimation(Entity entity, AnimationType type, boolean loop, Runnable onFinished) {
        ImageView sprite = entitySprites.get(entity);

        if (sprite == null) {
            if (onFinished != null) {
                onFinished.run();
            }
            return;
        }

        SpriteAnimation oldAnimation = activeAnimations.get(entity);

        if (oldAnimation != null) {
            oldAnimation.stop();
        }

        SpriteData data = entity.getIdleSpriteData(type);

        var stream = getClass().getResourceAsStream(data.getPath());

        if (stream == null) {
            System.out.println("Sprite non trovato: " + data.getPath());

            if (onFinished != null) {
                onFinished.run();
            }

            return;
        }

        sprite.setImage(new Image(stream));

        if (entity instanceof Hero) {
            sprite.setScaleX(-1);
        } else {
            sprite.setScaleX(1);
        }

        SpriteAnimation animation = new SpriteAnimation(sprite, data.getFrameWidth(), data.getFrameHeight(), data.getFrameCount(), data.getColumns(), data.getMillis(),                loop, () -> {
                    activeAnimations.remove(entity);

                    if (onFinished != null) {
                        onFinished.run();
                    }
                }
        );

        activeAnimations.put(entity, animation);
        animation.play();
    }

    public void setUpSpriteView(ImageView sprite){
        sprite.setFitWidth(120);
        sprite.setFitHeight(120);
        sprite.setPreserveRatio(true);
    }
    private void loadEnemies() {
        EnemyPane.getChildren().clear();

        for (Enemy enemy : battle.getEnemies()) {
            if (!enemy.getStatusManager().isAlive()) {
                continue;
            }

            Button button = new Button(enemy.getNome() + "\nHP " + enemy.getStatusManager().getHp() + "/" + enemy.getStatsManager().getScaledMaxHP());

            EnemyPane.getChildren().add(button);
        }
    }
    @FXML
    private void onAbilitiesClick() {
        System.out.println("ABILITÀ");
    }

    @FXML
    private void onInventoryClick() {
        System.out.println("OGGETTI");
    }

    @FXML
    private void onStatsClick() {
        System.out.println("SQUADRA");
    }

    private void writeLog(String text) {
        LogPane.setText(text);
    }
}