package net.rbm.cybercraft.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
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
		CybercraftOperatingSystemStatCheckProcedure.execute();
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
