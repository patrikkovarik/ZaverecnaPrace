package learning;

import persons.Teacher;
import persons.Student;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class School implements java.io.Serializable {
	
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	Schedule addedSchedule;

  public void addTeacher(Teacher teacher) {
    teachers.add(teacher);
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public void addSubject(Subject subject) {
    subjects.add(subject);
  }

  public void addSchedule(Schedule schedule) {
    addedSchedule = schedule;
  }

  public Schedule getSchedule() {
    return addedSchedule;
  }

  public void fileLoader(String fileName) {

    School school = null;

    try {
       FileInputStream fileIn = new FileInputStream(fileName);
       ObjectInputStream in = new ObjectInputStream(fileIn);
       school = (School) in.readObject();
       in.close();
       fileIn.close();
    } catch (IOException i) {
       i.printStackTrace();
       return;
    } catch (ClassNotFoundException c) {
       System.out.println("School class not found");
       c.printStackTrace();
       return;
    }
    
    //System.out.println(school.toString());
    //System.out.println(school.getSchedule().printTextSchedule());
    this.students = school.students;
    this.teachers = school.teachers;
    this.subjects = school.subjects;
    this.addedSchedule = school.addedSchedule;

  }

  public String toString() {
    String result = "";
    result = result + "Teachers:";
     for (Teacher t: teachers) {
       result = result + "\n";
       result = result + t.toString();
    }

    result = result + "\n\n";
    result = result + "Students:";
     for (Student s: students) {
       result = result + "\n";
       result = result + s.toString();
    }

    result = result + "\n\n";
    result = result + "Subjects:";
     for (Subject s: subjects) {
       result = result + "\n";
       result = result + s.toString();
    }

    return result;
  }


}
