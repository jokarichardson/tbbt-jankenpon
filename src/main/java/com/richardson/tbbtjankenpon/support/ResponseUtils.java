package com.richardson.tbbtjankenpon.support;

import java.util.Date;

import com.richardson.tbbtjankenpon.model.response.ErrorResponseMessage;

public class ResponseUtils {
    public static ErrorResponseMessage criaResponseMessage(Integer status, String error, String message, String exceptionClass, String mapping) {
    	
    	ErrorResponseMessage responseMessage = new ErrorResponseMessage();
    	responseMessage.setTimestamp(new Date(System.currentTimeMillis()));
    	responseMessage.setStatus(status);
    	responseMessage.setError(error);
    	responseMessage.setException(exceptionClass);
    	responseMessage.setMessage(message);
    	responseMessage.setPath(mapping);
    	
        return responseMessage;
    }
}
