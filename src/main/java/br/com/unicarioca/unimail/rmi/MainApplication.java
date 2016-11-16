package br.com.unicarioca.unimail.rmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by alessandro.santos on 11/15/16.
 */

@SpringBootApplication
@EntityScan(value = "br.com.unicarioca.unimail.model")
@EnableJpaRepositories(basePackages = "br.com.unicarioca.unimail.model")
@ComponentScan(value = "br.com.unicarioca.unimail")
public class MainApplication {

    private Logger logger = LoggerFactory.getLogger(RMIServer.class);



    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }


    @Bean
    public MailService mailService() throws RemoteException {
        MailServiceImpl mailService = new MailServiceImpl();

        try {
            Naming.bind("//localhost/unimail", mailService);
            logger.info("RMI Server started");

        } catch (Exception e) {
            logger.error("RMI started failed: ", e);
        }


        return mailService;
    }


}
