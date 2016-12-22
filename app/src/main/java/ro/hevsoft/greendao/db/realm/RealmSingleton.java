package ro.hevsoft.greendao.db.realm;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * GreenDao
 * Created by erusu on 12/22/2016.
 */

public class RealmSingleton  {

    private static RealmSingleton instance;

    public static void Init(Context context){
        instance = new RealmSingleton();
        byte [] key = new byte[64];
        Realm.init(context);
        instance.secureConf = new RealmConfiguration.Builder()
                .encryptionKey(key)
                .build();
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                                            .deleteRealmIfMigrationNeeded()
                                            .name("realm.db")
                                            .build());
    }

    private RealmConfiguration secureConf;

    public static RealmSingleton instance(){
        if(instance == null){
            throw new IllegalStateException("instance is null pleas call Init First");
        }
        return instance;
    }

    public Realm getRealmInstance(){
        return Realm.getDefaultInstance();
    }

    public Realm getRealmSecureInstance(){
        return Realm.getInstance(secureConf);
    }
}
