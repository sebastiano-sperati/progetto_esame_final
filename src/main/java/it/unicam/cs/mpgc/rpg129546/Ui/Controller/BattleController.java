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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BattleController {

    private Game game;
    private Battle battle;

    private Action selectedAction;

    @FXML private Button dpsName;
    @FXML private Label DpsLvl1;
    @FXML private Label DpsHp1;
    @FXML private Label DpsAp1;

    @FXML private Button TankName;
    @FXML private Label TankLvl1;
    @FXML private Label TankHp1;
    @FXML private Label TankAp1;

    @FXML private Button MageName;
    @FXML private Label MageLvl1;
    @FXML private Label MageHp1;
    @FXML private Label MageAp1;

    @FXML private Button HEalerName;
    @FXML private Label HealerLvl1;
    @FXML private Label HealerHp1;
    @FXML private Label HealerAp1;

    @FXML private FlowPane EnemyPane;
    @FXML private VBox ActionSelectionPane;
    @FXML private FlowPane FinalSelectionPane;
    @FXML private Text LogPane;

    public void setGame(Game game) {
        this.game = game;
        this.battle = game.getCurrentBattle();
        refresh();
        loadActionMenu();
        writeLog("Battaglia iniziata. Tocca a " + battle.getCurrentHero().getNome());
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
        battle.executeHeroAction(selectedAction, target);

        writeLog("Azione eseguita.");

        afterPlayerAction();
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
                SceneManager.showShop(game);
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

        setHeroLabels(heroes.get(0), dpsName, DpsLvl1, DpsHp1, DpsAp1);
        setHeroLabels(heroes.get(1), TankName, TankLvl1, TankHp1, TankAp1);
        setHeroLabels(heroes.get(2), MageName, MageLvl1, MageHp1, MageAp1);
        setHeroLabels(heroes.get(3), HEalerName, HealerLvl1, HealerHp1, HealerAp1);
    }

    private void setHeroLabels(Hero hero, Button name, Label lvl, Label hp, Label ap) {
        name.setText(hero.getNome());
        lvl.setText("LVL " + hero.getStatusManager().getLvl());
        hp.setText("HP " + hero.getStatusManager().getHp() + "/" + hero.getStatsManager().getScaledMaxHP());
        ap.setText("AP " + hero.getStatusManager().getAp() + "/" + hero.getStatsManager().getScaledMaxAp());
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