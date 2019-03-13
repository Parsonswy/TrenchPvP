package net.peacefulcraft.trenchpvp.gamehandle.specials;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import net.peacefulcraft.trenchpvp.TrenchPvP;
import net.peacefulcraft.trenchpvp.gameclasses.classConfigurations.TrenchDemoman;
import net.peacefulcraft.trenchpvp.gameclasses.classConfigurations.TrenchHeavy;
import net.peacefulcraft.trenchpvp.gameclasses.classConfigurations.TrenchKits;
import net.peacefulcraft.trenchpvp.gameclasses.classConfigurations.TrenchMedic;
import net.peacefulcraft.trenchpvp.gameclasses.classConfigurations.TrenchSniper;
import net.peacefulcraft.trenchpvp.gamehande.TeamManager;
import net.peacefulcraft.trenchpvp.gamehande.player.TrenchPlayer;
import net.peacefulcraft.trenchpvp.gamehande.player.TrenchTeams;

public class KitSignListener implements Listener {
	
	@EventHandler
	public void onSignClick(PlayerInteractEvent e) {
		
		if(e.getClickedBlock() == null){return;}
		
		if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.WALL_SIGN){
			
			Block block = e.getClickedBlock();
			Sign sign = (Sign)block.getState();
			
			if(sign.getLine(0).equalsIgnoreCase("[Class]")){
				
				if(sign.getLine(1).equalsIgnoreCase("Trench")){
					
					if(sign.getLine(2) != null){
						
						TrenchPlayer t;
						try {
							
							t = TeamManager.findTrenchPlayer(e.getPlayer());
							
						}catch(RuntimeException x) {
							
							e.getPlayer().sendMessage(TrenchPvP.CMD_PREFIX + ChatColor.RED + " You must bne playing TrenchPvP to use this sign!");
							return;
							
						}
						
						String signText = sign.getLine(2).toUpperCase();
						switch(TrenchKits.valueOf(signText)){//Check which class was selected (based on 3rd line of class sign)
						case SCOUT:
						case SOLDIER:
						case PYRO:
						case DEMOMAN:
							
							if(TrenchPvP.getTrenchCFG().isDemomanEnabled()){
								
								t.equipKit(new TrenchDemoman());
								return;
							
							}else
							
							e.getPlayer().sendMessage("Sorry, the Demoman class is currently not avalible for use. Please select another class.");
							return;
							
						case HEAVY:
							if(TrenchPvP.getTrenchCFG().isHeavyEnabled()){
							
								t.equipKit(new TrenchHeavy());
								return;
							
							}
							
							e.getPlayer().sendMessage("Sorry, the Heavy class is currently not avalible for use. Please select another class.");
							return;
							
						case SNIPER:
							
							if(TrenchPvP.getTrenchCFG().isSniperEnabled()){
								
								t.equipKit(new TrenchSniper());
								return;
							
							}
							
							e.getPlayer().sendMessage("Sorry, the Sniper class is currently not avalible for use. Please select another class.");
							return;
							
						case MEDIC:
							if(TrenchPvP.getTrenchCFG().isMedicEnabled()){
								
								t.equipKit(new TrenchMedic());
								return;
							}
							
							e.getPlayer().sendMessage("Sorry, the Medic class is currently not avalible for use. Please select another class");
							return;
							
						case SPY:
							
						default:
							
						}
						
						e.getPlayer().sendMessage("You are now type " + t.getKitType());
						
					}
				
				}
			
			}
		
		}
	
	}
	
}
