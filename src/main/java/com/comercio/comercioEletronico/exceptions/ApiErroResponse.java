package com.comercio.comercioEletronico.exceptions;

import com.comercio.comercioEletronico.exceptions.enuns.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiErroResponse {
    private List<DetalheErro> erros = new ArrayList<>();

    public ApiErroResponse(ErrorEnum errorEnum) {
        super();
        DetalheErro detalhe = new DetalheErro(errorEnum);
        this.erros.add(detalhe);
    }
}
