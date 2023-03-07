package com.comercio.comercioEletronico.exceptions;

import com.comercio.comercioEletronico.exceptions.enuns.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalheErro {
    private String codigo;
    private String mensagem;
    private String detalhes;

    public DetalheErro(String codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public DetalheErro(ErrorEnum errorEnum) {
        this.codigo = errorEnum.getCodigoErro();
        this.mensagem = errorEnum.getNomeCodigo();
        this.detalhes = errorEnum.getMensagemErroDetalhada();
    }

    public DetalheErro(ErrorEnum errorEnum, String detalhes) {
        this.codigo = errorEnum.getCodigoErro();
        this.mensagem = errorEnum.getNomeCodigo();
        this.detalhes = detalhes;
    }

    public DetalheErro(ErrorEnum errorEnum, String detalhes, String erro) {
        this.codigo = errorEnum.getCodigoErro();
        this.mensagem = errorEnum.getNomeCodigo();
        this.detalhes = detalhes + " : " + erro;
    }
}
