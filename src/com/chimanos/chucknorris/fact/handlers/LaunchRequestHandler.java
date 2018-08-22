package com.chimanos.chucknorris.fact.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.chimanos.chucknorris.fact.model.Attributes;
import com.chimanos.chucknorris.fact.model.Constants;
import com.chimanos.chucknorris.fact.util.FactsUtils;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.put(Attributes.FACT_KEY, Attributes.START_FACT);
        return FactsUtils.makeMessage(Constants.WELCOME_MESSAGE, Constants.HELP_MESSAGE, "Bonjour", Constants.WELCOME_MESSAGE_SMALL, input, false);
    }

}
