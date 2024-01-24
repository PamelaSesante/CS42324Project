package phantasianbistrodemo;

public class Location {
    private String name;
    private Tile[][] map;
    private int row, column;
    
    public Location(String n){
        this.name = n;
        this.row = 100;
        this.column = 100;
        Tile[][] map = new Tile[100][100];
        
        Tile t = new Tile(); 
        for(int rCount=0; rCount< 100; rCount++){
            for(int cCount=0; cCount<100; cCount++){
                map[rCount][cCount] = t.pickRandomTile();
            }
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Tile[][] getMap() {
        return map;
    }
    public void setMap(Tile[][] map) {
        this.map = map;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    
}
