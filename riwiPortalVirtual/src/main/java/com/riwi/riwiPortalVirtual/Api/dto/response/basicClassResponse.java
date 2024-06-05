package com.riwi.riwiPortalVirtual.Api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class basicClassResponse {
     private long id_student;
    private String name;
    private String email;
    private LocalDateTime create_at;
    private boolean active;

}
