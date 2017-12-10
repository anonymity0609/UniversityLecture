package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.service.LectureService;

@Controller
public class LectureController {

	@Autowired
	private LectureService lectureservice;
	
	@RequestMapping("/lectures")
	public String showLectures(Model model) {
		List<Lecture> lectures = lectureservice.getCurrent();
		model.addAttribute("lectures", lectures);
		
		return "lectures";
	}
	
	@RequestMapping("/createlecture")
	public String createlecture(Model model) {
		
		model.addAttribute("lecture", new Lecture());
		return "createlecture";
	}
	
	@RequestMapping("/docreate")
	public String docreate(Model model, Lecture lecture) {
		
		lectureservice.insert(lecture);
		
		return "insertlecture";
	}
}
