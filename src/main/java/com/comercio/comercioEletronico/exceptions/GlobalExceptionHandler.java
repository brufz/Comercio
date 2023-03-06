package com.comercio.comercioEletronico.exceptions;

import com.comercio.comercioEletronico.exceptions.enuns.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(HttpMessageNotWritableException.class)
    protected ResponseEntity<Object> handleMessageNotWritableException(){
        ApiErroResponse apiErroResponse = new ApiErroResponse();
        String erro = "Formato JSON invalido";
        apiErroResponse.getErros().add(new DetalheErro(ErrorEnum.TEL_FAVORITOS_400));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
