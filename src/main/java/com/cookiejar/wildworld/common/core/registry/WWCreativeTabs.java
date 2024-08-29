package com.cookiejar.wildworld.common.core.registry;

import com.cookiejar.wildworld.common.core.WildWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class WWCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WildWorld.MODID);


    public static final ResourceKey<CreativeModeTab> MOD_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, WildWorld.resLoc("wildworld_tab"));


    // TODO - use our own tab(s) or simply inject our items into the respective vanilla ones?   (or both)
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("wildworld_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.wildworld.tab"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> WWBlocks.PENNY_BUN_MUSHROOM.asItem().getDefaultInstance())
            .displayItems(WWCreativeTabs::populateModTab).build());



    private static void populateModTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        WWItems.TAB_QUEUED_ITEMS.get(MOD_TAB_KEY).forEach((supplier) -> output.accept(supplier.get()));
    }
}
