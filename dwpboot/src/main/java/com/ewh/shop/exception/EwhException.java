package com.ewh.shop.exception;

public class EwhException extends Exception{
private static final long serialVersionUID=1L;
private String errorMessage;
private String DEFAULT_ERR_MSG="Something went wrong";
public EwhException(String errorMessage) {
	super(errorMessage);
	this.errorMessage=errorMessage;
}

public EwhException() {
	new EwhException(DEFAULT_ERR_MSG);
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}



}
