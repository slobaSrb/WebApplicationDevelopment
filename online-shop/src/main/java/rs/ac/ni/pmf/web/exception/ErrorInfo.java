package rs.ac.ni.pmf.web.exception;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorInfo {
	private ErrorCode errorCode;
	private ResourceType resourceType;

	private String message;
	
	private StackTraceElement[] stackTrace;

	public enum ErrorCode {
		AUTHENTICATION_FAILED,
		UNAUTORIZED,
		NOT_FOUND,
		DUPLICATE
	}

	public enum ResourceType {
		ACCESS,
		AD,
		COMMENT,
		PURCHASE,
		USER,
		ROLE
	}
}