package net.zyrkcraft.fancytrails.trails;

import net.zyrkcraft.fancytrails.Plugin;

public enum TrailType {
	
	DIAMOND(Plugin.getInstance().getConfig().getString("lores.diamonds")), 
	GOLD_INGOTS(Plugin.getInstance().getConfig().getString("lores.gold-ingots")), 
	IRON_INGOTS(Plugin.getInstance().getConfig().getString("lores.iron-ingots")), 
	EMERALDS(Plugin.getInstance().getConfig().getString("lores.emeralds")),
	REDSTONE(Plugin.getInstance().getConfig().getString("lores.redstone")),
	LAPIS_LAZULI(Plugin.getInstance().getConfig().getString("lores.lapis-lazuli")),
	WOOL(Plugin.getInstance().getConfig().getString("lores.wool")),
	MAKE_IT_RAIN(Plugin.getInstance().getConfig().getString("lores.make-it-rain")), 
	RAINBOW_WOOL(Plugin.getInstance().getConfig().getString("lores.rainbow-wool")),  
	RAINBOW_CARPET(Plugin.getInstance().getConfig().getString("lores.rainbow-carpet")),
	COLORED_DYE(Plugin.getInstance().getConfig().getString("lores.colored-dye")),
	RAINBOW_GLASS(Plugin.getInstance().getConfig().getString("lores.rainbow-glass")),
	BACON(Plugin.getInstance().getConfig().getString("lores.bacon")),
	CUSTOM(Plugin.getInstance().getConfig().getString("lores.custom"));
	
	String list;
	
	private TrailType(String list){
		this.list = list;
	}
	
	public String getLore(){
		StringBuilder output = new StringBuilder();
		
		for (int i=0; i < list.length(); i++){
			output.append(list.length() + ";");
		}
		output.setCharAt(output.length()-1, ' ');
		return output.toString();
	}
	

}
