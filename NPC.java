package phantasianbistrodemo;

import java.util.ArrayList;
import java.util.Collections;

public class NPC extends Person implements Interactable{
    private int friendship, orderNumber = 1; 
    private Item dislikedGift, likedGift;
    private ArrayList<String> dialog = new ArrayList();
    private static ArrayList<NPC> NPClist = new ArrayList<>();
    
    public NPC(){
    }
    
    public NPC (String n, int y, int x, String d1, String d2, String d3, String d4, String d5, String d6, Item dG, Item lG){
        super(n,y,x);
        this.dislikedGift = dG;
        this.likedGift = lG;
        Collections.addAll(dialog, d1, d2, d3, d4, d5, d6);
        NPClist.add(this);
    }

    @Override
    public void interact() {
        int i = (int)(Math.random() * 3);
        System.out.println(this.name + ": " + dialog.get(i));
        friendship += 10;
    }
    
    public void acceptGift(Item g) throws UnsuitableGiftException {
        if(g == likedGift){
            System.out.println(this.name + ": " + dialog.get(3));
            this.friendship += 20;
        }
        else if(g instanceof Weapon){
            throw new UnsuitableGiftException("You cannot gift this to " + this.name);
        }
        else if(g == dislikedGift){
            System.out.println(this.name + ": " + dialog.get(4));
            this.friendship -= 20;
        }
        else {
            System.out.println(this.name + ": " + dialog.get(5));
            this.friendship += 5;
        }         
    }
    
    public void placeOrder(){
        Order o = new Order(orderNumber); 
        this.orderList.add(o);
        orderNumber++;
        this.printOrder(o);
    }
    
    public void printOrder(Order o){
        System.out.println(this.name + "'s order #" + o.getNpcOrderNumber() + ":\n" +
        "Dish required: " + o.getDishRequired().getName() + "\n" +
        "Quantity: " + o.getQuantityFood() + "\n" +
        "Payment: " + o.getPrice() + "\n");
    }
    
    public void removeOrder(Order o){
        this.orderList.remove(o);
        System.out.println(this.name + "'s #" + o.getNpcOrderNumber() + " order has been completed!");
    }
    
    public void printOrderList(){
        System.out.println("\n" + this.name + "'s order list: ");
        for(Order ord : this.orderList){
            printOrder(ord); 
        }
    }
    
    public int findOrder(int npcOrderNumber) throws IndexNotFoundException {
       int index = 0;
       boolean found = false;

        for(int i = 0; i < this.orderList.size(); i++){
            if(npcOrderNumber == this.orderList.get(i).getNpcOrderNumber()){
                index = i;
                found = true;
            }
        }    
        if(!found){
            throw new IndexNotFoundException("No such order exists.");
        }
        
        return index;
    }
    
    public int getFriendship() {
        return friendship;
    }
    public void setFriendship(int friendship) {
        this.friendship = friendship;
    }
    public Item getDislikedGift() {
        return dislikedGift;
    }
    public void setDislikedGift(Item dislikedGift) {
        this.dislikedGift = dislikedGift;
    }
    public Item getLikedGift() {
        return likedGift;
    }
    public void setLikedGift(Item likedGift) {
        this.likedGift = likedGift;
    }
    public ArrayList<String> getDialog() {
        return dialog;
    }
    public void setDialog(ArrayList<String> dialog) {
        this.dialog = dialog;
    }

    
}
