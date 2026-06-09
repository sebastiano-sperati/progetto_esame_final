package it.unicam.cs.mpgc.rpg129546.Game;

import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Armor;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.ArmorSave;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Weapon;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.WeaponSave;
import it.unicam.cs.mpgc.rpg129546.Items.Consumabili.Item;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.ItemSave;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveData;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveManager;
import it.unicam.cs.mpgc.rpg129546.Shop.Shop;
import it.unicam.cs.mpgc.rpg129546.Shop.ShopComand;
import it.unicam.cs.mpgc.rpg129546.Shop.ShopSelector;
import it.unicam.cs.mpgc.rpg129546.combat.Battle;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.HeroSave;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.Enemy;
import it.unicam.cs.mpgc.rpg129546.Show.ShowStock;
import it.unicam.cs.mpgc.rpg129546.Show.ShowInventory;

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

    public Game(List<Hero> eroi){
        this.eroi=eroi;
        this.shop=new Shop();
        this.floor=1;
        this.selector= new ShopSelector();
        this.stockView=new ShowStock();
        this.inventoryView = new ShowInventory();
        this.EnemyFacctory = new EnemyFactory();
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
            }

            if(!battle.heroseAlive()){
                break;
            }

            RewardManager.reward(eroi, nemici, floor);

            shop.refreshStock();

            enterShop();

            floor++;


            System.out.println("salvare e uscire?");
            System.out.println("1-SI         0-NO");
            
            int choice = 0;
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
    public List<Hero> getHeroes() {
        return eroi;
    }

    public void saveGame() {

        try {

            List<HeroSave> heroSaves = new ArrayList<>();

            for (Hero hero : eroi) {

                HeroSave save = new HeroSave();

                save.type = hero.getClass().getSimpleName();
                save.nome = hero.getNome();

                save.hp = hero.getStatusManager().getHp();
                save.maxHp = hero.getStatusManager().getMaxHp();

                save.ap = hero.getStatusManager().getAp();
                save.maxAp = hero.getStatusManager().getMaxAp();

                save.atk = hero.getAtk();
                save.def = hero.getDif();
                save.wis = hero.getWis();

                save.lvl = hero.getHeroStatusManager().getLvl();
                save.gold = hero.getHeroStatusManager().getGold();

                save.xp = hero.getHeroStatusManager().getXp();
                save.sogliaLvlUp = hero.getHeroStatusManager().getSogliaLvlUp();

                Weapon w = hero.getArma();

                save.weapon = new WeaponSave();
                save.weapon.nome = w.getNome();
                save.weapon.rarity = String.valueOf(w.getRarity());
                save.weapon.scaling = String.valueOf(w.getScaling());

                Armor a = hero.getArmatura();

                save.armor = new ArmorSave();
                save.armor.nome = a.getNome();
                save.armor.rarity = a.getRarity().name();

                save.inventory = new ArrayList<>();

                for (Item i : hero.getInventoryManager().getInventario()) {

                    ItemSave is = new ItemSave();

                    is.nome = i.getNome();
                    is.qta = i.getQta();

                    save.inventory.add(is);
                }


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
