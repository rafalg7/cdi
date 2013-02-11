package pl.itcrowd.tjug.cditut.services;

import pl.itcrowd.tjug.cditut.domain.User;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Rafal Gielczowski
 * Date: 2/11/13
 * Time: 8:08 PM
 */
@Named
@SessionScoped
public class LoggedManager implements Serializable {

    private User user;

    public void login()
    {
        this.user = new User();
        this.user.setName("Max");
    }

    @Named
    @Produces
    private User getCurrentUser()
    {
        return user == null ? new User() : user;
    }
}
