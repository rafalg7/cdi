package pl.itcrowd.tjug.cditut.interceptors;

import javax.inject.Qualifier;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Rafal Gielczowski
 * Date: 2/12/13
 * Time: 1:07 PM
 */

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Admin {
}
