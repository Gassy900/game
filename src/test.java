
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

public class test extends BasicGame {

    soldier s, p;
    structure hbase, hfarm, pbase, pfarm;
    Rectangle grass, sky;
    button spwn, baseup, farmup;
    CPU cpu;
    ArrayList<soldier> humsoldier = new ArrayList<soldier>();
    ArrayList<soldier> pigsoldier = new ArrayList<soldier>();
    String bases, farms, soldiers, PointsS;
    int basei = 1, farmi = 1, soldieri = 1;
    int humtimer = 0, humpoints = 1;
    int cost = 10, costf = 100, costs = 500;
    int soldvar = 0;

    public test(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
    
        p = new pig(870, 647, "data/Pig.png");
        hbase = new base(200, 500, "data/baseh.png");
        hfarm = new farm(0, 500, "data/Farm.png");
        pfarm = new farm(1000, 500, "data/Farm.png");
        pbase = new base(800, 500, "data/basep.png");
        cpu = new CPU(1,1,1,1);

        grass = new Rectangle(0, 700, 1200, 200);
        sky = new Rectangle(0, 0, 1200, 900);
        spwn = new button(500, 100, "Spawn Soldier", 500, 1);
        baseup = new button(50, 100, "Upgrade Base", 10, 1);
        farmup = new button(275, 100, "Upgrade Farm", 100, 1);
        bases = "lvl " + basei;
        farms = "lvl " + farmi;
        soldiers = "lvl " + soldieri;
        PointsS = "Pts " + humpoints;

    }

    public void update(GameContainer gc, int i) throws SlickException {
        Input in = gc.getInput();
        int mx = in.getMouseX();
        int my = in.getMouseY();

        if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (spwn.isHit(mx, my) == true) {
                if (humpoints >= costs) {
                    soldvar += 1;
                    humsoldier.add(new human(270, 637, "data/lof.png"));
                    humpoints -= costs;
                    if (soldvar == 3) {
                        costs += 5000;
                        soldieri++;
                        spwn.update(costs, soldieri);
                        soldvar = 0;
                    }
                }
            }
            if (baseup.isHit(mx, my) == true) {
                hbase.pointvar(humpoints, basei);
                if (hbase.paydept() == true) {
                    humpoints -= cost;
                }
                cost = hbase.returnCost();
                basei = hbase.returnLevel();
                baseup.update(cost, basei);
            }
            if (farmup.isHit(mx, my) == true) {
                hfarm.pointvar(humpoints, farmi);
                if (hfarm.paydept() == true) {
                    humpoints -= costf;
                }
                costf = hfarm.returnCost();
                farmi = hbase.returnLevel();
                farmup.update(costf, farmi);
            }
        }
           cpu.timer();
            if(cpu.spawnenemy()==true){
                 pigsoldier.add(new pig(870, 647, "data/Pig.png"));
            }

        

        bases = "lvl " + basei;
        farms = "lvl " + farmi;
        soldiers = "lvl " + soldieri;
        humtimer++;
        if (humtimer == 100) {
            humpoints += (hbase.returnVal() * hfarm.returnVal());
            humtimer = 0;
        }
        PointsS = "Pts " + humpoints;

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
        for (int i = 0; i < humsoldier.size(); i++) {
            soldier s = humsoldier.get(i);
            s.move(p.getHitbox());
            s.draw();
            g.setColor(Color.red);
            g.drawString(soldiers, s.getX(), 600);
            if (s.attack(p.getHitbox()) == true) {
                s.stopani();
                s.attackdraw();
            }
        }
        for (int i = 0; i < pigsoldier.size(); i++) {
            soldier p = pigsoldier.get(i);
            p.move(s.getHitbox());
            p.draw();
            g.setColor(Color.red);
            g.drawString(soldiers, p.getX(), 600);
            if (p.attack(s.getHitbox()) == true) {
                p.stopani();
                p.attackdraw();
            }
        }

        g.setColor(Color.red);
        g.drawString(bases, 220, 480);
        g.drawString(farms, 10, 500);
        g.setColor(Color.red);
        g.drawString(PointsS, 220, 300);

    }

    public static void main(String args[]) throws SlickException {
        test game = new test("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(1200, 900, false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
