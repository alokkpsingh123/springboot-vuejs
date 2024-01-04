package org.alok.smspostgres.dto;

import lombok.Data;

import java.util.Date;

@Data
public class InstructorResposeDTO {
    private String instructorId;
    private String instructorName;
    private Date dateOfBirth;
}
