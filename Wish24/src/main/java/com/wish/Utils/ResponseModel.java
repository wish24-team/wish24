package com.wish.Utils;
/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
public class ResponseModel implements Response {

	private Integer Status;
	private String Message;
	private Object object;
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return Status;
	}
	/**
	 * @param status the status to set
	 */
	public ResponseModel setStatus(Integer status) {
		Status = status;
		return this;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return Message;
	}
	/**
	 * @param message the message to set
	 */
	public ResponseModel setMessage(String message) {
		Message = message;
		return this;
	}
	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public ResponseModel setObject(Object object) {
		this.object = object;
		return this;
	}
	@Override
	public String toString() {
		return "ResponseEntity [Status=" + Status + ", Message=" + Message + ", object=" + object + "]";
	}
	
	
}
