
package net.rbm.cybercraft.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ChemicalDOTCooldownMobEffect extends MobEffect {
	public ChemicalDOTCooldownMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.cybercraft.chemical_dot_cooldown";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
