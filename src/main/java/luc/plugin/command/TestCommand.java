package luc.plugin.command;

import luc.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestCommand implements CommandExecutor {

    private final Main main = Main.getInstance();

    @Override
    public boolean onCommand(final CommandSender sender, Command command, String s, final String[] args) {
        main.getServer().getScheduler().runTaskAsynchronously(main, () -> {
            Bukkit.broadcastMessage("Test Message");
        });
        return true;
    }

}
