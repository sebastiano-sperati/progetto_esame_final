package it.unicam.cs.mpgc.rpg129546.Game;

import it.unicam.cs.mpgc.rpg129546.Game.Factory.EnemyFactory;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.*;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveData;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveManager;
import it.unicam.cs.mpgc.rpg129546.Shop.Shop;
import it.unicam.cs.mpgc.rpg129546.Shop.ShopComand;
import it.unicam.cs.mpgc.rpg129546.Shop.ShopSelector;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Combat.Battle;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Show.ShowStock;
import it.unicam.cs.mpgc.rpg129546.Show.ShowInventory;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.GenericSaver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final List<Hero> eroi;
    public SaveData saveData;
    private Shop shop;

    private int floor;
    public ShopSelector selector;
    public ShowStock stockView;
    public ShowInventory inventoryView;
    public EnemyFactory EnemyFacctory;
    public GenericSaver saver;

    public Game(List<Hero> eroi){
        this.eroi=eroi;
        this.shop=new Shop();
        this.floor=1;
        this.selector= new ShopSelector();
        this.stockView=new ShowStock();
        this.inventoryView = new ShowInventory();
        this.EnemyFacctory = new EnemyFactory();
        this.saver = new GenericSaver();
        this.shop = new Shop();

    }

    public void Start(){

        while (floor <= 10){

            System.out.println("===PIANO "+ floor +"===");

            List<Enemy> nemici = EnemyFactory.generate(floor);

            Battle battle = new Battle(eroi,nemici);

            battle.Start();

            for(Hero h : eroi){
                h.getEffectManager().getEffects().clear();
                for(Action a : h.getAzioni()){
                    if(a instanceof Ultimate){
                        ((Ultimate) a).resetCharge();
                    }
                }
            }

            if(!battle.heroseAlive()){
                break;
            }

            RewardManager.reward(eroi, nemici, floor);

            enterShop();

            floor++;

            System.out.println("salvare e uscire?");
            System.out.println("1-SI         altro-NO");
            
            int choice;
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            
            if(choice==1) {
                saveGame();
                return;
            }
        }
        System.out.println("GAME OVER");
    }

    private void enterShop(){

        shop.refreshStock();


        for (int i = 0; i < eroi.size(); i++) {
            boolean exit = false;
            while (!exit) {
                System.out.println(eroi.get(i).getNome() + " - saldo : " + eroi.get(i).getHeroStatusManager().getGold() + "$");
                ShopComand comand = selector.select();
                switch (comand) {
                    case BUY -> {
                        while (true) {
                            System.out.println("selezionare l'articolo");
                            stockView.showStock(shop.getStock());
                            Scanner sc = new Scanner(System.in);
                            int choice = sc.nextInt();
                            if ((choice - 1) >= 0 && (choice - 1) <= shop.getStock().size()) {
                                shop.buyItem(eroi.get(i), choice - 1);
                                break;
                            }
                            System.out.println("selezione non valida");
                        }
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


    public void saveGame() {

        try {

            List<HeroSave> heroSaves = new ArrayList<>();

            for (Hero hero : eroi) {

                HeroSave save = new HeroSave();

                saver.GenericSaver(save,hero);

                heroSaves.add(save);
            }

            SaveData data = new SaveData(heroSaves, floor);
            SaveManager.save(data);

            System.out.println("Partita salvata!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void setFloor(int floor){
        this.floor = floor;
    }
}
