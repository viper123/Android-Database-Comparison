package ro.hevsoft.greendao.benchmark.scenarios.greenDao;

import java.util.ArrayList;
import java.util.List;

import ro.hevsoft.greendao.benchmark.Scenario;
import ro.hevsoft.greendao.common.TimeUtils;
import ro.hevsoft.greendao.db.greendao.GreenDaoSingleton;
import ro.hevsoft.greendao.model.User;
import ro.hevsoft.greendao.model.UserDao;

/**
 * GreenDao
 * Created by erusu on 12/21/2016.
 */

public class BasicEncryptedScenario extends Scenario {

    UserDao userDao;

    public BasicEncryptedScenario() {
        super("GreenDao Write 1000 read 1000 encrypted");
        userDao = GreenDaoSingleton.instance().secureSession().getUserDao();
    }

    @Override
    public long runScenario() {
        long time = System.nanoTime();
        userDao.deleteAll();
        User user = new User();
        user.setEmail("amail@gmail.com");
        user.setCui("234345546456");
        user.setPasswd("pppp5666");
        user.setPhoneNr("0789456723");
        List<User> users = new ArrayList<>();
        for(int i=0;i<1000;i++){
            users.add(new User(user.getEmail(),user.getPasswd(),user.getCui(),user.getPasswd()));
        }
        userDao.insertInTx(users);
        userDao.detachAll();
        List<User> res = userDao.queryBuilder().list();
        if(res.size() != users.size()){
            throw new IllegalArgumentException("Wrong list");
        }
        time = System.nanoTime() - time;
        return TimeUtils.msFromNs(time);
    }
}
