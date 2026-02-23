package co.uk.retr00.mcplugins;

import co.uk.retr00.mcplugins.builders.ItemBuilder;
import co.uk.retr00.mcplugins.commands.DailyCrateCommand;
import co.uk.retr00.mcplugins.commands.FreeXpCommand;
import co.uk.retr00.mcplugins.commands.ServerHelpGUI;
import co.uk.retr00.mcplugins.listeners.XPBottleBreakListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mcplugins extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Plugin has loaded.");

        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new ServerHelpGUI(), this);

        getCommand("helpgui").setExecutor(new ServerHelpGUI());
        getCommand("dailycrate").setExecutor(new DailyCrateCommand());
        getCommand("freexp").setExecutor(new FreeXpCommand());
        getCommand("daily").setExecutor(new DailyCrateCommand());
    }

    public void onDisable() {
        System.out.println("Plugin has unloaded.");
    }
}
