package ro.hevsoft.greendao.benchmark;

import java.util.ArrayList;
import java.util.List;

/**
 * GreenDao
 * Created by erusu on 12/21/2016.
 */

public class ScenarioRunner {

    private ResultDisplay resultDisplay;

    private List<Scenario> scenarios;

    public ScenarioRunner(ResultDisplay resultDisplay){
        scenarios = new ArrayList<>();
        this.resultDisplay = resultDisplay;
    }

    public void addScenario(Scenario sc){
        this.scenarios.add(sc);
    }

    public void runScenarios(){
        for(Scenario sc:scenarios){
            resultDisplay.showResult("Scenario: "+sc.name()+" completed in "+sc.runScenario()+ "ms");
        }
    }


}
