public class CPU {
    private int baselevel, farmlevel;
    private static int timer;
    private int desc,farm;
    public CPU(){
        baselevel = 1;
        farmlevel = 1;
        
    }
    
    public boolean spawnenemy(){
        if(timer==1000){
            timer=-2000;
            return true;
        }
        return false;
    }
    
    public void baseup(int locpo){
        if(locpo >= 500000 ){
            baselevel = 6;
            desc = 400;
        }
        else if(locpo >= 50000){
            baselevel = 5;
            desc=250;
        }
         else if(locpo >= 2000){
            baselevel = 4;
            desc=100;
        }
         else if(locpo >= 250){
            baselevel = 3;
            desc=20;
        }
         else if(locpo >= 10){
            baselevel = 2;
            desc=5;
        }
         else{
             baselevel=1;
         }
    }
    
    public void farmup(int locpo){
        if(locpo >= 1000000){
            farmlevel = 6;
            farm=20;
        }
        else if(locpo >= 25000){
            farmlevel = 5;
            farm=8;
        }
         else if(locpo >= 10000){
            farmlevel = 4;
            farm=5;
        }
         else if(locpo >= 2000){
            farmlevel = 3;
            farm=4;
        }
         else if(locpo >= 100){
            farmlevel = 2;
            farm=2;
        }
         else{
             farmlevel = 1;
         }
    }
    
    public static void timer(){
        timer++;
    }
    public int returnbase(){
        return baselevel;
    }
    public int returnfarm(){
        return farmlevel;
    }
    public int returnbaseval(){
        return desc;
    }
    public int returnfarmval(){
        return farm;
    }
}
