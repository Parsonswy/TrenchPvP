package net.peacefulcraft.trenchpvp.stats.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.peacefulcraft.trenchpvp.TrenchPvP;
import net.peacefulcraft.trenchpvp.gamehandle.TrenchPlayer;
import net.peacefulcraft.trenchpvp.stats.TrenchStats.GeneralStat;

public class FriendlykillListener implements Listener
{
	@EventHandler
	private void friendlyKill(PlayerDeathEvent e) {
		
		if( !(e.getEntity().getKiller() instanceof Player) ) { return; }
		
		Player agent = e.getEntity().getKiller();
		Player victim = e.getEntity();
		
		TrenchPlayer killer = TrenchPvP.getTrenchManager().findTrenchPlayer(agent);
		TrenchPlayer vic = TrenchPvP.getTrenchManager().findTrenchPlayer(victim);
		
		if(killer == null || vic == null) {
			return;
		}
		
		if(killer.getPlayerTeam() == vic.getPlayerTeam()) {
			TrenchPvP.getStatTracker().track(killer, GeneralStat.player_friendly_kills, 1);
		}
	}
}
