package org.alok.smspostgres.dto;

import lombok.Data;

@Data
public class InstructorDTO {
    private String instructorId;
    private String instructorName;
    private long dateOfBirth;
}
