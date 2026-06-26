package it.unicam.cs.mpgc.rpg129546.Shop;

import it.unicam.cs.mpgc.rpg129546.Items.Consumables.*;
import it.unicam.cs.mpgc.rpg129546.Equipment.Armor;
import it.unicam.cs.mpgc.rpg129546.Equipment.Equipaggiamento;
import it.unicam.cs.mpgc.rpg129546.Equipment.Rarity;
import it.unicam.cs.mpgc.rpg129546.Equipment.Weapon;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static it.unicam.cs.mpgc.rpg129546.Equipment.WeaponScaling.STR;
import static it.unicam.cs.mpgc.rpg129546.Equipment.WeaponScaling.WIS;

/**
 * contiene tutti i metodi fondamentali per definire e gestire un negozio
 */
public class Shop {

    private final List<GenericItem> catalogo;
    private final List<Stock> stock;

    public Shop(){
        this.catalogo=new ArrayList<>();
        this.stock=new ArrayList<>();

        inizializzaCatalogo();
    }

    /**
     * contiene tutti gli item trovabili nel mondo di gioco, fungendo da catalogo per ogni negozio,
     * che poi  aggiornerà casualmente il proprio stock
     */
    public void inizializzaCatalogo(){
        catalogo.add(new AntiFirePotion());
        catalogo.add(new AntiFrostPotion());
        catalogo.add(new DefensePotion());
        catalogo.add(new HealingPotion());
        catalogo.add(new PoisonKnives());
        catalogo.add(new StaminaPotion());
        catalogo.add(new StrenghtPotion());

        catalogo.add(new Weapon("spada iniziale", Rarity.STARTER,STR));
        catalogo.add(new Weapon("bastone iniziale", Rarity.STARTER,WIS));

        catalogo.add(new Weapon("spada comune", Rarity.COMUNE,STR));
        catalogo.add(new Weapon("bastone comune",Rarity.COMUNE,WIS));

        catalogo.add(new Weapon("spada rara",Rarity.RARO,STR));
        catalogo.add(new Weapon("bastone raro",Rarity.RARO,WIS));

        catalogo.add(new Weapon("spada leggendaria", Rarity.LEGENDARIO,STR));
        catalogo.add(new Weapon("bastone leggendario",Rarity.LEGENDARIO,WIS));

        catalogo.add(new Armor("armatura iniziale",Rarity.STARTER));
        catalogo.add(new Armor("armatura comune",Rarity.COMUNE));
        catalogo.add(new Armor("armatura rara",Rarity.COMUNE));
        catalogo.add(new Armor("armatura leggendaria",Rarity.LEGENDARIO));
    }

    /**
     * ogni volta che si entra in un negozio, viene cancellato lo stock precedente,
     * e vengono creati 5 stand con item randomici, e dove permesso, con una quantità di item randomica per stand
     */
    public void refreshStock(){
        stock.clear();

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            GenericItem item = catalogo.get(random.nextInt(catalogo.size()));
            int qta = item.getShopQta();
            stock.add(new Stock(item,qta));
        }
    }

    public List<Stock> getStock(){return this.stock;}

    /**
     * permette ad un eroe di comprare un item (che viene aggiunto all'inventario come copia),
     * se e solo se l'eroe ha abbastanza soldi per permettersi di acquistarlo,
     * decrementatnndone la quantità nello shop, ed eliminandolo nel caso finisca
     * @param h eroe che effettua l'acquisto
     * @param index indice dell'item che si desidera acquistare
     */
    public void buyItem(Hero h, int index){
        GenericItem item = stock.get(index).getItem().getCopy();

        if(h.getHeroStatusManager().getGold()<item.getPrezzo()){
            System.out.println("denaro insufficiente");
            return;
        }

        h.getHeroStatusManager().subGold(item.getPrezzo());

        if(item instanceof Equipaggiamento){
            if(item instanceof Weapon) {
                h.equipaggiaArma((Weapon) item);
            } else {
                h.equipaggiaArmatura((Armor) item);
            }
        } else {
            h.getInventoryManager().addItem((Item)item);
        }

        stock.get(index).decreaseQta();
        if(stock.get(index).soldOut()) stock.remove(index);

        System.out.println(h.getNome() + "acquista" + item.getNome());
    }

    /**
     * permette ad un eroe di vendere un item presente nel suo inventario
     * @param h eroe venditore
     * @param index indice dell'item da vendere
     */
    public void sellItem(Hero h, int index){
        GenericItem item = h.getInventoryManager().getInventario().get(index);

        h.getHeroStatusManager().addGold(item.getPrezzo()/2);

        h.getInventoryManager().getInventario().remove(index);

        System.out.println(h.getNome() + "vende" + item.getNome());
    }

    public List<GenericItem> getCatalogo(){
        return this.catalogo;
    }
}