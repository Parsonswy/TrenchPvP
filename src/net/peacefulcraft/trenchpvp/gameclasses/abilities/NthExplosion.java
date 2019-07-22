package net.peacefulcraft.trenchpvp.gameclasses.abilities;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import net.peacefulcraft.trenchpvp.gameclasses.classConfigurations.TrenchKit;
import net.peacefulcraft.trenchpvp.gamehandle.TeamManager;
import net.peacefulcraft.trenchpvp.gamehandle.player.TrenchPlayer;

public class NthExplosion extends TrenchAbility
{
	private TrenchKit k;
	
	public NthExplosion(TrenchKit k)
	{
		super(k.getTrenchPlayer(), 25000, "Nth Explosion");
		
		this.k=k;
	}

	@Override
	public boolean abilitySignature(Event ev)
	{
		Player p = k.getTrenchPlayer().getPlayer();
		
		if(!(p.getInventory().getItemInMainHand().getType() == Material.TNT)) { return false; }
		if(!(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Nth Explosion"))) { return false; }
		
		return true;
	}

	@Override
	public void triggerAbility(Event ev)
	{
		TrenchPlayer t = k.getTrenchPlayer();
		Player p = t.getPlayer();
		
		List<Entity> list = p.getNearbyEntities(7, 7, 7);
		for(Entity e : list) {
			if(e instanceof Player) {
				Player vic = (Player)e;
				if(TeamManager.findTrenchPlayer(vic).getPlayerTeam() != t.getPlayerTeam()) {
					Location loc = vic.getLocation();
					loc.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 3.0f, false, false);
				}
			}
		}
		
	}

}
