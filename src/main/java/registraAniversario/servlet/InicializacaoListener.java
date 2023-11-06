package registraAniversario.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import registraAniversario.scheduler.EnviaEmailTask;

public class InicializacaoListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EnviaEmailTask enviaEmailTask = new EnviaEmailTask();
        enviaEmailTask.agendarEnvioEmail();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	
    }
}