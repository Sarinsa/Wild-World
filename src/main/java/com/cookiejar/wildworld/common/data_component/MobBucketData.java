package com.cookiejar.wildworld.common.data_component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

public record MobBucketData(int textureIndex, ResourceLocation entityTypeId, CompoundTag entityData) {

    public static final Codec<MobBucketData> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            Codec.INT.fieldOf("textureIndex").forGetter(MobBucketData::textureIndex),
                            ResourceLocation.CODEC.fieldOf("entityTypeId").forGetter(MobBucketData::entityTypeId),
                            CompoundTag.CODEC.fieldOf("entityData").forGetter(MobBucketData::entityData)
                    )
                    .apply(instance, MobBucketData::new)
    );
}
