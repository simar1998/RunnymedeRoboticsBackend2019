package database.CloudDB;

public class CloudRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Running cloud persistence");
        CloudDAO.checkCloudPresistantce();
    }
}
