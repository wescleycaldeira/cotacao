package br.com.base.assertion;

import javax.ws.rs.core.Response.Status;

import br.com.base.exception.BusinessException;

public class AssertionUtil {
 
    public static void isTrue(Boolean condition, String message){
        if(condition) throw new BusinessException(message, Status.BAD_REQUEST);
    }

    public static void isTrue(Boolean condition, String message, Status status){
        if(condition) throw new BusinessException(message, status);
    }

    public static void isFalse(Boolean condition, String message){
        if(!condition) throw new BusinessException(message, Status.BAD_REQUEST);
    }

    public static void isFalse(Boolean condition, String message, Status status){
        if(!condition) throw new BusinessException(message, status);
    }
}