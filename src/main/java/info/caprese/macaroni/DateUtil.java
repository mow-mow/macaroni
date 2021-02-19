package info.caprese.macaroni;

import info.caprese.macaroni.model.TimeZone;

import java.time.LocalDateTime;

public class DateUtil {
    public static TimeZone convertTimeZone(LocalDateTime localDateTime) {
        int hour = localDateTime.getHour();
        if ( hour >= 5 && hour < 11 ) {
            return TimeZone.MORNING;
        } else if ( hour >= 11 && hour < 16 ) {
            return TimeZone.DAYTIME;
        } else {
            return TimeZone.NIGHT;
        }
    }
}
