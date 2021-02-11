package me.saidbysolo.study;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Study extends JavaPlugin {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        getServer().getLogger().info(config.getString("wtfisthis"));
        getServer().getLogger().info("Success");
        getServer().getPluginManager().registerEvents(new Listener(), this);
        getCommand("O").setExecutor(new Command(this));
        getCommand("X").setExecutor(new Command(this));
        getCommand("start").setExecutor(new Command(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
