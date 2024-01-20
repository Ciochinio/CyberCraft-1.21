
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.rbm.cybercraft.init;

import net.rbm.cybercraft.potion.ReducedFallDamageMobEffect;
import net.rbm.cybercraft.potion.HealCooldownMobEffect;
import net.rbm.cybercraft.potion.EnemyNearbyMobEffect;
import net.rbm.cybercraft.CybercraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class CybercraftModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CybercraftMod.MODID);
	public static final RegistryObject<MobEffect> REDUCED_FALL_DAMAGE = REGISTRY.register("reduced_fall_damage", () -> new ReducedFallDamageMobEffect());
	public static final RegistryObject<MobEffect> ENEMY_NEARBY = REGISTRY.register("enemy_nearby", () -> new EnemyNearbyMobEffect());
	public static final RegistryObject<MobEffect> HEAL_COOLDOWN = REGISTRY.register("heal_cooldown", () -> new HealCooldownMobEffect());
}
