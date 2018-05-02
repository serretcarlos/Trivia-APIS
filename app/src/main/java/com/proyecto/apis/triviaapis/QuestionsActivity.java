package com.proyecto.apis.triviaapis;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    //runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            seconds = (int) (millis / 1000);
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

    private TextView txtProgress;
    long startTime = 0;
    private ProgressBar progressBar;
    int seconds = 0;
    private QuestionsLibrary mQuestionLibrary = new QuestionsLibrary();
    private Button btnOpcionUno;
    private Button btnOpcionDos;
    private Button btnOpcionTres;
    private Button btnOpcionCuatro;
    private TextView tvPregunta;
    private TextView tvNumeroPregunta;
    private TextView tvPuntaje;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private List<Integer> arrPreguntas = new ArrayList<>();

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
        shuffle();
        tvPuntaje = findViewById(R.id.text_puntaje_ques);
        tvPregunta = findViewById(R.id.text_pregunta_ques);
        tvNumeroPregunta = findViewById(R.id.text_question_number);
        btnOpcionUno = findViewById(R.id.btn_choiceone);
        btnOpcionDos = findViewById(R.id.btn_choicetwo);
        btnOpcionTres = findViewById(R.id.btn_choicethree);
        btnOpcionCuatro = findViewById(R.id.btn_choicefour);
        btnOpcionUno.setOnClickListener(this);
        btnOpcionDos.setOnClickListener(this);
        btnOpcionTres.setOnClickListener(this);
        btnOpcionCuatro.setOnClickListener(this);
        updateQuestion();

        txtProgress = findViewById(R.id.txtProgress);
        progressBar = findViewById(R.id.progressBar);
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);
    }


    @Override
    public void onClick(View view) {
        boolean correct = false;
        switch (view.getId()){
            case R.id.btn_choiceone:
                if (btnOpcionUno.getText() == mAnswer){
                    correct = true;
                }
                break;
            case R.id.btn_choicetwo:
                if (btnOpcionDos.getText() == mAnswer){
                    correct = true;
                }
                break;
            case R.id.btn_choicethree:
                if (btnOpcionTres.getText() == mAnswer){
                    correct = true;
                }
                break;
            case R.id.btn_choicefour:
                if (btnOpcionCuatro.getText() == mAnswer){
                    correct = true;
                }
                break;
        }
        somethingAnswered(view.getId(), correct);
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
        if (mQuestionNumber < 10) {
            tvPregunta.setText(mQuestionLibrary.getQuestion(arrPreguntas.get(mQuestionNumber)));
            btnOpcionUno.setText(mQuestionLibrary.getChoice1(arrPreguntas.get(mQuestionNumber)));
            btnOpcionDos.setText(mQuestionLibrary.getChoice2(arrPreguntas.get(mQuestionNumber)));
            btnOpcionTres.setText(mQuestionLibrary.getChoice3(arrPreguntas.get(mQuestionNumber)));
            btnOpcionCuatro.setText(mQuestionLibrary.getChoice4(arrPreguntas.get(mQuestionNumber)));
            mAnswer = mQuestionLibrary.getCorrectAnswer(arrPreguntas.get(mQuestionNumber));
        } else {
            Intent intent = new Intent(QuestionsActivity.this, PunctuationActivity.class);
            intent.putExtra("score", mScore);
            startActivity(intent);
            resetTimer();
            this.finish();
        }
        mQuestionNumber++;
        if (mQuestionNumber-1<10)
            tvNumeroPregunta.setText(String.valueOf(mQuestionNumber));
    }

    private void somethingAnswered(final int id, boolean correct){
        if (correct) {
            findViewById(id).setBackgroundResource(R.drawable.correct_answer);
            updateScore();
        }
        else {
            findViewById(id).setBackgroundResource(R.drawable.wrong_answer);
        }
        resetTimer();
        btnOpcionUno.setEnabled(false);
        btnOpcionDos.setEnabled(false);
        btnOpcionTres.setEnabled(false);
        btnOpcionCuatro.setEnabled(false);
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
                        btnOpcionCuatro.setEnabled(true);
                        startTime = System.currentTimeMillis();
                        timerHandler.postDelayed(timerRunnable, 0);
                        updateQuestion();
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

    private void updateScore(){
        mScore = mScore + (20 - (seconds*2));
        tvPuntaje.setText(String.valueOf(mScore));
    }


    public void shuffle() {
        int nuevo = new Random().nextInt(10);
        for (int i = 0; i < 10; i++) {
            while (arrPreguntas.contains(nuevo)){
                nuevo = new Random().nextInt(11);
            }
            arrPreguntas.add(nuevo);
        }
    }

}
