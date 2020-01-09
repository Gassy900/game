
import org.newdawn.slick.*;

public class test extends BasicGame {

    soldier s,p;
    structure humbase;

    public test(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        s = new human(100,100,"data/lof.png");
        p = new human(100,200,"data/pig.png");
        humbase = new humanbase(0,400,"data/baseh.png");
    }

    public void update(GameContainer gc, int i) throws SlickException {

    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        s.draw();
        p.draw();
        humbase.draw();
    }

    public static void main(String args[]) throws SlickException {
        test game = new test("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(1200, 900, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}