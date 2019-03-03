package net.peacefulcraft.trenchpvp;

import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;

public class TrenchConfig {

	private FileConfiguration c;
	
	private boolean scoutEnabled = false;
	private boolean soldierEnabled = false;
	private boolean pyroEnabled = false;
	private boolean demomanEnabled = false;
	private boolean heavyEnabled = false;
	private boolean sniperEnabled = false;
	private boolean medicEnabled = false;
	private boolean spyEnabled = false;

	private Map<String, Object> quit_spawn;
	private Map<String, Object> red_spawn;
	private Map<String, Object> blue_spawn;
	private Map<String, Object> red_class_spawn;
	private Map<String, Object> blue_class_spawn;
	private Map<String, Object> spectator_spawn;
	
	public TrenchConfig(FileConfiguration c) {
		
		this.c = c;
		
		scoutEnabled = c.getBoolean("classes.scout");
		soldierEnabled = c.getBoolean("classes.soldier");
		pyroEnabled = c.getBoolean("classes.pyro");
		demomanEnabled = c.getBoolean("classes.demoman");
		heavyEnabled = c.getBoolean("classes.heavy");
		sniperEnabled = c.getBoolean("classes.sniper");
		medicEnabled = c.getBoolean("classes.medic");
		spyEnabled = c.getBoolean("classes.spy");
		
		quit_spawn = c.getConfigurationSection("trenchspawns.quit").getValues(false);
		red_spawn = c.getConfigurationSection("trenchspawns.quit").getValues(false);
		blue_spawn = c.getConfigurationSection("trenchspawns.quit").getValues(false);
		red_class_spawn = c.getConfigurationSection("trenchspawns.quit").getValues(false);
		blue_class_spawn = c.getConfigurationSection("trenchspawns.quit").getValues(false);
		spectator_spawn = c.getConfigurationSection("trenchspawns.quit").getValues(false);
	
	}

	public boolean isScoutEnabled() {
		return scoutEnabled;
	}

	public void setScoutEnabled(boolean scoutEnabled) {
		this.scoutEnabled = scoutEnabled;
		c.set("classes.scout", scoutEnabled);
	}

	public boolean isSoldierEnabled() {
		return soldierEnabled;
	}

	public void setSoldierEnabled(boolean soldierEnabled) {
		this.soldierEnabled = soldierEnabled;
		c.set("classes.soldier", soldierEnabled);
	}

	public boolean isPyroEnabled() {
		return pyroEnabled;
	}

	public void setPyroEnabled(boolean pyroEnabled) {
		this.pyroEnabled = pyroEnabled;
		c.set("classes.pyro", pyroEnabled);
	}

	public boolean isDemomanEnabled() {
		return demomanEnabled;
	}

	public void setDemomanEnabled(boolean demomanEnabled) {
		this.demomanEnabled = demomanEnabled;
		c.set("classes.demoman", demomanEnabled);
	}

	public boolean isHeavyEnabled() {
		return heavyEnabled;
	}

	public void setHeavyEnabled(boolean heavyEnabled) {
		this.heavyEnabled = heavyEnabled;
		c.set("classes.heavy", heavyEnabled);
	}

	public boolean isSniperEnabled() {
		return sniperEnabled;
	}

	public void setSniperEnabled(boolean sniperEnabled) {
		this.sniperEnabled = sniperEnabled;
		c.set("classes.sniper", sniperEnabled);
	}

	public boolean isMedicEnabled() {
		return medicEnabled;
	}

	public void setMedicEnabled(boolean medicEnabled) {
		this.medicEnabled = medicEnabled;
		c.set("classes.medic", medicEnabled);
	}

	public boolean isSpyEnabled() {
		return spyEnabled;
	}

	public void setSpyEnabled(boolean spyEnabled) {
		this.spyEnabled = spyEnabled;
		c.set("classes.spy", spyEnabled);
	}

	public Map<String, Object> getQuit_spawn() {
		return quit_spawn;
	}

	public void setQuit_spawn(Map<String, Object> quit_spawn) {
		this.quit_spawn = quit_spawn;
	}

	public Map<String, Object> getRed_spawn() {
		return red_spawn;
	}

	public void setRed_spawn(Map<String, Object> red_spawn) {
		this.red_spawn = red_spawn;
	}

	public Map<String, Object> getBlue_spawn() {
		return blue_spawn;
	}

	public void setBlue_spawn(Map<String, Object> blue_spawn) {
		this.blue_spawn = blue_spawn;
	}

	public Map<String, Object> getRed_class_spawn() {
		return red_class_spawn;
	}

	public void setRed_class_spawn(Map<String, Object> red_class_spawn) {
		this.red_class_spawn = red_class_spawn;
	}

	public Map<String, Object> getBlue_class_spawn() {
		return blue_class_spawn;
	}

	public void setBlue_class_spawn(Map<String, Object> blue_class_spawn) {
		this.blue_class_spawn = blue_class_spawn;
	}

	public Map<String, Object> getSpectator_spawn() {
		return spectator_spawn;
	}

	public void setSpectator_spawn(Map<String, Object> spectator_spawn) {
		this.spectator_spawn = spectator_spawn;
	}

}
