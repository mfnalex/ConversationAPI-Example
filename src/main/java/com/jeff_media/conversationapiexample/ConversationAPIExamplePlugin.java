package com.jeff_media.conversationapiexample;

import org.bukkit.plugin.java.JavaPlugin;

public class ConversationAPIExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("createitem").setExecutor(new CreateItemCommand(this));
    }
}
