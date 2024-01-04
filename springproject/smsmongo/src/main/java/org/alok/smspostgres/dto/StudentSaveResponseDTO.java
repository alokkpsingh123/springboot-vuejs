package org.alok.smspostgres.dto;

import lombok.Data;

import java.util.Date;
@Data

public class StudentSaveResponseDTO {
    private String studentId;
    private String studentName;
    private Date dateOfBirth;
}
