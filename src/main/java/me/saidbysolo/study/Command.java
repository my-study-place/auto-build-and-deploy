package me.saidbysolo.study;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;;

public class Command implements CommandExecutor {
    private final Study plugin;
    private static final JSONParser parser = new JSONParser();
    private static final Random random = new Random();

    public Command(Study plugin) {
        this.plugin = plugin;
    }

    public ArrayList<Location> getBlocksInArea(Location loc1, Location loc2) {
        int lowX = (loc1.getBlockX() < loc2.getBlockX()) ? loc1.getBlockX() : loc2.getBlockX();
        int lowY = (loc1.getBlockY() < loc2.getBlockY()) ? loc1.getBlockY() : loc2.getBlockY();
        int lowZ = (loc1.getBlockZ() < loc2.getBlockZ()) ? loc1.getBlockZ() : loc2.getBlockZ();

        ArrayList<Location> locs = new ArrayList<Location>();

        for (int x = 0; x < Math.abs(loc1.getBlockX() - loc2.getBlockX()); x++) {
            for (int y = 0; y < Math.abs(loc1.getBlockY() - loc2.getBlockY()); y++) {
                for (int z = 0; z < Math.abs(loc1.getBlockZ() - loc2.getBlockZ()); z++) {
                    locs.add(new Location(loc1.getWorld(), lowX + x, lowY + y, lowZ + z));
                }
            }
        }

        return locs;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("o")) {
                player.sendMessage("O");
                Bukkit.broadcastMessage("Test Message!");
            } else if (label.equalsIgnoreCase("x")) {
                player.sendMessage("X");
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
            } else if (label.equalsIgnoreCase("distance")) {
                player.sendMessage(getBlocksInArea(this.plugin.firstLocation, this.plugin.secondLocation).toString());
            }
        }

        return false;
    }
}
