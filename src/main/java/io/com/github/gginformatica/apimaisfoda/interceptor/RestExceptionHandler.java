package io.com.github.gginformatica.apimaisfoda.interceptor;

import io.com.github.gginformatica.apimaisfoda.domain.ErrorResponse;
import io.com.github.gginformatica.apimaisfoda.exception.BadRequestException;
import io.com.github.gginformatica.apimaisfoda.exception.InternalServerErrorException;
import io.com.github.gginformatica.apimaisfoda.exception.NotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

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
        return new ErrorResponse(
                LocalDateTime.now(),
                httpServletRequest.getServletPath(),
                NOT_FOUND.value(),
                NOT_FOUND.getReasonPhrase(),
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
        return new ErrorResponse(
                LocalDateTime.now(),
                httpServletRequest.getServletPath(),
                INTERNAL_SERVER_ERROR.value(),
                INTERNAL_SERVER_ERROR.getReasonPhrase(),
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
        return new ErrorResponse(
                LocalDateTime.now(),
                httpServletRequest.getServletPath(),
                BAD_REQUEST.value(),
                BAD_REQUEST.getReasonPhrase(),
                "Payload with error"
        );
    }
}
