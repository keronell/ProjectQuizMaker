package vladislavPavlyuk;
import vladislavPavlyuk.BaseQ.DifficultyLevel;
import java.util.Scanner;

public class DataBase {
    public static Scanner s = new Scanner(System.in);

	public static int aNum; //Welcome to hell						// Answer number user choose
	public static int qNum; 								// Question number user choose

	public static int questionCounter = 10;					// Number of question in tray 
	public static int answersCounter = 22;					// Number of answers in tray
	

	public static  void questionBox() {						// Question tray
		// Question 1
		QuizCreator.question[0] = new Question("What is the optimal temperature for teaching?",DifficultyLevel.NORMAL );
			//Answers of the 1 question (Link to answers array and is answers true or false)
        QuizCreator.question[0].setAnswer(1, true);
		QuizCreator.question[0].setAnswer(2, true);
		QuizCreator.question[0].setAnswer(3, false);

		// Question 2
		QuizCreator.question[1] = new Question("What is the best language?",DifficultyLevel.EASY);
			//Answers of the 2 question (Link to answers array and is answers true or false)
        QuizCreator.question[1].setAnswer(4, true);
        QuizCreator.question[1].setAnswer(5, false);
        QuizCreator.question[1].setAnswer(6, false);
        QuizCreator.question[1].setAnswer(7, false);

		// Question 3
		QuizCreator.question[2] = new Question("Best name?",DifficultyLevel.NORMAL);
			//Answers of the 3 question (Link to answers array and is answers true or false)
        QuizCreator.question[2].setAnswer(18, false);
        QuizCreator.question[2].setAnswer(21, false);
        QuizCreator.question[2].setAnswer(19, false);
        QuizCreator.question[2].setAnswer(20, true);

		// Question 4
		QuizCreator.question[3] = new Question("1+1?",DifficultyLevel.EASY);
			//Answers of the 4 question (Link to answers array and is answers true or false)
        QuizCreator.question[3].setAnswer(8, true);
        QuizCreator.question[3].setAnswer(9, false);
        QuizCreator.question[3].setAnswer(10, false);
        QuizCreator.question[3].setAnswer(11, true);
        QuizCreator.question[3].setAnswer(12, false);
        QuizCreator.question[3].setAnswer(13, false);
		QuizCreator.question[3].setAnswer(14, false);
		QuizCreator.question[3].setAnswer(15, false);
		QuizCreator.question[3].setAnswer(16, true);

		// Question 5
		QuizCreator.question[4] = new Question("2+1?",DifficultyLevel.HARD);
			//Answers of the 5 question (Link to answers array and is answers true or false)
        QuizCreator.question[4].setAnswer(10, true);
		QuizCreator.question[4].setAnswer(11, false);
		QuizCreator.question[4].setAnswer(12, false);
		QuizCreator.question[4].setAnswer(13, true);
		

		// Question 6
		QuizCreator.question[5] = new Question("2+2?",DifficultyLevel.NORMAL);
			//Answers of the 6 question (Link to answers array and is answers true or false)
        QuizCreator.question[5].setAnswer(11, true);
		QuizCreator.question[5].setAnswer(12, false);
		QuizCreator.question[5].setAnswer(13, false);
		QuizCreator.question[5].setAnswer(14, true);
		QuizCreator.question[5].setAnswer(16, false);
		QuizCreator.question[5].setAnswer(17, false);
		
		// Question 7
		QuizCreator.question[6] = new Question("2/2?",DifficultyLevel.HARD);
			//Answers of the 7 question (Link to answers array and is answers true or false)
        QuizCreator.question[6].setAnswer(11, false);
        QuizCreator.question[6].setAnswer(12, false);
		QuizCreator.question[6].setAnswer(9, false);
        QuizCreator.question[6].setAnswer(10, false);
		QuizCreator.question[6].setAnswer(11, true);

		// Question 8
		QuizCreator.question[7] = new Question("2/1?",DifficultyLevel.NORMAL);
			//Answers of the 8 question (Link to answers array and is answers true or false)
        QuizCreator.question[7].setAnswer(10, false);
		QuizCreator.question[7].setAnswer(12, false);
		QuizCreator.question[7].setAnswer(11, false);
		QuizCreator.question[7].setAnswer(9, false);
		QuizCreator.question[7].setAnswer(8, true);

		// Question 9
		QuizCreator.question[8] = new Question("2^2?",DifficultyLevel.EASY);
			//Answers of the 9 question (Link to answers array and is answers true or false)
        QuizCreator.question[8].setAnswer(12, true);
		QuizCreator.question[8].setAnswer(13, false);
		QuizCreator.question[8].setAnswer(14, false);
		QuizCreator.question[8].setAnswer(15, true);
		QuizCreator.question[8].setAnswer(16, false);
		QuizCreator.question[8].setAnswer(17, false);
		
		// Question 10
		QuizCreator.question[9] = new Question("2*2?",DifficultyLevel.HARD);
			//Answers of the 10 question (Link to answers array and is answers true or false)
        QuizCreator.question[9].setAnswer(16, false);
		QuizCreator.question[9].setAnswer(17, false);
		QuizCreator.question[9].setAnswer(9, false);
		QuizCreator.question[9].setAnswer(10, false);
		QuizCreator.question[9].setAnswer(11, true);

		// Question 11 (Open question)
		QuizCreator.question[10] = new Question("What is the color of the sun?", "White",DifficultyLevel.NORMAL);

		// Question 12 (Open question)
		QuizCreator.question[11] = new Question("Is it possible to work and study?", "Everything is possible if you believe in yourself",DifficultyLevel.EASY);

		// Question 13 (Open question)
		QuizCreator.question[12] = new Question("Who let the dogs out?","Who, who, who, who, who?",DifficultyLevel.HARD);

	}

	public static void answersBox() {						// Answers tray 

		QuizCreator.answers[0] = ("Reserved place");

		// Special index for a situation when the program creates an array of int and
		// automatically sets it to "0"
		// So do not always start a new question with all answers pointing to the "0" index
		// I did not count index "0" in loops and avoided it

		QuizCreator.answers[1] = ("14 degree");
		QuizCreator.answers[2] = ("-14 degree");
		QuizCreator.answers[3] = ("30");
		QuizCreator.answers[4] = ("Java");
		QuizCreator.answers[5] = ("Chinese");
		QuizCreator.answers[6] = ("Assemble");
		QuizCreator.answers[7] = ("C++");
		QuizCreator.answers[8] = ("1");
		QuizCreator.answers[9] = ("2");
		QuizCreator.answers[10] = ("3");
		QuizCreator.answers[11] = ("4");
		QuizCreator.answers[12] = ("5");
		QuizCreator.answers[13] = ("6");
		QuizCreator.answers[14] = ("7");
		QuizCreator.answers[15] = ("8");
		QuizCreator.answers[16] = ("9");
		QuizCreator.answers[17] = ("10");
		QuizCreator.answers[18] = ("Toto");
		QuizCreator.answers[19] = ("Momo");
		QuizCreator.answers[20] = ("Coco");
		QuizCreator.answers[21] = ("Africa");
	}
}
