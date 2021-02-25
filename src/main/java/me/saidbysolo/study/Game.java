package me.saidbysolo.study;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

// 게임 메인 태스크
public class Game extends BukkitRunnable {
    public final Study plugin;
    private int timeCount = 0;

    public Game(Study plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        switch (this.plugin.state) {
            case WAITING:
                if (this.plugin.playerList.size() == 2) {
                    new Counter(this.plugin).runTaskLater(this.plugin, 20);
                    timeCount = 0;
                } else {
                    if (timeCount == 5) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendMessage("asdf");
                        }
                        timeCount = 0;
                    } else {
                        timeCount++;
                    }
                }
                break;
            case STARTING:
                break;
        }

    }

}
