package ShockShock;


   public class Tank {
    private int x, y;
    private int angle;      // degrees: 0 = right, 90 = straight up, 180 = left
    private int power;      // for example 1 to 100
    private int hp;
    private boolean playerOne;

    

    public Tank(int x, int y, int hp) {
        this.x = x;
        this.y = y;
        this.hp = hp;
      
    }

    public void move(int dx, Board b){
        int newX = x +dx;
        if(!b.inBounds(newX, y)){
            return;
        }
        if(! b.getBoard()[newX][y].isTerrain()){
             x = newX;
            fall(b);
        }
        else if( y-1 >= 0 && !b.getBoard()[newX][y-1].isTerrain()){
            x = newX;
            y--;
     
        }

    }
    // nx = x + dx; out of bounds -> return
    // terrain at (nx, y)? try one cell up (nx, y - 1). Free -> step up. Else blocked
    // after moving: fall(b)

    public void fall(Board b){
        while(y+1< b.getHeight() &&  !b.getSquare(x, y + 1).isTerrain()){
            y++;
        }
    }
    // while y + 1 < height and !b.getSquare(x, y + 1).isTerrain(): y++

    public void changeAngle(int d){
        angle+=d;
        angle=Math.min(angle,180);
        angle = Math.max(angle, 0);
    
    }
           // angle += d, keep it between 0 and 180
    public void changePower(int d){
        power+=d;
        power=Math.min(power,100);
        power = Math.max(power, 1);
       }   
     //public Bullet fire()             // new Bullet from x, y, angle, power


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAngle() {
        return angle;
    }

    public int getPower() {
        return power;
    }

    public int getHp() {
        return hp;
    }

    public boolean isPlayerOne() {
        return playerOne;
    }      
    

    // getters: getX, getY, getDirX, getDirY, getHp, isPlayerOne
}
