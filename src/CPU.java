public class CPU {
    private int baselevel, basecost, farmlevel,farmcost;
    private int timer;
    public CPU(int lvlb, int costb,int lvlf, int costf ){
        baselevel = lvlb;
        basecost = costb;
        farmlevel = lvlf;
        farmcost = costf;
    }
    
    public boolean spawnenemy(){
        if(timer==7000){
            timer=0;
            return true;
        }
        return false;
    }
    
    public void timer(){
        timer++;
        
    }
}
