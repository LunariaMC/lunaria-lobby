package net.lunaria.lobby;

import net.lunaria.api.core.account.Subscription;
import net.lunaria.api.plugins.bukkit.command.LunaCommand;
import net.lunaria.api.plugins.bukkit.command.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdTest extends LunaCommand {

    public CmdTest() {
        super("test", 0, Subscription::isSubscribed, false, "cmdtest");
    }

    @Override
    public boolean onCommand(CommandSender sender, String label, String[] args) {
        return true;
    }

    @Override
    public void sendHelp() {
        player.sendMessage("HELP");
    }

    @SubCommand(arg = "test", position = 0)
    void testSubCommand() {
        player.sendMessage("TEST");
    }

}
