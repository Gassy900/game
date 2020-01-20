import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class endscreen extends BasicGameState {
    Image s;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        s = new Image("data/end.png");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        s.draw(0,0);
    }

    public int getID() {
       return 2;  //this id will be different for each screen
    }


}
