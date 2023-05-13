package vladislavPavlyuk;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class QuizCreator {

	public static Scanner s = new Scanner(System.in);

	public static int aNum; 								// Answer number user choose
	public static int qNum; 								// Question number user choose

	public static Question[] question = new Question[20];	// Creates an array of Questions (size 20) from class Question
	public static String[] answers = new String[40];		// Creates an array of Answers
	public static int questionCounter = 13;					// Number of question in tray 
	public static int answersCounter = 22;					// Number of answers in tray

	public static int getInt(){								// Checks input (loops till user input int)
		while(!s.hasNextInt()){
			System.out.println("Invalid input, please enter a number!");
			s.nextLine();
		}
		return s.nextInt();
	}

	public static boolean getBoolean(){						// Checks input (loops till user input boolean)
		while(!s.hasNextBoolean()){
			System.out.println("Invalid input, please enter true or false: ");
			s.next();
		}
		return s.nextBoolean();
	}

	public static void printQuestion() {					// Function that print list of Questions and answers

		for (int i = 0; question[i] != null; i++) {				// A loop that runs on the question array
			System.out.println("  [" + (i + 1) + "] " + question[i].getQuestion() + ":" +" (" + question[i].getDifficultyLevel() +" question)");
            int j = 0;

            while(j<question[i].getAnsCount()){					// A loop that runs on the answers and prints only indexes
				if (question[i].getFitAns(j) != 0) {			// that aren't 0
					System.out.print(j + 1 + ") " + answers[question[i].getFitAns(j)] + ".");
					if (question[i].getboolAnsType(j))			// If the answers is correct adds a string (Correct answer)
						System.out.print("\u001B[32m(Correct answers) \u001B[0m");
					System.out.println("");
				}
                j++;
            }
			if(question[i].getCorrectAnswer()!=null)
				System.out.println("\u001B[32m" +question[i].getCorrectAnswer() +"\u001B[0m");

			System.out.println("");
		}
	}

	public static void printSpecificQuestion(int qNum) {	// A loop that prints specific question (works the same as the previous one)
		System.out.println("  [" + (qNum + 1) + "] " + question[qNum].getQuestion() + ":");
		for (int j = 0; j < 10&&question[qNum].getCorrectAnsCount()!=101; j++) {
			if (question[qNum].getFitAns(j) != 0) {
				System.out.print(j + 1 + ") " + answers[question[qNum].getFitAns(j)] + ".");
				if (question[qNum].getboolAnsType(j))
					System.out.print("\u001B[32m(Correct answers) \u001B[0m");
				System.out.println("");
			}
		}
	}

	public static void addAnsToQuestion() { 							// Adding new answers to question
		printQuestion();										// Prints a list of questions

		System.out.println("In which question you want to add answers:");
		
		qNum = getInt()-1;										// Int of question that user want to edit
		
																//If user inputs wrong input
																// While loop starts till user input if right
		while(qNum>=questionCounter||qNum<1) {
			System.out.println("Wrong input. There is only " +(questionCounter) +" questions!");
		System.out.println("Choose question you want to edit: ");
		qNum = getInt() - 1;
		}
		
		
		for (int i = 1; i < answersCounter; i++)				// Loop that print all answers of the question
			System.out.println(i + ") " + answers[i]);

		System.out.println("\nChoose answer you want to add: (enter number)");
		aNum = getInt() - 1;									// Int of answer that user wants to add
		
																//If user inputs wrong input
																// While loop starts till user input if right
		while(aNum>=answersCounter-1||aNum<1) {
			System.out.println("Wrong input. There is only " +(answersCounter-1) +" answers!");
		System.out.println("\nChoose answer you want to add: (enter number)");
		aNum = getInt() - 1;
		}
		
		
		System.out.println("Is this answer is true or false: ");
			question[qNum].setAnswer(aNum, getBoolean());		// Place answer in question Class with boolean type

		System.out.println("Your question is: ");				// Prints edited question
		printSpecificQuestion(qNum);

	}

	public static void addQuestionToTray() {							// Adding new question to tray
		System.out.println("Do you want to add:\n \n [1] Open Question. \n [2] Multiple choice question");
		System.out.println("Type question text you want to add: ");
		if(getInt()==1)
			aNum = 1;
		else 
			aNum = 2;
			
		
		String userQ = s.nextLine();	
		userQ = s.nextLine(); //sometimes scanner skip line (don't know why but the solution is to clone line)

        String difficultyInput = "";
		Boolean validInput = false;
		while (!validInput) {
            System.out.println("Enter the difficulty level (EASY, MEDIUM, HARD):");
            difficultyInput = s.nextLine();

            if (difficultyInput.equalsIgnoreCase("EASY")) 
                validInput = true;
			else if (difficultyInput.equalsIgnoreCase("MEDIUM")) 
                validInput = true;
        	else if (difficultyInput.equalsIgnoreCase("HARD")) 
                validInput = true;
            else {
                System.out.println("Invalid difficulty level. Please try again.");
            }
        }
		BaseQ.DifficultyLevel difficultyLevel = BaseQ.DifficultyLevel.valueOf(difficultyInput.toUpperCase());
		if(aNum==1){
			System.out.println("Type answer for your question:");
			String ans = s.nextLine();
		question[questionCounter] = new Question(userQ ,ans, difficultyLevel);
		}else
		question[questionCounter] = new Question(userQ ,difficultyLevel);
		questionCounter++;
		System.out.println("Your question is: \n");

		System.out.println("\u001B[32m" + "  [" + questionCounter + "] " + question[questionCounter-1].getQuestion() + ":"
				+ "\u001B[0m");
		

	}

	public static void addAnsToTray() {							// Adding new Answer to tray
		System.out.println("Type answer option you want to add to a tray");

		String userA = s.nextLine();
		userA = s.nextLine(); //sometimes scanner skip line (don't know why but the solution is to clone line)

		answers[answersCounter] = (userA);
		answersCounter++;

		for (int i = 1; i < answersCounter; i++) {
			if (i == (answersCounter -1))
				System.out.print("\u001B[32m");
			System.out.println(i  + ") " + answers[i] + "\u001B[0m");

		}

		System.out.println("Answer added successfully");

	}

	public static void editQuestionString() { 							// Edit question string from tray

		System.out.println("");							// Prints all questions
		for (int i = 0; question[i] != null; i++) {
			System.out.println("  [" + (i + 1) + "] " + question[i].getQuestion() + ":");
		}

		System.out.println("");

		System.out.println("Choose question you want to edit: ");
		qNum = getInt() - 1;
														//If user inputs wrong input
														// While loop starts till user input if right
		while(qNum>=questionCounter) {
			System.out.println("Wrong input. There is only " +questionCounter +" questions!");
		System.out.println("Choose question you want to edit: ");
		qNum = getInt() - 1;
		}

		System.out.println("Now, enter an edited question: ");

		String userQ = s.nextLine();
		userQ = s.nextLine();

		question[qNum].setQuestion(userQ);					// Sets new String to the question

		System.out.println("Your question now is: \n");

		printSpecificQuestion(qNum);

	}

	public static void editAnsString() {							// Edit Answer from tray

		for (int i = 1; i < answersCounter; i++) 				// Prints all answers
			System.out.println("[" + i + "] " + answers[i]);
	

		System.out.println("Choose answer you want to change: ");
		aNum = getInt();				

		System.out.println("Now, enter an edited answer");
		System.out.println("(New answer will change automaticly in all related questions)");

		String userAnswer = s.nextLine();
		userAnswer = s.nextLine();

		answers[aNum] = userAnswer;

		System.out.println("Your edited answer is: \n");
		System.out.println("[" + aNum + "]" + answers[aNum]);
	}

	public static void deleteAnsFromQuestion() {							// Delete answer from question

		printQuestion();

		System.out.println("Choose the question where you want to delete an answer: ");
		qNum = getInt() - 1;

		System.out.println("Choose answer you want to delete: ");
		aNum = getInt() - 1;

		question[qNum].deleteAns(aNum);

		System.out.println("Updated question is: ");

		printSpecificQuestion(qNum);

	}

	public static void deleteQuestion() { 							// Delete question from tray with all answers in it (links for answers)
		printQuestion();
		System.out.println("Which question you want to delete?");

		qNum = getInt() - 1;

		deleteQuestion(qNum);

		printQuestion();
	}

	public static void deleteQuestion(int qNum) {
		for (int i = qNum; i < questionCounter; i++)
			question[i] = question[i + 1];

		questionCounter--;

	}

	public static void createQuiz() throws FileNotFoundException {//Finally Quiz creating function

		System.out.println("How many questions do you want in your quiz?");
		qNum = getInt();	
		int[] quizQuestion = new int[qNum];						// Creates a new array of questions (links to questions) for quiz
		printQuestion();
		System.out.println("Choose question from the tray you want to add: ");

		for (int i = 0; i < qNum; i++) {						// User start to fill quiz array with questions from the list 
			System.out.println("Choose question number " + (i + 1) + ": ");
			aNum = getInt()-1;
			while(aNum-1>=questionCounter){
			System.out.println("There is only "+questionCounter +" questions (pick one that exists.)");
			aNum = getInt()-1;
			}
			quizQuestion[i] = aNum;
		}

		printQuiz(qNum, quizQuestion);
		boolean testDone = false;								// Additional menu for user to edit questions (can be removed)
		System.out.println("Do you want to change/add answers in questions?");

		while(!testDone){
			System.out.println("|[1] - Add new answers to exists question.   |");
			System.out.println("|[2] - Edit answer.                          |");
			System.out.println("|[3] - Delete answer from question.          |");
			System.out.println("|[4] - Save and create Quiz file.            |");

			switch (getInt()) {
				case 1 -> QuizCreator.addAnsToQuestion();
				case 2 -> QuizCreator.editAnsString();
				case 3 -> QuizCreator.deleteAnsFromQuestion();
				case 4 -> testDone = true;
				default -> System.out.println("INVALID INPUT");

			}

		}
		String examType = "Solutions";							// Solution that avoids creating two function that prints quiz 
		for(int i=0;i<=2;i++){
			createQuizFile(i,examType, quizQuestion);		// Calls for a function that do all the work of creating files
			examType = "Exam";
		}
	}

	public static void createQuizFile(int k, String examType, int[] quizQuestion) throws FileNotFoundException {
			// Function that creates two diffrent files
			// int k - is to check if the quiz is for Student or Teacher (with answers)
			// String examType is for file name (can be moved to this function)
			// int[] quizQuestion is the array qith questions for quiz
			
			// Two function that gets a current time and format it 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");  
		LocalDateTime now = LocalDateTime.now(); 

			// Print Writer function that prints text into files 
		PrintWriter pw = new PrintWriter(examType+"_"+dtf.format(now)+".txt");

			// Quiz printing loop that prints quiz with correct answers for Teacher and second time (when k is 1)
			// prints quiz without marking correct answers
		pw.println("Quiz:");
		
		if(k==1)
					pw.println("\nGood Luck");
			for (int i = 0; i < quizQuestion.length; i++) {
				int tempNum = quizQuestion[i];
				pw.println("\n_______________________________________________________");
				pw.println("\n"+" [" + (i + 1) + "] " + question[tempNum].getQuestion() + ":");
	
				int j = 0;
				while(j<question[tempNum].getAnsCount()&&question[tempNum].getCorrectAnsCount()!=101){
					if (question[tempNum].getFitAns(j) != 0){
						pw.print("\n"+(j + 1) + ") " + answers[question[tempNum].getFitAns(j)] + ".");
							if (question[tempNum].getboolAnsType(j)&&question[tempNum].getAnsCount()==1&&k==0)
							pw.print(" (Correct answers)");
								pw.print("");
					}
					j++;
				}if(question[tempNum].getCorrectAnsCount()==101){
					pw.print("Type your answer here: ____________________________________");
					if(k==0)
					pw.print("\n Correct answer is: "+question[tempNum].getCorrectAnswer());
				}
				else if(question[tempNum].getAnsCount()==0){
				pw.print("\n"+(question[tempNum].getAnsCount()+1) + ") There is no correct answers.");
					if(k==0)
						pw.print("(Correct answers)");
				} else if (question[tempNum].getAnsCount()>1){
					pw.print("\n"+(question[tempNum].getAnsCount()+1) + ") There is more than one correct answer.");
					if(k==0)
						pw.print("(Correct answers)");
				}
				}
				pw.println("");
				
			
			
			pw.close();
	}

	public static void printQuiz(int qNum, int[] quizQuestion) {	// A function that prints the quiz before printing it in to file

		for (int i = 0; i < qNum; i++) {
			int tempNum = quizQuestion[i];
			System.out.println("[" + (i + 1) + "] " + question[tempNum].getQuestion() + ":");

            int j = 0;
			while(j<question[tempNum].getAnsCount()&&question[tempNum].getCorrectAnsCount()!=101){
				if (question[tempNum].getFitAns(j) != 0){
							System.out.print(j + 1 + ") " + answers[question[tempNum].getFitAns(j)] + ".");
						if (question[tempNum].getboolAnsType(j)&&question[tempNum].getAnsCount()==1)
							System.out.print("\u001B[32m(Correct answers) \u001B[0m");
				System.out.println("");
				}
                j++;
            }
			if(question[tempNum].getCorrectAnsCount()==101)
				System.out.println("____________________________________");

			else switch(question[tempNum].getAnsCount()) {
				case 0:
				System.out.println((question[tempNum].getAnsCount()+1) + ") There is no correct answers."+"\u001B[32m(Correct answers) \u001B[0m");
				  break;
				case 1:
					break;
				default:
				System.out.println((question[tempNum].getAnsCount()+1) + ") There is more than one correct answer."+"\u001B[32m(Correct answers) \u001B[0m");
			}
        
		}
	}

}
