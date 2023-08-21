package com.jeff_media.conversationapiexample;

import com.jeff_media.conversationapiexample.prompts.AreYouSureYouWantToCreateAnItemPrompt;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.conversations.ConversationFactory;
import org.bukkit.entity.Player;

public class CreateItemCommand implements CommandExecutor {

    private final ConversationAPIExamplePlugin plugin;

    public CreateItemCommand(ConversationAPIExamplePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String commandLabel, String[] arguments) {
        if(!(commandSender instanceof Player player)) {
            commandSender.sendMessage("Only players can use this command.");
            return true;
        }

        if(arguments.length > 0) {
            player.sendMessage(ChatColor.RED + "No, you're not supposed to enter any args - the whole idea of this plugin is to demonstrate how to get chat input through conversations!");
            return true;
        }

        new ConversationFactory(plugin)
                .withFirstPrompt(new AreYouSureYouWantToCreateAnItemPrompt())
                .buildConversation(player).begin();

        return true;

    }
}
