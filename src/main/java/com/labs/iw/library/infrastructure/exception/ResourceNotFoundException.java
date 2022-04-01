package com.labs.iw.library.infrastructure.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceNotFoundException extends RuntimeException implements GraphQLError {
	private Map<String, Object> extensions = new HashMap<>();

	public ResourceNotFoundException(String message, String invalidUuid) {
		super(message);
		extensions.put("invalidUuid", invalidUuid);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.DataFetchingException;
	}
}
