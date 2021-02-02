package me.saidbysolo.study;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.FileReader;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            JSONParser parser = new JSONParser();

            if (label.equalsIgnoreCase("o")){
                player.sendMessage("O");
                Bukkit.broadcastMessage("Test Message!");
                try {
                    Object obj = parser.parse(new FileReader("/home/opc/asdf.json"));
                    JSONObject jsonObject = (JSONObject) obj;

                    String data = (String) jsonObject.get("data");

                    Bukkit.broadcastMessage(data.toString());

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            else if (label.equalsIgnoreCase("x")){
                player.sendMessage("X");
            }
        }
        return false;
    }
}
