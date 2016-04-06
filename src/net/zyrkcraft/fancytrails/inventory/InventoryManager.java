package net.zyrkcraft.fancytrails.inventory;

import net.zyrkcraft.fancytrails.Plugin;
import net.zyrkcraft.fancytrails.tasks.icons.DynamicIcon;
import net.zyrkcraft.fancytrails.tasks.icons.Icon;
import net.zyrkcraft.fancytrails.tasks.icons.TaskFrameGenerator;
import net.zyrkcraft.fancytrails.tasks.icons.Icon.IconType;
import net.zyrkcraft.fancytrails.utils.DyeColor;
import net.zyrkcraft.fancytrails.utils.Lores;
import net.zyrkcraft.fancytrails.utils.Messages;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {
	
	private InventoryGUI mainInventory;
	private InventoryGUI standardInventory;
	private InventoryGUI circularInventory;
	
	public InventoryManager(){
		createInventories();
		
		// Generate rainbow frame
		Bukkit.getServer().getScheduler().runTaskTimer(Plugin.getInstance(), new TaskFrameGenerator(), 0, 1);
	}
	
	public void createMainInventory(){
		mainInventory = new InventoryGUI("Coming Soon", 45);
		mainInventory.addIcon(new InventoryIcon(21, Material.APPLE, "Standard Trails", "Trails in this section will spawn items around the player"));
		mainInventory.addIcon(new InventoryIcon(23, Material.ANVIL, "Circular Trails", "Trails in this section will spawn in a circular motion around the player"));
	}
	
	public void createCircularInventory(){
		circularInventory = new InventoryGUI("Coming Soon", 45);
		circularInventory.addIcon(new InventoryIcon(21, Material.APPLE, "Standard Trails", "Trails in this section will spawn items around the player"));
		circularInventory.addIcon(new InventoryIcon(23, Material.ANVIL, "Circular Trails", "Trails in this section will spawn in a circular motion around the player"));
	}
	
	public void createStandardInventory(){
		standardInventory = new InventoryGUI(Messages.INVENTORY_TITLE, 45);
		
		// First row 
		standardInventory.addIcon(new InventoryIcon(10, Material.DIAMOND, "&bDiamonds", Lores.DIAMOND));
		standardInventory.addIcon(new InventoryIcon(11, Material.GOLD_INGOT, "&bGold Ingots", Lores.GOLD_INGOTS));
		standardInventory.addIcon(new InventoryIcon(12, Material.IRON_INGOT, "&bIron Ingots", Lores.IRON_INGOTS));
		standardInventory.addIcon(new InventoryIcon(13, Material.EMERALD, "&bEmeralds", Lores.EMERALDS));
		standardInventory.addIcon(new InventoryIcon(14, Material.REDSTONE, "&bRedstone", Lores.REDSTONE));
		standardInventory.addIcon(new InventoryIcon(15, new ItemStack(Material.INK_SACK, 1, DyeColor.BLUE), "&bLapis Lazuli", Lores.LAPIS_LAZULI));
		standardInventory.addIcon(new InventoryIcon(16, Material.WOOL, "&bWool", Lores.WOOL));
		
		// Second row
		/*inv.addDynamicIcon(new IconMakeItRain(20, "&6Make It Rain", Lores.MAKE_IT_RAIN), 5);*/
		standardInventory.addDynamicIcon(new DynamicIcon(new Icon(IconType.MAKE_IT_RAIN), 20, "&6Make It Rain", Lores.MAKE_IT_RAIN), 5);
		standardInventory.addDynamicIcon(new DynamicIcon(new Icon(IconType.RAINBOW_WOOL), 21, "&6Rainbow Wool", Lores.RAINBOW_WOOL), 5);
		standardInventory.addDynamicIcon(new DynamicIcon(new Icon(IconType.COLORED_DYE), 22, "&6Colored Dye", Lores.COLORED_DYE), 5);
     	standardInventory.addDynamicIcon(new DynamicIcon(new Icon(IconType.RAINBOW_CARPET), 23, "&6Rainbow Carpet", Lores.RAINBOW_CARPET), 5);
		standardInventory.addDynamicIcon(new DynamicIcon(new Icon(IconType.RAINBOW_GLASS), 24, "&6Rainbow Stained Glass", Lores.RAINBOW_GLASS), 5);
	
		// Third row
		ItemStack custom = new ItemStack(Material.EXP_BOTTLE);
		custom.getItemMeta().addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		standardInventory.addIcon(new InventoryIcon(30, new ItemStack(Material.PORK), "&6&lBACON!", Lores.BACON));
		standardInventory.addIcon(new InventoryIcon(32, custom, "&c&lCustom", Lores.CUSTOM));
	}
	
	public void createInventories(){
		createMainInventory();
		createCircularInventory();
		createStandardInventory();	
	}
	
	public InventoryGUI getInventoryGUI(){
		return standardInventory;
	}

}
