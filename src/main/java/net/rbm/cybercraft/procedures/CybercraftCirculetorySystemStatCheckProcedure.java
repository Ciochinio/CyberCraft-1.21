package net.rbm.cybercraft.procedures;

import net.minecraft.world.entity.Entity;

public class CybercraftCirculetorySystemStatCheckProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		MicrorotorsStatsProcedure.execute(entity);
	}
}