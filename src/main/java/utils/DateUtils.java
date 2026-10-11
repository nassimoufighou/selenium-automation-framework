package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class DateUtils {

    public static final String MMMM_D_YYYY = "MMMM d yyyy";    // November 3 2026
    public static final String MMMM = "MMMM";                  // November
    public static final String D = "d";                        // 3
    public static final String DD_MM_YYYY = "dd/MM/yyyy";      // 03/11/2026

    public static String dateInDays(int days, String pattern) {
        if (days < 0) return LocalDate.now()
                .minusDays(days)
                .format(DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH));
        else return LocalDate.now()
                .plusDays(days)
                .format(DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH));
    }
}