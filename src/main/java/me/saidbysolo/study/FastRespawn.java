package me.saidbysolo.study;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Listener implements org.bukkit.event.Listener{
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player.Spigot player = (Player.Spigot) event.getEntity();
        player.respawn();
    }
}