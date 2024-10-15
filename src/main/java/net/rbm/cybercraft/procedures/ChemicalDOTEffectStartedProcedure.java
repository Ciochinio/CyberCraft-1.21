package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.init.CybercraftModMobEffects;
import net.rbm.cybercraft.CybercraftMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class ChemicalDOTEffectStartedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double sumPassiveHealthRegeneration = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CybercraftModMobEffects.CHEMICAL_DOT)) {
			CybercraftMod.queueServerWork(20, () -> {
				if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(CybercraftModMobEffects.CHEMICAL_DOT_COOLDOWN))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(CybercraftModMobEffects.CHEMICAL_DOT_COOLDOWN, 40, 0));
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 1);
				}
				ChemicalDOTEffectStartedProcedure.execute(world, entity);
			});
		}
	}
}
