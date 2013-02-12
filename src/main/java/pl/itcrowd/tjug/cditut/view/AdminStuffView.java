package pl.itcrowd.tjug.cditut.view;

import pl.itcrowd.tjug.cditut.interceptors.Admin;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Rafal Gielczowski
 * Date: 2/12/13
 * Time: 2:07 PM
 */

@Admin
@Named
@RequestScoped
public class AdminStuffView implements Serializable {

    public String getAdminNews(){
        return "Hello admin! This is restricted text!";
    }

}
