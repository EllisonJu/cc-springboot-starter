package com.cc.exception;

import javax.servlet.http.HttpServletRequest;

import com.cc.pojo.CcJSONResult;

//@RestControllerAdvice
public class CcAjaxExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
	public CcJSONResult defaultErrorHandler(HttpServletRequest req, 
			Exception e) throws Exception {

		e.printStackTrace();
		return CcJSONResult.errorException(e.getMessage());
	}
}
