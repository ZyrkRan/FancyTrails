package net.zyrkcraft.fancytrails;

import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import net.zyrkcraft.fancytrails.command.CommandFancyTrails;
import net.zyrkcraft.fancytrails.inventory.InventoryManager;
import net.zyrkcraft.fancytrails.listeners.InventoryListener;
import net.zyrkcraft.fancytrails.listeners.PlayerJoinQuitListener;
import net.zyrkcraft.fancytrails.trails.TrailManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

public class Plugin extends JavaPlugin{
	
	private static Plugin instance;
	private static InventoryManager invManager;
	private static TrailManager trailManager;
	
	public void onEnable(){
		instance = this;
		
		// load configuration file
		saveDefaultConfig();
		
		// Initialize objects
		invManager = new InventoryManager();
		trailManager = new TrailManager();
		
		// register events
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new InventoryListener(), this);
		pm.registerEvents(new PlayerJoinQuitListener(), this);
		
		// register commands
		getCommand("fancytrails").setExecutor(new CommandFancyTrails());
		
		// MCStats
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (Exception e) {
			// no connection
		}
	}
	
	public void onDisable() {
		if (TrailManager.getDataManager().getRunningTasks().isEmpty() || TrailManager.getDataManager().getFloatingItems().isEmpty() || TrailManager.getDataManager().getTrailItems().isEmpty()){
			return;
		}
		
		for (Entry<UUID, Integer> entry : TrailManager.getDataManager().getRunningTasks().entrySet()){
			getTrailManager().stopTrail(Bukkit.getPlayer(entry.getKey()));
		}
		
		for (Entry<UUID, List<Item>> entry : TrailManager.getDataManager().getFloatingItems().entrySet()){
			for (int i=0; i < entry.getValue().size(); i++){
				entry.getValue().get(i).remove();
			}
		}
	}
	
	public static String decolor(String text){
		text = ChatColor.stripColor(text);
		return text;
	}
	
	public static String color(String text){
		text = ChatColor.translateAlternateColorCodes('&', text);
		return text;
	}
	
	public static TrailManager getTrailManager(){
		return trailManager;
	}
	
	public static InventoryManager getInventoryManager(){
		return invManager;
	}
	
	public static Plugin getInstance(){
		return instance;
	}
}
