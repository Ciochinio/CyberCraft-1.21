package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMobEffects;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class ChitinStatsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem1.getItem() == CybercraftModItems.CHITIN.get()
				|| entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem2.getItem() == CybercraftModItems.CHITIN.get()) {
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftArmor = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftArmor + 4;
				_vars.syncPlayerVariables(entity);
			}
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftToughness = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftToughness + 4;
				_vars.syncPlayerVariables(entity);
			}
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftPassiveHealthRegeneration = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftPassiveHealthRegeneration + 2;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(CybercraftModMobEffects.PASSIVE_HEALTH_REGEN, 30, 0));
		}
	}
}
