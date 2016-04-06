package net.zyrkcraft.fancytrails.tasks.icons;

import net.zyrkcraft.fancytrails.trails.trailObjects.TrailObjects;

import org.bukkit.inventory.ItemStack;

public class Icon {

	public enum IconType{
		MAKE_IT_RAIN, COLORED_DYE, RAINBOW_CARPET, RAINBOW_GLASS, RAINBOW_WOOL
	}
	
	private ItemStack[] icon;
	
	public Icon(IconType iconType){
		switch (iconType){
		
		case MAKE_IT_RAIN:
			this.icon = TrailObjects.MAKE_IT_RAIN;
			break;
		case COLORED_DYE:
			this.icon = TrailObjects.COLORED_DYE;
			break;
		case RAINBOW_CARPET:
			this.icon = TrailObjects.RAINBOW_CARPET;
			break;
		case RAINBOW_GLASS:
			this.icon = TrailObjects.RAINBOW_GLASS;
			break;
		case RAINBOW_WOOL:
			this.icon = TrailObjects.RAINBOW_WOOL;
			break;
		default:
			System.out.println("Something went wrong while handling icon!");
			break;
		}
	}
	
	public ItemStack[] getIconContents(){
		return icon;
	}
	
}
