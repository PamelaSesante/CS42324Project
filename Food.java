package phantasianbistrodemo;

import java.util.ArrayList;


public class Food extends Item{
    private int addedHealth, addedEnergy;
    private static ArrayList<Food> foodList = new ArrayList<>();
    
    public Food(){
    }
    
    public Food(String n, String d, String r, int p,int ah, int ae){
        super(n,d,r,p);
        this.addedHealth = ah;
        this.addedEnergy = ae;
        foodList.add(this);
    }
     
     public Food(String n, String d, String r, int p,int ah, int ae, ArrayList<Object[]> a){
        super(n,d,r,p);
        this.addedHealth = ah;
        this.addedEnergy = ae;
        for(Object[] o : a) {
            Item item = (Item) o[0];
            int qty = (int) o[1];
            this.components.put(item, qty);
        }
        foodList.add(this);
    }
    
    public Food pickRandomFood(){
        Food chosenFood;
        int index = (int)(Math.random() * getFoodList().size());
        chosenFood = foodList.get(index);     
        return chosenFood;
    }
    
    public int getAddedHealth() {
        return addedHealth;
    }
    public void setAddedHealth(int addedHealth) {
        this.addedHealth = addedHealth;
    }
    public int getAddedEnergy() {
        return addedEnergy;
    }
    public void setAddedEnergy(int addedEnergy) {
        this.addedEnergy = addedEnergy;
    }
    public ArrayList<Food> getFoodList() {
        return foodList;
    }
    public void setFoodList(ArrayList<Food> foodList) {
        Food.foodList = foodList;
    }
    
    
}
