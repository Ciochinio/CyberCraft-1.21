package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;

import net.minecraft.world.entity.Entity;

public class WriteProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).save) {
			for (int index0 = 0; index0 < 10; index0++) {
				ReadProcedure.execute(entity);
			}
			{
				boolean _setval = false;
				entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.save = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
