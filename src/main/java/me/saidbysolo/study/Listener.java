package me.saidbysolo.study;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        player.spigot().respawn();
    }

    // @EventHandler
    // public void onMove(PlayerMoveEvent event) {
    // Player player = (Player) event.getPlayer();
    // player.sendMessage(player.getLocation().subtract(0,
    // 1,0).getBlock().getType().toString());
    // }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = (Player) event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getMaterial() == Material.INK_SACK) {
            player.sendMessage("right");
            player.sendMessage(event.getMaterial().toString());
        } else if (event.getAction() == Action.LEFT_CLICK_BLOCK && event.getMaterial() == Material.INK_SACK) {
            player.sendMessage("left");
            event.setCancelled(true);
        }

    }
}