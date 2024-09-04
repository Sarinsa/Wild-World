package com.cookiejar.wildworld.common.core.registry;

import com.cookiejar.wildworld.common.core.WildWorld;
import com.cookiejar.wildworld.common.item.CustomDataMobBucketItem;
import com.cookiejar.wildworld.datagen.WWLangProvider;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class WWItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WildWorld.MODID);

    /** Used to queue items for one or more creative tabs in the order they are registered */
    protected static final Map<ResourceKey<CreativeModeTab>, List<Supplier<? extends Item>>> TAB_QUEUED_ITEMS = new HashMap<>();



    public static final DeferredItem<CustomDataMobBucketItem> WATER_MOB_BUCKET = registerMobBucket("water_mob_bucket", () -> Fluids.WATER);




    private static DeferredItem<Item> register(String name) {
        return register(name, () -> new Item(new Item.Properties()));
    }

    private static DeferredItem<CustomDataMobBucketItem> registerMobBucket(String name, Supplier<Fluid> fluid) {
         return register(name, () -> new CustomDataMobBucketItem(fluid.get(), SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1)));
    }

    private static <T extends Item> DeferredItem<T> register(String name, Supplier<T> itemSupplier) {
        DeferredItem<T> regObj = ITEMS.register(name, itemSupplier);
        WWLangProvider.ITEMS.add(regObj);
        return regObj;
    }

    @SafeVarargs
    protected static void registerBlockItem(Holder<Block> blockHolder, ResourceKey<CreativeModeTab>... tabIds) {
        DeferredItem<BlockItem> regObject = ITEMS.registerSimpleBlockItem(blockHolder);

        if (tabIds != null) {
            for (ResourceKey<CreativeModeTab> tabId : tabIds) {
                if (!TAB_QUEUED_ITEMS.containsKey(tabId))
                    TAB_QUEUED_ITEMS.put(tabId, new ArrayList<>());

                TAB_QUEUED_ITEMS.get(tabId).add(regObject);
            }
        }
        WWLangProvider.ITEMS.add(regObject);
    }

    @SafeVarargs
    protected static void registerBlockItem(Holder<Block> blockHolder, Item.Properties itemProperties, ResourceKey<CreativeModeTab>... tabIds) {
        DeferredItem<BlockItem> regObject =  ITEMS.registerSimpleBlockItem(blockHolder, itemProperties);

        if (tabIds != null) {
            for (ResourceKey<CreativeModeTab> tabId : tabIds) {
                if (!TAB_QUEUED_ITEMS.containsKey(tabId))
                    TAB_QUEUED_ITEMS.put(tabId, new ArrayList<>());

                TAB_QUEUED_ITEMS.get(tabId).add(regObject);
            }
        }
        WWLangProvider.ITEMS.add(regObject);
    }
}
