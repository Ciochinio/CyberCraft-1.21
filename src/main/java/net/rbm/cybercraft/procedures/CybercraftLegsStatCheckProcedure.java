package net.rbm.cybercraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class CybercraftLegsStatCheckProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		LeeroyLigamentSystemEffectProcedure.execute(entity);
		TestHealProcedure.execute(world, entity);
	}
}
