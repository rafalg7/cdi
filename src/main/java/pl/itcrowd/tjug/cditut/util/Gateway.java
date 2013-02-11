package pl.itcrowd.tjug.cditut.util;

import pl.itcrowd.tjug.cditut.dao.UserRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 12:34 PM
 */
@ManagedBean
@SessionScoped
public class Gateway {

    private static final Logger LOGGER = Logger.getLogger(Gateway.class.getCanonicalName());

    private UserRepository userRepository;

    /**
     * Search UserRepository trough JNDI
     * @return
     */
    public UserRepository getUserRepository()
    {
        try {
            return  (UserRepository) new InitialContext().lookup("java:global/cdi-tut/UserRepository");
        } catch (NamingException e) {
            LOGGER.info("Error lookup PostManager:"+e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }
}
