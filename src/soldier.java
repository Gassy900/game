
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public abstract class soldier {

    protected Rectangle hitbox;
    protected int xloc, yloc;
    protected SpriteSheet humspr;
    protected Image walk[] = new Image[4];
    protected Animation ani;

    public soldier(int x, int y, String s) throws SlickException {
        humspr = new SpriteSheet(s, 192, 192);
        humspr.startUse();
        walk[0] = humspr.getSubImage(0, 0);
        walk[1] = humspr.getSubImage(0, 1);
        walk[2] = humspr.getSubImage(0, 2);
        walk[3] = humspr.getSubImage(1, 0);
        ani = new Animation(walk, 100);
        humspr.endUse();
        hitbox = new Rectangle(x, y, walk[0].getWidth(), walk[0].getHeight());
    }

    abstract public void attackdmg();

    public void draw() {
        ani.start();
        ani.draw(hitbox.getX(),hitbox.getY());
    }
}
