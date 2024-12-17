package net.rbm.cybercraft.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CybercrafPlayerStatCheckProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CybercraftPlayerBaseStatsProcedure.execute(entity);
		CybercraftFrontalCortexStatCheckProcedure.execute();
		CybercraftArmsStatCheckProcedure.execute();
		CybercraftFaceStatCheckProcedure.execute();
		CybercraftSkeletonStatCheckProcedure.execute(entity);
		CybercraftHandsStatCheckProcedure.execute();
		CybercraftNervousSystemStatCheckProcedure.execute(entity);
		CybercraftCirculetorySystemStatCheckProcedure.execute(entity);
		CybercraftIntegumentarySystemStatCheckProcedure.execute(entity);
		CybercraftLegsStatCheckProcedure.execute(entity);
		PassiveHealthRegenStartedProcedure.execute(world, entity);
		CybercraftPlayerStatApplyProcedure.execute(entity);
	}
}
