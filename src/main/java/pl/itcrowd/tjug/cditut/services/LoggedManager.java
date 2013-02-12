package pl.itcrowd.tjug.cditut.services;

import pl.itcrowd.tjug.cditut.dao.UserRepository;
import pl.itcrowd.tjug.cditut.domain.User;
import pl.itcrowd.tjug.cditut.util.qualifiers.CurrentUser;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
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

    @Inject
    private UserRepository userRepository;

    @Inject
    @CurrentUser
    private User user;

    public void login()
    {
        this.user = userRepository.getUserByName("Max");
    }

    public void logout(){
        this.user = null;
    }

    public boolean isLogged(){
        return (null==user || null==user.getId()) ? false : true;
    }

    @Named
    @Produces
    @CurrentUser
    private User getCurrentUser()
    {
        return user == null ? new User() : user;
    }
}
