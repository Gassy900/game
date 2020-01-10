
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class button {
    private Rectangle button;
    private String privname,s;
    private int xloc, yloc;
    
    public button(int x, int y, String name, int lvl){
        xloc = x;
        yloc = y;
        privname = name;
        button = new Rectangle(xloc,yloc,100,100);
        s = privname + " lvl " + lvl;
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fill(button);
        g.draw(button);
        g.setColor(Color.white);
        g.drawString(s, xloc+5, yloc+5);
        
    }
    
    
    public void update(int lvl){
        s = privname + " lvl " + lvl;
    }
}
