
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

public class test extends BasicGame {

    soldier s, p;
    structure hbase, hfarm, pbase, pfarm;
    Rectangle grass, sky;
    button spwn,baseup,farmup;
    ArrayList<soldier> humsoldier = new ArrayList<soldier>();
    String bases, farms, soldiers;
    int basei = 1, farmi = 1, soldieri = 1;

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

        grass = new Rectangle(0, 700, 1200, 200);
        sky = new Rectangle(0, 0, 1200, 900);
        spwn = new button(500, 100, "Spawn Soldier", 50, 1);
        baseup = new button(50,100,"Upgrade Base", 50, 1);
        farmup = new button(275,100,"Upgrade Farm", 50, 1);
        bases = "lvl " + basei;
        farms = "lvl " + farmi;
        soldiers = "lvl " + soldieri;
        
    }

    public void update(GameContainer gc, int i) throws SlickException {
        if (spwn.isHit(gc) == true) {
            humsoldier.add(new human(270, 637, "data/lof.png"));
        }
        bases = "lvl " + basei;
        farms = "lvl " + farmi;
        soldiers = "lvl " + soldieri;
        spwn.update(50, soldieri);
        
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
        baseup.draw(g);
        farmup.draw(g);
        p.draw();
        System.out.println();
        for (soldier s : humsoldier) {
            s.move(p.getHitbox());
            s.draw();
            g.setColor(Color.red);
            g.drawString(soldiers,s.getX(),600);
            if (s.attack(p.getHitbox()) == true) {
                s.stopani();
                s.attackdraw();
            }
        }
        
         g.setColor(Color.red);
         g.drawString(bases, 220, 480);
         

    }

    public static void main(String args[]) throws SlickException {
        test game = new test("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(1200, 900, false);
        app.setTargetFrameRate(100);
        app.start();
    }

}