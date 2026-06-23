package it.unicam.cs.mpgc.rpg129546.Ui.Controller;

import it.unicam.cs.mpgc.rpg129546.Game.Game;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class RewardController {

    private Game game;
    private int xpGained;
    private int goldGained;

    @FXML private Label title;

    @FXML private Label dpsName;
    @FXML private Label dpsXpgained;
    @FXML private Label dpsGoldGained;
    @FXML private Label dpsLvlUp;

    @FXML private Label tankName;
    @FXML private Label tankXpgained;
    @FXML private Label tankGoldGained;
    @FXML private Label TankLvlUp;

    @FXML private Label Magename;
    @FXML private Label mageXpGained;
    @FXML private Label MageGoldGained;
    @FXML private Label MageLvlUP;

    @FXML private Label HealerName;
    @FXML private Label HealerXpGained;
    @FXML private Label HealerGoldGained;
    @FXML private Label HealerLvlUp;

    @FXML private Label title2;

    @FXML private Button yes;
    @FXML private Button no;

    public void setGame(Game game, int xpGained, int goldGained) {
        this.game = game;
        this.xpGained = xpGained;
        this.goldGained = goldGained;

        refresh();
    }

    private void refresh() {
        title.setText("RICOMPENSE OTTENUTE");
        title2.setText("Vuoi salvare la partita?");

        yes.setText("Salva");
        no.setText("Continua");

        List<Hero> heroes = game.getHeroes();

        setHeroReward(heroes.get(0), dpsName, dpsXpgained, dpsGoldGained, dpsLvlUp);

        setHeroReward(heroes.get(1), tankName, tankXpgained, tankGoldGained, TankLvlUp);

        setHeroReward(heroes.get(2), Magename, mageXpGained, MageGoldGained, MageLvlUP);

        setHeroReward(heroes.get(3), HealerName,HealerXpGained, HealerGoldGained, HealerLvlUp);
    }

    private void setHeroReward(Hero hero, Label name, Label xp, Label gold, Label lvl) {
        name.setText(hero.getNome());
        xp.setText("XP +" + xpGained);
        gold.setText("Oro +" + goldGained);
        lvl.setText("Livello attuale: " + hero.getStatusManager().getLvl());
    }

    @FXML
    private void onSave() {
        game.saveGame();
        SceneManager.showMenu();
    }

    @FXML
    private void onContinue() {
        game.getShop().refreshStock();
        SceneManager.showShop(game);
    }
}