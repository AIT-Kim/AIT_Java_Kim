package lesson_39.dateArrays;

import lesson_39.CarsPredicate.lib.MyArrayList;
import lesson_39.CarsPredicate.lib.MyArrayList.*;
import lesson_39.CarsPredicate.lib.MyList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    public static void main(String[] args) {
        MyList<LocalDate> dates = new MyArrayList<>();
        dates.add(LocalDate.of(2022, 1, 1));
        dates.add(LocalDate.of(2023, 12, 30));
        dates.add(LocalDate.of(2023, 5, 15));
        dates.add(LocalDate.of(2024, 1, 1));

        System.out.println(DateUtil.durationBetweenMinMaxDate(dates));
    }

    public static long durationBetweenMinMaxDate(MyList<LocalDate> datesList) {
        if (datesList == null || datesList.isEmpty()) return 0;


        LocalDate minDate = datesList.get(0);
        LocalDate maxDate = datesList.get(0);

        for (LocalDate date : datesList) {
            if (date.isBefore(minDate)) {
                minDate = date;
            }

            if (date.isAfter(maxDate)) {
                maxDate = date;
            }
        }

        return minDate.until(maxDate, ChronoUnit.DAYS);
    }
}