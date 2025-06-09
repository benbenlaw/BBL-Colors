package com.benbenlaw.colors.worldgen;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.core.block.brightable.BrightBlock;
import com.benbenlaw.core.block.brightable.BrightLeaves;
import com.benbenlaw.core.block.brightable.BrightLog;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.HashMap;
import java.util.Map;

public class ColorsConfiguredFeatures {

    //Bonemeal Colored Grass

    //Flowers

    public static final Map<String, ResourceKey<ConfiguredFeature<?, ?>>> GRASS_BONEMEAL_KEY = new HashMap<>();
    public static final Map<String, ResourceKey<ConfiguredFeature<?, ?>>> TREES_KEY = new HashMap<>();
    public static final Map<String, ResourceKey<ConfiguredFeature<?, ?>>> STONE_KEY = new HashMap<>();



    static {
        for (String color : ColorList.COLORS) {
            GRASS_BONEMEAL_KEY.put(color, registerKey("bonemeal_" + color + "_grass_key"));
            //public static final ResourceKey<ConfiguredFeature<?, ?>> BONEMEAL_BLACK_GRASS_KEY = registerKey("bonemeal_black_grass_key");

            TREES_KEY.put(color, registerKey(color + "_tree"));
            //public static final ResourceKey<ConfiguredFeature<?, ?>> BLACK_TREE_KEY = registerKey("black_tree");

            STONE_KEY.put(color, registerKey(color + "_stone"));

        }
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        for (String color : ColorList.COLORS) {

            //Bonemeal Grass Black
            FeatureUtils.register(context, GRASS_BONEMEAL_KEY.get(color), Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                    new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                            .add(ColorsBlocks.DANDELION.get(color + "_dandelion").get().defaultBlockState(), 10)
                            .add(ColorsBlocks.POPPY.get(color + "_poppy").get().defaultBlockState(), 10)
                            .add(ColorsBlocks.SHORT_GRASS.get(color + "_short_grass").get().defaultBlockState(), 40)
                            .add(ColorsBlocks.TALL_GRASS.get(color + "_tall_grass").get().defaultBlockState(), 5))));

        }

        //Black Tree
        FeatureUtils.register(context, TREES_KEY.get("black"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("black_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("black_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("black_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Red Tree
        FeatureUtils.register(context, TREES_KEY.get("red"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("red_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(7, 5, 7),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("red_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new SpruceFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4)),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("red_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Blue Tree
        FeatureUtils.register(context, TREES_KEY.get("blue"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("blue_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(7, 5, 7),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("blue_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new SpruceFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4)),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("blue_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Light Blue Tree
        FeatureUtils.register(context, TREES_KEY.get("light_blue"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("light_blue_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(7, 5, 7),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("light_blue_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new SpruceFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4)),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("light_blue_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Cyan Tree
        FeatureUtils.register(context, TREES_KEY.get("cyan"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("cyan_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(7, 5, 7),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("cyan_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new SpruceFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(4)),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("cyan_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Green Tree
        FeatureUtils.register(context, TREES_KEY.get("green"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("green_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(7, 5, 0),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("green_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("green_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Yellow Tree
        FeatureUtils.register(context, TREES_KEY.get("yellow"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("yellow_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new ForkingTrunkPlacer(7, 3, 3),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("yellow_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("yellow_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Orange Tree
        FeatureUtils.register(context, TREES_KEY.get("orange"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("orange_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("orange_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("orange_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Purple Tree
        FeatureUtils.register(context, TREES_KEY.get("purple"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("purple_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(8, 4, 0),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("purple_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("purple_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Pink Tree
        FeatureUtils.register(context, TREES_KEY.get("pink"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("pink_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new ForkingTrunkPlacer(7, 3, 3),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("pink_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("pink_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Lime Tree
        FeatureUtils.register(context, TREES_KEY.get("lime"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("lime_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("lime_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("lime_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Magenta Tree
        FeatureUtils.register(context, TREES_KEY.get("magenta"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("magenta_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("magenta_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("magenta_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Light Gray Tree
        FeatureUtils.register(context, TREES_KEY.get("light_gray"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("light_gray_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("light_gray_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("light_gray_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Gray Tree
        FeatureUtils.register(context, TREES_KEY.get("gray"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("gray_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("gray_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("gray_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //White Tree
        FeatureUtils.register(context, TREES_KEY.get("white"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("white_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("white_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("white_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());

        //Brown Tree
        FeatureUtils.register(context, TREES_KEY.get("brown"), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ColorsBlocks.LOGS.get("brown_log").get().defaultBlockState().setValue(BrightLog.LIT, false)),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ColorsBlocks.LEAVES.get("brown_leaves").get().defaultBlockState().setValue(BrightLeaves.LIT, false)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get("brown_dirt").get().defaultBlockState().setValue(BrightBlock.LIT, false)))
                .build());


        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        //Stones
        register(context, STONE_KEY.get("black"), Feature.ORE, new OreConfiguration(deepslateReplaceables, ColorsBlocks.STONE_BLOCKS.get("black_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("red"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("red_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("green"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("green_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("blue"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("blue_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("yellow"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("yellow_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("orange"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("orange_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("purple"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("purple_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("pink"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("pink_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("cyan"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("cyan_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("white"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("white_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("brown"), Feature.ORE, new OreConfiguration(deepslateReplaceables, ColorsBlocks.STONE_BLOCKS.get("brown_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("gray"), Feature.ORE, new OreConfiguration(deepslateReplaceables, ColorsBlocks.STONE_BLOCKS.get("gray_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("light_blue"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("light_blue_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("lime"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("lime_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("magenta"), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get("magenta_stone").get().defaultBlockState(), 48));
        register(context, STONE_KEY.get("light_gray"), Feature.ORE, new OreConfiguration(deepslateReplaceables, ColorsBlocks.STONE_BLOCKS.get("light_gray_stone").get().defaultBlockState(), 48));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}