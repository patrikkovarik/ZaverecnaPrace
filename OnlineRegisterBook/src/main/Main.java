package main;

import java.io.*;
import learning.*;
import persons.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		School school = new School();
		Schedule schedule = new Schedule();
		school.addSchedule(schedule);

		System.out.println("KONEC - ukonci program");
		System.out.println("STUDENT+ - prida noveho studenta");
		System.out.println("UCITEL+ - prida noveho ucitele");
		System.out.println("PREDMET+ - prida novy predmet");
		System.out.println();
		System.out.println("ULOZ - ulozi rozvrh");
		System.out.println("ZALOHUJ - zalohuje vsechno co patri do skoly");
		
		
		boolean userEnd = false;

		do {
			System.out.println("Zadejte pøíkaz: ");
			String command = sc.nextLine().trim().toUpperCase();

			if (command.equals("KONEC")) {
				userEnd = true;
			}

			if (command.equals("STUDENT+")) {
				System.out.println("Zadejte jmeno a prijmeni studenta v tomto poradi:");
				String nameSt = sc.nextLine();
				String surnameSt = sc.nextLine();
				Student student0 = new Student(nameSt, surnameSt);
				school.addStudent(student0);
			}

			if (command.equals("UCITEL+")) {
				System.out.println("Zadejte jmeno a prijmeni ucitele v tomto poradi:");
				String nameTe = sc.nextLine();
				String surnameTe = sc.nextLine();
				Teacher teacher0 = new Teacher(nameTe, surnameTe);
				school.addTeacher(teacher0);
			
			}

			if (command.equals("PREDMET+")) {
				System.out.println("Zadejte jmeno predmetu: ");
				String nameSubj = sc.nextLine();
				Subject subject0 = new Subject(nameSubj);
				school.addSubject(subject0);
			}

			if (command.equals("ULOZ")) {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("tridnice.txt"))) {
					bw.write(school.toString());
					bw.newLine();
					bw.write(schedule.printTextSchedule());
					bw.newLine();
					bw.flush();
				} catch (Exception e) {
					System.err.println("Do souboru se nepovedlo zapsat.");
				}			}

			if (command.equals("ZALOHUJ")) {
				try {
					FileOutputStream fileOut = new FileOutputStream("school.save");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(school);
					out.close();
					fileOut.close();
					System.out.println("School is saved to school.save file.");
				} catch (IOException i) {
					i.printStackTrace();
				}
			}

		} while (!userEnd);
//   
	
		Teacher teacher1 = new Teacher("Karel", "Novak");
		Teacher teacher2 = new Teacher("Jana", "Novotna");
		school.addTeacher(teacher1);
		school.addTeacher(teacher2);

		Student student1 = new Student("Jindrich", "Maly");
		Student student2 = new Student("Andrea", "Svetla");
		school.addStudent(student1);
		school.addStudent(student2);

		Subject subject1 = new Subject("Matematika");
		Subject subject2 = new Subject("IT");
		Subject subject3 = new Subject("TI");
		subject1.addTeacher(teacher1);
		subject2.addTeacher(teacher2);
		school.addSubject(subject1);
		school.addSubject(subject2);

		Lesson lesson1 = null;
		Lesson lesson2 = null;
		Lesson lesson3 = null;

		try {
			lesson1 = new Lesson("algoritmy", subject3, 0, 0);
			lesson2 = new Lesson("navrhove vzory", subject2, 0, 1);
			lesson3 = new Lesson("goniometrie", subject1, 4, 2);
		} catch (WrongDayException e) {
			System.out.println(e);
		} catch (WrongSchoolHourException e) {
			System.out.println(e);
		}

		schedule.addLesson(lesson1);
		schedule.addLesson(lesson2);
		schedule.addLesson(lesson3);

		System.out.println(school.toString());
		System.out.println(schedule.printTextSchedule());

		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("tridnice.txt"))) {
			bw.write(school.toString());
			bw.newLine();
			bw.write(schedule.printTextSchedule());
			bw.newLine();
			bw.flush();
		} catch (Exception e) {
			System.err.println("Do souboru se nepovedlo zapsat.");
		}

		try {
			FileOutputStream fileOut = new FileOutputStream("school.save");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(school);
			out.close();
			fileOut.close();
			System.out.println("School is saved to school.save file.");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}