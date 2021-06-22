package com.breadloaf;


import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PluginMessageEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.messages.ChannelIdentifier;
import com.velocitypowered.api.proxy.messages.MinecraftChannelIdentifier;
import org.slf4j.Logger;

@Plugin(id = "voicechat-shim", name = "VoiceChat SHIM", version = "1.0-SNAPSHOT",
        description = "Shim for VoiceChat", authors = {"BreadLoaf"})
public class voicechatshim {
    private final ProxyServer server;
    public static String MODID = "voicechat";
    public static final MinecraftChannelIdentifier INIT = MinecraftChannelIdentifier.create(MODID,"init");
    public static final MinecraftChannelIdentifier SECRET = MinecraftChannelIdentifier.create(MODID,"secret");
    public static final MinecraftChannelIdentifier PLAYER_STATE = MinecraftChannelIdentifier.create(MODID,"player_state");
    public static final MinecraftChannelIdentifier PLAYER_STATES = MinecraftChannelIdentifier.create(MODID,"player_states");
    public static final MinecraftChannelIdentifier SET_GROUP = MinecraftChannelIdentifier.create(MODID,"set_group");
    @Inject
    public voicechatshim(ProxyServer server, Logger logger) {
        this.server = server;
    }
    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getChannelRegistrar().register(INIT);
        server.getChannelRegistrar().register(SECRET);
        server.getChannelRegistrar().register(PLAYER_STATE);
        server.getChannelRegistrar().register(PLAYER_STATES);
        server.getChannelRegistrar().register(SET_GROUP);
    }
    @Subscribe
    public void onPluginMessage(PluginMessageEvent event) { }
}
