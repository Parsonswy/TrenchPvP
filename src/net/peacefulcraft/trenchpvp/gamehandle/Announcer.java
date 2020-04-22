package net.peacefulcraft.trenchpvp.gamehandle;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.peacefulcraft.trenchpvp.TrenchPvP;

public abstract class Announcer {
	
	private static final String trench_prefix = ChatColor.DARK_RED  + "[" + ChatColor.RED + "Trench" + ChatColor.DARK_RED + "]";
		public static String getTrenchPrefix() { return trench_prefix; }
		
	public static void messageDeniedPermission(CommandSender cs) {
		cs.sendMessage(trench_prefix + ChatColor.RESET + " You do not have permission to use this command!");
	}
	
	public static void messagePlayer(CommandSender cs, String message) {
		cs.sendMessage(trench_prefix + ChatColor.RESET + ChatColor.GRAY + " " + message);
	}
	
	public static void messagePlayerActionBar(Player p, String message) {
		(new ActionBarMessage(1, p, message)).runTaskTimer(TrenchPvP.getPluginInstance(), 0L, 20L);
	}
	
	private static class ActionBarMessage extends BukkitRunnable {
		private int seconds;
		private Player p;
		private String message;
		
		public ActionBarMessage(int seconds, Player p, String message) {
			this.seconds = seconds;
			this.p = p;
			this.message = message;
		}
		
		@Override
		public void run() {
			BaseComponent base = new TextComponent(message);
			base.setColor(ChatColor.RED);
			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, base);
			
			seconds--;
			if(seconds<1) {
				this.cancel();
			}
		}
	}
		
	public static void messageAll(String message) {
		messageTarget(message, null);
	}
	
	public static void messageRedTeam(String message) {
		messageTarget(message, TrenchTeam.RED);
	}
	
	public static void messageBlueTeam(String message) {
		messageTarget(message, TrenchTeam.BLUE);
	}
	
	private static void messageTarget(String message, TrenchTeam team) {
		TrenchPvP.getTrenchManager().getCurrentArena().executeOnAllPlayers(
			(TrenchPlayer t) -> {
				if(team == null || t.getPlayerTeam() == team)
					t.getPlayer().sendMessage(trench_prefix + ChatColor.RESET + " " + message);
			}
		);
	}

}
