
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

public class test extends BasicGame {

    soldier s, p;
    structure hbase, hfarm, pbase, pfarm;
    Rectangle grass, sky;
    button spwn;
    ArrayList<soldier> humsoldier = new ArrayList<soldier>();
    boolean var = true, yeet = true;

    public test(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        s = new human(270, 637, "data/lof.png");
        p = new pig(870, 647, "data/Pig.png");
        hbase = new base(200, 500, "data/baseh.png");
        hfarm = new farm(0, 500, "data/Farm.png");
        pfarm = new farm(1000, 500, "data/Farm.png");
        pbase = new base(800, 500, "data/basep.png");
        spwn = new button(100, 100, "Spawn Soldier", 50, 1);

        grass = new Rectangle(0, 700, 1200, 200);
        sky = new Rectangle(0, 0, 1200, 900);

    }

    public void update(GameContainer gc, int i) throws SlickException {
        if (spwn.isHit(gc) == true) {
            humsoldier.add(new human(270, 637, "data/lof.png"));
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(Color.cyan);
        g.fill(sky);
        g.draw(sky);
        hbase.draw();
        g.setColor(Color.green);
        g.fill(grass);
        g.draw(grass);
        hfarm.draw();
        pbase.draw();
        pfarm.draw();
        spwn.draw(g);
        p.draw(var);
        System.out.println(var);
        for (soldier s : humsoldier) {
            s.move(p.getHitbox());
            s.draw(var);
            if (s.attack(p.getHitbox()) == true) {
                var = false;
                s.attackdraw();
            }

        }

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