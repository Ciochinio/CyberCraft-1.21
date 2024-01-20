package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;

import net.minecraft.world.entity.Entity;

public class ThreatevacActivationThresholdEffectStartedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftMovementSpeed + 20;
			entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.cybercraftMovementSpeed = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
