package learning;

import main.WrongDayException;
import main.WrongSchoolHourException;
import persons.*;
import java.util.ArrayList;

public class Lesson implements java.io.Serializable {
	
	ArrayList<Teacher> lessonTeach = new ArrayList<Teacher>();
	ArrayList<Student> presentStuds = new ArrayList<Student>();
	String discussedTopic;
	Subject lessonSubject; 
	int day; // 1 - 5 
	int schoolHour; // 0 - 9
	
	public Lesson(String discussedTopic, Subject lessonSubject, int day, int schoolHour) throws WrongDayException, WrongSchoolHourException {
		this.discussedTopic = discussedTopic;
		this.lessonSubject = lessonSubject;

    if (day < 0 || day > 5) {
      throw new WrongDayException("Den musí být v rozsahu 0 až 5.");
    }
		this.day = day;
    
    if (schoolHour < 0 || schoolHour > 9) {
      throw new WrongSchoolHourException("Školní hodina musí být v rozsahu 0 až 9.");
    }
		this.schoolHour = schoolHour;
	}

  public void addTeacher(Teacher teacher) {
    lessonTeach.add(teacher);
  }

  public void addStudent(Student student) {
    presentStuds.add(student);
  }


	// get-set discussedTopic
	public String getDiscussedTopic() {
		return discussedTopic;
	}
	public void setDiscussedTopic(String discussedTopic) {
		this.discussedTopic = discussedTopic;
	}
	
	// get-set lessonSubject
	public Subject getLessonSubject() {
		return lessonSubject;
	}
	public void setLessonSubject(Subject lessonSubject) {
		this.lessonSubject = lessonSubject;
	}
	
	// get-set Day
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	// get-set schoolHour
	public int getSchoolHour() {
		return schoolHour;
	}
	public void setschoolHour(int schoolHour) {
		this.schoolHour = schoolHour;
	}
	
	public String toString() {
    return lessonSubject.getName() + ": " + discussedTopic;
  }
	
}
