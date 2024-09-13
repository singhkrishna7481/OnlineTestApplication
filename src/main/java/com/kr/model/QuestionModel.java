package com.kr.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "Question_Tab")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class QuestionModel {
	
	@Id
	@SequenceGenerator(name = "g1", initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "g1",strategy = GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	private String question;
	
	@NonNull
	private List<String> options;
	
	@NonNull
	private String correctAnswer;
	
	@Transient
	private long qId;
}
