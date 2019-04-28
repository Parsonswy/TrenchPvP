package net.peacefulcraft.trenchpvp.gameclasses.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.peacefulcraft.trenchpvp.gameclasses.classConfigurations.TrenchKits;
import net.peacefulcraft.trenchpvp.gamehande.TeamManager;
import net.peacefulcraft.trenchpvp.gamehande.player.TrenchPlayer;
import net.peacefulcraft.trenchpvp.gamehande.player.TrenchTeams;

public class SugarRushListener implements Listener
{
	@EventHandler
	public void onrightClick(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		//Checks item in main hand is Shell
		if(!(p.getInventory().getItemInMainHand().getType() == Material.SUGAR)) return;
		if(!(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Sugar Rush"))) return;
		
		TrenchPlayer t = TeamManager.findTrenchPlayer(p);
		if(t == null) { return; }
		
		if(!(t.getKitType() == TrenchKits.SPY)) return;
	
		//TODO: FIX?
		//SugarRush sugar = new SugarRush();
		//sugar.updateClick();
		//if(!(System.currentTimeMillis() >= (sugar.getClick() + 10000))) return;
	
		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6, 3));
		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 4, 2));
		
	}
}
