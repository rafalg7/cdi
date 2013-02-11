package pl.itcrowd.tjug.cditut.util;

import javax.inject.Qualifier;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Rafal Gielczowski
 * Date: 2/11/13 Time: 1:46 PM
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface Real {

}
