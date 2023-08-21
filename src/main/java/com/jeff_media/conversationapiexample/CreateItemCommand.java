package com.jeff_media.conversationapiexample;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RenameItemCommand implements CommandExecutor {
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


    }
}
