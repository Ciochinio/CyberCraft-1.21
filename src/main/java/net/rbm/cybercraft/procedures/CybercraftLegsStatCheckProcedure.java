package net.rbm.cybercraft.procedures;

import net.minecraft.world.entity.Entity;

public class CybercraftLegsStatCheckProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		LeeroyLigamentSystemEffectProcedure.execute(entity);
	}
}
