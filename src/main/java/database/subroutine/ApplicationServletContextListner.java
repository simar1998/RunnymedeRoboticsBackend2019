package database.subroutine;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ApplicationServletContextListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
       scheduledExecutorService.scheduleAtFixedRate(new TimedSubroutine(), 0, 30, TimeUnit.MINUTES);

       System.out.print("Application Servlet Context Listener Initialized ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
