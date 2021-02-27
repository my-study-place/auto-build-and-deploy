package me.saidbysolo.study;

import org.bukkit.scheduler.BukkitRunnable;

// 5초전 카운트!
public class Counter extends BukkitRunnable {
    private final Study plugin;
    private int count = 5;

    public Counter(Study plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        switch (count) {
            case 5:
                this.plugin.utils.allSendMessage(this.plugin.playerList, "게임 시작 5초전");
                break;
            case 4:
                this.plugin.utils.allSendMessage(this.plugin.playerList, "게임 시작 4초전");
                break;
            case 3:
                this.plugin.utils.allSendMessage(this.plugin.playerList, "게임 시작 3초전");
                break;
            case 2:
                this.plugin.utils.allSendMessage(this.plugin.playerList, "게임 시작 2초전");
                break;
            case 1:
                this.plugin.utils.allSendMessage(this.plugin.playerList, "게임 시작 1초전");
                break;
            case 0:
                new Start(this.plugin).runTaskTimer(this.plugin, 0, 20);
                cancel();
                break;
        }
        count--;
    }
}
