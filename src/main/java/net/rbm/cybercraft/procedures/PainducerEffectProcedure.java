package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;
import net.rbm.cybercraft.CybercraftMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PainducerEffectProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).integumentarysystem1).getItem() == CybercraftModItems.PAINDUCER.get()
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).integumentarysystem2).getItem() == CybercraftModItems.PAINDUCER.get()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Dmg>>" + (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction)), false);
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
					- (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction >= 0) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
							- (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction * 0.6));
				CybercraftMod.queueServerWork(20, () -> {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
							- (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction * 0.1 >= 0) {
						if (entity instanceof LivingEntity _entity)
							_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
									- (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction * 0.1));
						CybercraftMod.queueServerWork(20, () -> {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
									- (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction * 0.1 >= 0) {
								if (entity instanceof LivingEntity _entity)
									_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
											- (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction * 0.1));
								CybercraftMod.queueServerWork(20, () -> {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
											- (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction * 0.1 >= 0) {
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
													- (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction * 0.1));
										CybercraftMod.queueServerWork(20, () -> {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
													- (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction * 0.1 >= 0) {
												if (entity instanceof LivingEntity _entity)
													_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
															- (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftDamageReduction * 0.1));
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
