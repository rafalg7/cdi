package pl.itcrowd.tjug.cditut.dao;

import pl.itcrowd.tjug.cditut.domain.User;
import pl.itcrowd.tjug.cditut.util.qualifiers.Removed;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 12:23 PM
 */
@Stateless
public class UserRepository implements Serializable {

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

    public User getUserByName(String name){
        final List<User> resultList = (List<User>)em.createQuery("SELECT u FROM User u WHERE u.name LIKE :sName").setParameter("sName", name).getResultList();
        if(resultList.size()==0)
            return null;
        else
            return (User)resultList.get(0);
    }

    public List<User> getAllUsers(){
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    public void removeUser(@Observes @Removed User user){
        User found = em.find(User.class, user.getId());
        em.remove(found);
    }

}
