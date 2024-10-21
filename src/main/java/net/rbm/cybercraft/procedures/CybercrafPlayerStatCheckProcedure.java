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
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		CybercraftPlayerBaseStatsProcedure.execute(entity);
		CybercraftFrontalCortexStatCheckProcedure.execute();
		CybercraftOperatingSystemStatCheckProcedure.execute(world, x, y, z, entity);
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
