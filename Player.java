package phantasianbistrodemo;

import java.util.HashMap;

public class Player extends Person {
    private Weapon weapon;
    private int money, energy, attack;

    public Player(){
    }
    
    public Player(String n, int y, int x, Weapon w){
        super(n,y,x);
        this.speed = this.speed - w.getWeight();
        this.weapon = w;
        this.money = 0;
        this.energy = 100;
        this.attack = 5 + w.getAttackBonus();
    }
    
    public void interact(Interactable i){
        i.interact();
    }
    
    public void gift(NPC n, Item g){
        try{
        if(inventory.containsKey(g)){
             int qty = inventory.get(g);
             qty -= 1;
             inventory.put(g, qty);
             
             try {
             n.acceptGift(g);
             }
             catch(UnsuitableGiftException uge){
                 System.out.println(uge.getMessage());
             }
        }
        else if(!inventory.containsKey(g)){
            throw new UnavailableInInventoryException("You have no " + g.getName() + " in your inventory.");
        }
        }
        catch(UnavailableInInventoryException uiie){
            System.out.println(uiie.getMessage());
        }
    }
    
    public void cook(Food f){
        
        if(f.getComponents().isEmpty()){
            System.out.println( f.getName() + " cannot be cooked. It can only be gathered from The Forest.");
        }
        else{
         boolean completeIng = false;  
          
         for(HashMap.Entry<Item, Integer> entry : f.getComponents().entrySet()){
             Item item = entry.getKey();
             int qty = entry.getValue();
             int playerQty = 0;
             
             try{
             if(this.inventory.containsKey(item) && this.inventory.get(item)>=qty){
                 playerQty = inventory.get(item) - qty;  
                 inventory.put(item,playerQty);
                 completeIng = true;
             }
             else{
               int missing = qty - playerQty;
               throw new UnavailableInInventoryException("You do not have enough " + item.getName() + " in your inventory. Missing: " + missing); 
             }
             }
             catch(UnavailableInInventoryException uiie){
                 System.out.println(uiie.getMessage());
             }
            }
         
         if(completeIng){
         try{
               int foodQty = this.inventory.get(f);
               foodQty++;
               this.inventory.put(f, foodQty);
               System.out.println("Succesfully cooked 1 " +  f.getName());
            }
            catch(NullPointerException npe){
               this.inventory.put(f, 1);
            }
            System.out.println("Succesfully cooked 1 " +  f.getName());
        }
        }
    }
    
    public void completeOrder(NPC npc, int oNum) throws NullPointerException, ArrayIndexOutOfBoundsException{
        try{
        int i = npc.findOrder(oNum);
        Order o = npc.getOrderList().get(i);
        Food reqDish = o.getDishRequired();
        int qtyOrder = o.getQuantityFood();
        
        try{
        int playerQty = inventory.get(reqDish);
        if(this.inventory.containsKey(reqDish) && this.inventory.get(reqDish)>=qtyOrder){
            npc.removeOrder(o);
            playerQty -= qtyOrder; 
            inventory.put(reqDish,playerQty);
            this.money += o.getPrice();
            System.out.println("You got paid " + o.getPrice() + " coins. Current balance: " + this.money);
        }
        else{
            int missing = qtyOrder - playerQty;
            System.out.println("You do not have " + reqDish.getName() + " in your inventory. Missing: " + missing);
        }
        }
        catch(NullPointerException npe){
            System.out.println("You do not have " + reqDish.getName() + " in your inventory.");
        }
        }
        catch(ArrayIndexOutOfBoundsException | IndexNotFoundException e){
            System.out.println("No such order exists.");
        }
    }
    
    public void sell(Item i, int qty) throws NullPointerException, UnavailableInInventoryException{
       try{
           if(!this.inventory.containsKey(i) || this.inventory.get(i)<qty){
               int missing = qty - this.inventory.get(i);
               throw new UnavailableInInventoryException("You do not have enough " + i.getName() + " in your inventory. Missing: " + missing);
           }
           else{
               int playerQty = this.inventory.get(i) - qty;  
               this.inventory.put(i,playerQty);
               int payment = i.getPrice() * qty;
               this.setMoney(this.getMoney() + payment);
               System.out.println("You sold " + qty + " " + i.getName());
           }
       }
       catch(NullPointerException npe){
            System.out.println("You do not have " + i.getName() + " in your inventory.");
        }
       catch(UnavailableInInventoryException uiie){
           System.out.println(uiie.getMessage());
       }
    }
    
    public void buy(Item i, int qty) throws NotEnoughMoneyException {
        try{
        int bill = i.getPrice() * qty;
        if(this.money <= bill){
            throw new NotEnoughMoneyException("You do not have enough money.");
        }
        else{
            this.inventory.put(i, qty);
            this.money -= bill;
            System.out.println("You bought " + qty + " " + i.getName() + ". Balance: " + this.money);
        }
        }
        catch(NotEnoughMoneyException neme){
            System.out.println(neme.getMessage());
        }
    }
    
    public void consume(Food f, int qty){
        try{
            if(!this.inventory.containsKey(f) || this.inventory.get(f)<qty){
               int missing = qty - this.inventory.get(f);
               throw new UnavailableInInventoryException("You do not have enough " + f.getName() + " in your inventory. Missing: " + missing);
           }
           else{
               int playerQty = this.inventory.get(f) - qty;  
               this.inventory.put(f,playerQty);
               this.health += f.getAddedHealth() * qty;
               this.energy += f.getAddedEnergy() * qty;
               System.out.println("You consumed " + qty + " " + f.getName() + ".\nCurrent health: " + this.health + "\nCurrent energy: " + this.energy);
           }
        }
        catch(UnavailableInInventoryException uiie){
          System.out.println(uiie.getMessage());
        }
    }
    
    public void attack(Monster m) throws DeathException{
        try{
        if(this.health<=0){
            throw new DeathException();
        }
        
        int mH = m.getHealth();
        mH -= this.attack;
        m.setHealth(mH);
        System.out.println(this.name+ " attacked " + m.getName());
        
        }
        catch(DeathException de){
            this.death();
        }
    }
    
    public void death(){
        System.out.println("You died and lost all your items.");
        this.inventory.clear();
        this.money-=50;
    }

    public void collect(Item i){
        System.out.println("You collected a " + i.getName());
        try{
               int iQty = this.inventory.get(i);
               iQty++;
               this.inventory.put(i, iQty);
            }
            catch(NullPointerException npe){
               this.inventory.put(i, 1);
            }
    }
    
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
}
