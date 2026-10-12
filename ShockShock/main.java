package ShockShock;


import java.io.IOException;



import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
/**
 * to RUN 
 * javac -cp lib/lanterna-3.1.3.jar ShockShock/main.java

screen.refresh();  // push buffer to terminal. Nothing shows until this call

 * main
 */
public class main {
    static int HEIGHT = 30;
    static int WIDTH = 90;
   

    public static void main(String[] args) throws Exception {  
       
        final int FRAME_MS = 33;   // about 30 frames per second
        boolean running = true;
        int frame = 0;   
        GameGraphics graphics = new GameGraphics(WIDTH, HEIGHT);
        Board gameBoard = new Board(WIDTH, HEIGHT);
        gameBoard =MapBuilder.initMap(gameBoard);
        graphics.screen.startScreen();

        Tank t = new Tank(5, 5, 5);
        t.fall(gameBoard);

        gameBoard.addTank(t);
        Tank currentTank = t;
        try {
          
            while (running) {
                long start = System.currentTimeMillis();

                // 1. input: drain all keys
                KeyStroke k = graphics.getInput();
                while (k != null) {

                
                    // Escape or EOF -> running = false;
                    // other keys -> move the tank, fire, ...
                  

                    if (k.getKeyType() == KeyType.Character) {        
                        char c = Character.toLowerCase(k.getCharacter()); 
                        if (c == 'd') { 
                            currentTank.move(1, gameBoard);

                            
                        }
                       
                    }
                      k = graphics.getInput();
                    
                }

                // 2. update: bullets move, hit checks, ...

                // 3. draw
                graphics.draw(gameBoard);

                // 4. wait out the rest of the frame
                long elapsed = System.currentTimeMillis() - start;
                Thread.sleep(Math.max(0, FRAME_MS - elapsed));
                frame++;

            }
        } finally {
            graphics.screen.stopScreen();   // runs even if the game crashes
        }
    }


}
