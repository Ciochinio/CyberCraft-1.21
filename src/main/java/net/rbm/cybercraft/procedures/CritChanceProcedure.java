package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMobEffects;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CritChanceProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double critChanceRoll = 0;
		{
			CybercraftModVariables.PlayerVariables _vars = sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES);
			_vars.sumCritChance = sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftCritChance;
			_vars.syncPlayerVariables(sourceentity);
		}
		critChanceRoll = Mth.nextInt(RandomSource.create(), 1, 100);
		if (sourceentity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(CybercraftModMobEffects.DEEPFIELD_VISUAL_INTERFACE_ACTIVATION)) {
			{
				CybercraftModVariables.PlayerVariables _vars = sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.sumCritChance = sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumCritChance + 15;
				_vars.syncPlayerVariables(sourceentity);
			}
		}
		if (sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(CybercraftModMobEffects.STABBER_ACTIVATION)) {
			{
				CybercraftModVariables.PlayerVariables _vars = sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.sumCritChance = sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumCritChance + 15;
				_vars.syncPlayerVariables(sourceentity);
			}
		}
		if (sourceentity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("crit roll>>>" + critChanceRoll)), false);
		if (sourceentity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("chance:" + sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumCritChance)), false);
		if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("cybercraft:enderdragon"))) && critChanceRoll <= sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumCritChance) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("CRIT!" + amount * (1 + sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumCritDamage))), false);
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) (amount * (1 + sourceentity.getData(CybercraftModVariables.PLAYER_VARIABLES).sumCritDamage)));
		}
	}
}