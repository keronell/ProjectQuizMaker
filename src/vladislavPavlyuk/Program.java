package vladislavPavlyuk;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
	public static Scanner s = new Scanner(System.in);

	public static void menu() throws FileNotFoundException {
		boolean flag = true;
			System.out.println("Welcome to Quiz creator");
			System.out.println("How may I help you:\n");
		do {
			System.out.println("---------------------------------------------");
			System.out.println("|[1] - Show questions list with answers.     |");
			System.out.println("|[2] - Add new answers to exists question.   |");
			System.out.println("|[3] - Add new question to tray.             |");
			System.out.println("|[4] - Add new answer to a tray.             |");
			System.out.println("|[5] - Edit question.                        |");
			System.out.println("|[6] - Edit answer.                          |");
			System.out.println("|[7] - Delete answer from  question.         |");
			System.out.println("|[8] - Delete question (with answers for it).|");
			System.out.println("|[9] - Create test.                          |");
			System.out.println("|[10]- Close Program.                        |");
			System.out.println("---------------------------------------------");

			switch (QuizCreator.getInt()) {

				case 10 -> flag = false;
				case 1 -> QuizCreator.printQuestion();
				case 2 -> QuizCreator.addAnsToQuestion();
				case 3 -> QuizCreator.addQuestionToTray();
				case 4 -> QuizCreator.addAnsToTray();
				case 5 -> QuizCreator.editQuestionString();
				case 6 -> QuizCreator.editAnsString();
				case 7 -> QuizCreator.deleteAnsFromQuestion();
				case 8 -> QuizCreator.deleteQuestion();
				case 9 -> QuizCreator.createQuiz();

				default -> System.out.println("INVALID INPUT");
			}
		} while (flag);
		System.out.println("Thank you for using this program to make students suffer!");

	}

	public static void main(String[] args) throws FileNotFoundException {
		DataBase.answersBox();			// - Function that sets answers tray
		DataBase.questionBox();			// - Function that sets questions tray
		menu();								// - Starts menu
		s.close();
	}

}
