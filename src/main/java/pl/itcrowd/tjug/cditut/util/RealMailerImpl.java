package pl.itcrowd.tjug.cditut.util;

import pl.itcrowd.tjug.cditut.domain.User;

import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 1:10 PM
 */
@Real
public class RealMailerImpl implements Mailer{

    private static final Logger LOGGER = Logger.getLogger(RealMailerImpl.class.getCanonicalName());

    public void sendMailToUser(User user, String message){
        LOGGER.info("Sending REAL mail to user "+user.getName()+": "+message);
    }

}
