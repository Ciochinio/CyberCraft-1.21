package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMobEffects;
import net.rbm.cybercraft.CybercraftMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class PassiveHealthRegenStartedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double sumPassiveHealthRegeneration = 0;
		{
			double _setval = (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftPassiveHealthRegeneration;
			entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.sumPassiveHealthRegeneration = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CybercraftModMobEffects.REGEN_TEST_PLUS_5.get())) {
			{
				double _setval = (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).sumPassiveHealthRegeneration + 1;
				entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sumPassiveHealthRegeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(CybercraftModMobEffects.PASSIVE_HEALTH_REGEN.get()) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			CybercraftMod.queueServerWork(20, () -> {
				if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(CybercraftModMobEffects.HEAL_COOLDOWN.get())) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(CybercraftModMobEffects.HEAL_COOLDOWN.get(), 60, 0));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
								+ (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).sumPassiveHealthRegeneration));
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(CybercraftModMobEffects.PASSIVE_HEALTH_REGEN.get(), 30, 0));
				PassiveHealthRegenStartedProcedure.execute(world, entity);
			});
		}
	}
}
