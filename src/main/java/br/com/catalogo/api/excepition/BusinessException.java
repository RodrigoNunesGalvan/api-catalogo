package br.com.catalogo.api.excepition;

public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BusinessException (String mensage) {
        super(mensage);
    }

    public BusinessException() {
        super();
    }

}