package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.Entity;

public class BionicJointsStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).skeleton1.getItem() == CybercraftModItems.BIONIC_JOINTS.get()
				|| entity.getData(CybercraftModVariables.PLAYER_VARIABLES).skeleton2.getItem() == CybercraftModItems.BIONIC_JOINTS.get()) {
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftArmor = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftArmor + 2;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
