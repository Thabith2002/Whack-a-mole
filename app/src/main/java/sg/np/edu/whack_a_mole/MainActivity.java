package sg.np.edu.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Whack A Mole!";
    TextView resultTextView;
    int score = 0;
    DecimalFormat df = new DecimalFormat("#");
    String points = df.format(score);
    Button buttonLeft;
    Button buttonMiddle;
    Button buttonRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Finished Pre-Initialisation!");
        resultTextView = findViewById(R.id.resultView);
        buttonLeft = findViewById(R.id.buttonLeft);
        buttonMiddle = findViewById(R.id.buttonMiddle);
        buttonRight = findViewById(R.id.buttonRight);
    }
    @Override
    protected void onStart() {
        super.onStart();

        Log.v(TAG, "Starting GUI!");

        resultTextView.setText(points);

        setNewMole();
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonLeft:
                        Log.v(TAG, "Button Left Clicked!");
                        if (buttonLeft.getText() == "*") {
                            score += 1;
                            points = df.format(score);
                            resultTextView.setText(points);
                            Log.v(TAG, "Hit, score added!\n");
                            setNewMole();
                        } else {
                            score -= 1;
                            if(score < 0){
                                score = 0;
                            }
                            points = df.format(score);
                            resultTextView.setText(points);
                            System.out.println("Missed, score deducted!");
                            setNewMole();
                        }
                        break;


                    case R.id.buttonMiddle:
                        Log.v(TAG, "Button Middle Clicked!");

                        if (buttonMiddle.getText() == "*") {
                            score += 1;
                            points = df.format(score);
                            resultTextView.setText(points);
                            Log.v(TAG, "Hit, score added!\n");
                            setNewMole();
                        } else {
                            score -= 1;
                            if(score < 0){
                                score = 0;
                            }
                            points = df.format(score);
                            resultTextView.setText(points);
                            Log.v(TAG, "Missed, score deducted!\n");
                            setNewMole();
                        }
                        break;

                    case R.id.buttonRight:
                        Log.v(TAG, "Button Right Clicked!");

                        if (buttonRight.getText() == "*") {
                            score += 1;
                            points = df.format(score);
                            resultTextView.setText(points);
                            Log.v(TAG, "Hit, score added!\n");
                            setNewMole();
                        } else {
                            score -= 1;
                            if(score < 0){
                                score = 0;
                            }
                            points = df.format(score);
                            resultTextView.setText(points);
                            Log.v(TAG, "Missed, score deducted!\n");
                            setNewMole();
                        }


                }
            }


        };

        buttonLeft.setOnClickListener(onclick);
        buttonMiddle.setOnClickListener(onclick);
        buttonRight.setOnClickListener(onclick);
    }




    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);

        if(randomLocation == 0){
            buttonLeft.setText("*");
            buttonMiddle.setText("O");
            buttonRight.setText("O");
        }
        else if(randomLocation == 1){
            buttonMiddle.setText("*");
            buttonLeft.setText("O");
            buttonRight.setText("O");
        }
        else if(randomLocation == 2){
            buttonRight.setText("*");
            buttonMiddle.setText("O");
            buttonLeft.setText("O");
        }
    }

}
