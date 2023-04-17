package net.lunaria.lobby.listener;

import net.lunaria.api.core.enums.Prefix;
import net.lunaria.api.plugins.bukkit.player.BukkitPlayer;
import net.lunaria.api.plugins.bukkit.utils.ItemBuilder;
import net.lunaria.api.plugins.bukkit.utils.nametag.NametagManager;
import net.lunaria.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        BukkitPlayer bukkitPlayer = BukkitPlayer.fromPlayer(player);

        if (bukkitPlayer.getSubscription().isSubscribed()) {
            event.setJoinMessage("§6§l ❘ " + bukkitPlayer.getPrefix() + player.getName() + " §f" + bukkitPlayer.getSubscription().getJoinMessage());
        } else if (bukkitPlayer.getPowerMod() != 0) {
            event.setJoinMessage("§6§l ❘ " + bukkitPlayer.getPrefix() + player.getName() + " §fa rejoint le lobby !");
        } else {
            event.setJoinMessage("");
        }


        player.teleport(new Location(Bukkit.getWorld("world"), 44.5, 77, 58.5, 0f, 0f));
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);

        for (int i = 0; i <= 300; i++) player.sendMessage(" ");
        welcomeMessage(player);
        giveItems(player);

        Lobby.getInstance().getScoreboard().join(bukkitPlayer);
        NametagManager.setNameTag();
    }

    private void welcomeMessage(Player player) {
        player.sendMessage(" \n" +
                        Prefix.LUNARIA.getPrefix() + "Bienvenue sur le serveur\n \n" +
                        "§3§l ❘ §fPour obtenir de l'aide faites §d/help§f.\n" +
                        "§3§l ❘ §fPour jouer utilisez le §eMenu Principal§f.\n" +
                        "§3§l ❘ §fPour signaler un joueur exécutez §c/report§f.\n \n" +
                        "§fVous avez §a0 ami(s) §fen ligne."
                );
    }
    private void giveItems(Player player) {
        player.getInventory().setItem(4,
                new ItemBuilder(Material.COMPASS).setName("§b§lMENU PRINCIPAL§8§l ❘ §fClic droit").toItemStack()
        );
        player.getInventory().setItem(2,
                new ItemBuilder(Material.EMERALD).setName("§a§lBOUTIQUE§8§l ❘ §fClic droit").toItemStack()
        );
        player.getInventory().setItem(1,
                new ItemBuilder(Material.SKULL_ITEM).setName("§6§lPROFIL§8§l ❘ §fClic droit").toItemStack()
        );
        player.getInventory().setItem(6,
                new ItemBuilder(Material.REDSTONE_COMPARATOR).setName("§c§lOPTIONS§8§l ❘ §fClic droit").toItemStack()
        );
        player.getInventory().setItem(7,
                new ItemBuilder(Material.ENDER_CHEST).setName("§5§lCOSMETIQUES§8§l ❘ §fClic droit").toItemStack()
        );
    }
}
