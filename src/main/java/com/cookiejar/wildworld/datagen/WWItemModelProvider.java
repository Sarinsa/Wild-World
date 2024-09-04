package com.cookiejar.wildworld.datagen;

import com.cookiejar.wildworld.common.core.WildWorld;
import com.cookiejar.wildworld.common.core.registry.WWItems;
import com.cookiejar.wildworld.common.misc.MobBucketRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

public class WWItemModelProvider extends ItemModelProvider {

    public WWItemModelProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator.getPackOutput(), WildWorld.MODID, fileHelper);
    }

    @Override
    protected void registerModels() {
        customMobBucket();
    }

    private void customMobBucket() {
        ResourceLocation itemId = WWItems.WATER_MOB_BUCKET.getId();
        final String bucketTextures = "item/mob_bucket/";
        String parentModel = "item/generated";

        ItemModelBuilder builder = getBuilder(itemId.toString())
                .parent(new ModelFile.UncheckedModelFile(parentModel))
                .texture("layer0", WildWorld.resLoc(bucketTextures + "default"));

        for (MobBucketRegistry.Entry entry : MobBucketRegistry.allEntries()) {
            ItemModelBuilder subBuilder = getBuilder("bucket_" + entry.textureIndex())
                    .parent(new ModelFile.UncheckedModelFile(parentModel))
                    .texture("layer0", WildWorld.resLoc(bucketTextures + entry.textureIndex()));

            builder.override()
                    .predicate(WildWorld.resLoc("mob_bucket_index"), entry.textureIndex())
                    .model(new ModelFile.UncheckedModelFile(subBuilder.getUncheckedLocation()));
        }
    }

    private static ResourceLocation modTexture(String name) {
        return WildWorld.resLoc("item/" + name);
    }

    private static ResourceLocation modArtifactTexture(String type, String name) {
        return WildWorld.resLoc("item/" + type + "/" + name);
    }
}
