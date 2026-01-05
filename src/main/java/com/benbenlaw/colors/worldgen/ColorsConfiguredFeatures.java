package com.benbenlaw.colors.worldgen;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.util.ColorList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.LeavesBlock;
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
            GRASS_BONEMEAL_KEY.put(color, registerKey( color + "_grass_bonemeal"));
            TREES_KEY.put(color, registerKey(color + "_tree"));
            STONE_KEY.put(color, registerKey(color + "_stone"));

        }
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        for (String color : ColorList.COLORS) {

            //Bonemeal Grass Black

            WeightedList<BlockState> weightedStates = WeightedList.<BlockState>builder()
                    .add(ColorsBlocks.DANDELION.get(color + "_dandelion").get().defaultBlockState(), 10)
                    .add(ColorsBlocks.POPPY.get(color + "_poppy").get().defaultBlockState(), 10)
                    .add(ColorsBlocks.SHORT_GRASS.get(color + "_short_grass").get().defaultBlockState(), 40)
                    .add(ColorsBlocks.TALL_GRASS.get(color + "_tall_grass").get().defaultBlockState(), 5)
                    .build();

            FeatureUtils.register(context, GRASS_BONEMEAL_KEY.get(color), Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                    new WeightedStateProvider(weightedStates)));

            //Trees
            FeatureUtils.register(context, TREES_KEY.get(color), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ColorsBlocks.LOGS.get(color + "_log").get().defaultBlockState()),
                    new StraightTrunkPlacer(4, 2, 0),
                    BlockStateProvider.simple(ColorsBlocks.LEAVES.get(color + "_leaves").get().defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1))
                    .dirt(BlockStateProvider.simple(ColorsBlocks.DIRT.get(color + "_dirt").get().defaultBlockState()))
                    .build());

            //Stone
            RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
            RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

            if (color.equals("magenta") || color.equals("pink") || color.equals("purple") || color.equals("orange") || color.equals("white") || color.equals("yellow") || color.equals("green") || color.equals("lime")) {
                register(context, STONE_KEY.get(color), Feature.ORE, new OreConfiguration(stoneReplaceables, ColorsBlocks.STONE_BLOCKS.get(color + "_stone").get().defaultBlockState(), 48));
            } else {
                register(context, STONE_KEY.get(color), Feature.ORE, new OreConfiguration(deepslateReplaceables, ColorsBlocks.STONE_BLOCKS.get(color + "_stone").get().defaultBlockState(), 48));
            }
        }
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Colors.identifier(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}