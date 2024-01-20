
package net.rbm.cybercraft.potion;

import net.rbm.cybercraft.procedures.ThreatevacActivationThresholdEffectStartedProcedure;
import net.rbm.cybercraft.procedures.ThreatevacActivationThresholdEffectExpiresProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ThreatevacActivationThresholdMobEffect extends MobEffect {
	public ThreatevacActivationThresholdMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.cybercraft.threatevac_activation_threshold";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ThreatevacActivationThresholdEffectStartedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		ThreatevacActivationThresholdEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
