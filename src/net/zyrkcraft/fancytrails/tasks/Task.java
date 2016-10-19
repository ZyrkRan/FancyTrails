package net.zyrkcraft.fancytrails.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import net.zyrkcraft.fancytrails.Plugin;
import net.zyrkcraft.fancytrails.trails.TrailManager;
import net.zyrkcraft.fancytrails.trails.TrailType;
import net.zyrkcraft.fancytrails.trails.trailObjects.TrailObjects;
import net.zyrkcraft.fancytrails.utils.DyeColor;
import net.zyrkcraft.fancytrails.utils.ItemUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Task implements Runnable{
	
	private Player player;
	private TrailType type;
	private Runnable task;
	
	Random random = new Random();
	private Vector[] vectors = { new Vector(0.125, 0.25, 0), new Vector(-0.125, 0.25, 0), new Vector(0, 0.25, 0.125), new Vector(0, 0.25, -0.125) };
	
	public Task(Player player, TrailType type){
		this.player = player;
		this.type = type;
	}
	
	public Player getOwner(){
		return player;
	}
	
	public TrailType getTrailType(){
		return type;
	}
	
	public Runnable getTaskRunnable(){
		return task;
	}
	
	public Random getRandom(){
		return random;
	}
	
	public Vector[] getVectors(){
		return vectors;
	}
	
	@Override
	public void run() {
		List<ItemStack> itemlist = new ArrayList<ItemStack>();
		
		switch(getTrailType()){

		case DIAMOND:
			itemlist.add(new ItemStack(Material.DIAMOND));
			break;
		case GOLD_INGOTS:
			itemlist.add(new ItemStack(Material.GOLD_INGOT));
			break;
		case IRON_INGOTS:
			itemlist.add(new ItemStack(Material.IRON_INGOT));
			break;
		case EMERALDS:
			itemlist.add(new ItemStack(Material.EMERALD));
			break;
		case REDSTONE:
			itemlist.add(new ItemStack(Material.REDSTONE));
			break;
		case LAPIS_LAZULI:
			itemlist.add(new ItemStack(Material.INK_SACK, 1, DyeColor.BLUE));
			break;
		case WOOL:
			itemlist.add(new ItemStack(Material.WOOL));
			break;
		case MAKE_IT_RAIN:
			for (ItemStack item : TrailObjects.MAKE_IT_RAIN){
				itemlist.add(item);
			}
			break;
		case RAINBOW_WOOL:
			for (ItemStack item : TrailObjects.RAINBOW_WOOL){
				itemlist.add(item);
			}
			break;
		case COLORED_DYE:
			for (ItemStack item : TrailObjects.COLORED_DYE){
				itemlist.add(item);
			}
			break;
		case RAINBOW_CARPET:
			for (ItemStack item : TrailObjects.RAINBOW_CARPET){
				itemlist.add(item);
			}
			break;
		case RAINBOW_GLASS:
			for (ItemStack item : TrailObjects.RAINBOW_GLASS){
				itemlist.add(item);
			}
			break;
		case BACON:
			itemlist.add(new ItemStack(Material.PORK));
			break;
		case CUSTOM:
			for (String s : Plugin.getInstance().getConfig().getStringList("custom-trail")){
				ItemStack i = new ItemStack(Material.valueOf(s));
				itemlist.add(i);
			}
			break;
		default:
			Bukkit.broadcastMessage(ChatColor.RED + "Something went wrong when selecting a trail type");
			return;
		}
		
		Item item = getOwner().getWorld().dropItem(getOwner().getLocation().add(0,2,0), ItemUtils.createItemWithNameAndLore(itemlist.get(getRandom().nextInt(itemlist.size())), UUID.randomUUID().toString(), "ENTITY_DROPPED"));
		item.setVelocity(getVectors()[getRandom().nextInt(getVectors().length)]);
		item.setPickupDelay(99999*99999);
		TrailManager.getDataManager().getTrailItems().add(item);
		TrailManager.getDataManager().getFloatingItems().put(getOwner().getUniqueId(), TrailManager.getDataManager().getTrailItems());
	
		for (int i=0; i < TrailManager.getDataManager().getFloatingItems().get(getOwner().getUniqueId()).size(); i++){
			if (TrailManager.getDataManager().getFloatingItems().get(getOwner().getUniqueId()).get(i).isOnGround()){
				TrailManager.getDataManager().getFloatingItems().get(getOwner().getUniqueId()).get(i).remove();
			}
		}	
	}
}
