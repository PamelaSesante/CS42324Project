package phantasianbistrodemo;

import java.util.ArrayList;
import java.util.HashMap;

public class Person extends Entity{
    protected HashMap<Item, Integer> inventory = new HashMap<>();
    protected ArrayList<Order> orderList = new ArrayList<>();
    
    public Person(){
    }
    
    public Person(String n, int y, int x){
        super(n,y,x, 5 ,100);
        HashMap<Item, Integer> inventory = new HashMap<>();
        ArrayList<Order> orderList = new ArrayList<>();
    }

    public HashMap<Item, Integer> getInventory() {
        inventory.values().removeIf(f -> f == 0f);
        return inventory;
    }
    public void setInventory(HashMap<Item, Integer> inventory) {
        this.inventory = inventory;
    }
    
     public void printInventory(){
        inventory = this.getInventory();
        System.out.println("\n" + this.getName() + "'s inventory:");
        for(HashMap.Entry<Item, Integer> entry : inventory.entrySet()){
            String itemName = entry.getKey().getName();
            int qty = entry.getValue();
            System.out.println(itemName + " = " + qty);
        }
        System.out.println();
    }
     
    public ArrayList<Order> getOrderList() {
        return orderList;
    }
    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}
