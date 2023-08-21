package com.jeff_media.conversationapiexample.prompts;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.ValidatingPrompt;

import java.util.List;

public class StartPrompt extends ValidatingPrompt {

    private static final List<String> ANSWERS_YES = List.of("yes", "y", "yeah", "yep", "sure");
    private static final List<String> ANSWERS_NO = List.of("no", "n", "nope", "nah", "nay");

    @Override
    protected boolean isInputValid(ConversationContext conversationContext, String input) {
        return ANSWERS_YES.contains(input.toLowerCase())
                || ANSWERS_NO.contains(input.toLowerCase());
    }

    @Override
    protected Prompt acceptValidatedInput(ConversationContext conversationContext, String s) {
        return null;
    }

    @Override
    public String getPromptText(ConversationContext conversationContext) {
        return "Do you want to create a custom item? Answer in chat!";
    }

    @Override
    protected String getFailedValidationText(ConversationContext context, String invalidInput) {
        return "You have answered '" + invalidInput + "' to a simple yes/no question - what's that even supposed to mean? Just answer with 'yes' or 'no'!";
    }
}
