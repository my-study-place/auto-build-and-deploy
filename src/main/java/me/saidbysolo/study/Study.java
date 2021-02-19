package me.saidbysolo.study;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Study extends JavaPlugin {
    FileConfiguration config = getConfig();
    public final Utils utils = new Utils(this);
    public Location firstLocation;
    public Location secondLocation;
    public ArrayList<Player> playerList;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listener(this), this);
        getCommand("setCorrectLocation").setExecutor(new Command(this));
        getCommand("setNegativeLocation").setExecutor(new Command(this));
        getCommand("start").setExecutor(new Command(this));
        getCommand("test").setExecutor(new Command(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
