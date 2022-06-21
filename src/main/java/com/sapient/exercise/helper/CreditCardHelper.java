package com.sapient.exercise.helper;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CreditCardHelper {

    /**
     * Method to validate Credit card numbers based on LUHN algorithm
     * @param cardNum
     * @return
     */
    public static boolean validateCardNumber(String cardNum) {

        //build regex expression to validate card with only numbers between 5 & 19
        Pattern pattern = Pattern.compile("\\d{5,19}");
        Matcher matcher = pattern.matcher(cardNum);
        boolean isValid = false;
        if(matcher.find()) {
            //convert string of card number to array of integers
            int[] nums = Arrays.stream(cardNum.split("")).mapToInt(Integer::parseInt).toArray();

            //using exclusive bitwise, divide & modulus operator
            isValid = IntStream.range(0, nums.length)
                    .map(i -> (((i % 2) ^ (nums.length % 2)) == 0) ? ((nums[i] * 2) / 10 + (nums[i] * 2) % 10) : nums[i])
                    .sum() % 10 == 0;
        }

        return isValid;
    }
}
