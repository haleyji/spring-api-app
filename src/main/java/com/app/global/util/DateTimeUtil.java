package com.app.global.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeUtil {
    /**
     *
     * @param date
     * @return LocalDateTime
     * @Description Date 타입을 LocalDateTime 으로 변경
     */
    public static LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
