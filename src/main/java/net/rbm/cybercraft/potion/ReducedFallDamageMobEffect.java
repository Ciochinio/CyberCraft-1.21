
package net.rbm.cybercraft.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ReducedFallDamageMobEffect extends MobEffect {
	public ReducedFallDamageMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.cybercraft.reduced_fall_damage";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
