package com.kr.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kr.model.QuestionModel;
import com.kr.model.ResultModel;
import com.kr.service.IQuestionService;

@Controller
public class QuizController {

	@Autowired
	private IQuestionService service;

	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/add")
	public String addQuesPage() {
		return "addQuestion";
	}
	@GetMapping("/quiz")
	public String quiz(Map<String,List<QuestionModel>> map,Model model)
	{
		model.addAttribute("result", new ResultModel());
		map.put("questions", service.getQuestions());
		return "quiz";
	}
	@PostMapping("/addQ")
	public String addQuestion(@ModelAttribute QuestionModel question, RedirectAttributes redirect) {
		service.addQuestion(question);
		redirect.addFlashAttribute("msg", "Question Added");
		return "redirect:/add";
	}
	@PostMapping("/submitQuiz")
	public String submitQuiz(@ModelAttribute("result") ResultModel result,RedirectAttributes redirect) {
		List<QuestionModel> questions = service.getQuestions();
		List<QuestionModel> result1 = result.getResult();
		int score = 0;
		for(int i=0;i<result1.size();i++)
		{
			if(questions.get(i).getCorrectAnswer().equalsIgnoreCase(result1.get(i).getCorrectAnswer()))
			{
				score++;
			}
		}
		System.out.println(result);
		double percent = (score*100.0)/questions.size();
		DecimalFormat df = new DecimalFormat("#.#");
        String roundedValue = df.format(percent);
		redirect.addFlashAttribute("result", "You Scored: "+score+"/"+questions.size());
		redirect.addFlashAttribute("percent", "You Got: "+roundedValue+"%");
		return "redirect:./";
	}

}
