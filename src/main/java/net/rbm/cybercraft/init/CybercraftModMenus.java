
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.rbm.cybercraft.init;

import net.rbm.cybercraft.world.inventory.CyberwareGuiMenu;
import net.rbm.cybercraft.CybercraftMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

public class CybercraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, CybercraftMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<CyberwareGuiMenu>> CYBERWARE_GUI = REGISTRY.register("cyberware_gui", () -> IMenuTypeExtension.create(CyberwareGuiMenu::new));
}
