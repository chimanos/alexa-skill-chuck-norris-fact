package com.chimanos.chucknorris.fact.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.chimanos.chucknorris.fact.model.Attributes;
import com.chimanos.chucknorris.fact.model.Constants;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class RepeatIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.RepeatIntent").and(sessionAttribute(Attributes.FACT_KEY, Attributes.START_FACT)));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        String fact = (String) sessionAttributes.get(Attributes.FACT_ITEM_KEY);

        if(fact == null || fact.equals("")) {
            return input.getResponseBuilder()
                    .withSpeech(Constants.REPROMPT_MESSAGE)
                    .withReprompt(Constants.REPROMPT_MESSAGE)
                    .withShouldEndSession(false)
                    .build();
        } else {
            return input.getResponseBuilder()
                    .withSpeech(fact)
                    .withReprompt(fact)
                    .withShouldEndSession(false)
                    .build();
        }
    }

}
