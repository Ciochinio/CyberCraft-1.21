package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMobEffects;
import net.rbm.cybercraft.CybercraftMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class PlayerPassiveRegenerationProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).operatingsystem1)
				.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).frontalcortex1)
						.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).frontalcortex2)
						.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).face1).is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).arms1).is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).hands1).is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).skeleton1)
						.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).skeleton2)
						.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).circuletorysystem1)
						.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).circulatorysystem2)
						.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).nervoussystem1)
						.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).nervoussystem2)
						.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).integumentarysystem1)
						.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).integumentarysystem2)
						.is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware")))
				|| ((entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).legs1).is(ItemTags.create(new ResourceLocation("cybercraft:passive_regeneration_cyberware"))))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			CybercraftMod.queueServerWork(20, () -> {
				if (!(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(CybercraftModMobEffects.HEAL_COOLDOWN.get()))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(CybercraftModMobEffects.HEAL_COOLDOWN.get(), 60, 0));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
								+ (entity.getCapability(CybercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CybercraftModVariables.PlayerVariables())).cybercraftPassiveHealthRegeneration));
					PlayerPassiveRegenerationProcedure.execute(world, entity);
				} else {
					PlayerPassiveRegenerationProcedure.execute(world, entity);
				}
			});
		}
	}
}
