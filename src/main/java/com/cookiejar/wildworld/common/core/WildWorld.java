package com.cookiejar.wildworld.common.core;

import com.cookiejar.wildworld.common.core.event.GameEventListener;
import com.cookiejar.wildworld.common.core.registry.*;
import com.cookiejar.wildworld.common.misc.MobBucketRegistry;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(WildWorld.MODID)
public class WildWorld {

    public static final String MODID = "wildworld";
    public static final Logger LOGGER = LogUtils.getLogger();


    public WildWorld(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        WWCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        WWBlocks.BLOCKS.register(modEventBus);
        WWItems.ITEMS.register(modEventBus);
        WWSounds.SOUNDS.register(modEventBus);
        WWDataComponents.DATA_COMPONENTS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(new GameEventListener());

        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> MobBucketRegistry.init());
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    public static ResourceLocation resLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
