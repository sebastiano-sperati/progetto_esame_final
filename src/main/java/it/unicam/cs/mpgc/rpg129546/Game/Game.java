package it.unicam.cs.mpgc.rpg129546.Game;

import it.unicam.cs.mpgc.rpg129546.Shop.Shop;
import it.unicam.cs.mpgc.rpg129546.Shop.ShopComand;
import it.unicam.cs.mpgc.rpg129546.Shop.ShopSelector;
import it.unicam.cs.mpgc.rpg129546.combat.Battle;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.Enemy;
import it.unicam.cs.mpgc.rpg129546.Show.ShowStock;
import it.unicam.cs.mpgc.rpg129546.Show.ShowInventory;

import java.util.List;
import java.util.Scanner;

public class Game {

    private final List<Hero> eroi;
    private final Shop shop;

    private int floor;
    private ShopSelector selector;
    private ShowStock stockView;
    private ShowInventory inventoryView;
    private EnemyFactory EnemyFacctory;

    public Game(List<Hero> eroi){
        this.eroi=eroi;
        this.shop=new Shop();
        this.floor=1;
    }

    public void Start(){

        while (true){

            System.out.println("===PIANO "+ floor +"===");

            List<Enemy> nemici = EnemyFactory.generate(floor);

            Battle battle = new Battle(eroi,nemici);

            battle.Start();

            if(!battle.heroseAlive()){
                break;
            }

            RewardManager.reward(eroi, nemici, floor);

            shop.refreshStock();

            enterShop();

            floor++;
        }
        System.out.println("GAME OVER");
    }

    private void enterShop(){
        Shop shop = new Shop();

        shop.refreshStock();


        for (int i = 0; i < eroi.size(); i++) {
            boolean exit = false;
            while (!exit) {
                System.out.println(eroi.get(i).getNome() + " - saldo : " + eroi.get(i).getHeroStatusManager().getGold() + "$");
                ShopComand comand = selector.select();
                switch (comand) {
                    case BUY -> {
                        System.out.println("selezionare l'articolo");
                        stockView.showStock(shop.getStock());
                        Scanner sc = new Scanner(System.in);
                        int choice = sc.nextInt();
                        shop.buyItem(eroi.get(i),choice-1);
                    }
                    case SELL -> {
                        System.out.println("selezionare l'oggetto");
                        inventoryView.showInventory(eroi.get(i));
                        Scanner sc = new Scanner(System.in);
                        int choice = sc.nextInt();
                        shop.sellItem(eroi.get(i),choice-1);
                    }
                    case EXIT -> {
                        exit = true;
                    }
                }
            }
        }
    }
}
