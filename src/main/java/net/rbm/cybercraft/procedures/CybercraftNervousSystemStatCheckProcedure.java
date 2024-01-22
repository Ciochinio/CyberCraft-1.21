package net.rbm.cybercraft.procedures;

import net.minecraft.world.entity.Entity;

public class CybercraftNervousSystemStatCheckProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		NeoFiberStatsProcedure.execute(entity);
	}
}
