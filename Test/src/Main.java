import java.util.Arrays;
import java.util.Scanner;

/**
 * The program parses ints from strings, but has no error handling, as soon as a string that can't be parsed as
 * a number is received, the program will fail inelegantly
 * */
public class Main {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                //Getting first line specifying initial capacity and number of operations and splitting it
                String[] firstLineInput =  scanner.nextLine().split(" ");
                //Parsing capacity, creating array and initializing it
                int initialCapacity = Integer.parseInt(firstLineInput[0]);
                int numberOfOperations = Integer.parseInt(firstLineInput[1]);
                int max = doOperations(initialCapacity, numberOfOperations, scanner);
                System.out.println(max);
        }

        /**
         * This program does the operations as it goes, inserting the values as the inputs are received
         * This will have poor scalability since it will keep waiting for n inputs.
         * Another solution would be to store in memory or in a file or in a db all the entries and then retrieve one by one
         * to parse them*/
        public static int doOperations (int initialCapacity, int numberOfOperations, Scanner scanner) {
                int[] numbersArray = new int[initialCapacity];
                Arrays.fill(numbersArray, 0);
                int currentLoop = 0;
                while(currentLoop<numberOfOperations) {
                        String[] operation =  scanner.nextLine().split(" ");
                        int startIndex = Integer.parseInt(operation[0]) - 1;
                        int endIndex = Integer.parseInt(operation[1]);
                        int numberToAdd = Integer.parseInt(operation[2]);
                        if(startIndex < 0)
                                startIndex = 0;
                        for (int i = startIndex; i<endIndex; i++) {
                                numbersArray[i] += numberToAdd;
                        }
                        currentLoop++;
                }
                return Arrays.stream(numbersArray).max().getAsInt();
        }
}
