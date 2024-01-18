package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.Entity;

public class LeeroyLigamentSystemStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (CybercraftModItems.LEEROY_LIGAMENT_SYSTEM.get() == ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).legs1).getItem()) {
			{
				double _setval = (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftMovementSpeed + 20;
				entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cybercraftMovementSpeed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
