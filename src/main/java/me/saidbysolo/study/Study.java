package me.saidbysolo.study;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Study extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getLogger().info("Success");
        getCommand("O").setExecutor(new Command());
        getCommand("X").setExecutor(new Command());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
