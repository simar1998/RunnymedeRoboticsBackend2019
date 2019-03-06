package database.CloudDB;

import java.sql.SQLException;

public class CloudRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Running cloud persistence");
        try {
            CloudDAO.checkCloudPresistantce();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
