package io.com.github.gginformatica.apimaisfoda.interceptor;

import io.com.github.gginformatica.apimaisfoda.domain.ErrorResponse;
import io.com.github.gginformatica.apimaisfoda.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFound(NotFoundException notFoundException, HttpServletRequest httpServletRequest) {
        return new ErrorResponse(
                LocalDateTime.now(),
                httpServletRequest.getServletPath(),
                NOT_FOUND.value(),
                NOT_FOUND.getReasonPhrase(),
                notFoundException.getMessage()
        );
    }
}
