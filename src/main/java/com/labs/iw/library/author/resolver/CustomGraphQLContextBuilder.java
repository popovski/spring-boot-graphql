package com.labs.iw.library.author.resolver;

import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.DefaultGraphQLWebSocketContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomGraphQLContextBuilder implements GraphQLServletContextBuilder {
	@Autowired
	private DataLoaderRegistryFactory dataLoaderRegistryFactory;

	@Override
	public GraphQLContext build(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		DefaultGraphQLServletContext context = DefaultGraphQLServletContext.createServletContext()
				.with(httpServletRequest).with(httpServletResponse).with(dataLoaderRegistryFactory.newDataLoaderRegistry()).build();

		return new CustomGraphQLContext(context);

	}

	@Override
	public GraphQLContext build() {
		throw new IllegalStateException("Unsupported");
	}

	@Override
	public GraphQLContext build(Session session, HandshakeRequest handshakeRequest) {
		throw new IllegalStateException("Unsupported");
	}

}
