package com.kr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kr.model.QuestionModel;

public interface IQuestionRepository extends JpaRepository<QuestionModel, Long> {

}
