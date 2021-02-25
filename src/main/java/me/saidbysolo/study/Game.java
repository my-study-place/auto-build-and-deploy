package me.saidbysolo.study;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

// 게임 메인 태스크
public class Game extends BukkitRunnable {
    public final Study plugin;

    public Game(Study plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        switch (this.plugin.state) {
            case WAITING:
                if (!(this.plugin.playerList.size() == 2)) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage("asdf");
                    }
                }
            case STARTING:
                return;
        }

    }

}
