package ShockShock;
import java.io.IOException;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.input.KeyStroke;

public class GameGraphics {
        public Screen screen; 
        public GameGraphics(int width,int height){

        try {
            screen = new DefaultTerminalFactory()
            .setPreferTerminalEmulator(true)
            .setInitialTerminalSize(new TerminalSize(width, height))  // 80 columns x 24 rows
            .createScreen();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
        }

        public void startScreen() throws IOException{
            screen.startScreen(); 

        }

        public void draw(Board b) throws IOException {
            screen.clear();
            TextGraphics g = screen.newTextGraphics();
            for(int x =0; x <b.getWidth(); x++){
                for(int y=0; y<b.getHeight(); y ++){
                    if(b.getBoard()[x][y].isTerrain()){
                        g.setCharacter(x,y ,'#');
                    }else{
                        g.setCharacter(x,y,' ');

                    }
                }
            }

            for (Tank t : b.getTanks()) {
                g.setForegroundColor(t.isPlayerOne() ? TextColor.ANSI.GREEN : TextColor.ANSI.RED);
                g.setCharacter(t.getX(), t.getY(), 'T');
            }
            g.setForegroundColor(TextColor.ANSI.DEFAULT);
            g.putString(0, 0, "Angle: "  + "  Power: ");


            // 1. terrain: loop x, y; if b.getSquare(x, y) is terrain, g.setCharacter(x, y, '#')
            // 2. tanks, bullets: g.setCharacter(tank x, tank y, 'T')
            // 3. HUD: g.putString(...), border with g.drawRectangle(...)

            screen.refresh();
        }

        public KeyStroke getInput() throws IOException {

            return screen.pollInput();
        }
 


}
