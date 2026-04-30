package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@EventBusSubscriber
public class NanoPlatingEffectProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity) {
		execute(null, damagesource, entity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		double dodgeChance = 0;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem1.getItem() == CybercraftModItems.NANO_PLATING.get()
				|| entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem2.getItem() == CybercraftModItems.NANO_PLATING.get()) {
			dodgeChance = Mth.nextInt(RandomSource.create(), 1, 100);
			if (damagesource.is(DamageTypes.ARROW) || damagesource.is(DamageTypes.FIREBALL) || damagesource.is(DamageTypes.TRIDENT) || damagesource.is(DamageTypes.MOB_PROJECTILE)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Rolujemy>>>" + dodgeChance)), false);
				if (dodgeChance <= 10) {
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
				}
			}
		}
	}
}