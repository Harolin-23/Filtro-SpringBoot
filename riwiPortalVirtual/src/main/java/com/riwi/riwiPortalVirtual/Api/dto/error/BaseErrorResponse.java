package com.riwi.riwiPortalVirtual.Api.dto.error;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseErrorResponse implements Serializable{
    private String status;
    private Integer code;
}
