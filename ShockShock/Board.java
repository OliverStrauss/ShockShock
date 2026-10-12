package ShockShock;
import java.util.ArrayList;



public class Board {



    Square[][] board;
    private int width; 
    private int height;

    private ArrayList<Tank> tanks = new ArrayList<>();

    public Board(int width,int height){
        this.width = width;
        this.height = height;
        board = new Square[width][height];
        initBoard();


    }

    private void initBoard(){
        for(int x =0; x< width; x ++ ){
            for( int y =0; y < height; y++){
                this.board[x][y] = new Square(x,y);
            }
        }

    }

    public void setSquare(int x, int y, Square s){
        board[x][y] = s;

    }
    public boolean inBounds(int x, int y){
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    public Square getSquare(int x,int y){
        return board[x][y];
    }

    public void addTank(Tank t){
        tanks.add(t); 
    }
    public ArrayList<Tank> getTanks(){ 
        return tanks; 
    }

    public Square[][] getBoard() {
        return board;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    

}
