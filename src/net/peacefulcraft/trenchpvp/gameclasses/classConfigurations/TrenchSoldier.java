package net.peacefulcraft.trenchpvp.gameclasses.classConfigurations;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.peacefulcraft.trenchpvp.gameclasses.abilities.Onslaught;
import net.peacefulcraft.trenchpvp.gameclasses.abilities.TrenchAbilityType;
import net.peacefulcraft.trenchpvp.gameclasses.abilities.Witherbringer;
import net.peacefulcraft.trenchpvp.gameclasses.abilities.WitherbringerBuddy;
import net.peacefulcraft.trenchpvp.gamehandle.player.TrenchPlayer;

public class TrenchSoldier extends TrenchKit{

	public TrenchSoldier(TrenchPlayer t) {
		super(t, TrenchKits.SOLDIER);

		//Register ability handlers
		WitherbringerBuddy witherEnforcer = new WitherbringerBuddy(this);
		getAbilityManager().registerAbility(TrenchAbilityType.PLAYER_INTERACT, new Witherbringer(this, witherEnforcer));
		getAbilityManager().registerAbility(TrenchAbilityType.ENTITY_DAMAGE_ENTITY, witherEnforcer);
		getAbilityManager().registerAbility(TrenchAbilityType.PLAYER_DEATH, new Onslaught(this));
	}

	@Override
	public void equipArmor() {
		ItemStack[] armor = new ItemStack[4];
		armor[3] = new ItemStack(Material.CHAINMAIL_HELMET, 1);

		armor[2] = new ItemStack(Material.IRON_CHESTPLATE, 1);
		armor[2].addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);

		armor[1] = new ItemStack(Material.LEATHER_LEGGINGS, 1);

		armor[0] = new ItemStack(Material.IRON_BOOTS, 1);
		armor[0].addEnchantment(Enchantment.PROTECTION_FALL, 1);
		this.getTrenchPlayer().getPlayer().getInventory().setArmorContents(armor);
	}

	@Override
	public void equipItems() {
		Inventory inv = this.getTrenchPlayer().getPlayer().getInventory();

		final String PRIMARY_NAME = "Witherbringer";
		final String SECONDARY_NAME = "Onslaught";
		
		addItemName(PRIMARY_NAME, 1);
		addItemName(SECONDARY_NAME, 2);		
		
		ItemStack primary = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta pMetaData = primary.getItemMeta();
		primary.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		pMetaData.setDisplayName(PRIMARY_NAME);

		ArrayList<String> pDesc = new ArrayList<String>();
		pDesc.add("Right Click to Activate The Wither Curse!");
		pDesc.add("Ability Time: 10 Seconds");
		pDesc.add("Cooldown Time: 25 Seconds");
		pMetaData.setLore(pDesc);

		primary.setItemMeta(pMetaData);

		inv.setItem(0, primary);

		ItemStack secondary = new ItemStack(Material.REDSTONE, 1);
		ItemMeta sMetaData = secondary.getItemMeta();
		sMetaData.setDisplayName(SECONDARY_NAME);

		ArrayList<String> sDesc = new ArrayList<String>();
		sDesc.add("Each Kill Adds the Blood of Your Enemies to Your Strength");
		sMetaData.setLore(sDesc);

		secondary.setItemMeta(sMetaData);

		inv.setItem(1, secondary);
	}
}
