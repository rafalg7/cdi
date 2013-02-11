package pl.itcrowd.tjug.cditut.util;

import pl.itcrowd.tjug.cditut.domain.User;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 1:09 PM
 */

public interface Mailer {
    void sendMailToUser(User u);
}
