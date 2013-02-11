package pl.itcrowd.tjug.cditut.services;

import pl.itcrowd.tjug.cditut.dao.UserRepository;
import pl.itcrowd.tjug.cditut.domain.User;
import pl.itcrowd.tjug.cditut.services.util.RandomGreeting;
import pl.itcrowd.tjug.cditut.util.Dummy;
import pl.itcrowd.tjug.cditut.util.Mailer;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 1:18 PM
 */
@Stateless
public class GreeterService {

    private static final Logger LOGGER = Logger.getLogger(GreeterService.class.getCanonicalName());

    @Inject
    private Mailer mailer;

    @Inject
    private UserRepository userRepository;

    @Asynchronous
    public void greetAllUsers(){
        List<User> userList = userRepository.getAllUsers();
        LOGGER.info("Greeter service will send greetings to "+userList.size()+" users.");

        for(User user : userList){
            mailer.sendMailToUser(user);
        }
    }
}
