package net.lunaria.lobby.scoreboard;

import net.lunaria.api.core.account.Subscription;
import net.lunaria.api.plugins.bukkit.player.BukkitPlayer;
import net.lunaria.api.plugins.bukkit.utils.scoreboard.SidebarManager;
import net.lunaria.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Scoreboard extends SidebarManager {
    @Override
    public void build(BukkitPlayer p, SidebarEditor e) {
        Subscription subscription = p.getSubscription();
        String subStatus = "§c✘";
        if (subscription.isSubscribed()) subStatus = "§a✔";

        e.setTitle("§8» §b§lLUNARIA§f§lMC §8«");
        e.add(" ");

        e.add("§3§l ❘ §f§l" + p.getPlayerName());
        e.add("§f   Abonnement: " + subStatus);
        e.add("§f   Lunes: §d" + p.getLunes() + " §l☾");
        e.add("§f   Planètes: §5" + p.getPlanetes() + " ☀");

        e.add(" ");
        e.add("§6§l ❘ §f§lNiveau");
        e.add("§e   "+p.getLevel()+" §f(" + p.getFormattedExp(10, '-', new ChatColor[]{ChatColor.YELLOW, ChatColor.STRIKETHROUGH}, new ChatColor[]{ChatColor.WHITE, ChatColor.STRIKETHROUGH}) + "§f)§6 "+((p.getLevel()+1)));
        e.add("§f   Progression: §e" + (int) p.getProgressExp() + "%");

        e.add(" ");
        e.add("§2§l ❘ §f§lServeur");
        e.add("§f   Lobby: §a#" + Lobby.getLobbyNumber());
        e.add("§f   Connectés: §a" + Bukkit.getOnlinePlayers().size());

        e.add(" ");
        e.add("§8» §bplay.lunariamc.net");
    }

    public void updateAllTime() {
        Bukkit.getServer().getScheduler().runTaskTimerAsynchronously(Lobby.getInstance(), () -> {
            if (Bukkit.getOnlinePlayers().size() != 0) {
                Lobby.getInstance().getScoreboard().update();
            }
        }, 0L, 5L);
    }
}
