package com.jeff_media.conversationapiexample.prompts;

import org.bukkit.Material;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.FixedSetPrompt;
import org.bukkit.conversations.Prompt;

import java.util.Arrays;

public class WhichItemPrompt extends FixedSetPrompt {

    public WhichItemPrompt() {
        super(Arrays.stream(Material.values()).filter(Material::isItem).map(mat -> mat.name().toLowerCase()).toArray(String[]::new));
    }

    @Override
    protected Prompt acceptValidatedInput(ConversationContext conversationContext, String input) {
        conversationContext.setSessionData("material", Material.valueOf(input.toUpperCase()));
        return new EnterNamePrompt();
    }

    @Override
    protected String getFailedValidationText(ConversationContext context, String invalidInput) {
        return "There is no item called '" + invalidInput + "' - please enter a valid item name.";
    }

    @Override
    public String getPromptText(ConversationContext conversationContext) {
        return "Which item do you want to create? Enter a valid item name (in lower case, e.g. diamond_shovel).";
    }




}
