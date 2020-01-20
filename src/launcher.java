import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class launcher extends StateBasedGame {

    public launcher(String title) {
        super(title);
    }

    public void initStatesList(GameContainer gc) throws SlickException {
      this.addState(new introscreen());
      this.addState(new maingame());
      this.addState(new endscreen());
    }

    public static void main(String args[]) throws SlickException {
        launcher game = new launcher("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(1200, 900, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }
}
