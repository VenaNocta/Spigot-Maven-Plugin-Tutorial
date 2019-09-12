package at.pl4yingnight.tutorial.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.Plugin;

public class ActionListener implements Listener {

	private Plugin plugin;
	
    public ActionListener(Plugin plugin) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }
    
    @EventHandler
    public void onSleep(PlayerBedEnterEvent event) {
    	event.getPlayer().sendMessage("Good night!");
    }
    
    @EventHandler
    public void onWakeup(PlayerBedLeaveEvent event) {
    	event.getPlayer().sendMessage("Good morning!");
    }
}