package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.Entity;

public class MicrotorsEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).circuletorysystem1).getItem() == CybercraftModItems.MICROROTORS.get()
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).circulatorysystem2).getItem() == CybercraftModItems.MICROROTORS.get()) {
			{
				double _setval = (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftAttackSpeed + 1;
				entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cybercraftAttackSpeed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
