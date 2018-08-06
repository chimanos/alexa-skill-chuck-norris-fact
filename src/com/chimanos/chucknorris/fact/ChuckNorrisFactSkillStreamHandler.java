package com.chimanos.chucknorris.fact;

import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.chimanos.chucknorris.fact.handlers.ExitSkillHandler;
import com.chimanos.chucknorris.fact.handlers.HelpIntentHandler;
import com.chimanos.chucknorris.fact.handlers.LaunchRequestHandler;
import com.chimanos.chucknorris.fact.handlers.FactIntentHandler;
import com.chimanos.chucknorris.fact.handlers.RepeatIntentHandler;
import com.chimanos.chucknorris.fact.handlers.SessionEndedHandler;

public class ChuckNorrisFactSkillStreamHandler extends SkillStreamHandler {

    public ChuckNorrisFactSkillStreamHandler() {
        super(Skills.standard()
                .addRequestHandlers(new LaunchRequestHandler(), new FactIntentHandler(),
                             new RepeatIntentHandler(), new HelpIntentHandler(),
                             new ExitSkillHandler(), new SessionEndedHandler())
                .build());
    }

}
