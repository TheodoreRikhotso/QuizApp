package com.example.admin.quizapp;

/**
 * Created by Admin on 6/1/2017.
 */

public class QuestionLibraryThree {
    private String textQuestions [] = {
            "1.When razor cutting, it is recommended that hair be cut ____________",
            "2. The amount of hair on a person's head is referred to as _____________",
            "3. The red dermal light is used to treat ______________",
            "4. Another name for tesla (high frequency) current is __________",
            "5. Eye tabbing involves the application of _______________"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"Wet","Damp", "Dry", "Dry after straightening"},
            {"Thickness", "Density", "Texture", "None of the above"},
            {"Oily skin", "Acneic skin", "Dry skin", "Combination skin"},
            {"Blue ray", "Violet ray", "White light", "Ultra violet ray"},
            {"Individual lashes", "Band lashes", "Strip lashes", "Permanent eyeliner"}
    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers[] = {"Wet", "Density", "Dry skin", "Violet ray","Individual lashes"};

    // method returns number of questions
    public int getLength(){
        return textQuestions.length;
    }

    // method returns question from array textQuestions[] based on array index
    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    // method return a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    //  method returns correct answer for the question based on array index
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
