package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.Entity;

public class LeeroyLigamentSystemStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (CybercraftModItems.LEEROY_LIGAMENT_SYSTEM.get() == entity.getData(CybercraftModVariables.PLAYER_VARIABLES).legs1.getItem()) {
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftMovementSpeed = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftMovementSpeed + 20;
				_vars.markSyncDirty();
			}
		}
	}
}