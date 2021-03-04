package me.saidbysolo.study;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

// 여기서 상호작용이나 탈락쪽 건드는곳
public class Listener implements org.bukkit.event.Listener {
    private final Study plugin;

    public Listener(Study plugin) {
        this.plugin = plugin;
    }

    /*
     * @EventHandler public void onDeath(PlayerDeathEvent event) { Player player =
     * event.getEntity(); player.spigot().respawn(); }
     */

    /*
     * @EventHandler public void onMove(PlayerMoveEvent event) { Player player =
     * (Player) event.getPlayer();
     * player.sendMessage(player.getLocation().subtract(0, 1,
     * 0).getBlock().getType().toString()); }
     */

    // 블록 지정
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        if (event.getAction() == Action.LEFT_CLICK_BLOCK && event.getMaterial() == Material.INK_SACK) {
            Location location = event.getClickedBlock().getLocation();
            this.plugin.firstLocation = location;
            player.sendMessage(
                    "첫번째 블록 선택됨: " + "X:" + location.getX() + " Y:" + location.getY() + " Z:" + location.getZ());
            event.setCancelled(true);
        } else if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getMaterial() == Material.INK_SACK) {
            Location location = event.getClickedBlock().getLocation();
            this.plugin.secondLocation = location;
            player.sendMessage(
                    "두번째 블록 선택됨: " + "X:" + location.getX() + " Y:" + location.getY() + " Z:" + location.getZ());
        }
    }

    @EventHandler
    public void onExit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (this.plugin.playerList.contains(player)) {
            this.plugin.playerList.remove(player);
        }
    }
}