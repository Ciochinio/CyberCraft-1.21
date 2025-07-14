package net.rbm.cybercraft.procedures;

import net.minecraft.world.entity.Entity;

public class CybercraftSkeletonStatCheckProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		BionicJointsStatsProcedure.execute(entity);
		EpimorphicSkeletonStatsProcedure.execute(entity);
	}
}