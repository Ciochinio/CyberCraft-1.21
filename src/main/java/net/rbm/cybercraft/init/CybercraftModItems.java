
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.rbm.cybercraft.init;

import net.rbm.cybercraft.item.SubdermalArmorItem;
import net.rbm.cybercraft.item.ReinforcedTendonsItem;
import net.rbm.cybercraft.item.RangeguardItem;
import net.rbm.cybercraft.item.ProxishieldItem;
import net.rbm.cybercraft.item.PainducerItem;
import net.rbm.cybercraft.item.PainEditorItem;
import net.rbm.cybercraft.item.NanoPlatingItem;
import net.rbm.cybercraft.item.LynxPawsItem;
import net.rbm.cybercraft.item.LeeroyLigamentSystemItem;
import net.rbm.cybercraft.item.FortifiedAnklesItem;
import net.rbm.cybercraft.item.CountershellItem;
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
}
