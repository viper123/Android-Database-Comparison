package ro.hevsoft.greendao.db.greendao;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

import ro.hevsoft.greendao.model.DaoMaster;
import ro.hevsoft.greendao.model.DaoSession;

/**
 * GreenDao
 * Created by erusu on 12/21/2016.
 */

public class GreenDaoSingleton {

    private static GreenDaoSingleton instance;

    public static GreenDaoSingleton instance(){
        if(instance == null){
            throw new IllegalStateException("instance is null, please call init first");
        }
        return instance;
    }

    public static void Init(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,"users.db");
        Database normalDb = helper.getWritableDb();
        DaoMaster.DevOpenHelper secureHelper = new DaoMaster.DevOpenHelper(context,"users-secure.db");
        Database encryptedDb = secureHelper.getEncryptedReadableDb("password");
        instance = new GreenDaoSingleton(new DaoMaster(normalDb).newSession(),
                new DaoMaster(encryptedDb).newSession());
    }

    private final DaoSession normalSession;
    private final DaoSession encryptedSession;

    private GreenDaoSingleton(DaoSession normalSession,DaoSession encryptedSession) {
        this.normalSession = normalSession;
        this.encryptedSession = encryptedSession;
    }

    public DaoSession session(){
        return normalSession;
    }

    public DaoSession secureSession(){
        return encryptedSession;
    }
}
