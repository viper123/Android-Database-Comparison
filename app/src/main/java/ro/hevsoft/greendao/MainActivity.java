package ro.hevsoft.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ro.hevsoft.greendao.benchmark.scenarios.greenDao.BasicDataAccessScenario;
import ro.hevsoft.greendao.benchmark.ResultDisplay;
import ro.hevsoft.greendao.benchmark.ScenarioRunner;
import ro.hevsoft.greendao.benchmark.scenarios.greenDao.BasicEncryptedScenario;
import ro.hevsoft.greendao.benchmark.scenarios.greenDao.OneOperationScenarion;
import ro.hevsoft.greendao.benchmark.scenarios.realm.BasicEncryptedDbOperationScenario;
import ro.hevsoft.greendao.benchmark.scenarios.realm.BasicOperationScenario;
import ro.hevsoft.greendao.benchmark.scenarios.realm.OneOperationEncryptedScenarion;

public class MainActivity extends AppCompatActivity {

    private TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_result = TextView.class.cast(findViewById(R.id.txt_res));

        final ScenarioRunner runner = new ScenarioRunner(new TextResultDisplay());
        runner.addScenario(new BasicDataAccessScenario());
        runner.addScenario(new BasicEncryptedScenario());
        runner.addScenario(new ro.hevsoft.greendao.benchmark.scenarios.sugar.BasicDataAccessScenario());
        runner.addScenario(new OneOperationScenarion());
        runner.addScenario(new ro.hevsoft.greendao.benchmark.scenarios.sugar.OneOperationScenarion());
        runner.addScenario(new BasicOperationScenario());
        runner.addScenario(new BasicEncryptedDbOperationScenario());
        runner.addScenario(new ro.hevsoft.greendao.benchmark.scenarios.realm.OneOperationScenarion());
        runner.addScenario(new OneOperationEncryptedScenarion());
        findViewById(R.id.btn_run).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runner.runScenarios();
            }
        });
        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_result.setText(R.string.results);
            }
        });
    }

    private class TextResultDisplay implements ResultDisplay{

        @Override
        public void showResult(String res) {
            txt_result.setText(txt_result.getText()+"\n"+res);
        }
    }
}
