package com.chimanos.chucknorris.fact.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.BodyTemplate3;
import com.amazon.ask.model.interfaces.display.RichText;
import com.amazon.ask.model.interfaces.display.Template;
import com.amazon.ask.model.interfaces.display.TextContent;
import com.chimanos.chucknorris.fact.model.Attributes;
import com.chimanos.chucknorris.fact.model.Constants;
import com.chimanos.chucknorris.fact.util.FactsUtils;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.requestType;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class FactIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("FactIntent").or(intentName("AMAZON.YesIntent")).and(sessionAttribute(Attributes.FACT_KEY, Attributes.START_FACT)));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.put(Attributes.FACT_KEY, Attributes.START_FACT);

        String fact = FactsUtils.getRandomFact(input);

        return FactsUtils.makeMessage(fact, Constants.REPROMPT_MESSAGE, "Fact", fact, input, false);
    }
}
