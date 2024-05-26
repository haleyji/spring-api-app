package com.app.global.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 *  Entity 에서 사용할 DB <-> Entity 암복호화 Converter
 *
 *  <p>
 *      Entity 에서 사용할 DB <-> Entity 암복호화 Converter
 *  </p>
 *
 * @version : 1.0
 * @author : hyeyoungji
 */
@Converter(autoApply = false)
public class DBEncryptionConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return null;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return null;
    }
}

