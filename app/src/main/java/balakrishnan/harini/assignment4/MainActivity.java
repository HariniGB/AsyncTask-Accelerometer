package balakrishnan.harini.assignment4;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView x,y,z,log;
    EditText simulate;
    Integer xParam, yParam, zParam, sParam;
    Button btn, cbtn;
    int min = -250;
    int max = 250;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x = (TextView) findViewById(R.id.xValueText);
        y = (TextView) findViewById(R.id.yValueText);
        z = (TextView) findViewById(R.id.zValueText);
        simulate = (EditText) findViewById(R.id.simulateValue);
        log = (TextView) findViewById(R.id.logReport);
        btn = (Button)  findViewById(R.id.generate_button);
        cbtn = (Button) findViewById(R.id.cancel_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sParam = Integer.parseInt(simulate.getText().toString());
                Log.i("Stimulate value",sParam.toString());
                new MyTask().execute(sParam);
            }
        });
        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    private class MyTask extends AsyncTask<Integer, Integer, Void> {
        String logReport = "";
        Integer count = 1;

        @Override
        protected Void doInBackground(Integer... sParam) {
            while(count <= sParam[0]){
                xParam = r.nextInt((max - min) + 1) + min;
                yParam = r.nextInt((max - min) + 1) + min;
                zParam = r.nextInt((max - min) + 1) + min;
                publishProgress(count);
                count++;
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.wtf("MainActivity", e.getMessage());
                }
            }
            return null;
        }
        protected void onProgressUpdate(Integer... count) {
            super.onProgressUpdate();
            String result = "\nSimulation Count:" + count[0].toString() +
                    ", X:" + xParam.toString() +
                    ", Y:" + yParam.toString() +
                    ", Z:"+ zParam.toString();
            logReport = logReport + result;
            x.setText(String.valueOf(xParam));
            y.setText(String.valueOf(yParam));
            z.setText(String.valueOf(zParam));
            log.setMovementMethod(new ScrollingMovementMethod());
            log.setText(logReport);
            Log.i("onProgressUpdate",result);
        }
    }
}
