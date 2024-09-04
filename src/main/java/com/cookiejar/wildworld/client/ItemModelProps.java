package com.cookiejar.wildworld.client;

import com.cookiejar.wildworld.common.core.WildWorld;
import com.cookiejar.wildworld.common.core.registry.WWDataComponents;
import com.cookiejar.wildworld.common.core.registry.WWItems;
import com.cookiejar.wildworld.common.item.CustomDataMobBucketItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.Entity;

public class ItemModelProps {

    @SuppressWarnings("ConstantConditions")
    protected static void register() {
        // Water mob bucket
        ItemProperties.register(WWItems.WATER_MOB_BUCKET.get(), WildWorld.resLoc("mob_bucket_index"), (itemStack, clientLevel, livingEntity, seed) -> {
            Entity entity = livingEntity != null ? livingEntity : itemStack.getEntityRepresentation();
            return entity == null ? 0.0F : (itemStack.getComponents().has(WWDataComponents.MOB_BUCKET_DATA.get()) ? 0.0F : itemStack.get(WWDataComponents.MOB_BUCKET_DATA.get()).textureIndex());
        });
    }
}
