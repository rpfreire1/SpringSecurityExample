package com.gatinodev.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;

@JsonPropertyOrder
public record AuthLoginRequest(@NotBlank String username,@NotBlank String password ) {
}
