package com.jeff_media.conversationapiexample.prompts;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

public class AreYouSureYouWantToCreateAnItemPrompt extends YesNoPrompt {
    @Override
    protected Prompt acceptValidatedInput(ConversationContext conversationContext, String input) {
        if(isNo(input)) {
            return Prompt.END_OF_CONVERSATION;
        } else if(isYes(input)) {
            return new WhichItemPrompt();
        } else {
            throw new IllegalStateException("The answer is neither yes or no - this should not happen because we already validated the input!");
        }
    }

    @Override
    public String getPromptText(ConversationContext conversationContext) {
        return "I see you've entered /createitem - are you sure you want to create a custom item now?";
    }
}
