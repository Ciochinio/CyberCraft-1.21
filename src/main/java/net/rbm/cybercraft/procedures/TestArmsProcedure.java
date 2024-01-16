package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.Entity;

public class TestArmsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).arms1).getItem() == CybercraftModItems.REINFORCED_TENDONS.get()) {
			{
				double _setval = (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftMovementSpeed + 70;
				entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cybercraftMovementSpeed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
