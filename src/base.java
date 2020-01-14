
import org.newdawn.slick.SlickException;

public class base extends structure {

    public base(int x, int y, String s) throws SlickException {
        super(x, y, s);
    }

    @Override
    public boolean pointvar(int cost, int lvl) {
       if(lvl ==1 && cost ==50){
         return true;
       }
       if(lvl ==2 && cost ==50){
         return true;
       }
       if(lvl ==3 && cost ==50){
         return true;
       }
       if(lvl ==4 && cost ==50){
         return true;
       }
       
       if(lvl ==4 && cost ==50){
         return true;
       }
       
       if(lvl ==4 && cost ==50){
         return true;
       }
       
       if(lvl ==4 && cost ==50){
         return true;
       }
       
       if(lvl ==4 && cost ==50){
         return true;
       }
       else {
           return false;
       }
       
       }
    
}

