package ro.hevsoft.greendao.model;

import org.greenrobot.greendao.annotation.Entity;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * GreenDao
 * Created by erusu on 12/21/2016.
 */
@Entity
public class User {

    private String email;
    private String passwd;
    private String phoneNr;
    private String cui;
    //private List<String> addresses;
    @Generated(hash = 151885613)
    public User(String email, String passwd, String phoneNr, String cui) {
        this.email = email;
        this.passwd = passwd;
        this.phoneNr = phoneNr;
        this.cui = cui;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswd() {
        return this.passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getPhoneNr() {
        return this.phoneNr;
    }
    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }
    public String getCui() {
        return this.cui;
    }
    public void setCui(String cui) {
        this.cui = cui;
    }
}
