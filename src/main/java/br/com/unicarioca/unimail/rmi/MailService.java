package br.com.unicarioca.unimail.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 * Created by alessandro.santos on 11/15/16.
 */
public interface MailService extends Remote {

    void sendMessage(MessageDTO messageDTO) throws RemoteException;

    ArrayList<MessageDTO> getMessages(int userId) throws RemoteException;

}
