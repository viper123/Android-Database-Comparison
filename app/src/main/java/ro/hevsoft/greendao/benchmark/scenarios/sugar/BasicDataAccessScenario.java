package ro.hevsoft.greendao.benchmark.scenarios.sugar;

import java.util.ArrayList;
import java.util.List;

import ro.hevsoft.greendao.benchmark.Scenario;
import ro.hevsoft.greendao.common.TimeUtils;
import ro.hevsoft.greendao.model.UserSugar;

/**
 * GreenDao
 * Created by erusu on 12/22/2016.
 */

public class BasicDataAccessScenario extends Scenario{

    public BasicDataAccessScenario() {
        super("Sugar write 1000 read 1000");
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
        List<UserSugar> users = new ArrayList<>();
        for(int i=0;i<1000;i++){
            users.add(new UserSugar(user));
        }
        UserSugar.saveInTx(users);
        List<UserSugar> res = UserSugar.listAll(UserSugar.class);
        if(res.size() != users.size()){
            throw new IllegalStateException("list size are different: expected:"+users.size()+" Got:"+res.size());
        }
        return TimeUtils.msFromNs(System.nanoTime()-time);
    }
}
