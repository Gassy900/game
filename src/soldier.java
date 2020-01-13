
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public abstract class soldier {

    protected Rectangle hitbox;
    protected SpriteSheet soldspr, soldspr2;
    protected Image walk[] = new Image[4];
    protected Image attack[] = new Image[3];
    protected Animation ani, attani;
    protected int xloc, yloc;

    public soldier(int x, int y, String s) throws SlickException {
        soldspr = new SpriteSheet(s, 64, 64);
        soldspr2 = new SpriteSheet(s, 64, 64);
        soldspr.startUse();
        xloc = x;
        yloc = y;
        walk[0] = soldspr.getSubImage(0, 0);
        walk[1] = soldspr.getSubImage(0, 1);
        walk[2] = soldspr.getSubImage(0, 2);
        walk[3] = soldspr.getSubImage(1, 0);
        ani = new Animation(walk, 100);
        soldspr.endUse();
        soldspr2.startUse();
        attack[0] = soldspr.getSubImage(0, 0);
        attack[1] = soldspr.getSubImage(2, 1);
        attack[2] = soldspr.getSubImage(0, 0);
        attani = new Animation(attack, 100);
        soldspr2.endUse();
        hitbox = new Rectangle(xloc, yloc, 64, 64);
    }
    abstract public void move(Rectangle var);

    public void draw(boolean var) {
        if(var == true){
        ani.start();
        hitbox = new Rectangle(xloc, yloc, 64, 64);
        ani.draw(hitbox.getX(), hitbox.getY());
        } else{
            ani.stop();
        }
    }
    
    public boolean attack(Rectangle Var){
       if(hitbox.intersects(Var)){
            return true;
        } else{
            return false;
        }   
    }


    public void attackdraw() {

        attani.start();
        hitbox = new Rectangle(xloc, yloc, 64, 64);
        attani.draw(hitbox.getX(), hitbox.getY());
    }


    public Rectangle getHitbox() {
        return hitbox;
    }
}