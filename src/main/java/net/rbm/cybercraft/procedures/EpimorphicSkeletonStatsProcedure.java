package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class EpimorphicSkeletonStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).skeleton1.getItem() == CybercraftModItems.EPIMORPHIC_SKELETON.get()
				|| entity.getData(CybercraftModVariables.PLAYER_VARIABLES).skeleton2.getItem() == CybercraftModItems.EPIMORPHIC_SKELETON.get()) {
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftHealth = (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.2;
				_vars.markSyncDirty();
			}
		}
	}
}