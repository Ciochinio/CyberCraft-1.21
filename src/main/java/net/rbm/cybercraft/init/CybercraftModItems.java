
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.rbm.cybercraft.init;

import net.rbm.cybercraft.item.ReinforcedTendonsItem;
import net.rbm.cybercraft.item.FortifiedAnklesItem;
import net.rbm.cybercraft.CybercraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

public class CybercraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CybercraftMod.MODID);
	public static final RegistryObject<Item> REINFORCED_TENDONS = REGISTRY.register("reinforced_tendons", () -> new ReinforcedTendonsItem());
	public static final RegistryObject<Item> FORTIFIED_ANKLES = REGISTRY.register("fortified_ankles", () -> new FortifiedAnklesItem());
}
