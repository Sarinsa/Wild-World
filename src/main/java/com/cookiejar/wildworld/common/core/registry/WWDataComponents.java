package com.cookiejar.wildworld.common.core.registry;

import com.cookiejar.wildworld.common.core.WildWorld;
import com.cookiejar.wildworld.common.data_component.MobBucketData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class WWDataComponents {

    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(WildWorld.MODID);


    public static final DeferredHolder<DataComponentType<?>, DataComponentType<MobBucketData>> MOB_BUCKET_DATA = DATA_COMPONENTS.registerComponentType("mob_bucket_data",
            (builder) -> builder.persistent(MobBucketData.CODEC));
}
