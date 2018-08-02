package com.chimanos.videogame.quiz;

import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.chimanos.videogame.quiz.handlers.ExitSkillHandler;
import com.chimanos.videogame.quiz.handlers.HelpIntentHandler;
import com.chimanos.videogame.quiz.handlers.LaunchRequestHandler;
import com.chimanos.videogame.quiz.handlers.NoAnswerIntentHandler;
import com.chimanos.videogame.quiz.handlers.AnswerIntentHandler;
import com.chimanos.videogame.quiz.handlers.QuizAndStartOverIntentHandler;
import com.chimanos.videogame.quiz.handlers.RepeatIntentHandler;
import com.chimanos.videogame.quiz.handlers.SessionEndedHandler;

public class QuizSkillStreamHandler extends SkillStreamHandler {

    public QuizSkillStreamHandler() {
        super(Skills.standard()
                .addRequestHandlers(new LaunchRequestHandler(), new QuizAndStartOverIntentHandler(), new NoAnswerIntentHandler(),
                             new AnswerIntentHandler(), new RepeatIntentHandler(), new HelpIntentHandler(),
                             new ExitSkillHandler(), new SessionEndedHandler())
                .build());
    }

}
