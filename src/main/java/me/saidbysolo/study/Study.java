package me.saidbysolo.study;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Study extends JavaPlugin {
    FileConfiguration config = getConfig();
    public Location firstLocation;
    public Location secondLocation;

    @Override
    public void onEnable() {
        getServer().getLogger().info(config.getString("wtfisthis"));
        getServer().getLogger().info("Success");
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
