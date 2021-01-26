package org.fundacionjala.app.quizz.console;

import java.util.Scanner;
import java.util.Set;

import org.fundacionjala.app.quizz.model.Answer;
import org.fundacionjala.app.quizz.model.Question;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.model.QuizAnswers;

public class QuizUIHandler {

	static Scanner scanner = new Scanner(System.in);

	public static Quiz createQuiz() {
		return new QuizUIMenu().handleCreateQuiz();
	}

	public static QuizAnswers fillQuiz(Quiz quiz) {
		QuizAnswers quizAnswers = new QuizAnswers(quiz);
		QuestionInputHandler questionHandler = new QuestionInputHandler();

		System.out.println("Quiz: " + quiz.getTitle());
		for (Question question : quiz.getQuestions()) {
			Set<String> answers = questionHandler.askQuestionValue(question);
			Answer answer = new Answer(question, answers);
			quizAnswers.addAnswer(answer);
		}

		return quizAnswers;
	}

	public static void showQuiz(QuizAnswers quizAnswers) {
		System.out.println(quizAnswers.getQuiz().getTitle());
		System.out.println("=============================================");

		for (Answer answer : quizAnswers.getAnswers()) {
			System.out.println(answer);
		}

		System.out.println("=============================================");
		System.out.println("Press ENTER to continue");
		scanner.nextLine();
	}
}
