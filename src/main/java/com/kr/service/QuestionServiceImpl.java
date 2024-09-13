package com.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.model.QuestionModel;
import com.kr.repository.IQuestionRepository;

@Service
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	private IQuestionRepository repo;
	
	@Override
	public void addQuestion(QuestionModel question) {
		repo.save(question);
	}

	@Override
	public List<QuestionModel> getQuestions() {
		return repo.findAll();
	}

}
