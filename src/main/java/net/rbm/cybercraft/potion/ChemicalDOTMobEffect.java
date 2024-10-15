
package net.rbm.cybercraft.potion;

import net.rbm.cybercraft.procedures.ChemicalDOTEffectStartedProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ChemicalDOTMobEffect extends MobEffect {
	public ChemicalDOTMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16764160);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		ChemicalDOTEffectStartedProcedure.execute(entity.level(), entity);
	}
}
