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
public class studentRequest {
    
    @NotBlank(message = "El nombre del studiante es requerido")
    @Size(min = 1, max = 255, message = "El nombre del studiante debe tener entre 1 y 255 caracteres")
    private String name;
    @NotBlank(message = "El email del studiante es requerido")
    @Size(min = 1, max = 255, message = "El email del studiante debe tener entre 1 y 255 caracteres")
    private String email;
    @NotNull(message = "debe especificar la actividad")
    private boolean active;
    @NotNull(message = "debe especificar la clase")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private long  id_class;



}
