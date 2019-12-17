package de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LottiZombottiGame extends JavaPlugin {

    private static LottiZombottiGame instance;
    private PluginManager pm;

    @Override
    public void onEnable() {
        instance = this;
        pm = Bukkit.getServer().getPluginManager();
        registerCommands();
        registerEventListeners();
    }

    private void registerEventListeners() {

    }

    private void registerCommands() {

    }

    public static LottiZombottiGame getInstance() {
        return instance;
    }
}
