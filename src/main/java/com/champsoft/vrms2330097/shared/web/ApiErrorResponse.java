package com.champsoft.vrms2330097.shared.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private final Instant timestamp;

    private final int status;
    private final String error;
    private final String message;
    private final String path;

    // Only populated for validation errors (field-level detail)
    private final List<FieldError> fieldErrors;

    // ── Constructor matching VehicleExceptionHandler usage ───────────────────
    // new ApiErrorResponse(Instant.now(), status, reasonPhrase, message, path)
    public ApiErrorResponse(Instant timestamp, int status, String error,
                            String message, String path) {
        this(timestamp, status, error, message, path, null);
    }

    // ── Full constructor (used for validation errors) ────────────────────────
    public ApiErrorResponse(Instant timestamp, int status, String error,
                            String message, String path, List<FieldError> fieldErrors) {
        this.timestamp   = timestamp;
        this.status      = status;
        this.error       = error;
        this.message     = message;
        this.path        = path;
        this.fieldErrors = fieldErrors;
    }

    // ── Getters ──────────────────────────────────────────────────────────────
    public Instant           getTimestamp()   { return timestamp;   }
    public int               getStatus()      { return status;      }
    public String            getError()       { return error;       }
    public String            getMessage()     { return message;     }
    public String            getPath()        { return path;        }
    public List<FieldError>  getFieldErrors() { return fieldErrors; }

    // ── Nested record for per-field validation detail ────────────────────────
    public record FieldError(String field, String rejectedValue, String reason) {}
}