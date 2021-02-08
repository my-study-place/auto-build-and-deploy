package me.saidbysolo.study;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Listener implements org.bukkit.event.Listener{
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        player.spigot().respawn();
    }
}