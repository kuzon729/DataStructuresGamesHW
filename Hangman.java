import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        int fileLength = 0;
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("C:\\Users\\Cchen\\IdeaProjects\\GithubBasicsHW\\src\\WordList");
        try {
            fileLength = (int)Files.lines(path).count();
        } catch(IOException e) {
            e.printStackTrace();
        }
        boolean gameRunning = true;
        while(gameRunning) {
            File myFile = new File("C:\\Users\\Cchen\\IdeaProjects\\GithubBasicsHW\\src\\WordList");
            Scanner wordReader = new Scanner(myFile);
            int random = (int)(1 + Math.random()*fileLength);
            String word = "";
            for(int i = 0; i < random; i++) {
                word = wordReader.nextLine();
            }

            String[][] wordProgress = new String[word.length()][2];
            int guessedCount = 0;
            int wrongGuessCount = 0;
            for(int i = 0; i < word.length(); i++) {
                wordProgress[i][0] = word.substring(i, i+1);
                wordProgress[i][1] = "n";
            }
            boolean guessed = false;
            HashSet<String> guessedLetter = new HashSet<String>();
            while(!guessed) {
                for(int i = 0; i < word.length(); i++) {
                    if(wordProgress[i][1].equals("y")) {
                        System.out.print(wordProgress[i][0] + " ");
                    }else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
                System.out.println("guess a letter(lowercase only)");
                int g = 6 - wrongGuessCount;
                System.out.println("you have " + g + " guesses left");
                String answer = scanner.nextLine();
                if(!guessedLetter.contains(answer)) {
                    boolean isCorrect = false;
                    for(int i = 0; i < word.length();i++) {
                        if(answer.contains(wordProgress[i][0])) {
                            wordProgress[i][1] = "y";
                            guessedCount++;
                            isCorrect = true;
                        }
                    }
                    guessedLetter.add(answer);
                    if(!isCorrect) {
                        wrongGuessCount++;
                    }
                }else {
                    System.out.println("you already guessed that, try again.");
                }

                if(guessedCount == word.length()) {
                    guessed = true;
                    System.out.println("You guessed the word! Would you like to play another round?");
                    String answerTwo = scanner.nextLine();
                    if(answerTwo.contains("y")|| answerTwo.contains("Y")) {
                        System.out.println("onto the next round");
                    }else {
                        gameRunning = false;
                    }
                }else if(wrongGuessCount > 5) {
                    guessed = true;
                    System.out.println("You failed. Would you like to play another round?");
                    String answerTwo = scanner.nextLine();
                    if(answerTwo.contains("y")|| answerTwo.contains("Y")) {
                        System.out.println("onto the next round");
                    }else {
                        gameRunning = false;
                    }
                }
            }
        }

    }
}
