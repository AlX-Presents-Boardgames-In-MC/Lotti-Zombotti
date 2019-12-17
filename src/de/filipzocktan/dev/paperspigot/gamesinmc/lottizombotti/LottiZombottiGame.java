package de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti;

import org.bukkit.plugin.java.JavaPlugin;

public class LottiZombottiGame extends JavaPlugin {

    private static LottiZombottiGame instance;

    @Override
    public void onEnable() {
        instance = this;
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
