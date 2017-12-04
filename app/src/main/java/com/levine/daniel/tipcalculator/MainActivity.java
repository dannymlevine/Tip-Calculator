package com.levine.daniel.tipcalculator;

/**
 * Created by daniel on 11/29/17.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button calculateButton;
    private TextView result;
    private SeekBar tipPercentage;
    private EditText billAmount;
    private TextView seekbarPercent;
    private int percentage;
    private float enteredBillAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        billAmount = (EditText) findViewById(R.id.billAmount);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        result = (TextView) findViewById(R.id.resultID);
        tipPercentage = (SeekBar) findViewById(R.id.tipPercentageID);
        seekbarPercent = (TextView) findViewById(R.id.seekbarPercentID);
        calculateButton.setOnClickListener(this);

        tipPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekbarPercent.setText(String.valueOf(seekBar.getProgress())+'%');
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                percentage = seekBar.getProgress();
            }
        });




    }

    @Override
    public void onClick(View view) {
        calculate();

    }

    public void calculate(){
        float resultAmount = 0.0f;
        if(!billAmount.getText().toString().equals("")) {


            enteredBillAmount = Float.parseFloat(billAmount.getText().toString());
            resultAmount = enteredBillAmount* percentage/100;
            result.setText("Your tip will be "+ String.valueOf(resultAmount));
        }
        else{
            Toast.makeText(MainActivity.this, "please enter a bill amount",Toast.LENGTH_LONG).show();
        }
    }
}
