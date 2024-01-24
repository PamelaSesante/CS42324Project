package phantasianbistrodemo;

import java.util.ArrayList;

public class Monster extends Entity {
    private int attack, level, droppedGold;
    private Item itemDrop;
    private static ArrayList<Monster> monsterList = new ArrayList<>();

    public Monster(){
    }
    
    public Monster (int l, int a, int g, Item i, String n, int x, int y, int s, int h){
        super(n,y,x,s,h);
        this.attack = a*level;
        this.droppedGold = g*level;
        this.itemDrop = i;
        monsterList.add(this);
    }
    
    public void attack(Player p) throws DeathException{
        try{
        if(this.health<=0){
            throw new DeathException();
        }
        
        int plyH = p.getHealth();
        plyH -= this.attack;
        p.setHealth(plyH);
        System.out.println(this.name+ " attacked " + p.getName());
        
        }
        catch(DeathException de){
            this.death();
            p.setMoney(p.getMoney() + this.droppedGold);
            p.getInventory().put(this.itemDrop, 1);
        }
    }
    
    public void death(){
        System.out.println(this.name + " died.");
        monsterList.remove(this);
    }
    
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getDroppedGold() {
        return droppedGold;
    }
    public void setDroppedGold(int droppedGold) {
        this.droppedGold = droppedGold;
    }
    public Item getItemDrop() {
        return itemDrop;
    }
    public void setItemDrop(Item itemDrop) {
        this.itemDrop = itemDrop;
    }
    
    
}
