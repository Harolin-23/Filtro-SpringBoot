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
public class classResponse {
    private long  id_class;
     private String name;
     private String description;
     private LocalDateTime create_at;
     private boolean active;
}
