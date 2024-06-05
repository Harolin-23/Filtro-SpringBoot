package com.riwi.riwiPortalVirtual.Api.dto.response;

import java.time.LocalDateTime;

import com.riwi.riwiPortalVirtual.utils.enums.typeDateEnum;

public class basciMultimediaRespomse {
       private long id_multimedy;
     private typeDateEnum type;
     private String url;
     private LocalDateTime create_at;
     private boolean active;
}
