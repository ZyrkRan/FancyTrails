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
		
		if (Plugin.getInstance().getConfig().getBoolean("settings.login-announcement")){
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[&e&lWelcome&c] &bThis server is running FancyTrails by ZyrkRan"));
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
