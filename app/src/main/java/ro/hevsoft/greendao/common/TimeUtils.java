package ro.hevsoft.greendao.common;

/**
 * GreenDao
 * Created by erusu on 12/21/2016.
 */

public class TimeUtils {
    private TimeUtils(){
        throw new Error("instance is not allowed");
    }

    public static long msFromNs(long ns){
        return ns/1000000L;
    }
}
