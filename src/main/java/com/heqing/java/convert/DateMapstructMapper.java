package com.heqing.java.convert;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author heqing
 */
public class DateMapstructMapper {

    public String asString(Date date) {
        return date != null ? new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( date ) : "";
    }

    public Long asLong(Date date) {
        return date.getTime();
    }

    public Date asDate(String date) {
        try {
            return date != null ? new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).parse( date ) : null;
        } catch (Exception e) {
            throw new RuntimeException( e );
        }
    }

    public Date asDate(Long date) {
        return new Date(date);
    }

}
