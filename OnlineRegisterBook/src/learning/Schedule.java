package learning;

import java.util.ArrayList;

public class Schedule implements java.io.Serializable {

	ArrayList<Lesson> lessons;
  ArrayList<String> workDays;
  
  
  public Schedule () {
    lessons = new ArrayList<Lesson>(50);
    for (int i = 0; i < 50; i++) {
      lessons.add(i, null);
    }

    workDays = new ArrayList<String>();
    workDays.add("Pondeli");
    workDays.add("Utery");
    workDays.add("Streda");
    workDays.add("Ctvrtek");
    workDays.add("Patek");
  }

	
  public void addLesson(Lesson lesson) {
    int position = lesson.getDay() * 10 + lesson.getSchoolHour();
    lessons.add(position, lesson); 
  }

  public String printSchedule() {
    String printed = "";
    for (int i = 0; i < lessons.size(); i++) {
      printed = printed + " " + lessons.get(i).toString();
    }
    return printed;
  }

  public String printTextSchedule() {
    int day = 0;
    int hour = 0;
    String result = "\nTextový výpis rozvrhu:\n";
    result = result + "======================\n\n";

    for (int i = 0; i < 50; i++) {
      result = result + workDays.get(day) + " " + hour + ". hodina: ";

      if (lessons.get(i) != null) {
        result = result + lessons.get(i).toString() + "\n";
      } else {
        result = result + "Volno\n";
      }

      hour++;
      if (hour == 10) {
        day++;
        hour = 0;
        result = result + "\n";
      }
    }

    return result;
  }

}
