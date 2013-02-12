package pl.itcrowd.tjug.cditut.interceptors;

import pl.itcrowd.tjug.cditut.domain.User;
import pl.itcrowd.tjug.cditut.domain.UserRole;
import pl.itcrowd.tjug.cditut.util.qualifiers.CurrentUser;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import java.io.Serializable;

/**
 * Rafal Gielczowski
 * Date: 2/12/13
 * Time: 1:05 PM
 */

@Admin
@Interceptor
public class SecurityInterceptor implements Serializable {

    @Inject
    @CurrentUser
    private User currentUser;

    @AroundInvoke
    public Object checkCredentials(InvocationContext invocationContext) throws Exception {

        if(null==currentUser || null==currentUser.getId()) {
            throw new SecurityException("Please log in!");
        }

        if(!currentUser.getRole().equals(UserRole.ADMIN)){
            throw new SecurityException("You must be ADMIN to see this!");
        }else{
            return invocationContext.proceed();
        }
    }
}
