package pl.itcrowd.tjug.cditut.view;

import pl.itcrowd.tjug.cditut.dao.UserRepository;
import pl.itcrowd.tjug.cditut.domain.User;
import pl.itcrowd.tjug.cditut.services.GreeterService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 12:29 PM
 */
@ManagedBean
@ViewScoped
public class UserView {

    private List<User> users;

    @Inject
    private UserRepository userRepository;

    @Inject
    private GreeterService greeterService;

    public UserView()
    {
    }

    public List<User> getUsers()
    {
        if(null==users){
            users = userRepository.getAllUsers();
        }
        return users;
    }

    public void greetAllUsers(){
        greeterService.greetAllUsers();
    }
}
