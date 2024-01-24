package phantasianbistrodemo;

import java.util.ArrayList;
import java.util.HashMap;

public class Item implements Interactable {
    protected String name, description, rarity;
    protected int price;
    protected HashMap<Item, Integer> components = new HashMap<>();
    protected static ArrayList<Item> itemList = new ArrayList<>();

    public Item(){
    }
    
    public Item (String n, String d, String r, int p){
        this.name = n;
        this.description = d;
        this.rarity = r;
        this.price = p;
        itemList.add(this);
    }
    
       public Item (String n, String d, String r, int p, ArrayList<Object[]> a) {
        this.name = n;
        this.description = d;
        this.rarity = r;
        this.price = p;
        for(Object[] o : a) {
            Item item = (Item) o[0];
            int qty = (int) o[1];
            this.components.put(item, qty);
        }
        itemList.add(this);
    }
       
    @Override
    public void interact() {
       System.out.println(this.description);
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public HashMap<Item, Integer> getComponents() {
        return components;
    }
    public void setComponents(HashMap<Item, Integer> components) {
        this.components = components;
    }
    
}
