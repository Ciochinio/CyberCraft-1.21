package net.rbm.cybercraft.procedures;

import net.minecraft.world.entity.Entity;

public class CybercraftIntegumentarySystemStatCheckProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		SubdermalArmorStatsProcedure.execute(entity);
		ChitinStatsProcedure.execute(entity);
	}
}