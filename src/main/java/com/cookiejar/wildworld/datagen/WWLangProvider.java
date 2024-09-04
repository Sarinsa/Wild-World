package com.cookiejar.wildworld.datagen;

import com.cookiejar.wildworld.common.core.WildWorld;
import com.cookiejar.wildworld.common.core.registry.WWBlocks;
import com.cookiejar.wildworld.common.core.registry.WWItems;
import com.cookiejar.wildworld.common.item.CustomDataMobBucketItem;
import com.cookiejar.wildworld.common.misc.MobBucketRegistry;
import com.cookiejar.wildworld.common.misc.StringHelper;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WWLangProvider extends LanguageProvider {

    public static final List<DeferredItem<?>> ITEMS = new ArrayList<>();
    public static final List<DeferredBlock<?>> BLOCKS = new ArrayList<>();
    public static final List<DeferredHolder<EntityType<?>, EntityType<?>>> ENTITY_TYPES = new ArrayList<>();


    public WWLangProvider(DataGenerator generator) {
        super(generator.getPackOutput(), WildWorld.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        MobBucketRegistry.forEach((type, entry) -> {
            ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(type);
            add(CustomDataMobBucketItem.translationName(entityId).getString(), "Bucket of " + idFormatToName(entityId.getPath()));
        });

        add("itemGroup.wildworld.tab", "Wild World");

        addDefaults(ITEMS, "item");
        addDefaults(BLOCKS, "block");
        addDefaults(ENTITY_TYPES, "entity");


        /*
          "itemGroup.wildworld.tab": "Wild World",

  "block.wildworld.packed_dirt": "Packed Dirt",
  "block.wildworld.carved_melon": "Carved Melon",
  "block.wildworld.large_melon_slice": "Large Melon Slice",
  "block.wildworld.carved_large_melon_slice": "Carved Large Melon Slice",
  "block.wildworld.blue_flower_carpet": "Blue Flower Carpet",
  "block.wildworld.orange_flower_carpet": "Orange Flower Carpet",
  "block.wildworld.pink_flower_carpet": "Pink Flower Carpet",
  "block.wildworld.red_flower_carpet": "Red Flower Carpet",
  "block.wildworld.white_flower_carpet": "White Flower Carpet",
  "block.wildworld.penny_bun_mushroom": "Penny Bun Mushroom",
  "block.wildworld.puffball_mushroom": "Puffball Mushroom",
  "block.wildworld.purple_rose": "Purple Rose",
  "block.wildworld.pink_rose": "Pink Rose",
  "block.wildworld.red_rose": "Red Rose",
  "block.wildworld.white_rose": "White Rose",
  "block.wildworld.yellow_rose": "Yellow Rose",
  "block.wildworld.black_rose": "Black Rose",
  "block.wildworld.orange_rose": "Orange Rose",
  "block.wildworld.blue_rose": "Blue Rose",
  "block.wildworld.red_pansies": "Red Pansies",
  "block.wildworld.yellow_pansies": "Yellow Pansies",
  "block.wildworld.blue_pansies": "Blue Pansies",
  "block.wildworld.white_pansies": "White Pansies",
  "block.wildworld.green_hyacinths": "Green Hyacinths",
  "block.wildworld.magenta_hyacinths": "Magenta Hyacinths",
  "block.wildworld.blue_hyacinths": "Blue Hyacinths",
  "block.wildworld.orange_hyacinths": "Orange Hyacinths",

  "block.wildworld.yellow_tulip": "Yellow Tulip",
  "block.wildworld.blue_tulip": "Blue Tulip",
  "block.wildworld.purple_tulip": "Purple Tulip",

  "item.wildworld.butterfly_spawn_egg": "Butterfly Spawn Egg",
  "item.wildworld.seashore": "Seahorse Spawn Egg",

  "entity.wildworld.butterfly": "Butterfly",
  "entity.wildworld.seahorse": "Seahorse"
         */
    }

    private void addDefaults(List<? extends DeferredHolder<?, ?>> list, String descriptionType) {
        for (DeferredHolder<?, ?> holder : list) {
            add(Util.makeDescriptionId(descriptionType, holder.getId()), idFormatToName(holder.getId().getPath()));
        }
    }

    private static String idFormatToName(String id) {
        return StringHelper.toTitleCase(id.replaceAll("_", " "));
    }
}
