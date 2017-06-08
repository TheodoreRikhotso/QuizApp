package com.example.admin.quizapp;

/**
 * Created by Admin on 6/1/2017.
 */

public class QuestionLibray {

    private String textQuestions [] = {
            "1.Which one of these is not a natural fibre from a plant or animal source?",
            "2. What machine is weaving made on?",
            "3. Which one of these is not a natural fibre from a plant or animal source?",
            "4. What is the process called that changes fibres into yarn?",
            "5. Which of these is not a manmade fibre?"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"Cotton","Wool", "Silk", "Linen"},
            {"Weft knitting machine", "Circular knitting machine", "Nylon", "Spinning wheel"},
            {"Cotton", "Wool", "Silk", "Viscose"},
            {"Knitting", "Spinning", "Weaving", "Felting"},
            {"Acetate", "Polystyrene", "Acrylic", "Nylon"}
    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers[] = {"Linen", "Nylon", "Viscose", "Spinning", "Polystyrene"};

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
