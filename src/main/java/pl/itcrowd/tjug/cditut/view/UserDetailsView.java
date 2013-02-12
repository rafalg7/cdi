package pl.itcrowd.tjug.cditut.view;

import pl.itcrowd.tjug.cditut.domain.User;
import pl.itcrowd.tjug.cditut.util.qualifiers.Saved;
import pl.itcrowd.tjug.cditut.util.qualifiers.Selected;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Rafal Gielczowski
 * Date: 2/12/13
 * Time: 10:56 AM
 */
@Named
@SessionScoped
public class UserDetailsView implements Serializable {

    private User user;

    public UserDetailsView() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    @Inject
    @Saved
    Event<User> selectEvent;

    /**
     * Observer method, consumes @Selected User event
     *
     * @param user
     */
    public void onUserSelected(@Observes @Selected User user) {
        this.user = user;
    }

    public void save() {
        selectEvent.fire(user);
    }

    public void newUser() {
        user = new User();
    }
}
