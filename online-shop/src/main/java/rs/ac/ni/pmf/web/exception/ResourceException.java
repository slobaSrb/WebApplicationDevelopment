package rs.ac.ni.pmf.web.exception;

import lombok.Getter;
import rs.ac.ni.pmf.web.exception.ErrorInfo.ResourceType;

@Getter
public class ResourceException extends Exception {
	private static final long serialVersionUID = 1L;

	private final ErrorInfo.ResourceType resourceType;

	public ResourceException(final ResourceType resourceType, final String message) {
		super(message);
		this.resourceType = resourceType;
	}
}
