import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class CreditCard {
    /*Verify if a credit card number is a valid or invalid number
    */

    //Ask the user to enter a credit card number and print weather its valid or not. 
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a credit card number as a long integer");
        long number = Long.parseLong(myObj.nextLine());
        if (isValid(number)){System.out.println(number+" is valid");}
        else{System.out.println(number+" is invalid");}


    }

    @Test
    public void testIsValid() {
        Assertions.assertEquals(true, CreditCard.isValid(431746198327461L));
    }


    public static boolean isValid(long number){
        if (getSize(number)>=13 && getSize(number)<=16){
            if (prefixMatched(number,4) || prefixMatched(number,5) || prefixMatched(number,37) || prefixMatched(number,6)){
                if ((sumOfDoubleEvenPlace(number)+sumOfOddPlace(number))%10==0){return true;}
                else{return false;}
            }
            else{return false;}
        }
        else{return false;}

    }

    public static int sumOfDoubleEvenPlace(long number){
        boolean secondDigit = false;
        int sumSingleDigits = 0;
        while (number>0){
            if (secondDigit){
                sumSingleDigits += getDigit(((int)(number%10L))*2);
                secondDigit = false;
            }
            else{secondDigit = true;}
            number = number / 10L;

        }
        return sumSingleDigits;
    }

    public static int getDigit(int number){
        if (number >= 10) {
            return number/10 + number%10;
        }
        else {
            return number;
        }
    }

    public static int sumOfOddPlace(long number){
        boolean oddDigit = true;
        int sumOddDigit = 0;
        while (number>0){
            if (oddDigit){
                sumOddDigit += (int)(number%10L);
                oddDigit = false;
            }
            else{oddDigit = true;}
            number = number / 10L;
        }
        return sumOddDigit;
    }

    public static boolean prefixMatched(long number, int d){
        if (getPrefix(number,getSize((long)d))==d){return true;}
        else{return false;}
    }

    public static int getSize(long d){
        int numberOfDigits =0;
        while (d>0){
            numberOfDigits++;
            d = d / 10L;
        }
        return numberOfDigits;
    }

    public static long getPrefix(long number, int k){
        int totalDigits = getSize(number);
        if (totalDigits>k){
            return (long) (number/(Math.pow(10,(totalDigits-k))));//chop off the right side digits we don't want
        }
        else{return number;}
    }
}
