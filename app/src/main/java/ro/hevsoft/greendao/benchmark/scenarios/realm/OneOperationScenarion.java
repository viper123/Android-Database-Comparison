package ro.hevsoft.greendao.benchmark.scenarios.realm;

import io.realm.Realm;
import io.realm.RealmModel;
import ro.hevsoft.greendao.benchmark.Scenario;
import ro.hevsoft.greendao.common.TimeUtils;
import ro.hevsoft.greendao.db.greendao.GreenDaoSingleton;
import ro.hevsoft.greendao.db.realm.RealmSingleton;
import ro.hevsoft.greendao.model.User;
import ro.hevsoft.greendao.model.UserDao;
import ro.hevsoft.greendao.model.UserRealm;

/**
 * GreenDao
 * Created by erusu on 12/22/2016.
 */

public class OneOperationScenarion extends Scenario {


    public OneOperationScenarion() {
        super("Realm one operation");
    }

    @Override
    public long runScenario() {
        long time = System.nanoTime();
        Realm realm = RealmSingleton.instance().getRealmInstance();
        realm.beginTransaction();
        realm.delete(UserRealm.class);
        UserRealm user = realm.createObject(UserRealm.class);
        user.setEmail("amail@gmail.com");
        user.setCui("234345546456");
        user.setPasswd("pppp5666");
        user.setPhoneNr("0789456723");
        realm.commitTransaction();
        UserRealm res = realm.where(UserRealm.class).findFirst();
        if(!res.getPasswd().equals(user.getPasswd())){
            throw  new IllegalStateException("incorrect returned user");
        }
        return TimeUtils.msFromNs(System.nanoTime() - time);
    }
}
