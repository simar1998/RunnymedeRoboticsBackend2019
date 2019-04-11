package database.subroutine;

import java.io.IOException;

public class TimedSubroutine implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println(TbaRequestHTTP.getTBAMatchData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
