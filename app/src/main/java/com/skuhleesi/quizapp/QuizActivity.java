package com.skuhleesi.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.skuhleesi.quizapp.R.id.questionFour;
import static com.skuhleesi.quizapp.R.id.questionFour_answerOne;
import static com.skuhleesi.quizapp.R.id.questionOne;

public class QuizActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    /**
     * This method will check the answer of question 2 and 3 and update the score
     */

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();

        switch(view.getId()){
            case R.id.radio_true:
                if(checked){
                    score += 1;
                }
                break;
            case R.id.radio_false:
                if(checked){
                    score += 0;
                }
                break;
            case R.id.multipleChoice_answer_one:
                if(checked){
                    score += 1;
                }
                break;
            case R.id.multipleChoice_answer_two:
                if(checked){
                    score += 0;
                }
                break;
            case R.id.multipleChoice_answer_three:
                if(checked){
                    score += 0;
                }
                break;
        }
    }

    /**
     * This method will check the answer to question four
     */

    public void isChecked(View view){
        CheckBox questionFour_answerOne = (CheckBox)findViewById(R.id.questionFour_answerOne);
        boolean answerOne = questionFour_answerOne.isChecked();

        CheckBox questionFour_answerTwo = (CheckBox)findViewById(R.id.questionFour_answerTwo);
        boolean answerTwo = questionFour_answerTwo.isChecked();

        CheckBox questionFour_answerThree = (CheckBox)findViewById(R.id.questionFour_answerThree);
        boolean answerThree = questionFour_answerThree.isChecked();

        CheckBox questionFour_answerFour = (CheckBox)findViewById(R.id.questionFour_answerFour);
        boolean answerFour = questionFour_answerFour.isChecked();

        if(answerOne & answerTwo & answerThree & answerFour == true){
            score += 1;
        }

    }

    /**
     * This method is called when submit button is pressed
     */

    public void submission(View view){
        EditText questionOneAnswer = (EditText)findViewById(R.id.question_one_answer);
        String answerQuestionOne = questionOneAnswer.getText().toString();

        if(answerQuestionOne.equals("technical")){
            score += 1;
        }

        //Make a toast to display quiz results
        CharSequence text = "Your score is " +score+ " out of 4";
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
