package learning;

import persons.Teacher;
import java.util.ArrayList;

public class Subject implements java.io.Serializable {
	String name;
	ArrayList<Teacher> teachers;
	
	public Subject(String name) {
		this.name = name;
    teachers = new ArrayList<Teacher>();
	}

  public void addTeacher(Teacher teacher) {
    teachers.add(teacher);
  }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
  public String toString() {
		return name + "; subject teachers(" + teachers + ")";
	}
	

}
