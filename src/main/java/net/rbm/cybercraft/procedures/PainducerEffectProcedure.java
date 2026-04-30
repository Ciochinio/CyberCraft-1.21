package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;
import net.rbm.cybercraft.CybercraftMod;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PainducerEffectProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem1.getItem() == CybercraftModItems.PAINDUCER.get()
				|| entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem2.getItem() == CybercraftModItems.PAINDUCER.get()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Dmg>>" + entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction)), false);
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction > 0) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.6));
				CybercraftMod.queueServerWork(20, () -> {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.1 > 0) {
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.1));
						CybercraftMod.queueServerWork(20, () -> {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.1 > 0) {
								if (entity instanceof LivingEntity _entity)
									_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.1));
								CybercraftMod.queueServerWork(20, () -> {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.1 > 0) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.1));
										CybercraftMod.queueServerWork(20, () -> {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.1 > 0) {
												if (entity instanceof LivingEntity _entity)
													_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.1));
											}
										});
									}
								});
							}
						});
					}
				});
			}
		}
	}
}