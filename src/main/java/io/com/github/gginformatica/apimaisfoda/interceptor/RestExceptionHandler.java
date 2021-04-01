package io.com.github.gginformatica.apimaisfoda.interceptor;

import io.com.github.gginformatica.apimaisfoda.domain.dto.ErrorResponse;
import io.com.github.gginformatica.apimaisfoda.exception.InternalServerErrorException;
import io.com.github.gginformatica.apimaisfoda.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFound(
            NotFoundException notFoundException,
            HttpServletRequest httpServletRequest
    ) {
        return getErrorResponse(
                httpServletRequest,
                NOT_FOUND,
                notFoundException.getMessage()
        );
    }

    @ResponseBody
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    public ErrorResponse handleInternalServerError(
            InternalServerErrorException internalServerErrorException,
            HttpServletRequest httpServletRequest
    ) {
        return getErrorResponse(
                httpServletRequest,
                INTERNAL_SERVER_ERROR,
                internalServerErrorException.getMessage()
        );
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleBadRequest(
            MethodArgumentNotValidException badRequestException,
            HttpServletRequest httpServletRequest
    ) {
        return getErrorResponse(
                httpServletRequest,
                BAD_REQUEST,
                "Payload com erro"
        );
    }

    private ErrorResponse getErrorResponse(
            HttpServletRequest httpServletRequest,
            HttpStatus httpStatus,
            String msgError) {
        return new ErrorResponse(
                LocalDateTime.now(),
                httpServletRequest.getServletPath(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                msgError
        );
    }
}
