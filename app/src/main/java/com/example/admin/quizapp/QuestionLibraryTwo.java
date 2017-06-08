package com.example.admin.quizapp;

/**
 * Created by Admin on 6/1/2017.
 */

public class QuestionLibraryTwo {

    private String textQuestions [] = {
        "1.In which country would you be most likely to see a woman wearing a \"lotus shoe\"?",
                "2. According to old English folklore, when is it good luck to throw a shoe?",
                "3. The world's oldest leather shoe was found in a cave in the Caucasus Mountains in which of the following countries?",
                "4. Which one of these French companies is well-known for their high-end, red-soled evening-wear stilettos?",
                "5. Ghillies are specialized shoes that are worn for which of the following activities??"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"Tunisia","Mexico", "Iceland", "China"},
            {"On New Years Eve", "When someone is leaving to go on a journey", "At a funeral", "On your birthday"},
            {"Belize", "Egypt", "Armenia", "Wales"},
            {"Michelin", "Christian Louboutin", "Pernod Ricard", "Lafarge"},
            {"Irish dancing", "Sponge diving", "Rock climbing", "High wire walking"}
    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers[] = {"China", "When someone is leaving to go on a journey", "Wales", "Christian Louboutin", "Irish dancing"};

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
