
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.rbm.cybercraft.init;

import net.rbm.cybercraft.potion.TyrosineInjectorActivationMobEffect;
import net.rbm.cybercraft.potion.ThreatevacActivationThresholdMobEffect;
import net.rbm.cybercraft.potion.StabberActivationMobEffect;
import net.rbm.cybercraft.potion.SecondHeartCooldownMobEffect;
import net.rbm.cybercraft.potion.RegenTestPlus5MobEffect;
import net.rbm.cybercraft.potion.ReducedFallDamageMobEffect;
import net.rbm.cybercraft.potion.RecoilLowMobEffect;
import net.rbm.cybercraft.potion.RecoilHighMobEffect;
import net.rbm.cybercraft.potion.RecentShotMobEffect;
import net.rbm.cybercraft.potion.RangeguardActivationMobEffect;
import net.rbm.cybercraft.potion.ProxishieldActivationMobEffect;
import net.rbm.cybercraft.potion.PassiveHealthRegenMobEffect;
import net.rbm.cybercraft.potion.HealCooldownMobEffect;
import net.rbm.cybercraft.potion.EnemyNearbyMobEffect;
import net.rbm.cybercraft.potion.DeepfieldVisualInterfaceActivationMobEffect;
import net.rbm.cybercraft.potion.CountershellMitigationChanceMobEffect;
import net.rbm.cybercraft.potion.ChemicalDOTMobEffect;
import net.rbm.cybercraft.potion.ChemicalDOTCooldownMobEffect;
import net.rbm.cybercraft.potion.BiomonitorCooldownMobEffect;
import net.rbm.cybercraft.potion.AtomicSensorsActivationMobEffect;
import net.rbm.cybercraft.potion.AdrenalineConverterActivationMobEffect;
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
	public static final RegistryObject<MobEffect> SECOND_HEART_COOLDOWN = REGISTRY.register("second_heart_cooldown", () -> new SecondHeartCooldownMobEffect());
	public static final RegistryObject<MobEffect> CHEMICAL_DOT = REGISTRY.register("chemical_dot", () -> new ChemicalDOTMobEffect());
	public static final RegistryObject<MobEffect> CHEMICAL_DOT_COOLDOWN = REGISTRY.register("chemical_dot_cooldown", () -> new ChemicalDOTCooldownMobEffect());
	public static final RegistryObject<MobEffect> BIOMONITOR_COOLDOWN = REGISTRY.register("biomonitor_cooldown", () -> new BiomonitorCooldownMobEffect());
	public static final RegistryObject<MobEffect> COUNTERSHELL_MITIGATION_CHANCE = REGISTRY.register("countershell_mitigation_chance", () -> new CountershellMitigationChanceMobEffect());
	public static final RegistryObject<MobEffect> ADRENALINE_CONVERTER_ACTIVATION = REGISTRY.register("adrenaline_converter_activation", () -> new AdrenalineConverterActivationMobEffect());
	public static final RegistryObject<MobEffect> ATOMIC_SENSORS_ACTIVATION = REGISTRY.register("atomic_sensors_activation", () -> new AtomicSensorsActivationMobEffect());
	public static final RegistryObject<MobEffect> DEEPFIELD_VISUAL_INTERFACE_ACTIVATION = REGISTRY.register("deepfield_visual_interface_activation", () -> new DeepfieldVisualInterfaceActivationMobEffect());
	public static final RegistryObject<MobEffect> STABBER_ACTIVATION = REGISTRY.register("stabber_activation", () -> new StabberActivationMobEffect());
	public static final RegistryObject<MobEffect> TYROSINE_INJECTOR_ACTIVATION = REGISTRY.register("tyrosine_injector_activation", () -> new TyrosineInjectorActivationMobEffect());
	public static final RegistryObject<MobEffect> RECENT_SHOT = REGISTRY.register("recent_shot", () -> new RecentShotMobEffect());
	public static final RegistryObject<MobEffect> RECOIL_LOW = REGISTRY.register("recoil_low", () -> new RecoilLowMobEffect());
	public static final RegistryObject<MobEffect> RECOIL_HIGH = REGISTRY.register("recoil_high", () -> new RecoilHighMobEffect());
}
