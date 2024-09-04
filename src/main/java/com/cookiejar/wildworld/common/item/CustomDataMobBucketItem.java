package com.cookiejar.wildworld.common.item;

import com.cookiejar.wildworld.common.core.WildWorld;
import com.cookiejar.wildworld.common.core.registry.WWDataComponents;
import com.cookiejar.wildworld.common.data_component.MobBucketData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;

import javax.annotation.Nullable;

public class CustomDataMobBucketItem extends BucketItem {

    private final SoundEvent emptySound;

    public CustomDataMobBucketItem(Fluid content, SoundEvent emptySound, Item.Properties properties) {
        super(content, properties);
        this.emptySound = emptySound;
    }

    @Override
    public void checkExtraContent(@Nullable Player player, Level level, ItemStack containerStack, BlockPos pos) {
        if (level instanceof ServerLevel) {
            spawn((ServerLevel)level, containerStack, pos);
            level.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
        }
    }

    @Override
    protected void playEmptySound(@Nullable Player player, LevelAccessor level, BlockPos pos) {
        level.playSound(player, pos, emptySound, SoundSource.NEUTRAL, 1.0F, 1.0F);
    }

    @Override
    public Component getName(ItemStack stack) {
        if (stack.getComponents().has(WWDataComponents.MOB_BUCKET_DATA.get())) {
            MobBucketData bucketData = stack.getComponents().get(WWDataComponents.MOB_BUCKET_DATA.get());
            return translationName(bucketData.entityTypeId());
        }
        return super.getName(stack);
    }



    protected void spawn(ServerLevel serverLevel, ItemStack bucketedMobStack, BlockPos pos) {
        if (bucketedMobStack.getComponents().has(WWDataComponents.MOB_BUCKET_DATA.get())) {
            MobBucketData bucketData = bucketedMobStack.get(WWDataComponents.MOB_BUCKET_DATA.get());
            ResourceLocation entityTypeId = bucketData.entityTypeId();

            if (BuiltInRegistries.ENTITY_TYPE.containsKey(entityTypeId)) {
                EntityType<?> entityType = BuiltInRegistries.ENTITY_TYPE.get(entityTypeId);
                Entity entity = entityType.create(serverLevel, null, pos, MobSpawnType.BUCKET, true, false);

                if (entity != null) {
                    EntityType.updateCustomEntityTag(serverLevel, null, entity, CustomData.of(bucketData.entityData()));
                    entity.setPos(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D);
                    serverLevel.addFreshEntityWithPassengers(entity);
                }
            }
        }
    }

    public static Component translationName(ResourceLocation rl) {
        return Component.translatable("item." + WildWorld.MODID + ".water_mob_bucket." + rl.getPath());
    }
}
