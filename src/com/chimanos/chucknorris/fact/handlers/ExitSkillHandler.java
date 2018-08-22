package com.chimanos.chucknorris.fact.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.chimanos.chucknorris.fact.model.Constants;
import com.chimanos.chucknorris.fact.util.FactsUtils;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class ExitSkillHandler implements RequestHandler {

    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.StopIntent")
                .or(intentName("AMAZON.PauseIntent")
                .or(intentName("AMAZON.CancelIntent")
                .or(intentName("AMAZON.NoIntent")))));
    }

    public Optional<Response> handle(HandlerInput input) {
        return FactsUtils.makeMessage(Constants.EXIT_SKILL_MESSAGE, null, "Au revoir", Constants.EXIT_SKILL_MESSAGE, input, true);
    }

}
