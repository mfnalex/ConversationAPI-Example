package com.jeff_media.conversationapiexample.prompts;

import org.bukkit.Material;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class EnterNamePrompt extends StringPrompt {
    @Override
    public String getPromptText(ConversationContext conversationContext) {
        Material materialChosen = (Material) conversationContext.getSessionData("material");
        Objects.requireNonNull(materialChosen, "Material should not be null at this point!");
        return "Ok, so how do you want to name your " + materialChosen.name().toLowerCase() + "?";
    }

    @Override
    public Prompt acceptInput(ConversationContext conversationContext, String s) {
        ItemStack item = new ItemStack((Material) conversationContext.getSessionData("material"));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(s);
        item.setItemMeta(meta);
        ((Player)conversationContext.getForWhom()).getInventory().addItem(item);
        ((Player) conversationContext.getForWhom()).sendMessage("Here you go!");
        return Prompt.END_OF_CONVERSATION;
    }
}
