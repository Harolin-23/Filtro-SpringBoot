package com.riwi.riwiPortalVirtual.Api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.riwi.riwiPortalVirtual.domain.entities.ClassRiwi;
import com.riwi.riwiPortalVirtual.domain.entities.multimed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class lessonResponse {
    private long id_lesson;
    private String title;
    private String content;
    private LocalDateTime create_at;
    private boolean active;
    private ClassRiwi id_class;
    private List<multimed> multimedia;

}
