package pl.itcrowd.tjug.cditut.util;

import pl.itcrowd.tjug.cditut.dao.UserRepository;
import pl.itcrowd.tjug.cditut.domain.User;
import pl.itcrowd.tjug.cditut.domain.UserRole;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 12:32 PM
 */

@Startup
@Singleton
public class Starter {

    @Inject
    private UserRepository userRepository;

    @PostConstruct
    private void onCreate(){
        userRepository.saveUser(new User("John", UserRole.CLIENT));
        userRepository.saveUser(new User("Mark", UserRole.CLIENT));
        userRepository.saveUser(new User("Max", UserRole.ADMIN));
        userRepository.saveUser(new User("Anna", UserRole.CLIENT));
    }

}
