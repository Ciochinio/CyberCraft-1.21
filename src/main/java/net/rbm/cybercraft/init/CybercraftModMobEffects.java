
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.rbm.cybercraft.init;

import net.rbm.cybercraft.potion.ThreatevacActivationThresholdMobEffect;
import net.rbm.cybercraft.potion.TestinstanthealcdMobEffect;
import net.rbm.cybercraft.potion.SecondHeartCooldownMobEffect;
import net.rbm.cybercraft.potion.RegenTestPlus5MobEffect;
import net.rbm.cybercraft.potion.ReducedFallDamageMobEffect;
import net.rbm.cybercraft.potion.RangeguardActivationMobEffect;
import net.rbm.cybercraft.potion.ProxishieldActivationMobEffect;
import net.rbm.cybercraft.potion.PassiveHealthRegenMobEffect;
import net.rbm.cybercraft.potion.HealCooldownMobEffect;
import net.rbm.cybercraft.potion.EnemyNearbyMobEffect;
import net.rbm.cybercraft.potion.ChemicalDOTMobEffect;
import net.rbm.cybercraft.potion.ChemicalDOTCooldownMobEffect;
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
	public static final RegistryObject<MobEffect> THREATEVAC_ACTIVATION_THRESHOLD = REGISTRY.register("threatevac_activation_threshold", () -> new ThreatevacActivationThresholdMobEffect());
	public static final RegistryObject<MobEffect> PROXISHIELD_ACTIVATION = REGISTRY.register("proxishield_activation", () -> new ProxishieldActivationMobEffect());
	public static final RegistryObject<MobEffect> RANGEGUARD_ACTIVATION = REGISTRY.register("rangeguard_activation", () -> new RangeguardActivationMobEffect());
	public static final RegistryObject<MobEffect> REGEN_TEST_PLUS_5 = REGISTRY.register("regen_test_plus_5", () -> new RegenTestPlus5MobEffect());
	public static final RegistryObject<MobEffect> PASSIVE_HEALTH_REGEN = REGISTRY.register("passive_health_regen", () -> new PassiveHealthRegenMobEffect());
	public static final RegistryObject<MobEffect> TESTINSTANTHEALCD = REGISTRY.register("testinstanthealcd", () -> new TestinstanthealcdMobEffect());
	public static final RegistryObject<MobEffect> SECOND_HEART_COOLDOWN = REGISTRY.register("second_heart_cooldown", () -> new SecondHeartCooldownMobEffect());
	public static final RegistryObject<MobEffect> CHEMICAL_DOT = REGISTRY.register("chemical_dot", () -> new ChemicalDOTMobEffect());
	public static final RegistryObject<MobEffect> CHEMICAL_DOT_COOLDOWN = REGISTRY.register("chemical_dot_cooldown", () -> new ChemicalDOTCooldownMobEffect());
}
