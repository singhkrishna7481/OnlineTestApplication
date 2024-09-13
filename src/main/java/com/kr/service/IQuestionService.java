package com.kr.service;

import java.util.List;

import com.kr.model.QuestionModel;

public interface IQuestionService {
	void addQuestion(QuestionModel question);

	List<QuestionModel> getQuestions();
}
