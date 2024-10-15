package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.Entity;

public class NeoFiberStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).nervoussystem1.getItem() == CybercraftModItems.NEOFIBER.get()
				|| entity.getData(CybercraftModVariables.PLAYER_VARIABLES).nervoussystem2.getItem() == CybercraftModItems.NEOFIBER.get()) {
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftMitigationChance = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftMitigationChance + 10;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
