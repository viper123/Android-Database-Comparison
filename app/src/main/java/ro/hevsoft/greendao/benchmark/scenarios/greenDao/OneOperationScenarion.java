package ro.hevsoft.greendao.benchmark.scenarios.greenDao;

import ro.hevsoft.greendao.benchmark.Scenario;
import ro.hevsoft.greendao.common.TimeUtils;
import ro.hevsoft.greendao.db.greendao.GreenDaoSingleton;
import ro.hevsoft.greendao.model.User;
import ro.hevsoft.greendao.model.UserDao;

/**
 * GreenDao
 * Created by erusu on 12/22/2016.
 */

public class OneOperationScenarion extends Scenario {

    private UserDao userDao;

    public OneOperationScenarion() {
        super("greenDao one operation");
        this.userDao = GreenDaoSingleton.instance().session().getUserDao();
    }

    @Override
    public long runScenario() {
        long time = System.nanoTime();
        User user = new User("fsdfdfg","sdfgdfgdfg","dfgdfgdfg","sfgdfgdfgdf");
        userDao.deleteAll();
        userDao.insert(user);
        userDao.detachAll();
        User res = userDao.queryBuilder().where(UserDao.Properties.Email.eq(user.getEmail())).unique();
        if(!res.getPasswd().equals(user.getPasswd())){
            throw  new IllegalStateException("incorrect returned user");
        }
        return TimeUtils.msFromNs(System.nanoTime() - time);
    }
}
