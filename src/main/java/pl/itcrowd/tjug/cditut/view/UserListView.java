package pl.itcrowd.tjug.cditut.view;

import pl.itcrowd.tjug.cditut.dao.UserRepository;
import pl.itcrowd.tjug.cditut.domain.User;
import pl.itcrowd.tjug.cditut.interceptors.Admin;
import pl.itcrowd.tjug.cditut.services.GreeterService;
import pl.itcrowd.tjug.cditut.util.qualifiers.Removed;
import pl.itcrowd.tjug.cditut.util.qualifiers.Selected;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.util.List;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 12:29 PM
 */
@ManagedBean
@ViewScoped
public class UserListView {

    private List<User> users;

    @Inject
    private UserRepository userRepository;

    @Inject
    private GreeterService greeterService;

    @Inject
    Event<User> selectedEvent;

    public UserListView()
    {
    }

    public List<User> getUsers()
    {
//        if(null==users){
            users = userRepository.getAllUsers();
//        }
        return users;
    }

    public void greetAllUsers(){
        greeterService.greetAllUsers();
    }

    /**
     * method fires selectedEvent with User from param
     * @param u
     */
    public void selectUser(User u){
        selectedEvent.select(new AnnotationLiteral<Selected>() {}).fire(u);
    }

    /**
     * method fires selectedEvent with User from param
     * @param u
     */
    public void removeUser(User u){
        selectedEvent.select(new AnnotationLiteral<Removed>(){}).fire(u);
    }
}
