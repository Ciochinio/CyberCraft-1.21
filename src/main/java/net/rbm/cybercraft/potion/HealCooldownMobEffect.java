
package net.rbm.cybercraft.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class HealCooldownMobEffect extends MobEffect {
	public HealCooldownMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}
}
