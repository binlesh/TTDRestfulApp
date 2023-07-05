package com.restful.TDDRestfulApp.utils;

import java.util.function.Predicate;

public class AppUtils {

    public static boolean validSouthAfricanIDNumber(String idNumberToValidate){
        System.out.println("Validating ID "+ idNumberToValidate);

        Predicate<String> idLength = s-> s.length() ==13;
        Predicate<String> isNumberValidator = s -> s.chars().allMatch(Character::isDigit);

        Predicate<String> controlDigitValidator = s -> {
            int sum = 0;
            int[] weights = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};

            for (int i = 0; i < 12; i++) {
                int iDdigit = Character.getNumericValue(s.charAt(i));
                sum += iDdigit < 10 ? iDdigit * weights[i] : iDdigit;
            }

            int controlDigit = (10 - (sum % 10)) % 10;
            return controlDigit == Character.getNumericValue(s.charAt(12));
        };

        return idLength.and(isNumberValidator).and(controlDigitValidator).test(idNumberToValidate);
    }

    public String maskID(String id){

        return null;
    }
}
