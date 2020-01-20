import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.GameContainer;


public class maingame extends BasicGameState {
    structure hbase, hfarm, pbase, pfarm;
    Rectangle grass, sky, hbox, pbox;
    button spwn, baseup, farmup;
    CPU cpu;
    ArrayList<soldier> humsoldier = new ArrayList<soldier>();
    ArrayList<soldier> pigsoldier = new ArrayList<soldier>();
    String bases, farms, soldiers, pigs, PointsS, pbases, pfarms, pigps,winner;
    int basei = 1, farmi = 1, soldieri = 1, pigi = 1;
    int humtimer = 0, humpoints = 1;
    int cost = 10, costf = 100, costs = 500;
    int soldvar = 0;
    int pigdam = 1, humdam = 1;
    boolean car = false, hvar = false, pvar = false;
    int pigpoints = 1;
    int pbasei = 1, pfarmi = 1;
    int pigintb = 1, pigintf = 1;
    int random;
    int pigvar = 0;
    int enemycost = 500;
    int pigtimer = 0;
    boolean agro = false;
    boolean agro2 = false;
    boolean agro3 = false;
    boolean carp = false;
    boolean piguse = false;
    boolean canspwn = false;
    static final int WIN = 300000;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
         hbase = new base(200, 500, "data/baseh.png");
        hfarm = new farm(0, 500, "data/Farm.png");
        pfarm = new farm(1000, 500, "data/Farm.png");
        pbase = new base(800, 500, "data/basep.png");
        cpu = new CPU();
        pbox = new Rectangle(1, 1, 1, 1);
        hbox = new Rectangle(1, 1, 1, 1);

        grass = new Rectangle(0, 700, 1200, 200);
        sky = new Rectangle(0, 0, 1200, 900);
        spwn = new button(500, 100, "Spawn Soldier", 500, 1);
        baseup = new button(50, 100, "Upgrade Base", 10, 1);
        farmup = new button(275, 100, "Upgrade Farm", 100, 1);
        bases = "lvl " + basei;
        farms = "lvl " + farmi;
        soldiers = "lvl " + soldieri;
        pigs = "lvl " + pigi;
        pbases = "lvl " + pbasei;
        pfarms = "lvl " + pfarmi;
        PointsS = "Pts " + humpoints;
        pigps = "Pts " + pigpoints;
        winner = "Winning amount of points: "+WIN;
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
         Input in = gc.getInput();
        int mx = in.getMouseX();
        int my = in.getMouseY();
        if (pigpoints >= 10 && pbasei == 1) {
            cpu.baseup(pigpoints);
            pigpoints -= 10;
            pbasei = cpu.returnbase();
            pigintb = cpu.returnbaseval();
        }
        if (pigpoints >= 100 && pfarmi == 1) {
            cpu.farmup(pigpoints);
            pigpoints -= 100;
            pfarmi = cpu.returnfarm();
            pigintf = cpu.returnfarmval();
        }
        if (pigpoints >= 250 && pbasei == 2) {
            cpu.baseup(pigpoints);
            pigpoints -= 250;
            pbasei = cpu.returnbase();
            pigintb = cpu.returnbaseval();
        }

        if (agro == true && agro3 == false) {
            if (pigpoints >= enemycost) {
                pigsoldier.add(new pig(870, 647, "data/Pig.png"));
                piguse = true;
                pvar = false;
                pigvar++;
                pigpoints -= enemycost;
                agro = false;

                if (pigvar >= 3) {
                    enemycost += 5000;
                    pigi++;
                    carp = true;
                    pigvar = 0;
                }
            }
        }
        if (pigpoints >= 500) {
            random = (int) (Math.random() * 2) + 1;
            if (random == 1) {
                if (pigpoints >= 2000 && pbasei == 3) {
                    cpu.baseup(pigpoints);
                    pigpoints -= 2000;
                    pbasei = cpu.returnbase();
                    pigintb = cpu.returnbaseval();
                }
                if (pigpoints >= 50000 && pbasei == 4) {
                    cpu.baseup(pigpoints);
                    pigpoints -= 50000;
                    pbasei = cpu.returnbase();
                    pigintb = cpu.returnbaseval();

                }
                if (pigpoints >= 100000 && pbasei == 5) {
                    cpu.baseup(pigpoints);
                    pigpoints -= 100000;
                    pbasei = cpu.returnbase();
                    pigintb = cpu.returnbaseval();

                }
            }

            if (random == 2) {
                if (pigpoints >= 2000 && pfarmi == 2) {
                    cpu.farmup(pigpoints);
                    pigpoints -= 2000;
                    pfarmi = cpu.returnfarm();
                    pigintf = cpu.returnfarmval();
                }
                if (pigpoints >= 10000 && pfarmi == 3) {
                    cpu.farmup(pigpoints);
                    pigpoints -= 10000;
                    pfarmi = cpu.returnfarm();
                    pigintf = cpu.returnfarmval();
                }
                if (pigpoints >= 25000 && pfarmi == 4) {
                    cpu.farmup(pigpoints);
                    pigpoints -= 25000;
                    pfarmi = cpu.returnfarm();
                    pigintf = cpu.returnfarmval();
                }
                if (pigpoints >= 200000 && pfarmi == 5) {
                    cpu.farmup(pigpoints);
                    pigpoints -= 200000;
                    pfarmi = cpu.returnfarm();
                    pigintf = cpu.returnfarmval();
                }
            }
        }

        if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (spwn.isHit(mx, my) == true) {
                if (humpoints >= costs && canspwn==false) {
                    soldvar += 1;
                    hvar = false;
                    humsoldier.add(new human(270, 637, "data/lof.png"));
                    canspwn=true;
                    if (agro3 == false) {
                        agro = true;
                    }
                    humpoints -= costs;
                    if (soldvar >= 3) {
                        costs += 5000;
                        soldieri++;
                        car = true;
                        spwn.update(costs, soldieri);
                        soldvar = 0;
                    }
                }
            }

            if (baseup.isHit(mx, my) == true) {
                hbase.pointvar(humpoints, basei);
                if (hbase.paydept() == true) {
                    humpoints -= cost;
                    cost = hbase.returnCost();
                    basei = hbase.returnLevel();
                    baseup.update(cost, basei);
                }
            }
            if (farmup.isHit(mx, my) == true) {
                hfarm.pointvar(humpoints, farmi);
                if (hfarm.paydept() == true) {
                    humpoints -= costf;
                    costf = hfarm.returnCost();
                    farmi = hfarm.returnLevel();
                    farmup.update(costf, farmi);
                }

            }
        }
        if (agro == true) {
            agro2 = true;
        }
        if (agro2 == true) {
            pigtimer++;
        }
        if (pigtimer >= 2000 && piguse == false) {
            pigtimer = 0;
            if (pigpoints >= enemycost) {
                agro3 = true;
                pigsoldier.add(new pig(870, 647, "data/Pig.png"));
                piguse = true;
                pigvar++;
                pigpoints -= enemycost;
                pvar = false;
                agro = false;
                agro2 = false;

            }
        }

        bases = "lvl " + basei;
        farms = "lvl " + farmi;
        soldiers = "lvl " + soldieri;
        pigs = "lvl " + pigi;
        pbases = "lvl " + pbasei;
        pfarms = "lvl " + pfarmi;
        humtimer++;
        if (humtimer == 100) {
            humpoints += (hbase.returnVal() * hfarm.returnVal());
            pigpoints += (pigintb * pigintf);
            humtimer = 0;
        }
        PointsS = "Pts " + humpoints;
        pigps = "Pts " + pigpoints;
        if(WIN <= humpoints || WIN <= pigpoints){
            sbg.enterState(2);
        }
    }
    

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
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
            hbox = s.getHitbox();
            s.move(pbox);
            if (car == true) {
                s.healthdam();
                car = false;
            }
            humdam = s.returnDam();
            s.draw();
            g.setColor(Color.red);
            g.drawString(soldiers, s.getX(), 600);
            if (s.attack(pbox) == true) {
                s.stopani();
                s.attackdraw();
                s.deathcalc(pigdam);
            }
            if (hvar == true) {
                s.stopatt();
                s.move(pbox);
                s.draw();
            }
            if (s.death() == true) {
                humsoldier.remove(s);
                canspwn=false;
                hbox = new Rectangle(1, 1, 1, 1);
                pvar = true;
            }

            if (hbox.intersects(pbase.gethit())) {
                humsoldier.remove(s);
                canspwn=false;
                hbox = new Rectangle(1, 1, 1, 1);
                humpoints += (pigpoints / 2);
                pigpoints -= (pigpoints / 2);
            }
        }

        for (int i = 0; i < pigsoldier.size(); i++) {
            soldier p = pigsoldier.get(i);
            pbox = p.getHitbox();
            p.move(hbox);
            if (carp == true) {
                p.healthdam();
                carp = false;
            }
            p.draw();
            pigdam = p.returnDam();
            g.setColor(Color.red);
            g.drawString(pigs, p.getX(), 600);
            if (p.attack(hbox) == true) {
                p.stopani();
                p.attackdraw();
                p.deathcalc(humdam);
            }
            if (pvar == true) {
                p.stopatt();
                p.move(hbox);
                p.draw();
            }
            if (p.death() == true) {
                pigsoldier.remove(p);
                piguse = false;
                agro3 = false;
                pbox = new Rectangle(1, 1, 1, 1);
                hvar = true;
            }

            if (pbox.intersects(hbase.gethit())) {
                pigsoldier.remove(p);
                pigpoints += (humpoints / 2);
                humpoints -= (humpoints / 2);
                piguse = false;
                agro3 = false;
                pbox = new Rectangle(1, 1, 1, 1);
            }
        }

        g.setColor(Color.red);
        g.drawString(winner,400,200);
        g.drawString(bases, 220, 480);
        g.drawString(farms, 10, 500);
        g.drawString(pbases, 940, 480);
        g.drawString(pfarms, 1130, 500);
        g.setColor(Color.red);
        g.drawString(PointsS, 220, 300);
        g.drawString(pigps, 830, 300);

    
    }

    public int getID() {
       return 1;  //this id will be different for each screen
    }


}
