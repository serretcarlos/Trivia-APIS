package com.proyecto.apis.triviaapis;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtProgress;
    long startTime = 0;
    long pauseTime = 0;
    private ProgressBar progressBar;

    //runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            seconds = seconds % 60;
            if (seconds == 10){
                txtProgress.setText(String.format("%2d", 0));
                timerHandler.removeCallbacks(timerRunnable);
                updateQuestion();
                startTime = System.currentTimeMillis();
                timerHandler.postDelayed(timerRunnable, 0);
            }
            else {
                txtProgress.setText(String.format("%2d", seconds));
                timerHandler.postDelayed(this, 500);
                progressBar.setProgress(seconds*10);
            }
        }
    };


    private QuestionsLibrary mQuestionLibrary = new QuestionsLibrary();
    private Button btnOpcionUno;
    private Button btnOpcionDos;
    private Button btnOpcionTres;
    private TextView tvPregunta;
    private String mAnswer;
    private int mQuestionNumber = 0;


    private static final int UI_ANIMATION_DELAY = 0;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
        }
    };

    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        mContentView = findViewById(R.id.fullscreen_content);
        hide();

        tvPregunta = findViewById(R.id.text_pregunta_ques);
        btnOpcionUno = findViewById(R.id.btn_choiceone);
        btnOpcionDos = findViewById(R.id.btn_choicetwo);
        btnOpcionTres = findViewById(R.id.btn_choicethree);
        btnOpcionUno.setOnClickListener(this);
        btnOpcionDos.setOnClickListener(this);
        btnOpcionTres.setOnClickListener(this);
        updateQuestion();

        txtProgress = findViewById(R.id.txtProgress);
        progressBar = findViewById(R.id.progressBar);
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);
    }


    @Override
    public void onClick(View view) {
        boolean correcta = false;
        switch (view.getId()){
            case R.id.btn_choiceone:
                if (btnOpcionUno.getText() == mAnswer){
                    //updateScore(mScore);
                    correcta = true;
                }
                break;
            case R.id.btn_choicetwo:
                if (btnOpcionDos.getText() == mAnswer){
                    //updateScore(mScore);
                    correcta = true;
                }
                break;
            case R.id.btn_choicethree:
                if (btnOpcionTres.getText() == mAnswer){
                    //updateScore(mScore);
                    correcta = true;
                }
                break;
        }
        somethingAnswered(view.getId(), correcta);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hide();
    }

    private void updateQuestion(){
        tvPregunta.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        btnOpcionUno.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        btnOpcionDos.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        btnOpcionTres.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
    }

    private void somethingAnswered(final int id, boolean correcta){

        resetTimer();
        if (correcta) {
            findViewById(id).setBackgroundResource(R.drawable.correct_answer);
        }
        else {
            findViewById(id).setBackgroundResource(R.drawable.wrong_answer);
        }
        btnOpcionUno.setEnabled(false);
        btnOpcionDos.setEnabled(false);
        btnOpcionTres.setEnabled(false);
        Timer buttonTimer = new Timer();
        buttonTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        btnOpcionUno.setEnabled(true);
                        btnOpcionDos.setEnabled(true);
                        btnOpcionTres.setEnabled(true);
                        updateQuestion();
                        startTime = System.currentTimeMillis();
                        timerHandler.postDelayed(timerRunnable, 0);
                        findViewById(id).setBackgroundResource(R.drawable.unanswered);
                    }
                });
            }
        }, 2500);
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    private void resetTimer(){
        timerHandler.removeCallbacks(timerRunnable);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

}
