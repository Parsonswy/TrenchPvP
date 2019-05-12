package net.peacefulcraft.trenchpvp.gamehandle.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import net.peacefulcraft.trenchpvp.gamehande.TeamManager;
import net.peacefulcraft.trenchpvp.gamehande.player.Teleports;
import net.peacefulcraft.trenchpvp.gamehande.player.TrenchPlayer;
import net.peacefulcraft.trenchpvp.gamehande.player.TrenchTeams;

public class PlayerRespawning implements Listener{

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		
			TrenchPlayer t = TeamManager.findTrenchPlayer(e.getPlayer());
			if(t == null)
				return;
			
			//Reset kit
			t.equipKit(t.getKit());
			
			//Teleport player
			if(t.getPlayerTeam() == TrenchTeams.BLUE) {
				e.setRespawnLocation(Teleports.getBlueSpawn());
			}else {
				e.setRespawnLocation(Teleports.getRedSpawn());
			}
			
			return;
			
	}
	
}
