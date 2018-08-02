package com.chimanos.spacequiz.quiz;

import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.chimanos.spacequiz.quiz.handlers.ExitSkillHandler;
import com.chimanos.spacequiz.quiz.handlers.HelpIntentHandler;
import com.chimanos.spacequiz.quiz.handlers.LaunchRequestHandler;
import com.chimanos.spacequiz.quiz.handlers.NoAnswerIntentHandler;
import com.chimanos.spacequiz.quiz.handlers.AnswerIntentHandler;
import com.chimanos.spacequiz.quiz.handlers.QuizAndStartOverIntentHandler;
import com.chimanos.spacequiz.quiz.handlers.RepeatIntentHandler;
import com.chimanos.spacequiz.quiz.handlers.SessionEndedHandler;

public class QuizSkillStreamHandler extends SkillStreamHandler {

    public QuizSkillStreamHandler() {
        super(Skills.standard()
                .addRequestHandlers(new LaunchRequestHandler(), new QuizAndStartOverIntentHandler(), new NoAnswerIntentHandler(),
                             new AnswerIntentHandler(), new RepeatIntentHandler(), new HelpIntentHandler(),
                             new ExitSkillHandler(), new SessionEndedHandler())
                .build());
    }

}
