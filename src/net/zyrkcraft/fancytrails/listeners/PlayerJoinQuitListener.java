package net.zyrkcraft.fancytrails.listeners;

import java.util.List;
import java.util.UUID;
import java.util.Map.Entry;

import net.md_5.bungee.api.ChatColor;
import net.zyrkcraft.fancytrails.Plugin;
import net.zyrkcraft.fancytrails.trails.TrailManager;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		if (player.isOp()){
			player.sendMessage(" ");
			player.sendMessage(ChatColor.RED + "Please review FancyTrails if you enjoy the plugin!");
			player.sendMessage(ChatColor.RED + "Spigot page: https://goo.gl/I95gLl");
			player.sendMessage(" ");
		}
		
		// Dont worry, this will just let me know if a server is using my plugin when I join :)
		if (player.getUniqueId().toString().equalsIgnoreCase("0454e46b-25ca-444a-a3d6-c6f49eb9fef3")){
			player.sendMessage(" ");
			player.sendMessage(" ");
			player.sendMessage(ChatColor.RED + "This plugin is using your plugin (FancyTrails), yay!");
			player.sendMessage(" ");
			player.sendMessage(" ");
		}
		
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		Player player = event.getPlayer();
		
		for (Entry<UUID, List<Item>> entry : TrailManager.getDataManager().getFloatingItems().entrySet()){
			for (int i=0; i < entry.getValue().size(); i++){
				entry.getValue().get(i).remove();
			}
		}
		
		Plugin.getTrailManager().stopTrail(player);
	}
}
