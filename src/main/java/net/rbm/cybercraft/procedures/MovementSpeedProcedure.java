package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMobEffects;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MovementSpeedProcedure {
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
		double sumMovementSpeed = 0;
		sumMovementSpeed = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftMovementSpeed;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(CybercraftModMobEffects.THREATEVAC_ACTIVATION_THRESHOLD)) {
			sumMovementSpeed = sumMovementSpeed + 15;
		}
		if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(CybercraftModMobEffects.TYROSINE_INJECTOR_ACTIVATION)) {
			sumMovementSpeed = sumMovementSpeed + 15;
		}
		if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(CybercraftModMobEffects.ADRENALINE_CONVERTER_ACTIVATION) || entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(CybercraftModMobEffects.ATOMIC_SENSORS_ACTIVATION)) {
			sumMovementSpeed = sumMovementSpeed + 15;
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("/attribute @s minecraft:generic.movement_speed base set  " + (0.1 + sumMovementSpeed * 0.001)));
			}
		}
	}
}