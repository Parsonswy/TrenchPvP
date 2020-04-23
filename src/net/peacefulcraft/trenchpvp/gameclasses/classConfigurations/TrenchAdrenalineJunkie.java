package net.peacefulcraft.trenchpvp.gameclasses.classConfigurations;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.peacefulcraft.trenchpvp.gameclasses.abilities.LaunchPad;
import net.peacefulcraft.trenchpvp.gameclasses.abilities.SyrumHigh;
import net.peacefulcraft.trenchpvp.gameclasses.abilities.TrenchAbilityType;
import net.peacefulcraft.trenchpvp.gamehandle.player.TrenchPlayer;

public class TrenchAdrenalineJunkie extends TrenchKit
{

	public TrenchAdrenalineJunkie(TrenchPlayer t)
	{
		super(t, TrenchKits.ADRENALINE_JUNKIE);
		
		//Register special ability handlers
		getAbilityManager().registerAbility(TrenchAbilityType.PLAYER_INTERACT, new LaunchPad(this));
		getAbilityManager().registerAbility(TrenchAbilityType.PLAYER_INTERACT, new SyrumHigh(this));
		
	}

	@Override
	public void equipItems()
	{
		Inventory inv = this.getTrenchPlayer().getPlayer().getInventory();
		
		final String MELEE_NAME = "The Bird";
		final String PRIMARY_NAME = "Syrum High";
		final String SECONDARY_NAME = "Launch Pad";
		
		addItemName(MELEE_NAME, 2);
		addItemName(PRIMARY_NAME, 1);
		addItemName(SECONDARY_NAME, 1);		
		
		//Melee Weapon
		ItemStack melee = new ItemStack(Material.IRON_SWORD, 1);
		
		ItemMeta meleeMeta = melee.getItemMeta();
		meleeMeta.setDisplayName(MELEE_NAME);
		
		ArrayList<String> mDesc = new ArrayList<String>();
		mDesc.add("Flip 'em The Bird!");
		meleeMeta.setLore(mDesc);
		meleeMeta.setUnbreakable(true);
		melee.setItemMeta(meleeMeta);
		
		//Primary Ability
		ItemStack primary = new ItemStack(Material.GLASS_BOTTLE, 1);
		
		ItemMeta pMeta = primary.getItemMeta();
		pMeta.setDisplayName(PRIMARY_NAME);
		
		ArrayList<String> pDesc = new ArrayList<String>();
		pDesc.add("Right Click to Inject the Syrum!");
		pDesc.add("Ability Time: 15 Seconds");
		pDesc.add("Cooldown Time: 25 Seconds");
		pMeta.setLore(pDesc);
		
		primary.setItemMeta(pMeta);
		
		//Secondary Ability
		ItemStack secondary = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE, 1);
		
		ItemMeta sMeta = secondary.getItemMeta();
		sMeta.setDisplayName(SECONDARY_NAME);
		
		ArrayList<String> sDesc = new ArrayList<String>();
		sDesc.add("Right Click the Ground to Place a Launch Pad!");
		sDesc.add("Ability Time: 15 Seconds");
		sDesc.add("Cooldown Time: 30 Seconds");
		sMeta.setLore(sDesc);
		
		secondary.setItemMeta(sMeta);
		
		inv.setItem(0, melee);
		inv.setItem(1, primary);
		inv.setItem(2, secondary);
		
	}

	@Override
	public void equipArmor()
	{
		Player p = this.getTrenchPlayer().getPlayer();
		
		ItemStack[] armor = new ItemStack[4];
		armor[3] = new ItemStack(Material.LEATHER_HELMET, 1);
		
		armor[2] = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		
		armor[1] = new ItemStack(Material.IRON_LEGGINGS, 1);
		
		armor[0] = new ItemStack(Material.LEATHER_BOOTS, 1);
		
		LeatherArmorMeta metaH = (LeatherArmorMeta) armor[3].getItemMeta();
		metaH.setColor(Color.LIME);
		armor[3].setItemMeta(metaH);
		LeatherArmorMeta metaC = (LeatherArmorMeta) armor[2].getItemMeta();
		metaC.setColor(Color.GREEN);
		armor[2].setItemMeta(metaC);
		LeatherArmorMeta metaB = (LeatherArmorMeta) armor[0].getItemMeta();
		metaB.setColor(Color.BLACK);
		armor[0].setItemMeta(metaB);
		
		ItemMeta MetaH = armor[3].getItemMeta();
		MetaH.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 2, true);
		MetaH.setUnbreakable(true);
		armor[3].setItemMeta(MetaH);	
		
		ItemMeta MetaC = armor[2].getItemMeta();
		MetaC.addEnchant(Enchantment.THORNS, 2, true);
		MetaC.setUnbreakable(true);
		armor[2].setItemMeta(MetaC);

		ItemMeta MetaL = armor[1].getItemMeta();
		MetaL.setUnbreakable(true);
		armor[1].setItemMeta(MetaL);
		
		ItemMeta MetaB = armor[0].getItemMeta();
		MetaB.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
		MetaB.setUnbreakable(true);
		armor[0].setItemMeta(MetaB);
		
		p.getInventory().setArmorContents(armor);
		
	}
	
}
