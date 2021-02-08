package me.saidbysolo.study;

import com.destroystokyo.paper.Title;
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
        switch (count) {
            case 5:
                this.player.sendMessage("a");
                break;
            case 4:
                this.player.sendMessage("as");
                break;
            case 3:
                this.player.sendMessage("asd");
                break;
            case 2:
                this.player.sendMessage("asdf");
                break;
            case 1:
                this.player.sendMessage("asdfg");
                break;
            case 0:
                this.player.sendMessage(randomResult.toJSONString());
                this.player.sendTitle("Asdf","",1,5,1);
                cancel();
                break;
        }
        count--;
    }
}
