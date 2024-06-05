package com.riwi.riwiPortalVirtual.Api.dto.request;

import com.riwi.riwiPortalVirtual.utils.enums.typeDateEnum;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class multimedRequest {
    
    @NotNull( message = "El tipo de multimedia es requerido")
    private typeDateEnum type;
    @NotNull(message = "debe agregar la url")
    private String url;
    @NotNull(message = "debe especificar la actividad")
    private boolean active;

    @NotNull(message = "debe especificar la lesson")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Long id_lesson;


}
