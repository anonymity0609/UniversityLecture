package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Lecture;

@Repository
public class LectureDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 학년/학기별 총 이수학점
	public List<Lecture> getTotal_semester(int year, int semester) {
		String sqlStatement = "SELECT year, semester, sum(credit) FROM lecture_list group by year, semester";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				Lecture lecture = new Lecture();
				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;
			}
		});
	}

	// 학년/학기별 이수 과목 목록
	public List<Lecture> getTotal_list(int year, int semester) {
		String sqlStatement = "select * from lecture_list where year=? AND semester=?";
		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Lecture>() {
			@Override
			public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {

				Lecture lecture = new Lecture();
				lecture.setYear(rs.getInt("year"));
				lecture.setSemester(rs.getInt("semester"));
				lecture.setSubject_code(rs.getString("subject_code"));
				lecture.setSubject_name(rs.getString("subject_name"));
				lecture.setClassification(rs.getString("classification"));
				lecture.setCredit(rs.getInt("credit"));

				return lecture;
			}
		});
	}

	// 이수 구분별 학점
	public int getTotal_classification(String classification) {
		String sqlStatement = "select sum(credit) from lecture_list where classification=?";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { classification }, Integer.class);
	}

	// 총 학점
	public int getTotal() {
		String sqlStatement = "select sum(credit) from lecture_list";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// if update success return true
	public boolean insert(Lecture lecture) {
		int year = lecture.getYear();
		int semester = lecture.getSemester();
		String subject_code = lecture.getSubject_code();
		String subject_name = lecture.getSubject_name();
		String classification = lecture.getClassification();
		int credit = lecture.getCredit();

		String sqlStatement = "insert into lecture_list (year, semester, subject_code, subject_name, classification, credit) values (?, ?, ?, ?, ?, ?)";
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, subject_code, subject_name, classification, credit }) == 1);
	}

}
