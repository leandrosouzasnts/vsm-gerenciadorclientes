package com.vsmgerenciadorclientes.dtos;

import java.time.LocalDateTime;

public record ExceptionDTO(String message, String statusCode, LocalDateTime timeStamp) {
}
