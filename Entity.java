package phantasianbistrodemo;

public abstract class Entity {
    protected String name;
    protected int yPosition, xPosition, speed, health;
    
    public Entity(){
    }
    
    public Entity(String n, int y, int x, int s, int h){
        this.name = n;
        this.yPosition = y;
        this.xPosition = x;
        this.speed = s;
        this.health = h;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getyPosition() {
        return yPosition;
    }
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    public int getxPosition() {
        return xPosition;
    }
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    
}
