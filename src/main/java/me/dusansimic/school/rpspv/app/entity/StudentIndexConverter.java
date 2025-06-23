package me.dusansimic.school.rpspv.app.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StudentIndexConverter implements AttributeConverter<StudentIndex, String> {
    @Override
    public String convertToDatabaseColumn(StudentIndex studentIndex) {
        return studentIndex != null ? studentIndex.toString() : null;
    }

    @Override
    public StudentIndex convertToEntityAttribute(String studentIndex) {
        return studentIndex != null ? new StudentIndex(studentIndex) : null;
    }
}
