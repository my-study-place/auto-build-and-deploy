package me.saidbysolo.study;

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
                return;
            case STARTING:
                return;
        }

    }

}
