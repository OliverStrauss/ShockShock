package ShockShock;

public class Square {
    private int x;
    private int y;
    private boolean isTerrain;

    public Square(int x, int y){
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean isTerrain(){
        return isTerrain;
    }
    
    public void makeTerrain(){
        isTerrain = true;
    }
    public void clearTerrain(){
        isTerrain = false;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "square [x=" + x + ", y=" + y + "]";
    }



}
