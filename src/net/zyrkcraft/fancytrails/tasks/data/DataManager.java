package net.zyrkcraft.fancytrails.tasks.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Item;

public class DataManager {
	
	private HashMap<UUID, Integer> runningTasks = new HashMap<UUID, Integer>();
	private HashMap<UUID, List<Item>> floatingItems = new HashMap<UUID, List<Item>>();
	private List<Item> trailItems = new ArrayList<Item>();
	
	public HashMap<UUID, Integer> getRunningTasks(){
		return runningTasks;
	}
	
	public HashMap<UUID, List<Item>> getFloatingItems(){
		return floatingItems;
	}
	
	public List<Item> getTrailItems(){
		return trailItems;
	}
}
