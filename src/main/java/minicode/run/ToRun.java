package minicode.run;

public class ToRun {

    public static void runnerLoop(Runner runner){
        //if need to switch into waiting
        if(runner.secondsToWait < 1 && runner.distanceAcc > 200){
            runner.secondsToWait = 120;
            runner.distanceAcc = 0;
        }

        if(runner.secondsToWait > 0){
            //waiting
            runner.secondsToWait--;
        }else{
            //running
            runner.distanceTotal += runner.speedPreSecond;
            runner.distanceAcc += runner.speedPreSecond;
        }
    }

    public static void log(Runner a, Runner b){
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        Runner a = new Runner("A", 40f/60f);
        Runner b = new Runner("B", 60f/60f);

        Long timer = 0L;
        while (!Runner.hasCatchUp(timer, b, a, 800)){
            //log
            if((timer % 60) == 0) {
                ToRun.log(a, b);
            }
            //status update
            ToRun.runnerLoop(a);
            ToRun.runnerLoop(b);
            //loop
            timer++;
        }
        //result
        System.out.println("\nEnds At:" + timer + " Second");
        ToRun.log(a, b);
    }

}
