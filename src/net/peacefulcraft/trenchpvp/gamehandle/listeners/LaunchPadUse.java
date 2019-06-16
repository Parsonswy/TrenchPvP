package net.peacefulcraft.trenchpvp.gamehandle.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import net.peacefulcraft.trenchpvp.gameclasses.classConfigurations.TrenchKits;
import net.peacefulcraft.trenchpvp.gamehandle.TeamManager;
import net.peacefulcraft.trenchpvp.gamehandle.player.TrenchPlayer;

public class LaunchPadUse implements Listener
{
	@EventHandler
	private void LaunchPadLaunch(PlayerInteractEvent e) {
		if(e.getPlayer().getGameMode() != GameMode.ADVENTURE) { return; }
		
		TrenchPlayer t = TeamManager.findTrenchPlayer(e.getPlayer());
		if(t == null) { return; }
		
		if(t.getKitType() == TrenchKits.UNASSIGNED) { return; }
		if(!(e.getAction().equals(Action.PHYSICAL))) { return; }
		
		Player p = e.getPlayer();
		if(e.getClickedBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
			Vector v = new Vector(p.getVelocity().getX(), p.getVelocity().getY(), p.getVelocity().getZ());
			Vector forward = p.getLocation().getDirection().multiply(2.5);
			Vector jump = p.getLocation().getDirection().multiply(1.5).setY(1);
			
			v.add(forward).add(jump);
			p.setVelocity(v);
		}
		return;
	}
}
