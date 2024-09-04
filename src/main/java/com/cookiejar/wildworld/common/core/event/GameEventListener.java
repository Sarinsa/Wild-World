package com.cookiejar.wildworld.common.core.event;

import com.cookiejar.wildworld.common.core.registry.WWDataComponents;
import com.cookiejar.wildworld.common.core.registry.WWItems;
import com.cookiejar.wildworld.common.data_component.MobBucketData;
import com.cookiejar.wildworld.common.misc.MobBucketRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class GameEventListener {

    @SubscribeEvent
    public void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget() instanceof LivingEntity livingEntity && event.getItemStack().getItem() == Items.WATER_BUCKET) {
            MobBucketRegistry.Entry entry = MobBucketRegistry.getEntry(livingEntity.getType());

            if (entry == null)
                return;

            if (entry.bucketPredicate().test(livingEntity)) {
                ItemStack mobBucket = new ItemStack(WWItems.WATER_MOB_BUCKET.get());
                CompoundTag entityData = livingEntity.saveWithoutId(new CompoundTag());
                MobBucketData bucketData = new MobBucketData(entry.textureIndex(), BuiltInRegistries.ENTITY_TYPE.getKey(livingEntity.getType()), entityData);

                mobBucket.set(WWDataComponents.MOB_BUCKET_DATA.get(), bucketData);

                event.getEntity().addItem(mobBucket);

                livingEntity.discard();

                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }
    }
}
