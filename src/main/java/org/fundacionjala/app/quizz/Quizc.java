package org.fundacionjala.app.quizz;

public class Quizc {

    public void run() {
        Menu menu = new Menu();

        boolean shouldExit = false;
        do {
            shouldExit = menu.process();
        } while (!shouldExit);
        if (shouldExit){
            System.out.println("salio");
        }
    }
}
