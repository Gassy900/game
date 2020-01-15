import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

public class button {

    private Rectangle b;
    private String privname, s, s2;
    private int xloc, yloc;

    public button(int x, int y, String name, int cost, int lvl) {
        xloc = x;
        yloc = y;
        privname = name;
        b = new Rectangle(xloc, yloc, 190, 50);
        s = privname + " lvl " + lvl;
        s2 = "Cost: " + cost;
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fill(b);
        g.draw(b);
        g.setColor(Color.white);
        g.drawString(s, xloc + 5, yloc + 5);
        g.drawString(s2, xloc + 5, yloc + 25);
    }

    public boolean isHit(int mx, int my) {
        if (b.contains(mx, my)) {
            
            return true;
        } else {
            return false;
        }
    }

    public void update(int cost, int lvl) {
        s = privname + " lvl " + lvl;
        s2 = "Cost: " + cost;
    }
}