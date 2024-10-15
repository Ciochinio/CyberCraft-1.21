package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;

import net.minecraft.world.entity.Entity;

public class WriteProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).save) {
			for (int index0 = 0; index0 < 10; index0++) {
				ReadProcedure.execute(entity);
			}
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.save = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
