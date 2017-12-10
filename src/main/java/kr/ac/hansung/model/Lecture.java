package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Lecture {

	private int year;
	private int semester;
	private String subject_code;
	private String subject_name;
	private String classification;
	private int credit;

}
