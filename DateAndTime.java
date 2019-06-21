package javaapplication7;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Samuel-Arthurs
 */



public class DateAndTime {

    private static final Pattern regex = Pattern.compile("^([0-9]{2})-([0-9]{2})-([0-9]{4})$");
    private int month, year, date;

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the date
     */
    public int getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(int date) {
        this.date = date;
    }

    public static boolean validateDate(String date) {

        Matcher matcher = regex.matcher(date);
        if (matcher.find()) {

            int month = Integer.parseInt(matcher.group(1));
            int day = Integer.parseInt(matcher.group(2));
            int year = Integer.parseInt(matcher.group(3));

            if (month <= 12 && month > 0 && day <= 30 && day > 0 && year <= 2019 && year > 1500) {
                return true;
            }

            return false;

        } else {
            return false;
        }

    }

    public static DateAndTime makeObject(String date) {

        if (validateDate(date)) {

            Matcher matcher = regex.matcher(date);
            if (matcher.find()) {

                int month = Integer.parseInt(matcher.group(1));
                int day = Integer.parseInt(matcher.group(2));
                int year = Integer.parseInt(matcher.group(3));

                return new DateAndTime(day, month, year);

            } else {
                return null;

            }

        }
        return null;

    }

    private DateAndTime(int date, int month, int year) {

        this.month = month;
        this.date = date;
        this.year = year;

    }

    public static void main(String[] args) throws NullPointerException {

        String sc = getDateAndTime();
        if (DateAndTime.validateDate(sc)) {

            DateAndTime date = DateAndTime.makeObject(sc);
            System.out.printf("Okay the date is %d-%d-%d", date.getDate(), date.getMonth(), date.getYear());

        } else {

            System.out.println("Invalid Date");
        }

    }

    private static String getDateAndTime() {

        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();

        return date;

    }

}
