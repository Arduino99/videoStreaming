package com.example.replyglue.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * If the request body fails to satisfy any of the basic validation checks return HTTP Status code: 400
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid card details")
public class InvalidCardNumberException extends RuntimeException { }
