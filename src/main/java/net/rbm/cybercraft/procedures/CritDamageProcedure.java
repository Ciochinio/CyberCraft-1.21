package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMobEffects;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CritDamageProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.sumCritDamage = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftCritDamage;
			_vars.markSyncDirty();
		}
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CybercraftModMobEffects.TYROSINE_INJECTOR_ACTIVATION)) {
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.sumCritDamage = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumCritDamage + 20;
				_vars.markSyncDirty();
			}
		}
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.sumCritDamage = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumCritDamage * 0.01;
			_vars.markSyncDirty();
		}
	}
}