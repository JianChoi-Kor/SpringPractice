package practice.member.service;

import java.util.Map;

import practice.member.Student;
import practice.member.dao.StudentDao;

public class StudentAllSelectService {
	
	private StudentDao studentDao;
	
	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
}
