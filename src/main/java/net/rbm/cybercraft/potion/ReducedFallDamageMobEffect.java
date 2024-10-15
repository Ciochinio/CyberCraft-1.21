
package net.rbm.cybercraft.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ReducedFallDamageMobEffect extends MobEffect {
	public ReducedFallDamageMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}
}
