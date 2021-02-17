package me.saidbysolo.study;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.FileReader;
import java.util.Random;;

public class Command implements CommandExecutor {
    private final Study plugin;
    private static final JSONParser parser = new JSONParser();
    private static final Random random = new Random();

    public Command(Study plugin) {
        this.plugin = plugin;
    }

    public void setConfig(Location firstLocation, Location secondLocation, Boolean correct) {
        if (correct) {
            this.plugin.config.set("correctLocation.firstLocation.X", firstLocation.getX());
            this.plugin.config.set("correctLocation.firstLocation.Y", firstLocation.getY());
            this.plugin.config.set("correctLocation.firstLocation.Z", firstLocation.getZ());
            this.plugin.config.set("correctLocation.secondLocation.X", secondLocation.getX());
            this.plugin.config.set("correctLocation.secondLocation.Y", secondLocation.getY());
            this.plugin.config.set("correctLocation.secondLocation.Z", secondLocation.getZ());
        } else {
            this.plugin.config.set("negativeLocation.firstLocation.X", firstLocation.getX());
            this.plugin.config.set("negativeLocation.firstLocation.Y", firstLocation.getY());
            this.plugin.config.set("negativeLocation.firstLocation.Z", firstLocation.getZ());
            this.plugin.config.set("negativeLocation.secondLocation.X", secondLocation.getX());
            this.plugin.config.set("negativeLocation.secondLocation.Y", secondLocation.getY());
            this.plugin.config.set("negativeLocation.secondLocation.Z", secondLocation.getZ());
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("setCorrectLocation")) {
                setConfig(this.plugin.firstLocation, this.plugin.secondLocation, true);
            } else if (label.equalsIgnoreCase("setNegativeLocation")) {
                setConfig(this.plugin.firstLocation, this.plugin.secondLocation, false);
            } else if (label.equalsIgnoreCase("start")) {
                try {
                    Object obj = parser.parse(new FileReader("/home/opc/asdf.json"));
                    JSONObject jsonObject = (JSONObject) obj;
                    JSONArray dataArray = (JSONArray) jsonObject.get("data");
                    JSONObject randomResult = (JSONObject) dataArray.get(random.nextInt(dataArray.toArray().length));
                    new Counter(player, randomResult).runTaskTimer(this.plugin, 0, 20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (label.equalsIgnoreCase("test")) {
                player.sendMessage(this.plugin.config.get("correctLocation").toString());
                player.sendMessage(this.plugin.config.get("negativeLocation").toString());
            }
        }

        return false;
    }
}
