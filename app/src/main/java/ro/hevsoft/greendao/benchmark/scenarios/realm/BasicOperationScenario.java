package ro.hevsoft.greendao.benchmark.scenarios.realm;

import io.realm.Realm;
import io.realm.RealmResults;
import ro.hevsoft.greendao.benchmark.Scenario;
import ro.hevsoft.greendao.common.TimeUtils;
import ro.hevsoft.greendao.db.realm.RealmSingleton;
import ro.hevsoft.greendao.model.UserRealm;

/**
 * GreenDao
 * Created by erusu on 12/22/2016.
 */

public class BasicOperationScenario extends Scenario {


    public BasicOperationScenario() {
        super("Realm write 1000 read 1000");
    }

    @Override
    public long runScenario() {
        long time = System.nanoTime();
        Realm realm = RealmSingleton.instance().getRealmInstance();
        realm.beginTransaction();
        realm.delete(UserRealm.class);
        for(int i=0;i<1000;i++) {
            UserRealm user = realm.createObject(UserRealm.class);
            user.setEmail("amail@gmail.com");
            user.setCui("234345546456");
            user.setPasswd("pppp5666");
            user.setPhoneNr("0789456723");
        }
        realm.commitTransaction();
        RealmResults<UserRealm> res = realm.where(UserRealm.class).findAll();
        if(res.size() !=1000){
            throw new IllegalStateException("realm result size is incorrect : expected:1000 got:"+res.size());
        }
        return TimeUtils.msFromNs(System.nanoTime() - time);
    }
}
