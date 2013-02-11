package pl.itcrowd.tjug.cditut.util;

import pl.itcrowd.tjug.cditut.domain.User;
import pl.itcrowd.tjug.cditut.services.util.RandomGreeting;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.New;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 1:10 PM
 */

public class RealMailerImpl implements Mailer{

    private static final Logger LOGGER = Logger.getLogger(RealMailerImpl.class.getCanonicalName());

    public void sendMailToUser(User user){
        LOGGER.info("Sending REAL mail to user "+user.getName());
    }

}
