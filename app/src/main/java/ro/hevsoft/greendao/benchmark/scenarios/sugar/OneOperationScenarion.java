package ro.hevsoft.greendao.benchmark.scenarios.sugar;

import ro.hevsoft.greendao.benchmark.Scenario;
import ro.hevsoft.greendao.common.TimeUtils;
import ro.hevsoft.greendao.db.greendao.GreenDaoSingleton;
import ro.hevsoft.greendao.model.User;
import ro.hevsoft.greendao.model.UserDao;
import ro.hevsoft.greendao.model.UserSugar;

/**
 * GreenDao
 * Created by erusu on 12/22/2016.
 */

public class OneOperationScenarion extends Scenario {

    public OneOperationScenarion() {
        super("Sugar one operation");
    }

    @Override
    public long runScenario() {
        long time = System.nanoTime();
        UserSugar.deleteAll(UserSugar.class);
        UserSugar user = new UserSugar();
        user.setEmail("amail@gmail.com");
        user.setCui("234345546456");
        user.setPasswd("pppp5666");
        user.setPhoneNr("0789456723");
        user.save();

        UserSugar res = UserSugar.find(UserSugar.class,"email =\""+user.getEmail()+"\"").get(0);
        if(!res.getPasswd().equals(user.getPasswd())){
            throw new IllegalStateException("not the same object");
        }
        return TimeUtils.msFromNs(System.nanoTime() - time);
    }
}
