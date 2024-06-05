package com.riwi.riwiPortalVirtual.Api.dto.response;

import java.time.LocalDateTime;

import com.riwi.riwiPortalVirtual.domain.entities.ClassRiwi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class studenResponse {
    private long id_student;
    private String name;
    private String email;
    private LocalDateTime create_at;
    private boolean active;
    private ClassRiwi id_class;
}
