package net.peacefulcraft.trenchpvp.gameclasses.classConfigurations;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.peacefulcraft.trenchpvp.gameclasses.abilities.ArmadilloShell;
import net.peacefulcraft.trenchpvp.gameclasses.abilities.DenseAxe;
import net.peacefulcraft.trenchpvp.gamehandle.player.TrenchPlayer;

public class TrenchHeavy extends TrenchKit{
	
	
	public TrenchHeavy(TrenchPlayer t) {
		super(t, TrenchKits.HEAVY);
		
		//Register special ability handlers
		registerAbility(new DenseAxe(this));
		registerAbility(new ArmadilloShell(this));
	}

	@Override
	public void equipItems() {
		
		Inventory inv = this.getTrenchPlayer().getPlayer().getInventory();
		
		/*
		 * Primary
		 * Heavy - Dense Axe - Slows player and increases attack
		 */
		ItemStack primary = new ItemStack(Material.IRON_AXE, 1);
		
		ItemMeta pMetaData = primary.getItemMeta();
		pMetaData.setDisplayName("Dense Axe");
		
		
		ArrayList<String> pDesc = new ArrayList<String>();
		pDesc.add("Right Click to Increase Attack!");
		pDesc.add("Ability Time: 4 Seconds");
		pDesc.add("Cooldwon Time: 8 Seconds");
		
		pMetaData.setLore(pDesc);
		
		primary.setItemMeta(pMetaData);
		
		
		/*
		 * Secondary
		 * Heavy - Armadillo Shell - Slows, fatigues player increase defense
		 */
		ItemStack secondary = new ItemStack(Material.SHULKER_SHELL, 1);
		
		ItemMeta sMetaData = secondary.getItemMeta();
		sMetaData.setDisplayName("Armadillo Shell");
		
		ArrayList<String> sDesc = new ArrayList<String>();
		sDesc.add("Right Click to Engage Defensive Shell!");
		sDesc.add("Ability Time: 7 Seconds");
		sDesc.add("Cooldown Time: 14 Seconds");
		sMetaData.setLore(sDesc);
		
		secondary.setItemMeta(sMetaData);

		inv.setItem(0, primary);
		inv.setItem(1, secondary);
	}
	
	/*
	 * Armor Set:
	 * Iron Helmet
	 * Iron Chestplate : Projectile Protection 1
	 * Leather Leggings
	 * Leather Boots
	 */
	@Override
	public void equipArmor() {
		
		Player p = this.getTrenchPlayer().getPlayer();
		
		ItemStack[] armor = new ItemStack[4];
		armor[3] = new ItemStack(Material.IRON_HELMET,1);
		
		armor[2] = new ItemStack(Material.IRON_CHESTPLATE,1);
		
		armor[1] = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		
		armor[0] = new ItemStack(Material.LEATHER_BOOTS, 1);
		
		ItemMeta enchantMeta = armor[2].getItemMeta();
		enchantMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
		armor[2].setItemMeta(enchantMeta);
		
		p.getInventory().setArmorContents(armor);
		
	}

}
