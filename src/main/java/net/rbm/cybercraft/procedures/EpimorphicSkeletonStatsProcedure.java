package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class EpimorphicSkeletonStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).skeleton1).getItem() == CybercraftModItems.EPIMORPHIC_SKELETON.get()
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).skeleton2).getItem() == CybercraftModItems.EPIMORPHIC_SKELETON.get()) {
			{
				double _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.2;
				entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cybercraftHealth = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
