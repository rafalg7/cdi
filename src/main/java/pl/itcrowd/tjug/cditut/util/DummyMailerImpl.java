package pl.itcrowd.tjug.cditut.util;

import pl.itcrowd.tjug.cditut.domain.User;

import javax.enterprise.inject.Alternative;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 1:12 PM
 */

@Alternative
public class DummyMailerImpl implements Mailer{

    private static final Logger LOGGER = Logger.getLogger(DummyMailerImpl.class.getCanonicalName());

    @Override
    public void sendMailToUser(User user, String message)
    {
        LOGGER.info("Should send mail to "+user.getName()+": "+message);
    }
}
