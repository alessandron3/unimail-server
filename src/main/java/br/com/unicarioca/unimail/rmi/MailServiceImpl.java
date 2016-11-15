package br.com.unicarioca.unimail.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


/**
 * Created by alessandro.santos on 11/15/16.
 */

public class MailServiceImpl extends UnicastRemoteObject implements MailService {


    public MailServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void sendMessage(MessageDTO messageDTO) throws RemoteException {

    }

    @Override
    public ArrayList<MessageDTO> getMessages(int userId) throws RemoteException {
        return null;
    }
}
