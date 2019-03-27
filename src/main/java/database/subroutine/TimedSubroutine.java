package database.subroutine;

import java.io.IOException;

public class TimedSubroutine implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println(tbaRequestHTTP.getTBAMatchData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
