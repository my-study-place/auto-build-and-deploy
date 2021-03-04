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
            if (this.plugin.playerUUIDList.size() == 2) {
                System.out.println(this.plugin.playerUUIDList.size());
                new Counter(this.plugin).runTaskTimer(this.plugin, 0, 20);
                timeCount = 0;
            } else {
                if (timeCount == 10) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage("참여를 기다리고 있어요.");
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
