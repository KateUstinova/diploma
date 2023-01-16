package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;


public class DataHelp {

    private DataHelp() {
    }

    private static Faker faker = new Faker(new Locale("en"));

    @Value
    public static class Card {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    public static String cardNumberApproved() {
        return "4444444444444441";
    }
    public static String cardNumberDeclined() {
        return "4444444444444442";
    }
    public static String randomMonth() {
        Random random = new Random();
        int i = random.nextInt(10);
        LocalDate dataMonth = LocalDate.now().plusMonths(i);
        int month = dataMonth.getMonthValue();
        return String.format("%02d", month);
    }

    public static String currentMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue();
        return String.format("%02d", month);
    }

    public static String pastMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue() - 1;
        return String.format("%02d", month);
    }

    public static String thirteenthMonth() {
        int month = 13;
        return String.format("%02d", month);
    }

    public static String zeroMonth() {
        return "00";
    }

    public static String nextMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue() + 1;
        return String.format("%02d", month);
    }

    public static String randomYear() {
        Random random = new Random();
        int i = random.nextInt(10);
        LocalDate dataYear = LocalDate.now().plusYears(i);
        int year = dataYear.getYear() - 2000;
        return Integer.toString(year);
    }

    public static String currentYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 2000;
        return Integer.toString(year);
    }

    public static String pastYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 2001;
        return Integer.toString(year);
    }

    public static String nextYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 1999;
        return Integer.toString(year);
    }

    public static String moreThenFiveYear() {
        LocalDate currentYear = LocalDate.now();
        int year = currentYear.getYear() - 1994;
        return Integer.toString(year);
    }

    public static String owner() {
        return faker.name().fullName();
    }

    public static String CVC() {
        return faker.number().digits(3);
    }

    public static String falseCvc() {
        return faker.number().digits(2);
    }

    public static String randomCardNumber() {

        return Long.toString(faker.number().randomNumber(16, true));
    }

    public static Card randomField() {
        return new Card(randomCardNumber(), randomMonth(), currentYear(), owner(), CVC());
    }

    public static Card approvedField() {
        return new Card(cardNumberApproved(), currentMonth(), currentYear(), owner(), CVC());
    }

    public static Card declinedField() {
        return new Card(cardNumberDeclined(), currentMonth(), currentYear(), owner(), CVC());
    }

    public static Card approvedFieldAndNextMonth() {
        return new Card(cardNumberApproved(), nextMonth(), currentYear(), owner(), CVC());
    }

    public static Card approvedFieldAndPastMonth() {
        return new Card(cardNumberApproved(), pastMonth(), currentYear(), owner(), CVC());
    }

    public static Card approvedFieldAndNextYear() {
        return new Card(cardNumberApproved(), currentMonth(), nextYear(), owner(), CVC());
    }

    public static Card approvedFieldAndPastYear() {
        return new Card(cardNumberApproved(), currentMonth(), pastYear(), owner(), CVC());
    }

    public static Card approvedFieldAndWrongCvc() {
        return new Card(cardNumberApproved(), currentMonth(), currentYear(), owner(), falseCvc());
    }

    public static Card emptyCardField() {

        return new Card("", currentMonth(), currentYear(), owner(), CVC());
    }

    public static Card emptyMonthField() {

        return new Card(cardNumberApproved(), "", currentYear(), owner(), CVC());
    }

    public static Card emptyYearField() {

        return new Card(cardNumberApproved(), currentMonth(), "", owner(), CVC());
    }

    public static Card emptyOwnerField() {
        return new Card(cardNumberApproved(), currentMonth(), currentYear(), "", CVC());
    }

    public static Card emptyCvcField() {
        return new Card(cardNumberApproved(), currentMonth(), currentYear(), owner(), "");
    }

    public static Card emptyFields() {
        return new Card("", "", "", "", "");
    }

    public static Card approvedFieldAndZeroMonth() {
        return new Card(cardNumberApproved(), zeroMonth(), nextYear(), owner(), CVC());
    }


    public static Card approvedFieldAndZeroCvc() {
        return new Card(cardNumberApproved(), currentMonth(), currentYear(), owner(), "000");
    }

    public static Card shortCard() {
        return new Card("00000000", currentMonth(), currentYear(), owner(), CVC());
    }

    public static Card approvedFieldAndRussiaName() {
        return new Card(cardNumberApproved(), currentMonth(), currentYear(), "Екатерина Устинова", CVC());
    }
}

