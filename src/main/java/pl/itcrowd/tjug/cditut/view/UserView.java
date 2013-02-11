package pl.itcrowd.tjug.cditut.view;

import pl.itcrowd.tjug.cditut.dao.UserRepository;
import pl.itcrowd.tjug.cditut.domain.User;
import pl.itcrowd.tjug.cditut.util.Gateway;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 12:29 PM
 */
@ManagedBean
@ViewScoped
public class UserView {

    private List<User> users;

    private UserRepository userRepository;

    public UserView()
    {
    }

    @ManagedProperty(value = "#{gateway}")
    private Gateway gateway;

    @PostConstruct
    public void onCreate(){
        this.userRepository = gateway.getUserRepository();
    }

    public List<User> getUsers()
    {
        if(null==users){
            users = userRepository.getAllUsers();
        }
        return users;
    }

    public Gateway getGateway()
    {
        return gateway;
    }

    public void setGateway(Gateway gateway)
    {
        this.gateway = gateway;
    }
}
