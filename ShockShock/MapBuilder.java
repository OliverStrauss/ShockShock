package ShockShock;

public class MapBuilder {
    public static Board initMap(Board b){
        Board newBoard = new Board(b.getWidth(), b.getHeight());
        for(int i =0; i < newBoard.getWidth(); i ++){
     
            newBoard.getBoard()[i][b.getHeight()-1].makeTerrain();
        }
        return newBoard;
        
    }

}
