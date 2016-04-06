package net.zyrkcraft.fancytrails.listeners;

import net.zyrkcraft.fancytrails.Plugin;
import net.zyrkcraft.fancytrails.trails.TrailType;
import net.zyrkcraft.fancytrails.utils.Messages;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener{
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		if (!event.getInventory().equals(Plugin.getInventoryManager().getInventoryGUI().getInventory())){
			return;
		}
		
		if (event.getCurrentItem() == null || event.getCurrentItem().getType() == null || event.getCurrentItem().getType() == Material.AIR || event.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
			event.setCancelled(true);
			return;
		}
		
		Player player = (Player)event.getWhoClicked();
		
		if (event.getInventory().equals(Plugin.getInventoryManager().getInventoryGUI().getInventory())){
			event.setCancelled(true); // Cancel event
			player.playSound(player.getLocation(), Sound.NOTE_PLING, Integer.MAX_VALUE, Integer.MAX_VALUE);
			
			ItemStack item = event.getCurrentItem();
			
			if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Diamonds")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.diamonds")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.DIAMOND);
					player.sendMessage(ChatColor.GREEN + "You selected Diamonds Trail");
					return;
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Gold Ingots")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.goldingots")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.GOLD_INGOTS);
					player.sendMessage(ChatColor.GREEN + "You selected Golden Ingots Trail");
					return;
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Iron Ingots")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.ironingots")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.IRON_INGOTS);
					player.sendMessage(ChatColor.GREEN + "You selected Iron Ingots Trail");
					return;
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Emeralds")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.emeralds")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.EMERALDS);
					player.sendMessage(ChatColor.GREEN + "You selected Emerald Trail");
					return;
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Redstone")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.redstone")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.REDSTONE);
					player.sendMessage(ChatColor.GREEN + "You selected Redstone Trail");
					return;
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Lapis Lazuli")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.lapislazuli")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.LAPIS_LAZULI);
					player.sendMessage(ChatColor.GREEN + "You selected Lapis Lazuli Trail");
					return;
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Wool")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.wool")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.WOOL);
					player.sendMessage(ChatColor.GREEN + "You selected Wool Trail");
					return;	
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Make It Rain")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.makeitrain")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.MAKE_IT_RAIN);
					player.sendMessage(ChatColor.GREEN + "You selected Make It Rain Trail");
					return;
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Rainbow Wool")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.rainbowwool")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.RAINBOW_WOOL);
					player.sendMessage(ChatColor.GREEN + "You selected Rainbow Wool Trail");
					return;	
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Colored Dye")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.coloreddye")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.COLORED_DYE);
					player.sendMessage(ChatColor.GREEN + "You selected Colored Dye Trail");
					return;	
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Rainbow Carpet")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.rainbowcarpet")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.RAINBOW_CARPET);
					player.sendMessage(ChatColor.GREEN + "You selected Rainbow Carpet Trail");
					return;	
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Rainbow Stained Glass")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.rainbowstainedglass")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.RAINBOW_GLASS);
					player.sendMessage(ChatColor.GREEN + "You selected Rainbow Glass Trail");
					return;	
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).equalsIgnoreCase("Bacon!")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.bacon")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.BACON);
					player.sendMessage(ChatColor.GREEN + "You selected bacon Trail");
					return;	
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else if (Plugin.decolor(item.getItemMeta().getDisplayName()).contains("Custom")){
				if (player.isOp() || player.hasPermission("fancytrails.use.*") || player.hasPermission("fancytrails.use.custom")){
					Plugin.getTrailManager().startTrail((Player)event.getWhoClicked(), TrailType.CUSTOM);
					player.sendMessage(ChatColor.GREEN + "You selected Custom Trail");
					return;
				}
				player.sendMessage(Messages.NO_PERMISSION);
			}
			
			else {
				player.sendMessage(ChatColor.RED + "You tried to activate an invalid TrailType");
				return;
			}
		}
	}

}
