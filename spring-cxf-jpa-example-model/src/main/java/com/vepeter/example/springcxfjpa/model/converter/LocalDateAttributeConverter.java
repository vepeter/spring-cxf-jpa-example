package com.vepeter.example.springcxfjpa.model.converter;

import java.sql.Timestamp;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDate localDate) {
        return localDate == null ? null : new Timestamp(localDate.toDateTimeAtStartOfDay().getMillis());
    }

    @Override
    public LocalDate convertToEntityAttribute(Timestamp dbData) {
        return dbData == null ? null : LocalDate.fromDateFields(dbData);
    }

}
