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
public class basicLessonResponse {
    private long id_lesson;
    private String title;
    private String content;
    private LocalDateTime create_at;
    private boolean active;
}
