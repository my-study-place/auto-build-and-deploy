package me.saidbysolo.study;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        player.spigot().respawn();
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Location location = (Location) event.getTo();
        Player player = (Player) event.getPlayer();
        player.sendMessage(location.getBlock().toString());
    }
}