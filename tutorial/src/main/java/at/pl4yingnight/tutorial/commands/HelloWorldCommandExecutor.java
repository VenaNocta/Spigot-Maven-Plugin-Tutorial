package at.pl4yingnight.tutorial.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.annotation.command.*;

@Commands(@Command(name = "HelloWorldCommand", aliases = "helloworld", usage = "/hello"))
public class HelloWorldCommandExecutor implements CommandExecutor {

	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

		if (sender instanceof Player)
			sender.sendMessage("Hello " + sender.getName() + " to Minecraft!");
		else
			sender.sendMessage("Hello Minecraft!");
		return true;
	}
}
