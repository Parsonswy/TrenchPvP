package net.peacefulcraft.trenchpvp.gameclasses.classConfigurations;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.peacefulcraft.trenchpvp.gameclasses.abilities.Flamethrower;
import net.peacefulcraft.trenchpvp.gameclasses.abilities.InfernoTrapDetonator;
import net.peacefulcraft.trenchpvp.gameclasses.abilities.InfernoTrapPlacer;
import net.peacefulcraft.trenchpvp.gameclasses.abilities.InfernoTrapRemover;
import net.peacefulcraft.trenchpvp.gameclasses.abilities.TrenchAbilityType;
import net.peacefulcraft.trenchpvp.gamehandle.player.TrenchPlayer;

public class TrenchPyro extends TrenchKit{

	private TrenchPlayer t;
	private TrenchKits k = TrenchKits.PYRO;
		public TrenchKits getKitType() { return k; }

	
	public ArrayList<Location> infernoTraps;
		public ArrayList<Location> getInfernoTraps() { return infernoTraps; }
		public void resetInfernoTraps(){ infernoTraps = new ArrayList<Location>(); }
	public InfernoTrapRemover infernoTrapRemover;
		
	public TrenchPyro(TrenchPlayer t) {
		super(t, TrenchKits.PYRO);
		this.t = t;

		infernoTraps = new ArrayList<Location>();
		
		//Register special ability handlers
		infernoTrapRemover = new InfernoTrapRemover(this);
		getAbilityManager().registerAbility(TrenchAbilityType.PLAYER_INTERACT, new Flamethrower(this));
		getAbilityManager().registerAbility(TrenchAbilityType.PLAYER_INTERACT, new InfernoTrapPlacer(this));
		getAbilityManager().registerAbility(TrenchAbilityType.PLAYER_INTERACT, new InfernoTrapDetonator(this));
		getAbilityManager().registerAbility(TrenchAbilityType.PLAYER_DEATH, infernoTrapRemover);
	}

	@Override
	public void dinitConfig() {
		infernoTrapRemover.removeInfernoTraps();
	}
	
	@Override
	public void equipArmor() {

		ItemStack[] armor = new ItemStack[4];
		armor[3] = new ItemStack(Material.IRON_HELMET,1);

		armor[2] = new ItemStack(Material.LEATHER_CHESTPLATE,1);
		armor[2].addEnchantment(Enchantment.PROTECTION_FIRE, 2);

		armor[1] = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		armor[1].addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1);

		armor[0] = new ItemStack(Material.LEATHER_BOOTS, 1);

		ItemMeta metaH = armor[3].getItemMeta();
		metaH.setUnbreakable(true);
		armor[3].setItemMeta(metaH);

		ItemMeta metaC = armor[2].getItemMeta();
		metaC.setUnbreakable(true);
		armor[2].setItemMeta(metaC);

		ItemMeta metaL = armor[1].getItemMeta();
		metaL.setUnbreakable(true);
		armor[1].setItemMeta(metaL);

		ItemMeta metaB = armor[0].getItemMeta();
		metaB.setUnbreakable(true);
		armor[0].setItemMeta(metaB);
		
		t.getPlayer().getInventory().setArmorContents(armor);

	}

	@Override
	public void equipItems() {
		
		//Remove all Inferno Traps from old kit if it exists
		infernoTrapRemover.removeInfernoTraps();
		
		Inventory inv = t.getPlayer().getInventory();
		
		final String MELEE_NAME = "Nether's Bite";
		final String PRIMARY_NAME = "Flamethrower";
		final String SECONDARY_NAME = "Inferno Trap Detonator";
		final String SECONDARYUTIL_NAME = "Inferno Trap";
		
		addItemName(MELEE_NAME, 2);
		addItemName(PRIMARY_NAME, 1);
		addItemName(SECONDARY_NAME, 1);	
		addItemName(SECONDARYUTIL_NAME, 1);

		ItemStack primary = new ItemStack(Material.GOLDEN_AXE);
		ItemMeta pMetaData = primary.getItemMeta();
		pMetaData.setUnbreakable(true);
		pMetaData.setDisplayName(MELEE_NAME);

		ArrayList<String> pDesc = new ArrayList<String>();
		pDesc.add("Just a Sharp Axe.");
		pMetaData.setLore(pDesc);

		primary.setItemMeta(pMetaData);

		ItemStack pUtil = new ItemStack(Material.BLAZE_ROD);
		ItemMeta pUMeta = pUtil.getItemMeta();
		pUMeta.setDisplayName(PRIMARY_NAME);

		ArrayList<String> pUDesc = new ArrayList<String>();
		pUDesc.add("Right Click to Shoot Flames!");
		pUMeta.setLore(pUDesc);

		pUtil.setItemMeta(pUMeta);

		inv.setItem(0, primary);
		inv.setItem(1, pUtil);

		/**
		 * Equip Inferno trap
		 */
		ItemStack secondary = new ItemStack(Material.TRIPWIRE_HOOK, 1);
		ItemMeta sMeta = secondary.getItemMeta();
		sMeta.setDisplayName(SECONDARY_NAME);

		ArrayList<String> sDesc = new ArrayList<String>();
		sDesc.add("Right Click to Detonate Inferno Traps!");
		sMeta.setLore(sDesc);

		secondary.setItemMeta(sMeta);

		ItemStack trapAmmo = new ItemStack(Material.LIGHT_WEIGHTED_PRESSURE_PLATE, 5);
		ItemMeta tAMeta = trapAmmo.getItemMeta();
		tAMeta.setDisplayName(SECONDARYUTIL_NAME);

		ArrayList<String> aDesc = new ArrayList<String>();
		aDesc.add("Can Only Place 5 at a Time! Detonate to Get More!");
		tAMeta.setLore(aDesc);

		trapAmmo.setItemMeta(tAMeta);

		inv.setItem(2, secondary);
		inv.setItem(3, trapAmmo);

	}

}
