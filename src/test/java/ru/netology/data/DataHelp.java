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
    public static class card {
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
        LocalDate currentMonth = LocalDate.now();
        int between = (12 - currentMonth.getMonthValue()) + 1;
        int month = currentMonth.getMonthValue() + between;
        return String.format("%02d", month);
    }

    public static String zeroMonth() {
        LocalDate currentMonth = LocalDate.now();
        int month = currentMonth.getMonthValue() - currentMonth.getMonthValue();
        return String.format("%02d", month);
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

    public static card randomField() {
        return new card(randomCardNumber(), randomMonth(), currentYear(), owner(), CVC());
    }

    public static card approvedField() {
        return new card(cardNumberApproved(), currentMonth(), currentYear(), owner(), CVC());
    }

    public static card declinedField() {
        return new card(cardNumberDeclined(), currentMonth(), currentYear(), owner(), CVC());
    }

    public static card approvedFieldAndNextMonth() {
        return new card(cardNumberApproved(), nextMonth(), currentYear(), owner(), CVC());
    }

    public static card approvedFieldAndPastMonth() {
        return new card(cardNumberApproved(), pastMonth(), currentYear(), owner(), CVC());
    }

    public static card approvedFieldAndNextYear() {
        return new card(cardNumberApproved(), currentMonth(), nextYear(), owner(), CVC());
    }

    public static card approvedFieldAndPastYear() {
        return new card(cardNumberApproved(), currentMonth(), pastYear(), owner(), CVC());
    }

    public static card approvedFieldAndWrongCvc() {
        return new card(cardNumberApproved(), currentMonth(), currentYear(), owner(), falseCvc());
    }

    public static card emptyCardField() {

        return new card("", currentMonth(), currentYear(), owner(), CVC());
    }

    public static card emptyMonthField() {

        return new card(cardNumberApproved(), "", currentYear(), owner(), CVC());
    }

    public static card emptyYearField() {

        return new card(cardNumberApproved(), currentMonth(), "", owner(), CVC());
    }

    public static card emptyOwnerField() {
        return new card(cardNumberApproved(), currentMonth(), currentYear(), "", CVC());
    }

    public static card emptyCvcField() {
        return new card(cardNumberApproved(), currentMonth(), currentYear(), owner(), "");
    }

    public static card emptyFields() {
        return new card("", "", "", "", "");
    }

    public static card approvedFieldAndZeroMonth() {
        return new card(cardNumberApproved(), zeroMonth(), nextYear(), owner(), CVC());
    }

    public static card approvedFieldAndThirteenthMonth() {
        return new card(cardNumberApproved(), thirteenthMonth(), currentYear(), owner(), CVC());
    }

    public static card approvedFieldAndZeroCvc() {
        return new card(cardNumberApproved(), currentMonth(), currentYear(), owner(), "000");
    }

    public static card shortCard() {
        return new card("00000000", currentMonth(), currentYear(), owner(), CVC());
    }

    public static card approvedFieldAndRussiaName() {
        return new card(cardNumberApproved(), currentMonth(), currentYear(), "Екатерина Устинова", CVC());
    }

    public static card approvedFieldAndMoreThanFiveYear() {
        return new card(cardNumberApproved(), currentMonth(), moreThenFiveYear(), owner(), CVC());
    }
}

