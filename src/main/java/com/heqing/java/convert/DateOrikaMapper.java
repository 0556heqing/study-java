package com.heqing.java.convert;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author heqing
 */
public class DateOrikaMapper extends BidirectionalConverter<Date, String> {

    @Override
    public String convertTo(Date source, Type<String> destinationType, MappingContext mappingContext) {
        return source != null ? new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( source ) : "";
    }

    @Override
    public Date convertFrom(String source, Type<Date> destinationType, MappingContext mappingContext) {
        try {
            return source != null ? new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).parse( source ) : null;
        } catch (Exception e) {
            throw new RuntimeException( e );
        }
    }
}
