package com.riwi.riwiPortalVirtual.Api.dto.response;



import java.time.LocalDateTime;

import com.riwi.riwiPortalVirtual.domain.entities.lesson;
import com.riwi.riwiPortalVirtual.utils.enums.typeDateEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class multimedResponse {
    private long id_multimedy;
     private typeDateEnum type;
     private String url;
     private LocalDateTime create_at;
     private boolean active;
     private lesson id_lesson;
}
