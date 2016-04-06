package net.zyrkcraft.fancytrails.utils;

import net.zyrkcraft.fancytrails.Plugin;

public class Messages {
	
	public static String INVENTORY_TITLE = Plugin.color(Plugin.getInstance().getConfig().getString("messages.inventory-title"));
	public static String NO_PERMISSION = Plugin.color(Plugin.getInstance().getConfig().getString("messages.no-permission"));
	
	public static void updateMessages(){
		INVENTORY_TITLE = Plugin.color(Plugin.getInstance().getConfig().getString("messages.inventory-title"));
		NO_PERMISSION = Plugin.color(Plugin.getInstance().getConfig().getString("messages.no-permission"));
	}

}
