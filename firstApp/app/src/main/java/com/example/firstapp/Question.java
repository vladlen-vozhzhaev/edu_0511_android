package com.example.firstapp;

public class Question {
    private int questionResId; // тут лежит id вопроса
    private boolean answerTrue; // какой должен быть ответ

    public Question(int questionResId, boolean answerTrue) {
        this.questionResId = questionResId;
        this.answerTrue = answerTrue;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }
}
