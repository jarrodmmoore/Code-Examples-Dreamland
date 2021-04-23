/**
* StudentApp.java
* Jarrod Moore / Friday 3:30pm
*
* Program allows the user to enter course scores for up to 50 students. Program then calculated grades and displays them.
* (Extra credit was NOT attempted)
*/

import java.util.Scanner;

public class StudentApp {
	// ====
	// MAIN
	// ====
	public static void main(String[] args) {
		// CONSTANTS
		final double ZYBOOK_PTS_MAX = 150.0;
		final double EXAMS_PTS_MAX = 150.0;
		final double F_EXAM_PTS_MAX = 100.0;
		
		Scanner scanny = new Scanner(System.in);
		String input = "x";
		char keepGoing = 'x';
		double labPtsPossible = -1;
		double projPtsPossible = -1;
		int studentNum = 0;
		double studentPtsLabs;
		double studentPtsProjects;
		double studentPtsZybook;
		double studentPtsExams;
		double studentPtsFinalExam;
		String studentWID;
		
		// user defines max possible points for LABS
		System.out.print("Enter total points possible for LABS: ");
		input = scanny.nextLine();
		labPtsPossible = Double.parseDouble(input);
		
		// user defines max possible points for PROJECTS
		System.out.print("Enter total points possible for PROJECTS: ");
		input = scanny.nextLine();
		projPtsPossible = Double.parseDouble(input);
				
		// create a student array of 50
		// it is unlikely they will ALL be used, we'll ignore the null ones when printing
		Student [] studentArray = new Student [50];
		
		// ======================================
		// Get all info for a single student loop
		// ======================================
		studentNum = 0;
		while (keepGoing != 'n' && studentNum < 50) {
			studentWID = "no WID";
			studentPtsLabs = 0.0;
			studentPtsProjects = 0.0;
			studentPtsZybook = 0.0;
			studentPtsExams = 0.0;
			studentPtsFinalExam = 0.0;
			
			// get all inputs...
			System.out.print("\nEnter the student's name (firstname lastname): ");
			input = scanny.nextLine();
			String[] fullName = input.split(" ");
			
			System.out.print("Enter the student's WID: ");
			studentWID = scanny.nextLine();
			
			System.out.print("\nEnter student's total for all LABS: ");
			input = scanny.nextLine();
			studentPtsLabs = Double.parseDouble(input);
			
			System.out.print("Enter student's total for all PROJECTS: ");
			input = scanny.nextLine();
			studentPtsProjects = Double.parseDouble(input);
			
			System.out.print("Enter student's total for ZYBOOK: ");
			input = scanny.nextLine();
			studentPtsZybook = Double.parseDouble(input);
			
			System.out.print("Enter student's total for the 3 CLASS EXAMS: ");
			input = scanny.nextLine();
			studentPtsExams = Double.parseDouble(input);
			
			System.out.print("Enter student's total for the FINAL EXAM: ");
			input = scanny.nextLine();
			studentPtsFinalExam = Double.parseDouble(input);
			
			// now assign the entry...
			studentArray[studentNum] = new Student(labPtsPossible, projPtsPossible, ZYBOOK_PTS_MAX, EXAMS_PTS_MAX, F_EXAM_PTS_MAX,
					fullName[0], fullName[1], studentWID, 
					studentPtsLabs, studentPtsProjects, studentPtsZybook, studentPtsExams, studentPtsFinalExam);
			
			studentNum++;
			System.out.print("\n" + studentNum + " Student(s) entered so far.\n"
					+ "Up to 50 students can be entered.\n");
			
			// keep going? get y/n
			keepGoing = 'x';
			while (keepGoing != 'y' && keepGoing != 'n') {
				System.out.print("Would you like to enter another student? ('Y' or 'N'): ");
				input = scanny.nextLine();
				keepGoing = input.toLowerCase().charAt(0);
			}

		}
		// ========================
		// END of student info loop
		// ========================
		
		// fill in the blanks to avoid a null pointer error
		while (studentNum <= 49) {
			studentArray[studentNum] = new Student();
			studentNum++;
		}
		
		// print out all entries and their calculated overall grades
		for (int i = 0; i < studentArray.length; i++) {
			// only print out the non-empty entries
			if (studentArray[i].validStudent) {
				System.out.print("\n" + studentArray[i].toString());
				System.out.print("\t\tPress enter to display next student...");
				scanny.nextLine();
			}
		}
		
		System.out.println("\nAll students displayed...");
		
		scanny.nextLine();
		scanny.close();
	}
	// ===========
	// END of main
	// ===========

}
