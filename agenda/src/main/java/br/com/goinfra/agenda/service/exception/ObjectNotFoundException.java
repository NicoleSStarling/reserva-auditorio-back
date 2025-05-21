package br.com.goinfra.agenda.service.exception;

public class ObjectNotFoundException extends RuntimeException{

    public static final long serialVersionUID = 1L;

    public ObjectNotFoundException (String msg){
        super(msg);
    }

    public ObjectNotFoundException (String msg, Throwable cause){
        super(msg,cause);
    }
}