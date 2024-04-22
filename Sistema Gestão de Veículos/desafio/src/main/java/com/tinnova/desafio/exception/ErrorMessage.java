package com.tinnova.desafio.exception;

import lombok.*;

import java.time.OffsetDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage {

    private String path;

    private String method;

    private int status;

    private String message;

    private OffsetDateTime timestamp;

    private String statusDescription;

}
