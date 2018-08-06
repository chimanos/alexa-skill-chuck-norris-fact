package com.chimanos.chucknorris.fact;

import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.chimanos.chucknorris.fact.handlers.ExitSkillHandler;
import com.chimanos.chucknorris.fact.handlers.HelpIntentHandler;
import com.chimanos.chucknorris.fact.handlers.LaunchRequestHandler;
import com.chimanos.chucknorris.fact.handlers.NoAnswerIntentHandler;
import com.chimanos.chucknorris.fact.handlers.AnswerIntentHandler;
import com.chimanos.chucknorris.fact.handlers.QuizAndStartOverIntentHandler;
import com.chimanos.chucknorris.fact.handlers.RepeatIntentHandler;
import com.chimanos.chucknorris.fact.handlers.SessionEndedHandler;

public class QuizSkillStreamHandler extends SkillStreamHandler {

    public QuizSkillStreamHandler() {
        super(Skills.standard()
                .addRequestHandlers(new LaunchRequestHandler(), new QuizAndStartOverIntentHandler(), new NoAnswerIntentHandler(),
                             new AnswerIntentHandler(), new RepeatIntentHandler(), new HelpIntentHandler(),
                             new ExitSkillHandler(), new SessionEndedHandler())
                .build());
    }

}
