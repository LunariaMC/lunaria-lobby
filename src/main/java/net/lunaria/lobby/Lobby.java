package net.lunaria.lobby;

import lombok.Getter;
import net.lunaria.api.plugins.bukkit.BukkitAPI;
import net.lunaria.api.plugins.bukkit.command.CommandRegister;
import net.lunaria.api.plugins.bukkit.listener.ListenerRegister;
import net.lunaria.lobby.listener.CancelledEvents;
import net.lunaria.lobby.listener.ItemsClickEvent;
import net.lunaria.lobby.listener.JoinEvent;
import net.lunaria.lobby.listener.QuitEvent;
import net.lunaria.lobby.scoreboard.Scoreboard;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Lobby extends JavaPlugin {
    private static Lobby instance;

    private @Getter Scoreboard scoreboard;

    @Override
    public void onEnable() {
        instance = this;

        ListenerRegister.registerListeners( this,
                new JoinEvent(), new QuitEvent(), new CancelledEvents(), new ItemsClickEvent()
        );

        CommandRegister.registerCommands(this,
                new CmdTest("cmd", 7, false, true, "cmdst"));
        //RedisListenersRegister.registerListeners();

        (this.scoreboard = new Scoreboard()).updateAllTime();
    }

    public static Lobby getInstance() {
        return instance;
    }

    public static String getLobbyNumber() {
        String serverName = BukkitAPI.getServerName();

        serverName = serverName.replace(".", "");
        serverName = serverName.replaceAll("[^\\\\d.]", "");

        return  serverName;
    }
}
