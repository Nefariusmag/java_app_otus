package thread.coal;

import static java.lang.Thread.sleep;

public class CoalMiner implements Runnable {

    static boolean shodTheJobBeFinished = false;

    int workerId;

    public CoalMiner(int workerId){
        this.workerId = workerId;
    }

   private void atWork(){
       int lestCapacity = CoalMine.getCapacityAndDecreaseByTen();

       try {
           sleep(100);
       } catch (InterruptedException e) {
           Thread.interrupted();
       }

       if(lestCapacity == 0) {
           shodTheJobBeFinished = true;
           return;
       }

       System.out.println("How much coal left=" + lestCapacity + " miner's id: " + workerId);
   }

    @Override
    public void run() {
        long startTimer = System.currentTimeMillis();
        while (!shodTheJobBeFinished) {
            atWork();
        }

        long endTimer = System.currentTimeMillis();
        long finishedTime = endTimer - startTimer;
        System.out.println("The miner: " + workerId + ". Finished the job time: " + finishedTime + " ms");
    }
}
