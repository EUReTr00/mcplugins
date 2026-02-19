package co.uk.retr00.mcplugins.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.entity.Player;

public class XPBottleBreakListener implements Listener {

    @EventHandler
    public void onXpBottleBreak(ExpBottleEvent e) {

        int exp = e.getExperience();
        String message = "<#e9e9e9>You just recieved <#ffff00>" + exp + " <#e9e9e9>XP!";

        if (e.getEntity().getShooter() instanceof Player player) {

            Component component = MiniMessage.miniMessage().deserialize(message);

            player.sendActionBar(component);

        }
    }
}
