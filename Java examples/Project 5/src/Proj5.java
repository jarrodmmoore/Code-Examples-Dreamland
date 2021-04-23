/***********************************************************
* Proj5.java
* Jarrod Moore / Friday 3:30
*
* Program reads in answers from an external file and grades them based on a user-defined key.
***********************************************************/

import java.util.*;
import java.io.*;
import java.nio.file.Files; 

public class Proj5 {
	
	public static void main(String[] args) throws IOException {
		Scanner scanny = new Scanner(System.in);
		String input;
		// Scanner inFile = new Scanner(new File("Proj5_QuizScores.txt"));
		String readFile = "";
		String filename;
		
		filename = getFileInfo();
		String[] storedFile = readFile(filename);
		char[] answerKey = createKey();
		
		System.out.print("\n");
		System.out.print("Student ID\t\t# Correct\t% Correct\tScore\t\tGrade");
		
		int correct = 0;
		int score = 0;
		double percent = 100.0;
		char grade = 'X';
		
		for(int line = 0; line < storedFile.length; line++) {
			String[] lineParts = storedFile[line].split(",");
			
			// get into character array
			char [] answersToChar = lineParts[1].toCharArray();
			
			correct = 0;
			for (int i = 0; i < lineParts[1].length(); i++) {
				if (answersToChar[i] == answerKey[i])
				correct += 1;
			}
			
			percent = correct / lineParts[1].length;
			score = correct * 2;
			
			if (percent >= 90) {
				grade = 'A';
			}
			else if (percent >= 80) {
				grade = 'B';
			}
			else if (percent >= 70) {
				grade = 'C';
			}
			else if (percent >= 60) {
				grade = 'D';
			}
			else {
				grade = 'F';
			}
			
			System.out.print("" + lineParts[0] + "\t\t" + correct + "\t");
			System.out.format("%.1f", percent);
			System.out.print("%\t" + score + "\t" + grade + "\n");
		}
		
		scanny.close();
	}

	public static String getFileInfo () throws IOException {
		boolean validFile = false;
		Scanner scanny2 = new Scanner(System.in);
		String filename = "x";
		
		while (!validFile) {
			System.out.print("Enter name of quiz file (i.e. Quizscores.txt): ");
			filename = scanny2.nextLine();
			validFile = true;
			try {
				File temp = new File(filename);
			} catch (Exception e) {
				validFile = false;
				System.out.println("Error! File does not exist.");
			}
		}
		scanny2.close();
		return filename;
	}
	
	public static String[] readFile (String filename) throws FileNotFoundException {
		Scanner lineCounter = new Scanner(new File(filename));
		int numLines = 0;
		while(lineCounter.hasNext()) {
			numLines++;
		}
		lineCounter.close();
		
		String [] storedFile = new String [numLines];
		
		Scanner inFile = new Scanner(new File(filename));
		for (int i = 0; i < numLines; i++) {
			storedFile[i] = inFile.nextLine();
		}
		inFile.close();
		return storedFile;
	}
	
	public static char [] createKey () {
		Scanner scanCreateKey = new Scanner(System.in);
		String input;
		
		int numQuestions = -1;
		System.out.print("Please enter the number of questions on the exam: ");
		while (numQuestions <= 0) {
			input = scanCreateKey.nextLine();
			numQuestions = Integer.parseInt(input);
		}
		
		System.out.println("Please enter the answers for the following questions");
		System.out.println("Where 'T' = true, 'F' = false, or A, B, D, D, E for multiple choice\n");
		
		char inKey;
		char [] answerKey = new char [numQuestions];
		for(int i = 0; i < numQuestions; i++) {
			inKey = 'x';
			boolean valid = false;
			while (!valid) {
				System.out.print("" + (i + 1) + ") ");
				input = scanCreateKey.nextLine();
				input = input.toLowerCase();
				inKey = input.charAt(0);
				switch(inKey) {
					case 't':
					case 'a':
						answerKey[i] = '1';
						valid = true;
						break;
					case 'f':
					case 'b':
						answerKey[i] = '2';
						valid = true;
						break;
					case 'c':
						answerKey[i] = '3';
						valid = true;
						break;
					case 'd':
						answerKey[i] = '4';
						valid = true;
						break;
					case 'e':
						answerKey[i] = '5';
						valid = true;
						break;
					default:
						break;
				}
			}
		}
		scanCreateKey.close();
		return answerKey;
	}
}
