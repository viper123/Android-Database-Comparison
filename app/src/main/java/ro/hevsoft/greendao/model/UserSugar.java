package ro.hevsoft.greendao.model;

import com.orm.SugarRecord;

/**
 * GreenDao
 * Created by erusu on 12/22/2016.
 */

public class UserSugar extends SugarRecord{


    private String email;
    private String passwd;
    private String phoneNr;
    private String cui;

    public UserSugar(){}

    public UserSugar(UserSugar us){
        this.email = us.email;
        this.passwd = us.passwd;
        this.phoneNr = us.phoneNr;
        this.cui = us.cui;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }
}
