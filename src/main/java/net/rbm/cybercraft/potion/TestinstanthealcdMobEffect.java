
package net.rbm.cybercraft.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class TestinstanthealcdMobEffect extends MobEffect {
	public TestinstanthealcdMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.cybercraft.testinstanthealcd";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
