package com.riwi.riwiPortalVirtual.Api.dto.request;

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
public class ClassRequest {
    
    @NotBlank(message = "El nombre de la clase es requerido")
    @Size(min = 1, max = 255, message = "El nombre de la clase debe tener entre 1 y 255 caracteres")
    private String name;    

    @NotBlank(message = "La descripción de la clase es requerida")
    @Size(min = 1, max = 255, message = "La descripción de la clase debe tener entre 1 y 255 caracteres")
    private String description;
    @NotNull(message = "debe especificar la actividad")
    private boolean active;






    
}
