package com.riwi.riwiPortalVirtual.Api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class lessonRequest {
    

    @NotBlank(message = "El titulo de la lesson es requerido")
    @Size(min = 1, max = 255, message = "El titulo de la clase debe tener entre 1 y 255 caracteres")
    private String title;
    
    @NotNull(message = "debe especificar el contenido la lesson")
    private String content;

    @NotNull(message = "debe especificar la actividad")
    private boolean active;

    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Long id_class;



}
