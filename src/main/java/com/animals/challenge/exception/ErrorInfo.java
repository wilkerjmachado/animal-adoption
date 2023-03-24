package com.animals.challenge.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorInfo {

    private String url;

    private String message;

    private Map<String, String> errors;

    private int errorCode;

    private Throwable ex;
}
