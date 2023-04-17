package net.lunaria.lobby;

import net.lunaria.api.plugins.bukkit.command.LunaCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdTest extends LunaCommand {

    public CmdTest(String name, int requiredPower, boolean forSubscribed, boolean staffByPass, String... aliases) {
        super(name, requiredPower, forSubscribed, staffByPass, aliases);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!super.onCommand(sender, command, label, args)) return false;
        Player player = (Player) sender;
        player.sendMessage("§aTest réussi");
        player.sendMessage(String.valueOf(requiredPower));
        player.sendMessage(name);
        player.sendMessage("PM:"+bukkitPlayer.getPowerMod());
        player.sendMessage("isSubscribed:"+bukkitPlayer.getSubscription().isSubscribed());
        return true;
    }
}
