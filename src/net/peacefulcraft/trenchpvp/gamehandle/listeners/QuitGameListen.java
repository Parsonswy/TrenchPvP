package net.peacefulcraft.trenchpvp.gamehandle.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import net.peacefulcraft.trenchpvp.TrenchPvP;
import net.peacefulcraft.trenchpvp.gamehandle.TrenchPlayer;

public class QuitGameListen implements Listener {
	@EventHandler
	public void onQuitEvent(PlayerQuitEvent e){
		
		TrenchPlayer t = TrenchPvP.getTrenchManager().findTrenchPlayer(e.getPlayer());
		if(t == null)
			return;
		
		TrenchPvP.getTrenchManager().removePlayerFromGame(t.getPlayer());
		
	}
}
