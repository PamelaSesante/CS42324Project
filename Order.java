package phantasianbistrodemo;

public class Order {
    private int qtyFood, price, orderNumber, npcOrderNumber;
    private static int totalOrders = 1;
    private Food dishRequired;
    
    public Order(int npcOrderNumber) {
        Food f = new Food();
        this.npcOrderNumber = npcOrderNumber; // number with relation to NPC and their order list
        this.orderNumber = totalOrders; // number in relation to ALL NPC orders 
        this.qtyFood = (int)(Math.random() * 3 + 1);
        this.dishRequired = f.pickRandomFood();
        this.price = dishRequired.getPrice() * qtyFood;
        totalOrders++;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public int getQuantityFood() {
        return qtyFood;
    }
    public void setQuantityFood(int quantityFood) {
        this.qtyFood = quantityFood;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Food getDishRequired() {
        return dishRequired;
    }
    public void setDishRequired(Food dishRequired) {
        this.dishRequired = dishRequired;
    }
    public int getNpcOrderNumber() {
        return npcOrderNumber;
    }
    public void setNpcOrderNumber(int npcOrderNumber) {
        this.npcOrderNumber = npcOrderNumber;
    }
}
