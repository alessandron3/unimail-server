package br.com.unicarioca.unimail.rmi;

import br.com.unicarioca.unimail.model.Message;
import br.com.unicarioca.unimail.model.MessageRepository;
import br.com.unicarioca.unimail.model.User;
import br.com.unicarioca.unimail.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by alessandro.santos on 11/15/16.
 */

@Service
public class MailServiceImpl extends UnicastRemoteObject implements MailService {


    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;


    public MailServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void sendMessage(MessageDTO messageDTO) throws RemoteException {
        Message message = new Message(messageDTO.getFrom(), messageDTO.getTo(),
                messageDTO.getTitle(), messageDTO.getBody());

        messageRepository.save(message);

    }

    @Override
    public List<MessageDTO> getMessages(Long userId) throws RemoteException {

        User user = userRepository.findOne(userId);
        Assert.notNull(user);
        List<Message> messages = messageRepository.findByTo(user.getEmail());

        return messages.stream()
                .map(m -> new MessageDTO(m.getFrom(), m.getTo(), m.getTitle(), m.getMessage()))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDTO createUser(UserDTO userDTO) throws RemoteException {

        User checkUser = userRepository.findByEmail(userDTO.getEmail());
        if(checkUser == null) {
            User user = new User(userDTO.getEmail(), userDTO.getName());
            user = userRepository.save(user);
            return new ResponseDTO("created", new UserDTO(user.getEmail(), user.getName(), user.getId()));
        }

        return new ResponseDTO("email_already_exist", null);
    }


    @Override
    public List<MessageDTO> getSentMessages(Long userId) throws RemoteException {

        User user = userRepository.findOne(userId);
        Assert.notNull(user);
        List<Message> messages = messageRepository.findByFrom(user.getEmail());

        return messages.stream()
                .map(m -> new MessageDTO(m.getFrom(), m.getTo(), m.getTitle(), m.getMessage()))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDTO recoverUser(String email) throws RemoteException {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            return new ResponseDTO("success", new UserDTO(user.getEmail(), user.getName(), user.getId()));
        }

        return new ResponseDTO("user_not_found", null);
    }
}
