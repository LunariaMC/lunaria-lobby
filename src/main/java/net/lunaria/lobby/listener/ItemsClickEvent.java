package net.lunaria.lobby.listener;

import net.lunaria.lobby.menu.MainMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemsClickEvent implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getItem() == null) return;
        ItemStack itemStack = event.getItem();
        String itemName = itemStack.getItemMeta().getDisplayName();

        if (itemName.equals("§b§lMENU PRINCIPAL§8§l ❘ §fClic droit")) {
            new MainMenu(player).open(player);
        }
    }
}
