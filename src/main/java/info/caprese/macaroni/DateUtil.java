package info.caprese.macaroni;

import info.caprese.macaroni.model.TimeZone;

import java.time.LocalDateTime;

public class DateUtil {
    public static TimeZone convertTimeZone(LocalDateTime localDateTime) {
        return TimeZone.MORNING;
    }
}
