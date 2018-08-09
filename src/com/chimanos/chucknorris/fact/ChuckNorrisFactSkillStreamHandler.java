package com.chimanos.chucknorris.fact;

import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.chimanos.chucknorris.fact.handlers.*;

public class ChuckNorrisFactSkillStreamHandler extends SkillStreamHandler {

    public ChuckNorrisFactSkillStreamHandler() {
        super(Skills.standard()
                .addRequestHandlers(new LaunchRequestHandler(), new FactIntentHandler(),
                             new RepeatIntentHandler(), new HelpIntentHandler(),
                             new ExitSkillHandler(), new SessionEndedHandler(), new YesIntentHandler())
                .build());
    }

}
