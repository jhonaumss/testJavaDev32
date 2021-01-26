package org.fundacionjala.app.quizz;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import org.fundacionjala.app.quizz.console.QuizUIHandler;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.model.QuizAnswers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Menu {

    private Quiz quiz;
    private QuizAnswers quizAnswers;

    private final Scanner scanner;

    public Menu() {

        this.quiz = null;
        this.quizAnswers = null;
        scanner = new Scanner(System.in);
    }

    public boolean process() {
        showMainMenu();
        char option = readOption();
        boolean shouldExit = false;
        switch (option) {
            case '1':
                quiz = QuizUIHandler.createQuiz();
                break;
            case '2':
                fillQuiz();
                break;
            case '3':
                showQuiz();
                break;
            case '4':
                shouldExit = true;
                saveData();
                break;
            case '5':
                readData();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

        System.out.println(System.lineSeparator());
        return shouldExit;
    }



    private void showQuiz() {
        if (quiz == null || quizAnswers == null) {
            System.out.println("No filled quiz available, you must create and fill a quiz");
            return;
        }

        QuizUIHandler.showQuiz(quizAnswers);
    }

    private void fillQuiz() {
        if (quiz == null) {
            System.out.println("No quiz available, you must create first a quiz");
            return;
        }

        quizAnswers = QuizUIHandler.fillQuiz(quiz);
    }

    private void showMainMenu() {
        System.out.println("Quizc - A command quiz utility");
        System.out.println("======================================");
        System.out.println("1. Create quiz");
        System.out.println("2. Fill quiz");
        System.out.println("3. Show quiz");
        System.out.println("4. Load previous quizzes");
        System.out.println("5. Exit");
        System.out.println("======================================");
    }

    private char readOption() {
        System.out.print("> ");
        return scanner.nextLine().trim().charAt(0);
    }

    private void saveData() {
        if (quiz!=null && quizAnswers!=null){
            Gson gson = new Gson();
            try (Writer writer = new FileWriter("./myQuiz.json")) {
                gson.toJson(quiz, writer);
            } catch (JsonIOException | IOException exception) {
                exception.printStackTrace();
            }
            try (Writer writer = new FileWriter("./myQuizAnswers.json")) {
                gson.toJson(quizAnswers, writer);
            } catch (JsonIOException | IOException exception) {
                exception.printStackTrace();
            }
        }
    }
    private void readData()
    {
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new FileReader("./myQuiz.json"))) {
            quiz = gson.fromJson(reader, Quiz.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try (JsonReader reader = new JsonReader(new FileReader("./myQuizAnswers.json"))) {
            quizAnswers = gson.fromJson(reader, QuizAnswers.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
