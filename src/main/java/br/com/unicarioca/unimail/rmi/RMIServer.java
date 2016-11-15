package br.com.unicarioca.unimail.rmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.rmi.Naming;


/**
 * Created by alessandro.santos on 11/15/16.
 */


public class RMIServer {

    private MailService mailService;

    private Logger logger = LoggerFactory.getLogger(RMIServer.class);

    public RMIServer() {

        try {
            Naming.bind("unimail", mailService);
            logger.info("RMI Server started");

        } catch (Exception e) {
            logger.error("RMI started failed: ", e);
        }
    }
}
