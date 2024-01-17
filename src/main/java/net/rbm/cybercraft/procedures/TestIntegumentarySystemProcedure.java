package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TestIntegumentarySystemProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity) {
		execute(null, damagesource, entity);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		double rolka = 0;
		if (((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).legs1).getItem() == Items.NETHERITE_HOE) {
			if (damagesource.is(DamageTypes.ARROW)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Co? >>" + damagesource)), false);
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
	}
}
