
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.rbm.cybercraft.init;

import net.rbm.cybercraft.item.TyrosineInjectorItem;
import net.rbm.cybercraft.item.ThreatevacItem;
import net.rbm.cybercraft.item.TestgunItem;
import net.rbm.cybercraft.item.SubdermalArmorItem;
import net.rbm.cybercraft.item.StabberItem;
import net.rbm.cybercraft.item.ShockNAweItem;
import net.rbm.cybercraft.item.SecondHeartItem;
import net.rbm.cybercraft.item.ReinforcedTendonsItem;
import net.rbm.cybercraft.item.RangeguardItem;
import net.rbm.cybercraft.item.ProxishieldItem;
import net.rbm.cybercraft.item.PainducerItem;
import net.rbm.cybercraft.item.PainEditorItem;
import net.rbm.cybercraft.item.NeofiberItem;
import net.rbm.cybercraft.item.NanoPlatingItem;
import net.rbm.cybercraft.item.MicrorotorsItem;
import net.rbm.cybercraft.item.LynxPawsItem;
import net.rbm.cybercraft.item.LeeroyLigamentSystemItem;
import net.rbm.cybercraft.item.IsometricStabilizerItem;
import net.rbm.cybercraft.item.HealOnKillItem;
import net.rbm.cybercraft.item.HandgunAmmoItem;
import net.rbm.cybercraft.item.FortifiedAnklesItem;
import net.rbm.cybercraft.item.DeepfieldVisualInterfaceItem;
import net.rbm.cybercraft.item.CountershellItem;
import net.rbm.cybercraft.item.ChitinItem;
import net.rbm.cybercraft.item.BlackMambaItem;
import net.rbm.cybercraft.item.BiomonitorItem;
import net.rbm.cybercraft.item.AtomicSensorsItem;
import net.rbm.cybercraft.item.AdrenalineConverterItem;
import net.rbm.cybercraft.item.AdrenalineBoosterItem;
import net.rbm.cybercraft.CybercraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

public class CybercraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CybercraftMod.MODID);
	public static final RegistryObject<Item> REINFORCED_TENDONS = REGISTRY.register("reinforced_tendons", () -> new ReinforcedTendonsItem());
	public static final RegistryObject<Item> FORTIFIED_ANKLES = REGISTRY.register("fortified_ankles", () -> new FortifiedAnklesItem());
	public static final RegistryObject<Item> LYNX_PAWS = REGISTRY.register("lynx_paws", () -> new LynxPawsItem());
	public static final RegistryObject<Item> LEEROY_LIGAMENT_SYSTEM = REGISTRY.register("leeroy_ligament_system", () -> new LeeroyLigamentSystemItem());
	public static final RegistryObject<Item> NANO_PLATING = REGISTRY.register("nano_plating", () -> new NanoPlatingItem());
	public static final RegistryObject<Item> PAINDUCER = REGISTRY.register("painducer", () -> new PainducerItem());
	public static final RegistryObject<Item> COUNTERSHELL = REGISTRY.register("countershell", () -> new CountershellItem());
	public static final RegistryObject<Item> PAIN_EDITOR = REGISTRY.register("pain_editor", () -> new PainEditorItem());
	public static final RegistryObject<Item> PROXISHIELD = REGISTRY.register("proxishield", () -> new ProxishieldItem());
	public static final RegistryObject<Item> RANGEGUARD = REGISTRY.register("rangeguard", () -> new RangeguardItem());
	public static final RegistryObject<Item> SUBDERMAL_ARMOR = REGISTRY.register("subdermal_armor", () -> new SubdermalArmorItem());
	public static final RegistryObject<Item> CHITIN = REGISTRY.register("chitin", () -> new ChitinItem());
	public static final RegistryObject<Item> SHOCK_N_AWE = REGISTRY.register("shock_n_awe", () -> new ShockNAweItem());
	public static final RegistryObject<Item> THREATEVAC = REGISTRY.register("threatevac", () -> new ThreatevacItem());
	public static final RegistryObject<Item> SECOND_HEART = REGISTRY.register("second_heart", () -> new SecondHeartItem());
	public static final RegistryObject<Item> MICROROTORS = REGISTRY.register("microrotors", () -> new MicrorotorsItem());
	public static final RegistryObject<Item> HEAL_ON_KILL = REGISTRY.register("heal_on_kill", () -> new HealOnKillItem());
	public static final RegistryObject<Item> ADRENALINE_BOOSTER = REGISTRY.register("adrenaline_booster", () -> new AdrenalineBoosterItem());
	public static final RegistryObject<Item> BLACK_MAMBA = REGISTRY.register("black_mamba", () -> new BlackMambaItem());
	public static final RegistryObject<Item> ISOMETRIC_STABILIZER = REGISTRY.register("isometric_stabilizer", () -> new IsometricStabilizerItem());
	public static final RegistryObject<Item> BIOMONITOR = REGISTRY.register("biomonitor", () -> new BiomonitorItem());
	public static final RegistryObject<Item> ADRENALINE_CONVERTER = REGISTRY.register("adrenaline_converter", () -> new AdrenalineConverterItem());
	public static final RegistryObject<Item> ATOMIC_SENSORS = REGISTRY.register("atomic_sensors", () -> new AtomicSensorsItem());
	public static final RegistryObject<Item> DEEPFIELD_VISUAL_INTERFACE = REGISTRY.register("deepfield_visual_interface", () -> new DeepfieldVisualInterfaceItem());
	public static final RegistryObject<Item> STABBER = REGISTRY.register("stabber", () -> new StabberItem());
	public static final RegistryObject<Item> NEOFIBER = REGISTRY.register("neofiber", () -> new NeofiberItem());
	public static final RegistryObject<Item> TYROSINE_INJECTOR = REGISTRY.register("tyrosine_injector", () -> new TyrosineInjectorItem());
	public static final RegistryObject<Item> TESTGUN = REGISTRY.register("testgun", () -> new TestgunItem());
	public static final RegistryObject<Item> HANDGUN_AMMO = REGISTRY.register("handgun_ammo", () -> new HandgunAmmoItem());
}
