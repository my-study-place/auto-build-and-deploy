package me.saidbysolo.study;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import java.io.FileReader;
import java.util.Random;;

public class Command implements CommandExecutor {
    private final Study plugin;
    private static final JSONParser parser = new JSONParser();
    private static final Random random = new Random();

    public Command(Study plugin) {
        this.plugin = plugin;
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
                Vector first = this.plugin.firstLocation.toVector();
                Vector second = this.plugin.secondLocation.toVector();
                Vector last = first.subtract(second);
                BlockIterator bi = new BlockIterator(player.getWorld(), second, last, 0,
                        ((Double) this.plugin.firstLocation.distance(player.getLocation())).intValue());
                while (bi.hasNext()) {
                    Block block = bi.next();
                    player.sendMessage("Block found: " + block.getType() + " at: " + block.getX() + ", " + block.getY()
                            + ", " + block.getZ());
                }
            }
        }
        return false;
    }
}
