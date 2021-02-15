package me.saidbysolo.study;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Study extends JavaPlugin {
    FileConfiguration config = getConfig();
    public Location firstLocation = null;
    public Location secondLocation = null;

    @Override
    public void onEnable() {
        getServer().getLogger().info(config.getString("wtfisthis"));
        getServer().getLogger().info("Success");
        getServer().getPluginManager().registerEvents(new Listener(this), this);
        getCommand("O").setExecutor(new Command(this));
        getCommand("X").setExecutor(new Command(this));
        getCommand("start").setExecutor(new Command(this));
        getCommand("distance").setExecutor(new Command(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
