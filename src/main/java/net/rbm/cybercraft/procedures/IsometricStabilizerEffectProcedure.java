package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class IsometricStabilizerEffectProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (CybercraftModItems.ISOMETRIC_STABILIZER.get() == sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES).circulatorysystem1.getItem()
				|| CybercraftModItems.ISOMETRIC_STABILIZER.get() == sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES).circulatorysystem2.getItem()) {
			if (entity instanceof Mob || entity instanceof WaterAnimal) {
				if (sourceentity instanceof Player _player)
					_player.getFoodData().setFoodLevel((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 1);
			}
		}
	}
}