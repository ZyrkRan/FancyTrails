package net.zyrkcraft.fancytrails.tasks.icons;

import java.util.Random;

import net.zyrkcraft.fancytrails.Plugin;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TaskFrameGenerator implements Runnable{

	private Random random = new Random();
	private int[] frame = {0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44};

	@Override
	public void run() {
		for (int i=0; i < frame.length; i++){
			Plugin.getInventoryManager().getInventoryGUI().getInventory().setItem(frame[i], new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)random.nextInt(16)));
		}		
	}

}
