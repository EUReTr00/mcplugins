package co.uk.retr00.mcplugins;

import co.uk.retr00.mcplugins.commands.ServerHelpGUI;
import co.uk.retr00.mcplugins.listeners.XPBottleBreakListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class Mcplugins extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Plugin has loaded.");

        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getCommand("helpgui").setExecutor(new ServerHelpGUI());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String @NotNull [] args) {

        if (command.getName().equalsIgnoreCase("freexp")){

            if (sender instanceof Player player) {

                int number = ThreadLocalRandom.current().nextInt(10);

                if (number == 9) {
                    player.sendMessage("Well done, you got lucky and have recieved 1 diamond.");
                    player.give(ItemStack.of(Material.DIAMOND));
                } else {
                    player.sendMessage("Unlucky, you got 50XP.");
                    player.giveExp(50);
                }


            }

        }

        return true;
    }

    public void onDisable() {
        System.out.println("Plugin has unloaded.");
    }
}
