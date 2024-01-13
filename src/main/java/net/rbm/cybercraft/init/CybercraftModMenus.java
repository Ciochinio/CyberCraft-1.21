
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.rbm.cybercraft.init;

import net.rbm.cybercraft.world.inventory.CyberwareGuiMenu;
import net.rbm.cybercraft.CybercraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class CybercraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, CybercraftMod.MODID);
	public static final RegistryObject<MenuType<CyberwareGuiMenu>> CYBERWARE_GUI = REGISTRY.register("cyberware_gui", () -> IForgeMenuType.create(CyberwareGuiMenu::new));
}
