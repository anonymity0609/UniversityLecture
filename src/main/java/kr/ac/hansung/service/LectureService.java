package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.LectureDAO;
import kr.ac.hansung.model.Lecture;

@Service
public class LectureService {
	
	@Autowired
	private LectureDAO lectureDAO;

	public List<Lecture> getCurrent() {
		// TODO Auto-generated method stub
		return lectureDAO.getTotal_list(2017, 1);
	}

	public void insert(Lecture lecture) {
		// TODO Auto-generated method stub
		lectureDAO.insert(lecture);
	}
	

}
