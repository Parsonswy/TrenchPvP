package net.peacefulcraft.trenchpvp.gamehandle.tasks;

import org.bukkit.scheduler.BukkitRunnable;

import net.peacefulcraft.trenchpvp.gamehande.GameManager;

public class Endgame extends BukkitRunnable{

	@Override
	public void run() {
		GameManager.endGame();		
	}

}
