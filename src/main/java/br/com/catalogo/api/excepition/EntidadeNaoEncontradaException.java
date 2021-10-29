package br.com.catalogo.api.excepition;

public abstract class EntidadeNaoEncontradaException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
