package it.unicam.cs.mpgc.rpg129546.Ui.Controller;

import it.unicam.cs.mpgc.rpg129546.Game.Game;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Shop.Shop;
import it.unicam.cs.mpgc.rpg129546.Shop.Stock;
import it.unicam.cs.mpgc.rpg129546.Items.Consumables.Item;
import it.unicam.cs.mpgc.rpg129546.Ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.util.List;

public class ShopController {

    private Game game;
    private Shop shop;
    private List<Hero> heroes;

    private int currentHeroIndex = 0;

    @FXML private Label Name;
    @FXML private Label Armor;
    @FXML private Label Weapon;

    @FXML private FlowPane displayPane;

    @FXML
    public void initialize() {
    }

    public void setGame(Game game) {
        this.game = game;
        this.shop = game.getShop();
        this.heroes = game.getHeroes();

        showCurrentHero();
        showStock();
    }

    private Hero getCurrentHero() {
        return heroes.get(currentHeroIndex);
    }

    private void showCurrentHero() {
        Hero hero = getCurrentHero();

        Name.setText(hero.getNome());
        Armor.setText("Armatura: " + hero.getArmatura().getNome());
        Weapon.setText("Arma: " + hero.getArma().getNome());
    }

    @FXML
    private void onBuy() {
        showStock();
    }

    @FXML
    private void onSell() {
        showInventory();
    }

    @FXML
    private void onExit() {
        goToNextHeroOrBattle();
    }

    private void showStock() {
        displayPane.getChildren().clear();

        for (int i = 0; i < shop.getStock().size(); i++) {
            Stock stockItem = shop.getStock().get(i);
            int index = i;

            Button button = new Button(stockItem.getItem().getNome() + "\nPrezzo: " + stockItem.getItem().getPrezzo() + "\nQta: " + stockItem.getQta());

            button.setOnAction(event -> {
                shop.buyItem(getCurrentHero(), index);
                showCurrentHero();
                showStock();
            });

            displayPane.getChildren().add(button);
        }
    }

    private void showInventory() {
        displayPane.getChildren().clear();

        Hero hero = getCurrentHero();

        if (hero.getInventoryManager().getInventario().isEmpty()) {
            displayPane.getChildren().add(new Label("Inventario vuoto"));
            return;
        }

        for (int i = 0; i < hero.getInventoryManager().getInventario().size(); i++) {
            Item item = hero.getInventoryManager().getInventario().get(i);
            int index = i;

            Button button = new Button(item.getNome() + "\nQta: " + item.getQta() + "\nVendi: " + item.getPrezzo() / 2);

            button.setOnAction(event -> {
                shop.sellItem(hero, index);
                showInventory();
            });

            displayPane.getChildren().add(button);
        }
    }

    private void goToNextHeroOrBattle() {
        currentHeroIndex++;

        if (currentHeroIndex < heroes.size()) {
            showCurrentHero();
            showStock();
            return;
        }

        game.startNewBattle();
        SceneManager.showBattle(game);
    }
}