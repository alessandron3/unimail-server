package br.com.unicarioca.unimail.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alessandro.santos on 11/15/16.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
