package net.zyrkcraft.fancytrails.tasks.icons;

import java.util.Random;

import net.zyrkcraft.fancytrails.Plugin;
import net.zyrkcraft.fancytrails.inventory.InventoryIcon;
import net.zyrkcraft.fancytrails.trails.trailObjects.TrailObjects;

import org.bukkit.inventory.ItemStack;

public class IconColoredDye implements Runnable{

	private String name;
	private String description;
	
	private Random random = new Random();	
	private int slot;
	private ItemStack[] itemlist = TrailObjects.COLORED_DYE;

	public IconColoredDye(int slot, String name, String description) {
		this.slot = slot;
		this.name = name;
		this.description = description;
	}

	@Override
	public void run() {
		Plugin.getInventoryManager().getInventoryGUI().addIcon(new InventoryIcon(slot, itemlist[random.nextInt(itemlist.length)], name, description));
	}
}
