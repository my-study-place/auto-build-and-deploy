package me.saidbysolo.study;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    private final Study plugin;

    public Command(Study plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("setCorrectLocation")) {
                this.plugin.utils.setConfig(this.plugin.firstLocation, this.plugin.secondLocation, true);
            } else if (label.equalsIgnoreCase("setNegativeLocation")) {
                this.plugin.utils.setConfig(this.plugin.firstLocation, this.plugin.secondLocation, false);
            } else if (label.equalsIgnoreCase("test")) {
                player.sendMessage(this.plugin.config.get("correctLocation").toString());
                player.sendMessage(this.plugin.config.get("negativeLocation").toString());
                player.sendMessage(this.plugin.playerUUIDList.toString());
            } else if (label.equalsIgnoreCase("join")) {
                if (this.plugin.playerUUIDList.contains(player.getUniqueId())) {
                    player.sendMessage("이미 참여하고계세요");

                } else {
                    player.sendMessage("성공적으로 참여했어요.");
                    this.plugin.playerUUIDList.add(player.getUniqueId());
                }
            } else if (label.equalsIgnoreCase("exit")) {
                if (this.plugin.playerUUIDList.contains(player.getUniqueId())) {
                    this.plugin.playerUUIDList.remove(player.getUniqueId());
                    player.sendMessage("성공적으로 나갔어요.");
                } else {
                    player.sendMessage("참여하고 있지 않으세요.");
                }
            }
        }

        return false;
    }
}
