package at.pl4yingnight.tutorial;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion.Target;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import at.pl4yingnight.tutorial.commands.HelloWorldCommandExecutor;
import at.pl4yingnight.tutorial.listener.ActionListener;

@Plugin(name = "Tutorial", version = "0.0.1")
@Description(value = "This Plugin is a Maven Spigot Plugin")
@Author(value = "Pl4yingNight")
@ApiVersion(Target.v1_13)
public class Main extends JavaPlugin{
	
	private static Main plugin;
	
	@Override
	public void onLoad() {
		plugin = this;
		
		getLogger().info("Loaded");
	}
	
	@Override
	public void onEnable() {
		
		new ActionListener(this);
		
		getCommand("hello").setExecutor(new HelloWorldCommandExecutor());
		
		getLogger().info("Enabled");
	}
	
	@Override
	public void onDisable() {
		
		
		getLogger().info("Disabled");
	}
	
	public static org.bukkit.plugin.Plugin getPlugin() {
		return plugin;
	}
}