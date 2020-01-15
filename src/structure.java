
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public abstract class structure {
    protected Image base;
    protected Rectangle hitbox;
    protected int var=1;
    protected int loccost = 10;
    protected int loclevel;
    protected int strcutlvl=1;
    
    public structure(int x, int y, String s) throws SlickException{
        base = new Image(s);
        hitbox = new Rectangle(x,y,200,200);
    }
    
    public void draw(){
        base.draw(hitbox.getX(),hitbox.getY());
    }
    
    public abstract void pointvar(int cost,int lvl);
    public abstract void costcalc();
    
    public int returnVal(){
        return var;
    }
    
    public int returnCost(){
        return loccost;
        
    }
    public int returnLevel(){
        return strcutlvl;
    }
    
}