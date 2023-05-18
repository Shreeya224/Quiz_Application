package com.example.quizapplicationp2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapplicationp2.QuestionsAnswers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion= QuestionsAnswers.question.length;
    int currentQuestionIndex=0;
    String selectedAnswer="";

    @Override
    public void onClick(View view){
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView=findViewById(R.id.total_question);
        questionTextView=findViewById(R.id.question);
        ansA=findViewById(R.id.ans_A);
        ansA=findViewById(R.id.ans_B);
        ansA=findViewById(R.id.ans_C);
        ansA=findViewById(R.id.ans_D);
        submitBtn=findViewById(R.id.submit_btn);


        totalQuestionsTextView.setText("Total questions: "+totalQuestion);
        loadNewQuestion();
    }
    @Override
    public void onClick(View view){
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);


        Button clickedButton=(Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            currentQuestionIndex++;
            loadNewQuestion();
            if(selectedAnswer.equals(QuestionsAnswers.correctAnswers[currentQuestionIndex]))
            {score++; }

        }
        else { //choices button clicked
            selectedAnswer= clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void loadNewQuestion()
    {
        if(currentQuestionIndex==totalQuestion)
        { finishQuiz();
        return;}
        questionTextView.setText(QuestionsAnswers.question[currentQuestionIndex]);
        ansA.setText(QuestionsAnswers.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionsAnswers.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionsAnswers.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionsAnswers.choices[currentQuestionIndex][3]);


    }
}
