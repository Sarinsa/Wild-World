package com.cookiejar.wildworld.datagen;

import com.cookiejar.wildworld.common.core.WildWorld;
import com.cookiejar.wildworld.common.misc.MobBucketRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = WildWorld.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGatherListener {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        prepare();

        DataGenerator dataGenerator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        if (event.includeServer()) {}

        if (event.includeClient()) {
            dataGenerator.addProvider(true, new WWItemModelProvider(dataGenerator, fileHelper));
            dataGenerator.addProvider(true, new WWLangProvider(dataGenerator));
        }
    }

    /**
     *  Most mod loading events are not fired when running data generation,
     *  so any missing setup that we depend on can be handled here.
     */
    private static void prepare() {
        MobBucketRegistry.init();
    }
}
