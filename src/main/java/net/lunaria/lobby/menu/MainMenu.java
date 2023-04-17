package net.lunaria.lobby.menu;

import net.lunaria.api.plugins.bukkit.game.Games;
import net.lunaria.api.plugins.bukkit.menu.LunaMenu;
import net.lunaria.api.plugins.bukkit.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MainMenu extends LunaMenu {
    public MainMenu(Player player) {
        super(player, "§b§lMENU PRINCIPAL", 6*9);
    }

    @Override
    public void onOpen(Player player, Inventory inventory) {
        ItemStack aquaGlass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 9).setName(" ").toItemStack();
        ItemStack tealGlass = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 3).setName(" ").toItemStack();

        inventory.setItem(0, aquaGlass); inventory.setItem(1, aquaGlass); inventory.setItem(7, aquaGlass); inventory.setItem(8, aquaGlass);
        inventory.setItem(45, aquaGlass); inventory.setItem(46, aquaGlass); inventory.setItem(52, aquaGlass); inventory.setItem(53, aquaGlass);

        int slot = 21;
        for (Games game : Games.values()) {
            inventory.setItem(slot, game.getMainMenuItem());
            if (slot == 23) slot = 29;
            slot++;
        }
    }

    @Override
    public void onClick(InventoryClickEvent event, Player player) {

    }

    @Override
    public void onClose(Player player) {

    }
}
