package net.peacefulcraft.trenchpvp.gamehandle.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import net.md_5.bungee.api.ChatColor;
import net.peacefulcraft.trenchpvp.gameclasses.classConfigurations.TrenchKit;
import net.peacefulcraft.trenchpvp.gamehandle.Announcer;
import net.peacefulcraft.trenchpvp.gamehandle.TeamManager;
import net.peacefulcraft.trenchpvp.gamehandle.player.TrenchPlayer;

public class ItemSwitchListener implements Listener
{	
	private final String leftPrefix = ChatColor.DARK_RED + "[" + ChatColor.DARK_BLUE + "Left Click" + ChatColor.DARK_RED + "]: ";
		private String getLeftPrefix() {return leftPrefix;}
	private final String rightPrefix = ChatColor.DARK_RED + " :[" + ChatColor.DARK_BLUE + "Right Click" + ChatColor.DARK_RED + "]";
		private String getRightPrefix() {return rightPrefix;}
		
	@EventHandler
	public void switchEvent(PlayerItemHeldEvent e) {
		
		TrenchPlayer t = TeamManager.findTrenchPlayer(e.getPlayer());
		TrenchKit k = t.getKit();
		Player p = t.getPlayer();
		
		if(p.getInventory().getItemInMainHand().getType().equals(Material.AIR) || p.getInventory().getItemInMainHand().getType().equals(null)) {
			return;
		}
		int index = e.getNewSlot();
		if(k.getItemNamesSet().contains(p.getInventory().getItem(index).getItemMeta().getDisplayName())) {
			Announcer.messagePlayerActionBar(p, message(k, p.getInventory().getItem(index).getItemMeta().getDisplayName()));
		}
	}
	
	public String message(TrenchKit k, String name) {
		if(k.getItemNames().get(name) == 0) {
			return getLeftPrefix() + ChatColor.AQUA + name + ChatColor.WHITE + "  |  " + ChatColor.AQUA + "None" + getRightPrefix();
		} else if(k.getItemNames().get(name) == 1) {
			return getLeftPrefix() + ChatColor.AQUA + "None" + ChatColor.WHITE + "  |  " + ChatColor.AQUA + name + getRightPrefix();
		} else {
			return getLeftPrefix() + ChatColor.AQUA + "None" + ChatColor.WHITE + "  |  " + ChatColor.AQUA + "None" + getRightPrefix();
	
		}
	}
}