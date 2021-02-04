package me.saidbysolo.study;

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
    private final Study plugin;
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
                    new Counter(player).runTaskTimer(this.plugin,0,20L);
                    Bukkit.broadcastMessage(randomResult.toJSONString());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
