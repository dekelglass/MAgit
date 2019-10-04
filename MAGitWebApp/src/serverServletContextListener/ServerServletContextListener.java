package serverServletContextListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebListener
public class ServerServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        File file = new File("c:"+File.separator+"magit-ex3");
        file.mkdirs();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            Files.delete(Paths.get("c:"+File.separator+"magit-ex3"));
        } catch (IOException e) {
        }
    }
}
