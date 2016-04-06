package net.zyrkcraft.fancytrails.utils;

import net.zyrkcraft.fancytrails.Plugin;

public class Lores {
	
	public static String DIAMOND = Plugin.getInstance().getConfig().getString("lores.diamonds");
	public static String GOLD_INGOTS = Plugin.getInstance().getConfig().getString("lores.gold-ingots");
	public static String IRON_INGOTS = Plugin.getInstance().getConfig().getString("lores.iron-ingots");
	public static String EMERALDS = Plugin.getInstance().getConfig().getString("lores.emeralds");
	public static String LAPIS_LAZULI = Plugin.getInstance().getConfig().getString("lores.lapis-lazuli");
	public static String REDSTONE = Plugin.getInstance().getConfig().getString("lores.redstone");
	public static String WOOL = Plugin.getInstance().getConfig().getString("lores.wool");
	public static String MAKE_IT_RAIN = Plugin.getInstance().getConfig().getString("lores.make-it-rain");
	public static String RAINBOW_WOOL = Plugin.getInstance().getConfig().getString("lores.rainbow-wool");
	public static String COLORED_DYE = Plugin.getInstance().getConfig().getString("lores.colored-dye");
	public static String RAINBOW_CARPET = Plugin.getInstance().getConfig().getString("lores.rainbow-carpet");
	public static String RAINBOW_GLASS = Plugin.getInstance().getConfig().getString("lores.rainbow-glass");
	public static String BACON = Plugin.getInstance().getConfig().getString("lores.bacon");
	public static String CUSTOM = Plugin.getInstance().getConfig().getString("lores.custom");
	
	public static void updateLores(){
		DIAMOND = Plugin.getInstance().getConfig().getString("lores.diamonds");
		GOLD_INGOTS = Plugin.getInstance().getConfig().getString("lores.gold-ingots");
		IRON_INGOTS = Plugin.getInstance().getConfig().getString("lores.iron-ingots");
		EMERALDS = Plugin.getInstance().getConfig().getString("lores.emeralds");
		LAPIS_LAZULI = Plugin.getInstance().getConfig().getString("lores.lapis-lazuli");
		REDSTONE = Plugin.getInstance().getConfig().getString("lores.redstone");
		WOOL = Plugin.getInstance().getConfig().getString("lores.wool");
		MAKE_IT_RAIN = Plugin.getInstance().getConfig().getString("lores.make-it-rain");
		RAINBOW_WOOL = Plugin.getInstance().getConfig().getString("lores.rainbow-wool");
		COLORED_DYE = Plugin.getInstance().getConfig().getString("lores.colored-dye");
		RAINBOW_CARPET = Plugin.getInstance().getConfig().getString("lores.rainbow-carpet");
		RAINBOW_GLASS = Plugin.getInstance().getConfig().getString("lores.rainbow-glass");
		BACON = Plugin.getInstance().getConfig().getString("lores.bacon");
		CUSTOM = Plugin.getInstance().getConfig().getString("lores.custom");
	}

}
