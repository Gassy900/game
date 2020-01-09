
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public abstract class soldier {

    protected Rectangle hitbox;
    protected SpriteSheet soldspr;
    protected Image walk[] = new Image[4];
    protected Animation ani;

    public soldier(int x, int y, String s) throws SlickException {
        soldspr = new SpriteSheet(s, 64, 64);
        soldspr.startUse();
        walk[0] = soldspr.getSubImage(0, 0);
        walk[1] = soldspr.getSubImage(0, 1);
        walk[2] = soldspr.getSubImage(0, 2);
        walk[3] = soldspr.getSubImage(1, 0);
        ani = new Animation(walk, 100);
        soldspr.endUse();
        hitbox = new Rectangle(x, y, 32, 32);
    }

    abstract public void attack();
    abstract public void move();

    public void draw() {
        ani.start();
        ani.draw(hitbox.getX(),hitbox.getY());
    }
}
