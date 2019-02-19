package database.CloudDB;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ApplicationServletContextListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        CloudThread cloudThread = new CloudThread();
        cloudThread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
