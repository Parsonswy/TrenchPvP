package net.peacefulcraft.trenchpvp.gamehandle.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import net.peacefulcraft.trenchpvp.gameclasses.classConfigurations.TrenchKits;
import net.peacefulcraft.trenchpvp.gamehandle.TeamManager;
import net.peacefulcraft.trenchpvp.gamehandle.player.TrenchPlayer;

public class LaunchPadUse implements Listener
{
	@EventHandler
	private void LaunchPadLaunch(PlayerMoveEvent e) {
		if(e.getPlayer().getGameMode() != GameMode.ADVENTURE) { return; }
		
		TrenchPlayer t = TeamManager.findTrenchPlayer(e.getPlayer());
		if(t == null) { return; }
		
		if(t.getKitType() == TrenchKits.UNASSIGNED) { return; }
		
		Player p = e.getPlayer();
		if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
			Vector v = new Vector(p.getVelocity().getX(), p.getVelocity().getY(), p.getVelocity().getZ());
			Vector forward = p.getLocation().getDirection().multiply(0.6);
			Vector jump = p.getLocation().getDirection().multiply(0.05).setY(1);
			
			v.add(forward).add(jump);
			p.setVelocity(v);
		}
		return;
	}
}
