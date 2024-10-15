package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.Entity;

public class MicrorotorsStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).circulatorysystem1.getItem() == CybercraftModItems.MICROROTORS.get()
				|| entity.getData(CybercraftModVariables.PLAYER_VARIABLES).circulatorysystem2.getItem() == CybercraftModItems.MICROROTORS.get()) {
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftAttackSpeed = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftAttackSpeed + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
