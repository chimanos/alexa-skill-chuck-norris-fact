package com.chimanos.chucknorris.fact.util;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.BodyTemplate3;
import com.amazon.ask.model.interfaces.display.RichText;
import com.amazon.ask.model.interfaces.display.Template;
import com.amazon.ask.model.interfaces.display.TextContent;
import com.chimanos.chucknorris.fact.model.Attributes;
import com.chimanos.chucknorris.fact.model.Constants;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

import static com.chimanos.chucknorris.fact.model.Constants.FACTS;

public class FactsUtils {

    private static final Random RANDOM = new Random();

    public static String getRandomFact(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        String fact = FACTS.get(RANDOM.nextInt(FACTS.size()-1));

        sessionAttributes.put(Attributes.FACT_ITEM_KEY, fact);

        return fact;
    }

    public static Optional<Response> makeMessage(String speech, String reprompt, String title, String primaryText, HandlerInput input, boolean shouldEndSession) {
        Template template = getBodyTemplate3(title, primaryText);

        if(input.getRequestEnvelope().getContext().getDisplay() != null) {
            if(reprompt != null) {
                return input.getResponseBuilder()
                        .withSpeech(speech)
                        .withSimpleCard(title, primaryText)
                        .addRenderTemplateDirective(template)
                        .withReprompt(reprompt)
                        .withShouldEndSession(shouldEndSession)
                        .build();
            } else {
                return input.getResponseBuilder()
                        .withSpeech(speech)
                        .withSimpleCard(title, primaryText)
                        .addRenderTemplateDirective(template)
                        .withShouldEndSession(shouldEndSession)
                        .build();
            }
        } else {
            if(reprompt != null) {
                return input.getResponseBuilder()
                        .withSpeech(speech)
                        .withSimpleCard(title, primaryText)
                        .withReprompt(reprompt)
                        .withShouldEndSession(shouldEndSession)
                        .build();
            } else {
                return input.getResponseBuilder()
                        .withSpeech(speech)
                        .withSimpleCard(title, primaryText)
                        .withShouldEndSession(shouldEndSession)
                        .build();
            }
        }
    }

    private static Template getBodyTemplate3(String title, String primaryText) {
        return BodyTemplate3.builder()
                .withTitle(title)
                .withTextContent(getTextContent(primaryText))
                .build();
    }

    private static TextContent getTextContent(String primaryText) {
        return TextContent.builder()
                .withPrimaryText(makeRichText(primaryText))
                .build();
    }

    private static RichText makeRichText(String text) {
        return RichText.builder()
                .withText(text)
                .build();
    }
}
