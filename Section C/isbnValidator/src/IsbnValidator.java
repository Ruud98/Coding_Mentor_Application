import java.util.Arrays;

public class IsbnValidator {

    public static void validate(String isbnNumber){

        int lenOfIsbn = isbnNumber.length(); // Getting length of isbn
        String[] isbnNumberArr = isbnNumber.split("");  // converting isbn to array
        int [] isbnVal10 = {10, 9,	8, 7, 6, 5,	4, 3, 2, 1};
        int [] isbnVal13 = {1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1};
        String isbnWord = "isbn13(";

        // removing extra x char

        if(lenOfIsbn == 11 || lenOfIsbn == 14){
            isbnNumberArr = Arrays.copyOf(isbnNumberArr, isbnNumberArr.length-1);
        }

        // ===========||IF A VALID ISBN IS PROVIDED |==================
        if (lenOfIsbn > 9 && lenOfIsbn < 15){
            // Using original isbn if equal to 10
            if (lenOfIsbn == 10){
                int sumOfProducts = 0;

                for(int num = 0; num < lenOfIsbn; num++){
                    int isbnChar = Integer.parseInt(isbnNumberArr[num]);
                    sumOfProducts += (isbnVal10[num] * isbnChar);
                }

                // Checking if sum of the product of given isbn and validating number is divisible by
                // 11, if it is then 10 digit isbn is valid
                if (sumOfProducts % 11 == 0){
                    System.out.println(isbnWord +"("+ isbnNumber +")" + "--> valid");

                    // converting isbn 10 to 13
                    String[] nineCharArr = isbnNumberArr.clone();
                    nineCharArr = Arrays.copyOf(nineCharArr, isbnNumberArr.length-1);

                    String newIsbn = "978";
                    for(int index = 0; index < 10; index++){
                        if(index == 9) // index 9 is the on which is the last number of isbn
                        {
                            newIsbn += (Integer.parseInt(isbnNumberArr[index]) + 1); // adding 1 to last number
                        }
                        else{
                            newIsbn += isbnNumberArr[index];  // adding all  other numbers to the new isbn
                        }
                    }
                    System.out.println(isbnWord + isbnNumber +") --> " + newIsbn);
                }
                else {
                    System.out.println(isbnWord + isbnNumber +")" + "--> Invalid");
                }

            // ======================| if isbn is 13 digits long |==============================
            } else if (lenOfIsbn == 13) {
                int sumOfProducts = 0;

                for(int num = 0; num < lenOfIsbn; num++){
                    int isbnChar = Integer.parseInt(isbnNumberArr[num]);
                    sumOfProducts += (isbnVal13[num] * isbnChar);
                }

                // Checking if sum of the product of given isbn and validating number is divisible by
                // 11, if it is then 10 digit isbn is valid
                if (sumOfProducts % 10 == 0){
                    System.out.println(isbnWord + isbnNumber +")" + "--> valid");
                }
                else {
                    System.out.println(isbnWord + isbnNumber +")" + "--> Invalid");
                }
            }
        }
        // ===========||IF PROVIDED FUNCTION PARAMETER IS NOT VALID |==================
        else {
            System.out.println("Invalid Parameter/Argument Given !!!!!!!");
        }
    }

    public static void main(String[] args) {
        validate("0316066524");


    }
}
