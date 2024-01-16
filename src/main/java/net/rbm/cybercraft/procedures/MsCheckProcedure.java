package net.rbm.cybercraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class MsCheckProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CoconutProcedure.execute(entity);
		TestArmsProcedure.execute(entity);
		LeeroyLigamentSystemEffectProcedure.execute(entity);
		PlayermsProcedure.execute(world, entity);
	}
}
