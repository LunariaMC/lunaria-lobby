package net.lunaria.lobby.listener;

import net.lunaria.api.plugins.bukkit.player.BukkitPlayer;
import net.lunaria.lobby.Lobby;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage("");

        BukkitPlayer bukkitPlayer = BukkitPlayer.fromPlayer(event.getPlayer());

        Lobby.getInstance().getScoreboard().leave(bukkitPlayer);
    }
}
