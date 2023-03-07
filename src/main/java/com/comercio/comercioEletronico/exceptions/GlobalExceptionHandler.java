package com.comercio.comercioEletronico.exceptions;

import com.comercio.comercioEletronico.exceptions.enuns.ErrorEnum;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.MalformedURLException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String erro = "Formato JSON invalido";
        ApiErroResponse apiErro = new ApiErroResponse();
        apiErro.getErros().add(new DetalheErro(ErrorEnum.COMERCIO_400, ErrorEnum.COMERCIO_400.getMensagemErroDetalhada(), erro));
        return respostaErro(apiErro, ErrorEnum.COMERCIO_400.getCodigoRetorno());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String erro = "Erro ao realizar saida de JSON";
        ApiErroResponse apiErroResponse = new ApiErroResponse();
        apiErroResponse.getErros().add(new DetalheErro(ErrorEnum.TEL_FAVORITOS_500, ErrorEnum.TEL_FAVORITOS_500.getMensagemErroDetalhada(), erro));
        return respostaErro(apiErroResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IdInvalidoException.class)
    protected ResponseEntity<Object> handleIdInvalidoException(){
        String erro = "Id não encontrado";
        ApiErroResponse apiErroResponse = new ApiErroResponse();
        apiErroResponse.getErros().add(new DetalheErro(ErrorEnum.COMERCIO_404, ErrorEnum.COMERCIO_404.getMensagemErroDetalhada(), erro));
        return respostaErro(apiErroResponse, ErrorEnum.COMERCIO_404.getCodigoRetorno());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected  ResponseEntity<Object> handleNumberFormatException(ConstraintViolationException exception){
        String erro = "Erro de validação " + exception.getMessage();
        ApiErroResponse apiErroResponse = new ApiErroResponse();
        apiErroResponse.getErros().add(new DetalheErro(ErrorEnum.COMERCIO_400, ErrorEnum.COMERCIO_400.getMensagemErroDetalhada(), erro));
        return respostaErro(apiErroResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MalformedURLException.class)
    protected ResponseEntity<Object> handleMalformedURLException(MalformedURLException exception){
        ApiErroResponse apiErroResponse = new ApiErroResponse(ErrorEnum.COMERCIO_400);
        return respostaErro(apiErroResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(ChangeSetPersister.NotFoundException exception){
        ApiErroResponse apiErroResponse = new ApiErroResponse(ErrorEnum.COMERCIO_404);
        return respostaErro(apiErroResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String erro = "MediaType não suportada";
        ApiErroResponse apiErroResponse = new ApiErroResponse();
        apiErroResponse.getErros().add(new DetalheErro(ErrorEnum.COMERCIO_400, ErrorEnum.COMERCIO_400.getMensagemErroDetalhada(), erro));
        return respostaErro(apiErroResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        ApiErroResponse apiErroResponse = new ApiErroResponse();
        String erro = "Ocorreu um erro interno no servidor: " + ex.getMessage();
        apiErroResponse.getErros().add(new DetalheErro(ErrorEnum.TEL_FAVORITOS_500, ErrorEnum.TEL_FAVORITOS_500.getMensagemErroDetalhada(), erro));
        return respostaErro(apiErroResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<Object> respostaErro(ApiErroResponse apiErroResponse, HttpStatus httpStatus){
        return new ResponseEntity<>(apiErroResponse, httpStatus);
    }
}
