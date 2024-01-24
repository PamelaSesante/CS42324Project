package phantasianbistrodemo;

import java.util.ArrayList;

public class Tile {
    private String name;
    private int tileHeight = 16, tileWidth = 16;
    private boolean collision;
    private Entity presentEntity;
    private Item presentItem; 
    private static ArrayList<Tile> availableTiles = new ArrayList<>();
    
    public Tile(){}
    
    public Tile(String n, boolean b){
        this.name = n;
        this.collision = b;
        availableTiles.add(this);
    }

    public Tile pickRandomTile(){
        Tile chosenTile;
        int index = (int)(Math.random() * getAvailableTiles().size());
        chosenTile = availableTiles.get(index);     
        return chosenTile;
    }
    
    public int getTileHeight() {
        return tileHeight;
    }
    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }
    public int getTileWidth() {
        return tileWidth;
    }
    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }
    public boolean isCollision() {
        return collision;
    }
    public void setCollision(boolean collision) {
        this.collision = collision;
    }
    public Entity getPresentEntity() {
        return presentEntity;
    }
    public void setPresentEntity(Entity presentEntity) {
        this.presentEntity = presentEntity;
    }
    public Item getPresentItem() {
        return presentItem;
    }
    public void setPresentItem(Item presentItem) {
        this.presentItem = presentItem;
    }
    public ArrayList<Tile> getAvailableTiles() {
        return availableTiles;
    }
    public void setAvailableTiles(ArrayList<Tile> availableTiles) {
        Tile.availableTiles = availableTiles;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
