package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMobEffects;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TestInstaHealProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (Blocks.ACACIA_SAPLING.asItem() == ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).legs1).getItem()
				&& !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(CybercraftModMobEffects.TESTINSTANTHEALCD.get()))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.5) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(CybercraftModMobEffects.TESTINSTANTHEALCD.get(), 600, 0));
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(15);
		}
	}
}
