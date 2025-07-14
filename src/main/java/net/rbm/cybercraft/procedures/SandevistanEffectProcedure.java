package net.rbm.cybercraft.procedures;

import net.rbm.cybercraft.network.CybercraftModVariables;
import net.rbm.cybercraft.init.CybercraftModMobEffects;
import net.rbm.cybercraft.init.CybercraftModItems;
import net.rbm.cybercraft.CybercraftMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SandevistanEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (CybercraftModItems.SANDEVISTAN.get() == entity.getData(CybercraftModVariables.PLAYER_VARIABLES).operatingsystem1.getItem()
				&& !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(CybercraftModMobEffects.SANDEVISTAN_COOLDOWN))) {
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftCritChance = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftCritChance + 85;
				_vars.syncPlayerVariables(entity);
			}
			{
				CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
				_vars.cybercraftCritDamage = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftCritDamage + 500;
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "tick freeze");
			CybercraftMod.queueServerWork(100, () -> {
				{
					CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
					_vars.cybercraftCritChance = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftCritChance - 85;
					_vars.syncPlayerVariables(entity);
				}
				{
					CybercraftModVariables.PlayerVariables _vars = entity.getData(CybercraftModVariables.PLAYER_VARIABLES);
					_vars.cybercraftCritDamage = entity.getData(CybercraftModVariables.PLAYER_VARIABLES).cybercraftCritDamage - 500;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tick unfreeze");
			});
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(CybercraftModMobEffects.SANDEVISTAN_COOLDOWN, 200, 0));
		}
	}
}