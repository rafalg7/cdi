package pl.itcrowd.tjug.cditut.dao;

import pl.itcrowd.tjug.cditut.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 12:23 PM
 */
@Stateless
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void saveUser(User user){
        if(null!=user){
            if(null!=user.getId()){
                em.merge(user);
            }else{
                em.persist(user);
            }
        }
    }

    public User getUserById(Long id){
        return em.find(User.class, id);
    }

    public List<User> getAllUsers(){
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

}
