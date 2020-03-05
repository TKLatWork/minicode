package minicode.run;

public class Runner {

    public static Boolean hasCatchUp(Long timer, Runner fast, Runner slow, float offset){
        if(timer < 1){
            return false;
        }else{
            return (fast.distanceTotal - slow.distanceTotal - offset) > 0f;
        }
    }

    public Runner(String name, float speedPreSecond) {
        this.name = name;
        this.speedPreSecond = speedPreSecond;
    }

    public String name;
    public float speedPreSecond;//speed pre ms
    public float secondsToWait = 0;//
    public float distanceTotal = 0;//total distance accumulation
    public float distanceAcc = 0;//period distance accumulation

    @Override
    public String toString() {
        return "Runner{" +
                "name='" + name + '\'' +
                ", speedPreSecond=" + speedPreSecond +
                ", secondsToWait=" + secondsToWait +
                ", distanceTotal=" + distanceTotal +
                '}';
    }


}
