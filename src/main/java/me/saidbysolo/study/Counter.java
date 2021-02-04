package me.saidbysolo.study;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.json.simple.JSONObject;

public class Counter extends BukkitRunnable {
    private final Player player;
    private final JSONObject randomResult;
    private int count = 5;

    public Counter(Player player, JSONObject randomResult){
        this.player = player;
        this.randomResult = randomResult;
    }

    @Override
    public void run() {
        // TODO: use switch statement
        if (count ==5){
            this.player.sendMessage("a");
        }
        else if(count==4){
            this.player.sendMessage("as");
        }
        else if(count==3){
            this.player.sendMessage("asd");
        }
        else if(count ==2){
            this.player.sendMessage("asdf");
        }
        else if(count==1){
            this.player.sendMessage(this.randomResult.toJSONString());
            cancel();
        }
        count--;
    }
}
