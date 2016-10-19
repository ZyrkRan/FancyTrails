package net.zyrkcraft.fancytrails.command;

import net.zyrkcraft.fancytrails.Plugin;
import net.zyrkcraft.fancytrails.utils.Lores;
import net.zyrkcraft.fancytrails.utils.Messages;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFancyTrails implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You can't run this command from the console!");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (args.length == 0){
			Plugin.getInventoryManager().getInventoryGUI().open(player);
			player.playSound(player.getLocation(), Sound.BLOCK_NOTE_PLING, Integer.MAX_VALUE, Integer.MAX_VALUE);
			player.sendMessage(ChatColor.GREEN + "You've opened the Trails GUI!");
			return true;
		}
		
		else if (args.length == 1){
			if (args[0].equalsIgnoreCase("off")){
				System.out.println(Plugin.getTrailManager().hasTrailEnabled(player));
				if (Plugin.getTrailManager().hasTrailEnabled(player)){
					Plugin.getTrailManager().stopTrail(player);
					player.sendMessage(ChatColor.GREEN + "You have successfully disabled your trail!");
					return true;
				}
				
				else {
					player.sendMessage(ChatColor.RED + "You don't have any trails activated right now!");
					return false;
				}
			}
			
			else if (args[0].equalsIgnoreCase("version")){
				player.sendMessage(" ");
				player.sendMessage(ChatColor.GREEN + "FancyTrails " + Plugin.getInstance().getDescription().getVersion());
				player.sendMessage(ChatColor.GREEN + "Authors: " + Plugin.getInstance().getDescription().getAuthors());
				player.sendMessage(" ");
				return true;
			}
			
			else if (args[0].equalsIgnoreCase("reload")){
				if (player.hasPermission("fancytrails.reload")){
					Plugin.getInstance().reloadConfig();
					Messages.updateMessages();
					Lores.updateLores();
					Plugin.getInventoryManager().createInventories();
					player.sendMessage(ChatColor.GREEN + "Configuration file reloaded!");
					return true;
				}
				
				else {
					player.sendMessage(Messages.NO_PERMISSION);
					return true;
				}
			}
			
			else if (args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")){
				player.sendMessage(ChatColor.GREEN + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				player.sendMessage(ChatColor.YELLOW + "/fancytrails off");
				player.sendMessage(ChatColor.YELLOW + "/fancytrails reload - Reload configuration file");
				player.sendMessage(ChatColor.YELLOW + "/fancytrails [info/help/?] - Help guide");
				player.sendMessage(ChatColor.YELLOW + "/fancytrails version");
				player.sendMessage(ChatColor.GREEN + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			}
		}
		
		return false;
	}

}
