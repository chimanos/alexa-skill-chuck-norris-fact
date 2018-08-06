package com.chimanos.chucknorris.fact.util;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.chimanos.chucknorris.fact.model.Attributes;

import java.util.Map;
import java.util.Random;

import static com.chimanos.chucknorris.fact.model.Constants.FACTS;

public class FactsUtils {

    private static final Random RANDOM = new Random();

    public static String getRandomFact(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        String fact = FACTS.get(RANDOM.nextInt(FACTS.size()));

        sessionAttributes.put(Attributes.FACT_ITEM_KEY, fact);

        return fact;
    }
}
