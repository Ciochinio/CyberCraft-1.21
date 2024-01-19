package net.rbm.cybercraft.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CybercraftStatCheckProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		CybercraftPlayerStatResetProcedure.execute(entity);
		CybercraftFrontalCortexStatCheckProcedure.execute();
		CybercraftOperatingSystemStatCheckProcedure.execute();
		CybercraftArmsStatCheckProcedure.execute();
		CybercraftFaceStatCheckProcedure.execute();
		CybercraftSkeletonStatCheckProcedure.execute();
		CybercraftHandsStatCheckProcedure.execute();
		CybercraftNervousSystemStatCheckProcedure.execute();
		CybercraftCirculetorySystemStatCheckProcedure.execute();
		CybercraftIntegumentarySystemStatCheckProcedure.execute(entity);
		CybercraftLegsStatCheckProcedure.execute(entity);
		CybercraftPlayerStatApplyProcedure.execute(entity);
	}
}
