package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.Entity;

public class SubdermalArmorStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double dodgeChance = 0;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem1.getItem() == CybercraftModItems.SUBDERMAL_ARMOR.get()
				|| entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem2.getItem() == CybercraftModItems.SUBDERMAL_ARMOR.get()) {
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftArmor = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftArmor + 2;
				_vars.syncPlayerVariables(entity);
			}
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftToughness = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftToughness + 2;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
