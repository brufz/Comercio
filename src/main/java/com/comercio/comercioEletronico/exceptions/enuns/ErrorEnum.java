package com.comercio.comercioEletronico.exceptions.enuns;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

@Getter
public enum ErrorEnum {

    COMERCIO_400(BAD_REQUEST, BAD_REQUEST.name(), "400", "Requisição Invalida"),
    COMERCIO_404(NOT_FOUND, NOT_FOUND.name(), "404", "O recurso solicitado não existe ou não foi implementado"),
    TEL_FAVORITOS_400_001(BAD_REQUEST, BAD_REQUEST.name(), "400001", "Campo não informado"),
    TEL_FAVORITOS_400_002(BAD_REQUEST, BAD_REQUEST.name(), "400002", "Campo precisa ser maior que X e menor que Y"),
    TEL_FAVORITOS_400_INVALID_UUID(BAD_REQUEST, BAD_REQUEST.name(), "400003", "Valor do campo não é um UUID válido"),
    TEL_FAVORITOS_415(UNSUPPORTED_MEDIA_TYPE, UNSUPPORTED_MEDIA_TYPE.name(), "415", "Servidor não suporta tipo de mídia"),
    COMERCIO_422(UNPROCESSABLE_ENTITY, UNPROCESSABLE_ENTITY.name(), "422", "Não foi possível processar a solicitação."),
    COMERCIO_500(INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR.name(), "500", "Erro inesperado"),
    TEL_FAVORITOS_503(SERVICE_UNAVAILABLE, SERVICE_UNAVAILABLE.name(), "503", "Serviço indisponível");

    private final HttpStatus codigoRetorno;

    private final String nomeCodigo;

    private final String codigoErro;

    private final String mensagemErroDetalhada;

    ErrorEnum(HttpStatus codigoRetorno, String nomeCodigo, String codigoErro, String mensagemErroDetalhada) {
        this.codigoRetorno = codigoRetorno;
        this.nomeCodigo = nomeCodigo;
        this.codigoErro = codigoErro;
        this.mensagemErroDetalhada = mensagemErroDetalhada;
    }
}
