package ro.hevsoft.greendao.benchmark;

/**
 * GreenDao
 * Created by erusu on 12/21/2016.
 */

public abstract class Scenario {


    private String name;

    public Scenario(String name){
        this.name = name;
    }

    public abstract long runScenario();

    public String name(){
        return name;
    }


}
