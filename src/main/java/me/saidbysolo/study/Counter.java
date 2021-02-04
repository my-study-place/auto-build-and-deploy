package me.saidbysolo.study;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Counter extends BukkitRunnable {
    private final Player player;
    private int count = 5;

    public Counter(Player player){
        this.player = player;
    }

    @Override
    public void run() {
        if (count ==5){
            this.player.sendMessage("asdf");
        }
        else if(count==4){
            this.player.sendMessage("asdf");
        }
        else if(count==3){
            this.player.sendMessage("asdf");
        }
        else if(count ==2){
            this.player.sendMessage("끝");
        }
        else if(count==1){
            cancel();
        }
        count--;
    }
}
