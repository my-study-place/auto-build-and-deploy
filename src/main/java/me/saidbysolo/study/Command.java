package me.saidbysolo.study;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("o")){
                player.sendMessage("O");
                Bukkit.broadcastMessage("Test Message!");
            }
            else if (label.equalsIgnoreCase("x")){
                player.sendMessage("X");
            }
        }
        return false;
    }
}
