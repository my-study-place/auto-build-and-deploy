package me.saidbysolo.study;

import org.bukkit.scheduler.BukkitRunnable;

public class Start extends BukkitRunnable {
    private final Study plugin;

    public Start(Study plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        System.out.println("시작됬음");
        this.plugin.state = GameState.STARTING;
        cancel();

    }
}
