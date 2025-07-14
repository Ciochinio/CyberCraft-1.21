package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModItems;
import net.rbm.cybercraft.CybercraftMod;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PainEditorEffectProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
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
		double rolka = 0;
		double mitigationChance = 0;
		if (entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem1.getItem() == CybercraftModItems.PAIN_EDITOR.get()
				|| entity.getData(CybercraftModVariables.PLAYER_VARIABLES).integumentarysystem2.getItem() == CybercraftModItems.PAIN_EDITOR.get()) {
			CybercraftMod.queueServerWork(1, () -> {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + Math.max(entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftDamageReduction * 0.1, 1)));
				}
			});
		}
	}
}