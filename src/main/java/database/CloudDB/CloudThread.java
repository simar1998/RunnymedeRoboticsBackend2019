package database.CloudDB;

import java.util.Timer;
import java.util.TimerTask;

public class CloudThread extends Thread {

    Timer timer = new Timer();

    public void run(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               // CloudDAO.checkCloudPresistantce();
            }
        }, 1*60*1000);
    }
}
