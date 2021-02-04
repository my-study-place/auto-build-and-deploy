package me.saidbysolo.study;

import org.bukkit.scheduler.BukkitRunnable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.FileReader;
import java.util.Random;

public class Command implements CommandExecutor {
    private Study plugin;
    private Integer count = 5;
    private static final JSONParser parser = new JSONParser();
    private static final Random rand = new Random();

    public Command(Study plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("o")){
                player.sendMessage("O");
                Bukkit.broadcastMessage("Test Message!");
            }
            else if (label.equalsIgnoreCase("x")){
                player.sendMessage("X");
            }
            else if(label.equalsIgnoreCase("start")){
                try {
                    Object obj = parser.parse(new FileReader("/home/opc/asdf.json"));
                    JSONObject jsonObject = (JSONObject) obj;
                    JSONArray data = (JSONArray) jsonObject.get("data");
                    JSONObject randomResult = (JSONObject) data.get(rand.nextInt(data.toArray().length));
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            switch (count){
                                case 5:
                                    player.sendMessage("5");
                                    break;
                                case 4:
                                    player.sendMessage("4");
                                    break;
                                default:
                                    break;
                            }
                            if(count==5){
                                player.sendMessage("멈춤");
                                cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0, 20);
                    Bukkit.broadcastMessage(randomResult.toJSONString());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
