
import org.newdawn.slick.SlickException;

public class farm extends structure {
    
    public farm(int x, int y, String s) throws SlickException {
        super(x, y, s);
    }

    @Override
    public void pointvar(int cost, int lvl) {
        loclevel = lvl;
        costcalc(); 
        dept=false;
        
        
        if (lvl == 1 && cost >= 100) {
            var = 2;
            strcutlvl++;
            loclevel++;
            costcalc();
            dept=true;
        }
        if (lvl == 2 && cost >= 2000) {
            var = 4;
            strcutlvl++;
            loclevel++;
            costcalc();
            dept=true;
        }
        if (lvl == 3 && cost >= 10000) {
            var = 5;
            strcutlvl++;
            loclevel++;
            costcalc();
            dept=true;
        }
        if (lvl == 4 && cost >= 25000) {
            var = 8;
            strcutlvl++;
            loclevel++;
            costcalc();
            dept=true;
        }

        if (lvl == 5 && cost >= 200000) {
            var = 20;
            strcutlvl++;
            loclevel++;
            costcalc();
            dept=true;
        }
       
    
    }

    @Override
    public void costcalc() {
        if (loclevel == 1){
            loccost=100;
        }
        if (loclevel == 2){
            loccost=2000;
        }
        if (loclevel == 3){
            loccost=10000;
        }
        if (loclevel == 4){
            loccost=25000;
        }
        if (loclevel == 5){
            loccost=200000;
        }
    }
    }

 
    
