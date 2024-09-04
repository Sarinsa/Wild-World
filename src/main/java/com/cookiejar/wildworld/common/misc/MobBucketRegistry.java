package com.cookiejar.wildworld.common.misc;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.registries.IdMappingEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class MobBucketRegistry {

    private static final Map<EntityType<?>, Entry> entries = new HashMap<>();



    public static void init() {
        register(EntityType.TURTLE, (livingEntity) -> livingEntity.isBaby() && !livingEntity.isPassenger());
    }






    private static void register(EntityType<?> entityType, Predicate<LivingEntity> bucketPredicate) {
        entries.put(entityType, new Entry(bucketPredicate, entries.size()));
    }

    public static Entry getEntry(EntityType<?> entityType) {
        if (entries.containsKey(entityType)) {
            return entries.get(entityType);
        }
        return null;
    }

    public static void forEach(BiConsumer<EntityType<?>, Entry> action) {
        entries.forEach(action);
    }

    public static Iterable<Entry> allEntries() {
        return entries.values();
    }



    private MobBucketRegistry() {}

    public record Entry(Predicate<LivingEntity> bucketPredicate, int textureIndex) { }
}
