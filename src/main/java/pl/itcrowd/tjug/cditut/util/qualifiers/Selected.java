package pl.itcrowd.tjug.cditut.util.qualifiers;

import javax.inject.Qualifier;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Rafal Gielczowski
 * Date: 2/12/13
 * Time: 11:00 AM
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, TYPE, PARAMETER})
public @interface Selected {
}
