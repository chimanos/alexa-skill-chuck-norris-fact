# Alexa Skill Chuck Norris Facts
This is a sample quiz skill about Chuck Noris facts in java for Amazon echo.
This project is based on the sample project of Amazon: [Here](https://github.com/alexa/skill-sample-java-quiz-game)

Warning: All of the text in this project is in French.

## Step 1
Follow the official Amazon Step by Step tutorial for start the project on your Amazon account.

Official link: [Here](https://github.com/alexa/skill-sample-java-quiz-game/blob/master/instructions/1-voice-user-interface.md)

For the step with the JSON config file you can use the [Interaction model here](https://github.com/chimanos/alexa-skill-chuck-norris-fact/blob/master/models/fr-FR.json)

## Step 2

For send the code too the lambda function in Amazon WS you can clone and build the project here.

Use this command line for build the project.

```
mvn assembly:assembly -DdescriptorId=jar-with-dependencies package
```

After a successfull build, you can fin the name-jar-with-dependencies.jar in the target folder.

## Other steps

For the other steps you have just to follow the Step by Step tutorial of Amazon.

Have fun !
