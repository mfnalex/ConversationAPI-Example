package com.jeff_media.conversationapiexample.prompts;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.ValidatingPrompt;

import java.util.List;

public abstract class YesNoPrompt extends ValidatingPrompt {

    private static final List<String> ANSWERS_YES = List.of("yes", "y", "yeah", "yep", "sure");
    private static final List<String> ANSWERS_NO = List.of("no", "n", "nope", "nah", "nay");

    @Override
    protected boolean isInputValid(ConversationContext conversationContext, String input) {
        return isYes(input) || isNo(input);
    }

    @Override
    protected String getFailedValidationText(ConversationContext context, String invalidInput) {
        return "You have answered '" + invalidInput + "' to a simple yes/no question - what's that even supposed to mean? Just answer with 'yes' or 'no'!";
    }

    public boolean isYes(String input) {
        return ANSWERS_YES.contains(input.toLowerCase());
    }

    public boolean isNo(String input) {
        return ANSWERS_NO.contains(input.toLowerCase());
    }
}
