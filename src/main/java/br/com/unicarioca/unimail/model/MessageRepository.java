package br.com.unicarioca.unimail.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alessandro.santos on 11/15/16.
 */

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {


    List<Message> findByFrom(String from);

    List<Message> findByTo(String to);

}
