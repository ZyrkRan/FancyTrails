package net.zyrkcraft.fancytrails.utils;

import java.util.ArrayList;
import java.util.List;

import net.zyrkcraft.fancytrails.Plugin;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemUtils implements Listener{
	
	public static ItemStack createItemWithName(ItemStack item, String name){
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Plugin.color(name));
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack createItemWithLore(ItemStack item, String... lore){
		ArrayList<String> list = new ArrayList<String>();
		ItemMeta meta = item.getItemMeta();
		for (String string : lore){
			list.add(Plugin.color(string));
		}
		meta.setLore(list);
		item.setItemMeta(meta);
		return item;
	}
	
    public static ItemStack createItemWithNameAndLore(final ItemStack item, final String name, final String... lore) {
        final ArrayList<String> list = new ArrayList<String>();
        final ItemMeta meta = item.getItemMeta();
        for (final String string : lore) {
            list.add(Plugin.color(string));
        }
        meta.setLore((List)list);
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        item.setItemMeta(meta);
        return item;
    }
	
	public static ItemStack enchantItem(ItemStack item, Enchantment paramEnchantment, int level){
		item.addEnchantment(paramEnchantment, level);
		return item;
	}
	
	public static ItemStack unSafeEnchantItem(ItemStack item, Enchantment paramEnchantment, int level){
		item.addUnsafeEnchantment(paramEnchantment, level);
		return item;
	}
	
	public static void setArmorColor(ItemStack item, Color color){
		LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
		meta.setColor(color);
		item.setItemMeta(meta);
	}
}
