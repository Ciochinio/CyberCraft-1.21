package net.rbm.cybercraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class OperatingSystemActivateOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		SandevistanEffectProcedure.execute(world, x, y, z, entity);
	}
}
