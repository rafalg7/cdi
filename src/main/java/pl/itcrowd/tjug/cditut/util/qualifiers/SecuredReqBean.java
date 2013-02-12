package pl.itcrowd.tjug.cditut.util.qualifiers;

import pl.itcrowd.tjug.cditut.interceptors.Admin;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;
import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Rafal Gielczowski
 * Date: 2/12/13
 * Time: 4:03 PM
 */

@RequestScoped
@Admin
@Named
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface SecuredReqBean {
}
