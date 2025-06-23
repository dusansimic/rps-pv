package me.dusansimic.school.rpspv.app.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(force = true)
public class StudentIndex {
    private final Integer MIN_INDEX_ID = 1;
    private final Integer MIN_INDEX_YEAR = 2000;

    @AllArgsConstructor
    public static enum StudyLevel {
        BACHELOR(""),
        MASTERS("m"),
        DOCTORAL("d");

        private final String code;

        public static StudyLevel stringToStudyLevel(String string) {
            return switch (string) {
                case "" -> BACHELOR;
                case "m" -> MASTERS;
                case "d" -> DOCTORAL;
                default -> throw new IllegalArgumentException("Invalid study level: " + string);
            };
        }
    }

    @Min(MIN_INDEX_ID)
    private final Integer id;
    private final StudyLevel level;
    @Min(MIN_INDEX_YEAR)
    private final Integer year;

    public StudentIndex(String index) {
        if (!index.matches("^[1-9][0-9]*[md]?/[0-9]{2}$")) {
            throw new IllegalArgumentException("Invalid student index format: " + index);
        }

        String[] parts =  index.split("/");
        String left = parts[0];
        String right = parts[1];

        if (left.endsWith("m") || left.endsWith("d")) {
            id = Integer.parseInt(left.substring(0, left.length() - 1));
            level = StudyLevel.stringToStudyLevel(String.valueOf(left.charAt(left.length() - 1)));
        } else {
            id = Integer.parseInt(left);
            level = StudyLevel.BACHELOR;
        }

        year = Integer.parseInt(right);
    }

    @Override
    public String toString() {
        return id + level.code + "/" + String.format("%02d", year);
    }
}
