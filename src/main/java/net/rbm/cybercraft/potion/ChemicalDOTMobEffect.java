
package net.rbm.cybercraft.potion;

import net.rbm.cybercraft.procedures.ChemicalDOTEffectStartedProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ChemicalDOTMobEffect extends MobEffect {
	public ChemicalDOTMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16764160);
	}

	@Override
	public String getDescriptionId() {
		return "effect.cybercraft.chemical_dot";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ChemicalDOTEffectStartedProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
