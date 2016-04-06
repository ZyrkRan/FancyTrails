package net.zyrkcraft.fancytrails.inventory;

import java.util.Arrays;

import net.zyrkcraft.fancytrails.Plugin;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryIcon {
	
	private ItemStack item;
	private String iconName;
	private String[] description;

	private int slot;
	
	public InventoryIcon(int slot, Material material, String iconName, String description){
		this.item = new ItemStack(material);
		this.slot = slot;
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Plugin.color(iconName));

		String[] args = description.split(";");
		
		
		for (int i=0; i < args.length; i++){
			args[i] = Plugin.color(args[i]);
		}

		meta.setLore(Arrays.asList(args));
		item.setItemMeta(meta);
	}
	
	public InventoryIcon(int slot, ItemStack item, String iconName, String description){
		this.item = item;
		this.slot = slot;
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Plugin.color(iconName));

		String[] args = description.split(";");
		
		
		for (int i=0; i < args.length; i++){
			args[i] = Plugin.color(args[i]);
		}

		meta.setLore(Arrays.asList(args));
		item.setItemMeta(meta);
	}
	
	public int getSlot(){
		return slot;
	}
	
	public ItemStack getIcon(){
		return item;
	}
	
	public String getName(){
		return iconName;
	}
	
	public String[] getDescription(){
		return description;
	}

}
