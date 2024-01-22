package net.rbm.cybercraft.network;

import net.rbm.cybercraft.CybercraftMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CybercraftModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		CybercraftMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.save = original.save;
			clone.operatingsystem1 = original.operatingsystem1;
			clone.frontalcortex1 = original.frontalcortex1;
			clone.frontalcortex2 = original.frontalcortex2;
			clone.face1 = original.face1;
			clone.arms1 = original.arms1;
			clone.hands1 = original.hands1;
			clone.skeleton1 = original.skeleton1;
			clone.skeleton2 = original.skeleton2;
			clone.circulatorysystem1 = original.circulatorysystem1;
			clone.circulatorysystem2 = original.circulatorysystem2;
			clone.nervoussystem1 = original.nervoussystem1;
			clone.nervoussystem2 = original.nervoussystem2;
			clone.legs1 = original.legs1;
			clone.integumentarysystem1 = original.integumentarysystem1;
			clone.integumentarysystem2 = original.integumentarysystem2;
			if (!event.isWasDeath()) {
				clone.doublejump = original.doublejump;
				clone.cybercraftMovementSpeed = original.cybercraftMovementSpeed;
				clone.cybercraftHealth = original.cybercraftHealth;
				clone.cybercraftArmor = original.cybercraftArmor;
				clone.cybercraftHackDamage = original.cybercraftHackDamage;
				clone.cybercraftAdditionalDamage = original.cybercraftAdditionalDamage;
				clone.cybercraftDamageReduction = original.cybercraftDamageReduction;
				clone.cybercraftCritChance = original.cybercraftCritChance;
				clone.cybercraftCritDamage = original.cybercraftCritDamage;
				clone.cybercraftToughness = original.cybercraftToughness;
				clone.cybercraftPassiveHealthRegeneration = original.cybercraftPassiveHealthRegeneration;
				clone.sumPassiveHealthRegeneration = original.sumPassiveHealthRegeneration;
				clone.cybercraftAttackSpeed = original.cybercraftAttackSpeed;
				clone.sumMitigationChance = original.sumMitigationChance;
				clone.cybercraftMitigationChance = original.cybercraftMitigationChance;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("cybercraft", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean save = true;
		public ItemStack operatingsystem1 = ItemStack.EMPTY;
		public ItemStack frontalcortex1 = ItemStack.EMPTY;
		public ItemStack frontalcortex2 = ItemStack.EMPTY;
		public ItemStack face1 = ItemStack.EMPTY;
		public ItemStack arms1 = ItemStack.EMPTY;
		public ItemStack hands1 = ItemStack.EMPTY;
		public ItemStack skeleton1 = ItemStack.EMPTY;
		public ItemStack skeleton2 = ItemStack.EMPTY;
		public ItemStack circulatorysystem1 = ItemStack.EMPTY;
		public ItemStack circulatorysystem2 = ItemStack.EMPTY;
		public ItemStack nervoussystem1 = ItemStack.EMPTY;
		public ItemStack nervoussystem2 = ItemStack.EMPTY;
		public ItemStack legs1 = ItemStack.EMPTY;
		public ItemStack integumentarysystem1 = ItemStack.EMPTY;
		public ItemStack integumentarysystem2 = ItemStack.EMPTY;
		public double doublejump = 2.0;
		public double cybercraftMovementSpeed = 0;
		public double cybercraftHealth = 0;
		public double cybercraftArmor = 0;
		public double cybercraftHackDamage = 0;
		public double cybercraftAdditionalDamage = 0.0;
		public double cybercraftDamageReduction = 0;
		public double cybercraftCritChance = 1.0;
		public double cybercraftCritDamage = 0;
		public double cybercraftToughness = 0;
		public double cybercraftPassiveHealthRegeneration = 0;
		public double sumPassiveHealthRegeneration = 0;
		public double cybercraftAttackSpeed = 0;
		public double sumMitigationChance = 0;
		public double cybercraftMitigationChance = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				CybercraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("save", save);
			nbt.put("operatingsystem1", operatingsystem1.save(new CompoundTag()));
			nbt.put("frontalcortex1", frontalcortex1.save(new CompoundTag()));
			nbt.put("frontalcortex2", frontalcortex2.save(new CompoundTag()));
			nbt.put("face1", face1.save(new CompoundTag()));
			nbt.put("arms1", arms1.save(new CompoundTag()));
			nbt.put("hands1", hands1.save(new CompoundTag()));
			nbt.put("skeleton1", skeleton1.save(new CompoundTag()));
			nbt.put("skeleton2", skeleton2.save(new CompoundTag()));
			nbt.put("circulatorysystem1", circulatorysystem1.save(new CompoundTag()));
			nbt.put("circulatorysystem2", circulatorysystem2.save(new CompoundTag()));
			nbt.put("nervoussystem1", nervoussystem1.save(new CompoundTag()));
			nbt.put("nervoussystem2", nervoussystem2.save(new CompoundTag()));
			nbt.put("legs1", legs1.save(new CompoundTag()));
			nbt.put("integumentarysystem1", integumentarysystem1.save(new CompoundTag()));
			nbt.put("integumentarysystem2", integumentarysystem2.save(new CompoundTag()));
			nbt.putDouble("doublejump", doublejump);
			nbt.putDouble("cybercraftMovementSpeed", cybercraftMovementSpeed);
			nbt.putDouble("cybercraftHealth", cybercraftHealth);
			nbt.putDouble("cybercraftArmor", cybercraftArmor);
			nbt.putDouble("cybercraftHackDamage", cybercraftHackDamage);
			nbt.putDouble("cybercraftAdditionalDamage", cybercraftAdditionalDamage);
			nbt.putDouble("cybercraftDamageReduction", cybercraftDamageReduction);
			nbt.putDouble("cybercraftCritChance", cybercraftCritChance);
			nbt.putDouble("cybercraftCritDamage", cybercraftCritDamage);
			nbt.putDouble("cybercraftToughness", cybercraftToughness);
			nbt.putDouble("cybercraftPassiveHealthRegeneration", cybercraftPassiveHealthRegeneration);
			nbt.putDouble("sumPassiveHealthRegeneration", sumPassiveHealthRegeneration);
			nbt.putDouble("cybercraftAttackSpeed", cybercraftAttackSpeed);
			nbt.putDouble("sumMitigationChance", sumMitigationChance);
			nbt.putDouble("cybercraftMitigationChance", cybercraftMitigationChance);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			save = nbt.getBoolean("save");
			operatingsystem1 = ItemStack.of(nbt.getCompound("operatingsystem1"));
			frontalcortex1 = ItemStack.of(nbt.getCompound("frontalcortex1"));
			frontalcortex2 = ItemStack.of(nbt.getCompound("frontalcortex2"));
			face1 = ItemStack.of(nbt.getCompound("face1"));
			arms1 = ItemStack.of(nbt.getCompound("arms1"));
			hands1 = ItemStack.of(nbt.getCompound("hands1"));
			skeleton1 = ItemStack.of(nbt.getCompound("skeleton1"));
			skeleton2 = ItemStack.of(nbt.getCompound("skeleton2"));
			circulatorysystem1 = ItemStack.of(nbt.getCompound("circulatorysystem1"));
			circulatorysystem2 = ItemStack.of(nbt.getCompound("circulatorysystem2"));
			nervoussystem1 = ItemStack.of(nbt.getCompound("nervoussystem1"));
			nervoussystem2 = ItemStack.of(nbt.getCompound("nervoussystem2"));
			legs1 = ItemStack.of(nbt.getCompound("legs1"));
			integumentarysystem1 = ItemStack.of(nbt.getCompound("integumentarysystem1"));
			integumentarysystem2 = ItemStack.of(nbt.getCompound("integumentarysystem2"));
			doublejump = nbt.getDouble("doublejump");
			cybercraftMovementSpeed = nbt.getDouble("cybercraftMovementSpeed");
			cybercraftHealth = nbt.getDouble("cybercraftHealth");
			cybercraftArmor = nbt.getDouble("cybercraftArmor");
			cybercraftHackDamage = nbt.getDouble("cybercraftHackDamage");
			cybercraftAdditionalDamage = nbt.getDouble("cybercraftAdditionalDamage");
			cybercraftDamageReduction = nbt.getDouble("cybercraftDamageReduction");
			cybercraftCritChance = nbt.getDouble("cybercraftCritChance");
			cybercraftCritDamage = nbt.getDouble("cybercraftCritDamage");
			cybercraftToughness = nbt.getDouble("cybercraftToughness");
			cybercraftPassiveHealthRegeneration = nbt.getDouble("cybercraftPassiveHealthRegeneration");
			sumPassiveHealthRegeneration = nbt.getDouble("sumPassiveHealthRegeneration");
			cybercraftAttackSpeed = nbt.getDouble("cybercraftAttackSpeed");
			sumMitigationChance = nbt.getDouble("sumMitigationChance");
			cybercraftMitigationChance = nbt.getDouble("cybercraftMitigationChance");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.save = message.data.save;
					variables.operatingsystem1 = message.data.operatingsystem1;
					variables.frontalcortex1 = message.data.frontalcortex1;
					variables.frontalcortex2 = message.data.frontalcortex2;
					variables.face1 = message.data.face1;
					variables.arms1 = message.data.arms1;
					variables.hands1 = message.data.hands1;
					variables.skeleton1 = message.data.skeleton1;
					variables.skeleton2 = message.data.skeleton2;
					variables.circulatorysystem1 = message.data.circulatorysystem1;
					variables.circulatorysystem2 = message.data.circulatorysystem2;
					variables.nervoussystem1 = message.data.nervoussystem1;
					variables.nervoussystem2 = message.data.nervoussystem2;
					variables.legs1 = message.data.legs1;
					variables.integumentarysystem1 = message.data.integumentarysystem1;
					variables.integumentarysystem2 = message.data.integumentarysystem2;
					variables.doublejump = message.data.doublejump;
					variables.cybercraftMovementSpeed = message.data.cybercraftMovementSpeed;
					variables.cybercraftHealth = message.data.cybercraftHealth;
					variables.cybercraftArmor = message.data.cybercraftArmor;
					variables.cybercraftHackDamage = message.data.cybercraftHackDamage;
					variables.cybercraftAdditionalDamage = message.data.cybercraftAdditionalDamage;
					variables.cybercraftDamageReduction = message.data.cybercraftDamageReduction;
					variables.cybercraftCritChance = message.data.cybercraftCritChance;
					variables.cybercraftCritDamage = message.data.cybercraftCritDamage;
					variables.cybercraftToughness = message.data.cybercraftToughness;
					variables.cybercraftPassiveHealthRegeneration = message.data.cybercraftPassiveHealthRegeneration;
					variables.sumPassiveHealthRegeneration = message.data.sumPassiveHealthRegeneration;
					variables.cybercraftAttackSpeed = message.data.cybercraftAttackSpeed;
					variables.sumMitigationChance = message.data.sumMitigationChance;
					variables.cybercraftMitigationChance = message.data.cybercraftMitigationChance;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
