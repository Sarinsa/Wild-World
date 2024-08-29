package com.cookiejar.wildworld.common.core.registry;

import com.cookiejar.wildworld.common.core.WildWorld;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class WWItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WildWorld.MODID);

    /** Used to queue items for one or more creative tabs in the order they are registered */
    protected static final Map<ResourceKey<CreativeModeTab>, List<Supplier<? extends Item>>> TAB_QUEUED_ITEMS = new HashMap<>();



    @SafeVarargs
    protected static DeferredItem<BlockItem> registerBlockItem(Holder<Block> blockHolder, ResourceKey<CreativeModeTab>... tabIds) {
        DeferredItem<BlockItem> regObject = ITEMS.registerSimpleBlockItem(blockHolder);

        if (tabIds != null) {
            for (ResourceKey<CreativeModeTab> tabId : tabIds) {
                if (!TAB_QUEUED_ITEMS.containsKey(tabId))
                    TAB_QUEUED_ITEMS.put(tabId, new ArrayList<>());

                TAB_QUEUED_ITEMS.get(tabId).add(regObject);
            }
        }
        return regObject;
    }

    @SafeVarargs
    protected static DeferredItem<BlockItem> registerBlockItem(Holder<Block> blockHolder, Item.Properties itemProperties, ResourceKey<CreativeModeTab>... tabIds) {
        DeferredItem<BlockItem> regObject =  ITEMS.registerSimpleBlockItem(blockHolder, itemProperties);

        if (tabIds != null) {
            for (ResourceKey<CreativeModeTab> tabId : tabIds) {
                if (!TAB_QUEUED_ITEMS.containsKey(tabId))
                    TAB_QUEUED_ITEMS.put(tabId, new ArrayList<>());

                TAB_QUEUED_ITEMS.get(tabId).add(regObject);
            }
        }
        return regObject;
    }
}
