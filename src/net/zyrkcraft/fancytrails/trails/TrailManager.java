package net.zyrkcraft.fancytrails.trails;

import java.util.List;
import java.util.UUID;
import java.util.Map.Entry;

import net.zyrkcraft.fancytrails.Plugin;
import net.zyrkcraft.fancytrails.tasks.Task;
import net.zyrkcraft.fancytrails.tasks.data.DataManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class TrailManager {
	
	private static DataManager dataManager;
	
	public TrailManager(){
		dataManager = new DataManager();
	}
	
	public void startTrail(Player player, TrailType type){
		int delay = Plugin.getInstance().getConfig().getInt("settings.delay");
		
		if (dataManager.getRunningTasks().containsKey(player.getUniqueId())){
			stopTrail(player);
		}
		int taskID = Bukkit.getServer().getScheduler().runTaskTimer(Plugin.getInstance(), new Task(player, type), 0, delay).getTaskId();
		dataManager.getRunningTasks().put(player.getUniqueId(), taskID);
	}
	
	public void stopTrail(Player player){
		if (dataManager.getRunningTasks().containsKey(player.getUniqueId())){
			for (Entry<UUID, List<Item>> entry : TrailManager.getDataManager().getFloatingItems().entrySet()){
				for (int i=0; i < entry.getValue().size(); i++){
					entry.getValue().get(i).remove();
				}
			}
		}
		if (dataManager.getRunningTasks().containsKey(player.getUniqueId())){
			Bukkit.getScheduler().cancelTask(dataManager.getRunningTasks().get(player.getUniqueId()).intValue()); // cancel trail
			dataManager.getRunningTasks().remove(player.getUniqueId());
			dataManager.getFloatingItems().remove(player.getUniqueId());
		}
	}
	
	public boolean hasTrailEnabled(Player player){
		return dataManager.getRunningTasks().containsKey(player.getUniqueId());
	}
	
	public static DataManager getDataManager(){
		return dataManager;
	}
}
