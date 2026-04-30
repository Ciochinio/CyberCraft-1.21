package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMobEffects;
import net.rbm.cybercraft.init.CybercraftModItems;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ReinforcedTendonsDoubleJumpProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).legs1.getItem() == CybercraftModItems.REINFORCED_TENDONS.get() && !entity.onGround() && entity.getData(CybercraftModVariables.PLAYER_VARIABLES).doublejump > 0) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 0.5), (entity.getDeltaMovement().z())));
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.doublejump = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).doublejump - 1;
				_vars.markSyncDirty();
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(CybercraftModMobEffects.REDUCED_FALL_DAMAGE, 25, 0));
		}
	}
}