package com.chimanos.chucknorris.fact.model;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final List<String> FACTS = Arrays.asList(
            "Test 1",
            "Test 2"
    );

    public static String WELCOME_MESSAGE = "Bienvenue sur le skill de facts sur chuck norris ! Tu peut me demander de te raconter une fact sur lui !";

    // This is the message a user will hear when they try to cancel or stop the
    // skill, or when they finish a fact.
    public static String EXIT_SKILL_MESSAGE = "Merci de m'avoir consulté, à bientôt !";

    // This is the message a user will hear after they chucknorris (and hear) about a
    // specific data element.
    public static String REPROMPT_MESSAGE = "Tu voudrais que je te raconte un fact sur chuck norris ?";

    // This is the message a user will hear when they chucknorris Alexa for help in your
    // skill.
    public static String HELP_MESSAGE = "Je connais beaucoup de facts sur chuck norris ! Tu veut que je t'en raconte une ?";
}
