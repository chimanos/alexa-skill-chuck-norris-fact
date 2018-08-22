package com.chimanos.chucknorris.fact.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.chimanos.chucknorris.fact.model.Constants;
import com.chimanos.chucknorris.fact.util.FactsUtils;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return FactsUtils.makeMessage(Constants.HELP_MESSAGE, Constants.HELP_MESSAGE, "Aide", Constants.HELP_MESSAGE_SMALL, input, false);
    }

}
