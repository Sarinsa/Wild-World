package com.cookiejar.wildworld.common.core.registry;

import com.cookiejar.wildworld.common.block.*;
import com.cookiejar.wildworld.common.core.WildWorld;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class WWBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WildWorld.MODID);



    public static final DeferredBlock<Block> PACKED_DIRT = registerWithItem("packed_dirt", () -> new Block(Properties.DIRT), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS, CreativeModeTabs.NATURAL_BLOCKS);

    public static final DeferredBlock<Block> CARVED_MELON = registerWithItem("carved_melon", () -> new CarvedMelonBlock(Properties.MELON), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.BUILDING_BLOCKS);
    public static final DeferredBlock<Block> LARGE_MELON_SLICE = registerWithItem("large_melon_slice", () -> new LargeMelonSliceBlock(Properties.MELON), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.BUILDING_BLOCKS);
    public static final DeferredBlock<Block> CARVED_LARGE_MELON_SLICE = registerWithItem("carved_large_melon_slice", () -> new CarvedLargeMelonSliceBlock(Properties.MELON), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.BUILDING_BLOCKS);

    public static final DeferredBlock<Block> PURPLE_ROSE = registerWithItem("purple_rose", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> BLACK_ROSE = registerWithItem("black_rose", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> ORANGE_ROSE = registerWithItem("orange_rose", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> BLUE_ROSE = registerWithItem("blue_rose", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> PINK_ROSE = registerWithItem("pink_rose", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> RED_ROSE = registerWithItem("red_rose", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> WHITE_ROSE = registerWithItem("white_rose", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> YELLOW_ROSE = registerWithItem("yellow_rose", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> RED_PANSIES = registerWithItem("red_pansies", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> YELLOW_PANSIES = registerWithItem("yellow_pansies", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> BLUE_PANSIES = registerWithItem("blue_pansies", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> WHITE_PANSIES = registerWithItem("white_pansies", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> GREEN_HYACINTHS = registerWithItem("green_hyacinths", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> MAGENTA_HYACINTHS = registerWithItem("magenta_hyacinths", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> BLUE_HYACINTHS = registerWithItem("blue_hyacinths", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> ORANGE_HYACINTHS = registerWithItem("orange_hyacinths", createSimpleFlower(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);

    public static final DeferredBlock<Block> YELLOW_TULIP = registerWithItem("yellow_tulip", createTulip(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> BLUE_TULIP = registerWithItem("blue_tulip", createTulip(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> PURPLE_TULIP = registerWithItem("purple_tulip", createTulip(), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);

    public static final DeferredBlock<Block> PENNY_BUN_MUSHROOM = registerWithItem("penny_bun_mushroom", () -> new BaseMushroomBlock(Properties.MUSHROOM), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> PUFFBALL_MUSHROOM = registerWithItem("puffball_mushroom", () -> new BaseMushroomBlock(Properties.MUSHROOM), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);

    public static final DeferredBlock<Block> POTTED_PURPLE_ROSE = BLOCKS.register("potted_purple_rose", createFlowerPot(PURPLE_ROSE));
    public static final DeferredBlock<Block> POTTED_PINK_ROSE = BLOCKS.register("potted_pink_rose", createFlowerPot(PINK_ROSE));
    public static final DeferredBlock<Block> POTTED_RED_ROSE = BLOCKS.register("potted_red_rose", createFlowerPot(RED_ROSE));
    public static final DeferredBlock<Block> POTTED_WHITE_ROSE = BLOCKS.register("potted_white_rose", createFlowerPot(WHITE_ROSE));
    public static final DeferredBlock<Block> POTTED_YELLOW_ROSE = BLOCKS.register("potted_yellow_rose", createFlowerPot(YELLOW_ROSE));
    public static final DeferredBlock<Block> POTTED_BLACK_ROSE = BLOCKS.register("potted_black_rose", createFlowerPot(BLACK_ROSE));
    public static final DeferredBlock<Block> POTTED_ORANGE_ROSE = BLOCKS.register("potted_orange_rose", createFlowerPot(ORANGE_ROSE));
    public static final DeferredBlock<Block> POTTED_BLUE_ROSE = BLOCKS.register("potted_blue_rose", createFlowerPot(BLUE_ROSE));
    public static final DeferredBlock<Block> POTTED_RED_PANSIES = BLOCKS.register("potted_red_pansies", createFlowerPot(RED_PANSIES));
    public static final DeferredBlock<Block> POTTED_YELLOW_PANSIES = BLOCKS.register("potted_yellow_pansies", createFlowerPot(YELLOW_PANSIES));
    public static final DeferredBlock<Block> POTTED_BLUE_PANSIES = BLOCKS.register("potted_blue_pansies", createFlowerPot(BLUE_PANSIES));
    public static final DeferredBlock<Block> POTTED_WHITE_PANSIES = BLOCKS.register("potted_white_pansies", createFlowerPot(WHITE_PANSIES));
    public static final DeferredBlock<Block> POTTED_GREEN_HYACINTHS = BLOCKS.register("potted_green_hyacinths", createFlowerPot(GREEN_HYACINTHS));
    public static final DeferredBlock<Block> POTTED_MAGENTA_HYACINTHS = BLOCKS.register("potted_magenta_hyacinths", createFlowerPot(MAGENTA_HYACINTHS));
    public static final DeferredBlock<Block> POTTED_BLUE_HYACINTHS = BLOCKS.register("potted_blue_hyacinths", createFlowerPot(BLUE_HYACINTHS));
    public static final DeferredBlock<Block> POTTED_ORANGE_HYACINTHS = BLOCKS.register("potted_orange_hyacinths", createFlowerPot(ORANGE_HYACINTHS));

    public static final DeferredBlock<Block> POTTED_YELLOW_TULIP = BLOCKS.register("potted_yellow_tulip", createFlowerPot(YELLOW_TULIP));
    public static final DeferredBlock<Block> POTTED_BLUE_TULIP = BLOCKS.register("potted_blue_tulip", createFlowerPot(BLUE_TULIP));
    public static final DeferredBlock<Block> POTTED_PURPLE_TULIP = BLOCKS.register("potted_purple_tulip", createFlowerPot(PURPLE_TULIP));

    public static final DeferredBlock<Block> POTTED_PENNY_BUN_MUSHROOM = BLOCKS.register("potted_penny_bun_mushroom", createFlowerPot(PENNY_BUN_MUSHROOM));
    public static final DeferredBlock<Block> POTTED_PUFFBALL_MUSHROOM = BLOCKS.register("potted_puffball_mushroom", createFlowerPot(PUFFBALL_MUSHROOM));

    public static final DeferredBlock<Block> BLUE_FLOWER_CARPET = registerWithItem("blue_flower_carpet", () -> new FlowerCarpetBlock(Properties.FLOWER_CARPET), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> ORANGE_FLOWER_CARPET = registerWithItem("orange_flower_carpet", () -> new FlowerCarpetBlock(Properties.FLOWER_CARPET), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> PINK_FLOWER_CARPET = registerWithItem("pink_flower_carpet", () -> new FlowerCarpetBlock(Properties.FLOWER_CARPET), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> RED_FLOWER_CARPET = registerWithItem("red_flower_carpet", () -> new FlowerCarpetBlock(Properties.FLOWER_CARPET), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);
    public static final DeferredBlock<Block> WHITE_FLOWER_CARPET = registerWithItem("white_flower_carpet", () -> new FlowerCarpetBlock(Properties.FLOWER_CARPET), WWCreativeTabs.MOD_TAB_KEY, CreativeModeTabs.NATURAL_BLOCKS);



    private static DeferredBlock<Block> register(String name, Supplier<Block> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }

    @SafeVarargs
    private static DeferredBlock<Block> registerWithItem(String name, Supplier<Block> blockSupplier, ResourceKey<CreativeModeTab>... tabIds) {
        DeferredBlock<Block> regObject = BLOCKS.register(name, blockSupplier);
        WWItems.registerBlockItem(regObject, tabIds);
        return regObject;
    }

    @SafeVarargs
    private static DeferredBlock<Block> registerWithItem(String name, Supplier<Block> blockSupplier, Item.Properties itemProperties, ResourceKey<CreativeModeTab>... tabIds) {
        DeferredBlock<Block> regObject = BLOCKS.register(name, blockSupplier);
        WWItems.registerBlockItem(regObject, itemProperties, tabIds);
        return regObject;
    }

    private static Supplier<Block> createSimpleFlower() {
        return () -> new FlowerBlock(MobEffects.SATURATION, 7, Properties.FLOWER);
    }

    private static Supplier<Block> createTulip() {
        return () -> new FlowerBlock(MobEffects.WEAKNESS, 7, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TULIP));
    }

    private static Supplier<Block> createFlowerPot(Supplier<Block> block) {
        return () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, block, Properties.POTTED_PLANT);
    }


    public static final class Properties {
        public static final BlockBehaviour.Properties DIRT = BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F).sound(SoundType.NYLIUM);
        public static final BlockBehaviour.Properties MELON = BlockBehaviour.Properties.ofFullCopy(Blocks.MELON);
        public static final BlockBehaviour.Properties POTTED_PLANT = BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM);
        public static final BlockBehaviour.Properties FLOWER = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS);
        public static final BlockBehaviour.Properties FLOWER_CARPET = BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CARPET).sound(SoundType.AZALEA_LEAVES).noOcclusion().noCollission();
        public static final BlockBehaviour.Properties MUSHROOM = BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM);
    }
}
