
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.rbm.cybercraft.init;

import net.rbm.cybercraft.CybercraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class CybercraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CybercraftMod.MODID);
	public static final RegistryObject<CreativeModeTab> CYBER_CRAFT_TAB = REGISTRY.register("cyber_craft_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.cybercraft.cyber_craft_tab")).icon(() -> new ItemStack(Blocks.REDSTONE_TORCH)).displayItems((parameters, tabData) -> {
				tabData.accept(CybercraftModItems.REINFORCED_TENDONS.get());
				tabData.accept(CybercraftModItems.FORTIFIED_ANKLES.get());
				tabData.accept(CybercraftModItems.LYNX_PAWS.get());
				tabData.accept(CybercraftModItems.LEEROY_LIGAMENT_SYSTEM.get());
				tabData.accept(CybercraftModItems.NANO_PLATING.get());
				tabData.accept(CybercraftModItems.PAINDUCER.get());
				tabData.accept(CybercraftModItems.COUNTERSHELL.get());
				tabData.accept(CybercraftModItems.PAIN_EDITOR.get());
				tabData.accept(CybercraftModItems.PROXISHIELD.get());
				tabData.accept(CybercraftModItems.RANGEGUARD.get());
				tabData.accept(CybercraftModItems.SUBDERMAL_ARMOR.get());
				tabData.accept(CybercraftModItems.CHITIN.get());
				tabData.accept(CybercraftModItems.SHOCK_N_AWE.get());
				tabData.accept(CybercraftModItems.THREATEVAC.get());
			})

					.build());
}
