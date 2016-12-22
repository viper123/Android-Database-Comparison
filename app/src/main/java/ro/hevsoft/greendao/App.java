package ro.hevsoft.greendao;

import com.orm.SugarApp;

import io.realm.RealmConfiguration;
import ro.hevsoft.greendao.db.greendao.GreenDaoSingleton;
import ro.hevsoft.greendao.db.realm.RealmSingleton;

/**
 * GreenDao
 * Created by erusu on 12/21/2016.
 */

public class App extends SugarApp {


    @Override
    public void onCreate() {
        super.onCreate();
        //GreenDao init
        GreenDaoSingleton.Init(this);
        RealmSingleton.Init(this);
    }

}
