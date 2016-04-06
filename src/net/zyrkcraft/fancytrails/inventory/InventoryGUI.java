package net.zyrkcraft.fancytrails.inventory;

import java.util.ArrayList;
import java.util.List;

import net.zyrkcraft.fancytrails.Plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryGUI {
	
	private String title;
	private Inventory inventory;
	private List<InventoryIcon> icons;
	
	public InventoryGUI(String title, int size){
		this.title = title;
		this.inventory = Bukkit.createInventory(null, size, Plugin.color(title));
		icons = new ArrayList<InventoryIcon>();
		
		for (int i=0; i < icons.size(); i++){
			addIcon(icons.get(i));
		}
	}
	
	public void open(Player player){
		player.openInventory(inventory);
	}
	
	public void addIcon(InventoryIcon icon){
		inventory.setItem(icon.getSlot(), icon.getIcon());
	}
	
	public void addDynamicIcon(Runnable runnable, long refreshRate){
		Bukkit.getServer().getScheduler().runTaskTimer(Plugin.getInstance(), runnable, 0L, refreshRate);
	}
	
	public Inventory getInventory(){
		return inventory;
	}
	
	public String getInventoryTitle(){
		return title;
	}
	
	public List<InventoryIcon> getAllIcons(){
		return icons;
	}

}
