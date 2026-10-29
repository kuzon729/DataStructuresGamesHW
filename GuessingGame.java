import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        System.out.println("Pick a number, any number between 1 and 100 and I'll try to guess it.");
        Scanner scanner = new Scanner(System.in);
        boolean guessed = false;
        int lowerBound = 0;
        int higherBound = 100;
        int guess = 50;
        while(!guessed) {
            System.out.println("I guess " + guess + ". Is this higher, lower, or correct?");
            String response = scanner.nextLine();
            boolean validAnswer = false;
            while(!validAnswer) {

                if(response.contains("h") || response.contains("H")) {
                    lowerBound = guess;
                    guess = (lowerBound+higherBound)/2;
                    validAnswer = true;
                    if(guess >99) {
                        System.out.println("I quit");
                        guessed=true;
                    }
                }else if(response.contains("l") || response.contains("L")) {
                    higherBound = guess;
                    guess = (lowerBound+higherBound)/2;
                    validAnswer = true;
                    if(guess <1) {
                        System.out.println("I quit");
                        guessed=true;
                    }
                }else if(response.contains("c") || response.contains("C")){
                    guessed = true;
                    validAnswer = true;
                    System.out.println("Your number is " + guess);
                }else {
                    System.out.println("Answer is invalid, please try again");
                    response = scanner.nextLine();

                }
            }
            if(lowerBound==guess || higherBound == guess) {
                guessed = true;
                System.out.println("I quit");
            }
        }





    }

}
