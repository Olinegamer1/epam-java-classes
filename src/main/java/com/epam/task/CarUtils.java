package com.epam.task;

import java.util.Objects;
import java.util.Random;
import java.util.function.IntPredicate;

/**
 * The CarUtils class contains auxiliary methods for the Car class
 *
 * @author Pavel Lysenkov
 * @version 1.0
 * @see Car
 */
public final class CarUtils {

    /**
     * Don't let anyone instantiate this class.
     */
    private CarUtils() {
    }

    /**
     * Used to generate a random registration number.
     *
     * @see Random
     */
    private final static Random RANDOM = new Random();

    /**
     * The method defines the range of digits [0-9] and uppercase letters [A-Z] of the ASCII table.
     *
     * @return IntPredicate for the correct registration number.
     */
    private static IntPredicate alphanumeric() {
        return i -> (i >= 48 && i <= 57) || (i >= 65 && i <= 90);
    }

    /**
     * Checks whether the number consists only of digits and uppercase
     * letters of the English alphabet, also does not exceed the length of 7 characters.
     *
     * @param registrationNumber registration number of Car object.
     * @return false, if the registration number does not meet the standards.
     */
    public static boolean isCorrectRegistrationNumber(String registrationNumber) {
        if (Objects.nonNull(registrationNumber)) {
            return registrationNumber.chars().allMatch(alphanumeric()) && registrationNumber.length() < 8;
        }
        return false;
    }

    /**
     * Generates a registration number with a length of 7 characters
     *
     * @return registration number for Car object.
     * @see CarUtils#alphanumeric()
     */
    public static String generateRegistrationNumber() {
        return RANDOM.ints(48, 91)
                .filter(alphanumeric())
                .limit(7)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
