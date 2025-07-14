package net.rbm.cybercraft.network;

import net.rbm.cybercraft.CybercraftMod;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CybercraftModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, CybercraftMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		CybercraftMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
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
				clone.sumCritChance = original.sumCritChance;
				clone.sumCritDamage = original.sumCritDamage;
				clone.cybercraftInaccuracy = original.cybercraftInaccuracy;
				clone.cybercraftRecoilYaw = original.cybercraftRecoilYaw;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
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
		public double sumCritChance = 0;
		public double sumCritDamage = 0;
		public double cybercraftInaccuracy = 0;
		public double cybercraftRecoilYaw = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("save", save);
			nbt.put("operatingsystem1", operatingsystem1.saveOptional(lookupProvider));
			nbt.put("frontalcortex1", frontalcortex1.saveOptional(lookupProvider));
			nbt.put("frontalcortex2", frontalcortex2.saveOptional(lookupProvider));
			nbt.put("face1", face1.saveOptional(lookupProvider));
			nbt.put("arms1", arms1.saveOptional(lookupProvider));
			nbt.put("hands1", hands1.saveOptional(lookupProvider));
			nbt.put("skeleton1", skeleton1.saveOptional(lookupProvider));
			nbt.put("skeleton2", skeleton2.saveOptional(lookupProvider));
			nbt.put("circulatorysystem1", circulatorysystem1.saveOptional(lookupProvider));
			nbt.put("circulatorysystem2", circulatorysystem2.saveOptional(lookupProvider));
			nbt.put("nervoussystem1", nervoussystem1.saveOptional(lookupProvider));
			nbt.put("nervoussystem2", nervoussystem2.saveOptional(lookupProvider));
			nbt.put("legs1", legs1.saveOptional(lookupProvider));
			nbt.put("integumentarysystem1", integumentarysystem1.saveOptional(lookupProvider));
			nbt.put("integumentarysystem2", integumentarysystem2.saveOptional(lookupProvider));
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
			nbt.putDouble("sumCritChance", sumCritChance);
			nbt.putDouble("sumCritDamage", sumCritDamage);
			nbt.putDouble("cybercraftInaccuracy", cybercraftInaccuracy);
			nbt.putDouble("cybercraftRecoilYaw", cybercraftRecoilYaw);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			save = nbt.getBoolean("save");
			operatingsystem1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("operatingsystem1"));
			frontalcortex1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("frontalcortex1"));
			frontalcortex2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("frontalcortex2"));
			face1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("face1"));
			arms1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("arms1"));
			hands1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("hands1"));
			skeleton1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("skeleton1"));
			skeleton2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("skeleton2"));
			circulatorysystem1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("circulatorysystem1"));
			circulatorysystem2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("circulatorysystem2"));
			nervoussystem1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("nervoussystem1"));
			nervoussystem2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("nervoussystem2"));
			legs1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("legs1"));
			integumentarysystem1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("integumentarysystem1"));
			integumentarysystem2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("integumentarysystem2"));
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
			sumCritChance = nbt.getDouble("sumCritChance");
			sumCritDamage = nbt.getDouble("sumCritDamage");
			cybercraftInaccuracy = nbt.getDouble("cybercraftInaccuracy");
			cybercraftRecoilYaw = nbt.getDouble("cybercraftRecoilYaw");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CybercraftMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}