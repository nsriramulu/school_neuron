package com.sn.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sn.entity.Post;
import com.sn.entity.QuizAnswer;
import com.sn.entity.QuizQuestion;
import com.sn.service.PostService;

@Controller
@RequestMapping(value = "/sn")
public class QuizController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/quizzes", method = RequestMethod.GET)
	public String getQuizsPage(ModelMap model,HttpSession session) {
		String view = "quizzes";
		
		try {
			List<Post> posts = new ArrayList<Post>();
			Post post1 = new Post();
			Post post2 = new Post();
			
			Set<QuizQuestion> queSet1 = new HashSet<QuizQuestion>();
			queSet1.add(getQuestion("que1.1"));
			queSet1.add(getQuestion("que1.2"));
			queSet1.add(getQuestion("que1.3"));
			queSet1.add(getQuestion("que1.4"));
			queSet1.add(getQuestion("que1.5"));
			post1.setQuizQuestions(queSet1);
			post1.setEventTitle("Quistion set test 1");
			post1.setPoints(25);
			
			Set<QuizQuestion> queSet2 = new HashSet<QuizQuestion>();
			queSet2.add(getQuestion("que2.1"));
			queSet2.add(getQuestion("que2.2"));
			queSet2.add(getQuestion("que2.3"));
			queSet2.add(getQuestion("que2.4"));
			queSet2.add(getQuestion("que2.5"));
			post2.setQuizQuestions(queSet2);
			post2.setEventTitle("Quistion set test 2");
			post2.setPoints(25);
			
			posts.add(post1);
			posts.add(post2);
			model.put("posts", posts);
		} catch(Exception e) {
			view = "error";
		}
		
		return view;
	}
	
	private QuizQuestion getQuestion(String suffix){
		QuizQuestion quizQ = new QuizQuestion();
		quizQ.setQuestion("Question_"+suffix);
		
		Set<QuizAnswer> ansSet = new HashSet<QuizAnswer>();
		QuizAnswer qAns1 = new QuizAnswer();
		qAns1.setAnswer("Anwer1"+suffix);
		ansSet.add(qAns1);
		
		QuizAnswer qAns2 = new QuizAnswer();
		qAns2.setAnswer("Anwer2"+suffix);
		ansSet.add(qAns2);
		
		QuizAnswer qAns3 = new QuizAnswer();
		qAns3.setAnswer("Anwer3"+suffix);
		ansSet.add(qAns3);
		
		return quizQ;
	}
}
