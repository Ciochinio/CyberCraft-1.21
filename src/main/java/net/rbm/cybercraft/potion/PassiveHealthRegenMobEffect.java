
package net.rbm.cybercraft.potion;

import net.rbm.cybercraft.procedures.PassiveHealthRegenStartedProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PassiveHealthRegenMobEffect extends MobEffect {
	public PassiveHealthRegenMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		PassiveHealthRegenStartedProcedure.execute(entity.level(), entity);
	}
}
