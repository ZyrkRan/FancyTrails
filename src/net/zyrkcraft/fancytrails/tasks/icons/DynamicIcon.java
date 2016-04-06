package net.zyrkcraft.fancytrails.tasks.icons;

import java.util.Random;

import net.zyrkcraft.fancytrails.Plugin;
import net.zyrkcraft.fancytrails.inventory.InventoryIcon;

import org.bukkit.inventory.ItemStack;

public class DynamicIcon implements Runnable{

	private String name;
	private String description;
	
	private Random random;	
	private int slot;
	private ItemStack[] itemlist;

	public DynamicIcon(Icon icon, int slot, String name, String description) {
		this.slot = slot;
		this.name = name;
		this.description = description;
		this.random = new Random();
		this.itemlist = icon.getIconContents();
	}

	@Override
	public void run() {
		Plugin.getInventoryManager().getInventoryGUI().addIcon(new InventoryIcon(slot, itemlist[random.nextInt(itemlist.length)], name, description));
	}

}
