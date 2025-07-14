package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMobEffects;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DamageMitigationProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		double mitigationRoll = 0;
		{
			CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.sumMitigationChance = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftMitigationChance;
			_vars.syncPlayerVariables(entity);
		}
		mitigationRoll = Mth.nextInt(RandomSource.create(), 1, 100);
		if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(CybercraftModMobEffects.COUNTERSHELL_MITIGATION_CHANCE)) {
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.sumMitigationChance = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumMitigationChance + 20;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("dmg mitigation roll>>>" + mitigationRoll)), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("chance:" + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumMitigationChance)), false);
		if (mitigationRoll <= entity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumMitigationChance && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - amount > 0) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.5));
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Damage Mitigated"), true);
		}
	}
}