package net.peacefulcraft.trenchpvp.gamehandle.listeners;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import net.peacefulcraft.trenchpvp.gamehande.Announcer;
import net.peacefulcraft.trenchpvp.gamehande.GameManager;
import net.peacefulcraft.trenchpvp.gamehande.TeamManager;
import net.peacefulcraft.trenchpvp.gamehande.player.TrenchPlayer;

public class LeaveGameSign implements Listener {

	@EventHandler
	public void onSignClick(PlayerInteractEvent e) {
		
		if(e.getClickedBlock() == null) { return; }
		
		if(e.getClickedBlock().getType() != Material.OAK_SIGN && e.getClickedBlock().getType() != Material.OAK_WALL_SIGN) { return; }
		
		Sign sign = (Sign) e.getClickedBlock().getState();
		
		if(sign.getLine(0).equalsIgnoreCase("[Trench]")) {
			if(sign.getLine(1).equalsIgnoreCase("Leave")) {
				
				TrenchPlayer t = TeamManager.findTrenchPlayer(e.getPlayer());
				if(t == null) { 
					Announcer.messagePlayer(e.getPlayer(), "You must be playing TrenchPvP before you can leave TrenchPvP.");
					return;
				}
				
				GameManager.quitPlayer(e.getPlayer());
			}
		}
		
	}
	
}
