/**
* Student.java
* Jarrod Moore / Friday 3:30pm
*
* Class for student objects.'
* Contains everything needed to create a Student object, assign point values, calculate grades, and nicely format an output
*/

import java.text.DecimalFormat;

public class Student {
	String first_name = "NO_NAME";
	String last_name = "NO_NAME";
	String WID = "no WID";
	double score_labs = 0;
	double score_projects = 0;
	double score_zybook = 0;
	double score_exams = 0;
	double score_final_exam = 0;
	double score_overall = 0;
	boolean validStudent = false;
	
	// weight constants
	final double WEIGHT_LABS = 0.1;
	final double WEIGHT_PROJECTS = 0.18;
	final double WEIGHT_ZYBOOK = 0.07;
	final double WEIGHT_3_EXAMS = 0.45;
	final double WEIGHT_F_EXAM = 0.2;
	
	 /** Student()
	 * Default Constructor, fills all fields for object with default (zero'd) values.
	 * Note: validStudent is set to FALSE here, meaning the program will not do anything with this object
	 *
	 * @param N/A
	 * @return N/A
	 */ 
	public Student() { // default constructor
		first_name = "NO_NAME";
		last_name = "NO_NAME";
		WID = "no WID";
		score_labs = 0;
		score_projects = 0;
		score_zybook = 0;
		score_exams = 0;
		score_final_exam = 0;
		score_overall = 0;
		validStudent = false;
	}
	
	/** Student()
	 * Constructor WITH PARAMETERS, all scores are sent via parameters, as well as the max possible points for labs and projects defined for all students by the user
	 * Note: validStudent is set to TRUE here, meaning the program will display this student's scores
	 *
	 * @param lab_possible, max points possible in labs
	 * @param proj_possible, max points possible in projects
	 * @param zybook_possible, max points possible in projects
	 * @param exams_possible, max points possible in the 3 exams
	 * @param f_exam_possible, max points possible in the final exam
	 * 
	 * @param in_first_name, student's first name (defined by user for this student only)
	 * @param in_last_name, student's last name (defined by user for this student only)
	 * @param in_WID, student's WID (defined by user for this student only)
	 * @param in_labs, student's total lab score (defined by user for this student only)
	 * @param in_projects, student's total project score (defined by user for this student only)
	 * @param in_zybook, student's total zybook completion score (defined by user for this student only)
	 * @param in_exams, student's total score between all 3 exams (defined by user for this student only)
	 * @param in_final, student's final exam score (defined by user for this student only)
	 * @return N/A
	 */ 
	public Student(double lab_possible, double proj_possible, double zybook_possible, double exams_possible, double f_exam_possible,
			String in_first_name, String in_last_name, String in_WID, 
			double in_labs, double in_projects, double in_zybook, double in_exams, double in_final) { // arg constructor
		first_name = in_first_name;
		last_name = in_last_name;
		WID = in_WID;
		score_labs = in_labs;
		score_projects = in_projects;
		score_zybook = in_zybook;
		score_exams = in_exams;
		score_final_exam = in_final;
		score_overall = calcOverall(lab_possible, proj_possible, zybook_possible, exams_possible, f_exam_possible);
		validStudent = true;
	}
	
	/** getFirstName()
	 * For use in Student class methods
	 * @param N/A
	 * @return first_name, the first name of this student object
	 */ 
	public String getFirstName ( ) {
		return first_name;
	}
	
	/** getLastName()
	 * For use in Student class methods
	 * @param N/A
	 * @return last_name, the last name of this student object
	 */ 
	public String getLastName ( ) {
		return last_name;
	}
	
	/** getWID()
	 * For use in Student class methods
	 * @param N/A
	 * @return WID, the WID of this student object
	 */ 
	public String getWID ( ) {
		return WID;
	}
	
	/** getLabScore()
	 * For use in Student class methods
	 * @param N/A
	 * @return score_labs, the total lab score of this student object
	 */ 
	public double getLabScore ( ) {
		return score_labs;
	}
	
	/** getProjScore()
	 * For use in Student class methods
	 * @param N/A
	 * @return score_projects, the total projects score of this student object
	 */ 
	public double getProjScore ( ) {
		return score_projects;
	}
	
	/** getZybookScore()
	 * For use in Student class methods
	 * @param N/A
	 * @return score_zybook, the total zybook completion score of this student object
	 */ 
	public double getZybookScore ( ) {
		return score_zybook;
	}
	
	/** getExamsScore()
	 * For use in Student class methods
	 * @param N/A
	 * @return score_exams, the total of the 3 exam scores of this student object
	 */ 
	public double getExamsScore ( ) {
		return score_exams;
	}
	
	/** getFinalExamScore()
	 * For use in Student class methods
	 * @param N/A
	 * @return score_final_exam, the final exam score of this student object
	 */ 
	public double getFinalExamScore ( ) {
		return score_final_exam;
	}
	
	/** getOverallScore()
	 * For use in Student class methods
	 * @param N/A
	 * @return score_overall, the total weighted score of this student object
	 */ 
	public double getOverallScore ( ) {
		return score_overall;
	}
	
	/** calcOverall()
	 * For use in Student class methods
	 * Finds total weighted point score based on fractions and point weights
	 * 
	 * @param lab_pts_max, max possible points in labs
	 * @param proj_pts_max, max possible points in projects
	 * @param zybook_pts_max, max possible points in zybook
	 * @param exams_pts_max, max possible points in the 3 exams
	 * @param final_exam_max, max possible points in the final exam
	 * @return weightedTotal, the total weighted score of this student object (out of 1000 points)
	 */ 
	private double calcOverall (double lab_pts_max, double proj_pts_max, double zybook_pts_max, double exams_pts_max, double final_exam_max) { // GET
		double weightedTotal = (
				((getLabScore() / lab_pts_max) * (WEIGHT_LABS * 1000)) 
				+ ((getProjScore() / proj_pts_max) * (WEIGHT_PROJECTS * 1000))
				+ ((getZybookScore() / zybook_pts_max) * (WEIGHT_ZYBOOK * 1000))
				+ ((getExamsScore() / exams_pts_max) * (WEIGHT_3_EXAMS * 1000))
				+ ((getFinalExamScore() / final_exam_max) * (WEIGHT_F_EXAM * 1000))
				);
		return weightedTotal;
	}
	
	/** calcFinalGrade()
	 * Takes a score out of 100.0 and assigns a letter grade accordingly
	 * 
	 * @param N/A
	 * @return grade, letter grade in char form
	 */ 
	private char calcFinalGrade ( ) {
		char grade = 'F';
		double percentGrade = (getOverallScore() / 10.0);
		if (percentGrade > 58.5) {
			grade = 'D';
		}
		if (percentGrade > 68.5) {
			grade = 'C';
		}
		if (percentGrade > 79.5) {
			grade = 'B';
		}
		if (percentGrade > 89.5) {
			grade = 'A';
		}
		return grade;
	}
	
	/** toString()
	 * Formats the name, WID, and grades of the student object nicely
	 * 
	 * @param N/A
	 * @return a nicely formatted string, this can easily be printed or written to a file
	 */ 
	public String toString( ) {
		DecimalFormat df1 = new DecimalFormat("#.#'%'");
		return "Student Name: " + getLastName() 
				+ ", " + getFirstName() 
				+ "\nWID: " + getWID()
				+ "\nOverall %: " + df1.format((getOverallScore() / 10.0))
				+ "\nFinal Grade: " + calcFinalGrade()
				+ "\n";
	}
	
	// method comments seem a bit excessive here
}
