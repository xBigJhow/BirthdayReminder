package registraAniversario.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import registraAniversario.smtp.EnviaEmail;

import java.util.Calendar;

public class EnviaEmailTask implements Runnable {
    @Override
    public void run() {
        EnviaEmail enviaEmail = new EnviaEmail();
        enviaEmail.enviarEmail();
    }

    public void agendarEnvioEmail() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        
        Calendar now = Calendar.getInstance();
        Calendar seisDaManha = Calendar.getInstance();
        seisDaManha.set(Calendar.HOUR_OF_DAY, 6);
        seisDaManha.set(Calendar.MINUTE, 0);
        seisDaManha.set(Calendar.SECOND, 0);
        long initialDelay = seisDaManha.getTimeInMillis() - now.getTimeInMillis();
        
        // Agendar a tarefa para ser executada todos os dias às 06:00 da manhã
        scheduler.scheduleAtFixedRate(this, initialDelay, 1, TimeUnit.DAYS);
    }
}