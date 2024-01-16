package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.CybercraftMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class TestHealProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).legs1).getItem() == Items.NETHERITE_HOE) {
			CybercraftMod.queueServerWork(60, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
				TestHealProcedure.execute(world, entity);
			});
		}
	}
}
