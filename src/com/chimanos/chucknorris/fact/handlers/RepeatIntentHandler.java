package com.chimanos.chucknorris.fact.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.chimanos.chucknorris.fact.model.Attributes;
import com.chimanos.chucknorris.fact.model.Constants;
import com.chimanos.chucknorris.fact.util.FactsUtils;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

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
            return FactsUtils.makeMessage(Constants.REPROMPT_MESSAGE, Constants.REPROMPT_MESSAGE, "J'ai dit", Constants.REPROMPT_MESSAGE, input, false);
        } else {
            return FactsUtils.makeMessage(fact, fact, "J'ai dit", fact, input, false);
        }
    }

}
