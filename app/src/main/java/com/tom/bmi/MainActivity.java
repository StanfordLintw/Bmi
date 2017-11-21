package com.tom.bmi;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s = new String("abc");
    private EditText edWeight;
    private EditText edHeight;
    private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate" );
        findViews();
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("xxx")
                        .setMessage("BMI原來的設計是一個用於公眾健康研究的統計工具。當需要知道肥胖是否為某一疾病的致病原因時，可以把病人的身高及體重換算成BMI，再找出其數值及病發率是否有線性關連。")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume" );
    }

    private void findViews() {
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_height);
        bHelp = (Button) findViewById(R.id.b_help);
    }


    public void bmi(View view){
//        System.out.println("what???");
        Log.d("MainActivity", "testing bmi method");

        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi = weight / (height * height);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(getString(R.string.extra_bmi), bmi);
        startActivity(intent);


        /*new AlertDialog.Builder(this)
                .setMessage(getString(R.string.your_bmi_is) + bmi)
                .setTitle(R.string.bmi_title)
                .setPositiveButton(R.string.ok, null)
                .show();*/

       /* Log.d("MainActivity", "You BMI is : " + bmi);
        Toast.makeText(this,
                "Your BMI is " + bmi,
                Toast.LENGTH_LONG)
                .show();*/
    }
}
