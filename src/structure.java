
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public abstract class structure {
    protected Image base;
    protected Rectangle hitbox;
    public structure(int x, int y, String s) throws SlickException{
        base = new Image(s);
        hitbox = new Rectangle(x,y,200,200);
    }
    
    public void draw(){
        base.draw(hitbox.getX(),hitbox.getY());
    }
    
}

