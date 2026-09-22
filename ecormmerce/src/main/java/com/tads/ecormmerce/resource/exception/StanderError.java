package com.tads.ecormmerce.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class StanderError {
    private Instant timestamp;
    private String message;
    public Integer status;
    public String error;
    public String path;

}
