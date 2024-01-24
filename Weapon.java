package phantasianbistrodemo;

public class Weapon extends Item{
    private int weight, attackBonus;
    
    public Weapon(String n, String d, String r, int p, int w, int a){
        super(n, d, r, p);
        this.weight = w;
        this.attackBonus = a;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getAttackBonus() {
        return attackBonus;
    }
    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }  
}
