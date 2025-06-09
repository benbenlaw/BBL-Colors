package com.benbenlaw.colors.worldgen;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.benbenlaw.colors.worldgen.ColorsConfiguredFeatures.*;

public class ColorsPlacedFeatures {

    public static final Map<String, ResourceKey<PlacedFeature>> GRASS_BONEMEAL = new HashMap<>();
    public static final Map<String, ResourceKey<PlacedFeature>> TREE_PLACED = new HashMap<>();
    public static final Map<String, ResourceKey<PlacedFeature>> STONE_PLACED = new HashMap<>();

    static {
        for (String color : ColorList.COLORS) {
            GRASS_BONEMEAL.put(color, registerKey(color + "_grass_bonemeal"));
            TREE_PLACED.put(color, registerKey(color + "_tree_placed"));
            STONE_PLACED.put(color, registerKey(color + "_stone_placed"));
        }
    }


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        for (String color : ColorList.COLORS) {
            PlacementUtils.register(context, GRASS_BONEMEAL.get(color), configuredFeatures.getOrThrow(GRASS_BONEMEAL_KEY.get(color)),
                    RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP);

        }

        //Black Tree
        register(context, TREE_PLACED.get("black"), configuredFeatures.getOrThrow(TREES_KEY.get("black")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(10),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("black_sapling").get())));

        //Red Tree
        register(context, TREE_PLACED.get("red"), configuredFeatures.getOrThrow(TREES_KEY.get("red")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(20),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("red_sapling").get())));

        //Blue Tree
        register(context, TREE_PLACED.get("blue"), configuredFeatures.getOrThrow(TREES_KEY.get("blue")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(16),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("blue_sapling").get())));

        //Green Tree
        register(context, TREE_PLACED.get("green"), configuredFeatures.getOrThrow(TREES_KEY.get("green")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(10),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("green_sapling").get())));

        //Yellow Tree
        register(context, TREE_PLACED.get("yellow"), configuredFeatures.getOrThrow(TREES_KEY.get("yellow")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(20),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        Blocks.CACTUS)));

        //Purple Tree
        register(context, TREE_PLACED.get("purple"), configuredFeatures.getOrThrow(TREES_KEY.get("purple")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(12),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("purple_sapling").get())));

        //Orange Tree
        register(context, TREE_PLACED.get("orange"), configuredFeatures.getOrThrow(TREES_KEY.get("orange")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(12),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        Blocks.DEAD_BUSH)));

        //White Tree
        register(context, TREE_PLACED.get("white"), configuredFeatures.getOrThrow(TREES_KEY.get("white")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(16),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("white_sapling").get())));

        //Brown Tree
        register(context, TREE_PLACED.get("brown"), configuredFeatures.getOrThrow(TREES_KEY.get("brown")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(10),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("brown_sapling").get())));

        //Pink Tree
        register(context, TREE_PLACED.get("pink"), configuredFeatures.getOrThrow(TREES_KEY.get("pink")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(12),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("pink_sapling").get())));

        //Cyan Tree
        register(context, TREE_PLACED.get("cyan"), configuredFeatures.getOrThrow(TREES_KEY.get("cyan")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(10),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("cyan_sapling").get())));

        //Light Gray Tree
        register(context, TREE_PLACED.get("light_gray"), configuredFeatures.getOrThrow(TREES_KEY.get("light_gray")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(12),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("light_gray_sapling").get())));

        //Lime Tree
        register(context, TREE_PLACED.get("lime"), configuredFeatures.getOrThrow(TREES_KEY.get("lime")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(12),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("lime_sapling").get())));

        //Magenta Tree
        register(context, TREE_PLACED.get("magenta"), configuredFeatures.getOrThrow(TREES_KEY.get("magenta")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(12),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("magenta_sapling").get())));

        //Gray Tree
        register(context, TREE_PLACED.get("gray"), configuredFeatures.getOrThrow(TREES_KEY.get("gray")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(10),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("gray_sapling").get())));

        //Light Blue Tree
        register(context, TREE_PLACED.get("light_blue"), configuredFeatures.getOrThrow(TREES_KEY.get("light_blue")), List.of(
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                RarityFilter.onAverageOnceEvery(16),
                CountPlacement.of(1),
                BiomeFilter.biome(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                InSquarePlacement.spread(),
                PlacementTrees.create(),
                PlacementUtils.filteredByBlockSurvival(
                        ColorsBlocks.SAPLINGS.get("light_blue_sapling").get())));





        //Black Stone
        register(context, STONE_PLACED.get("black"), configuredFeatures.getOrThrow(STONE_KEY.get("black")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(10)),
                BiomeFilter.biome()));

        //Red Stone
        register(context, STONE_PLACED.get("red"), configuredFeatures.getOrThrow(STONE_KEY.get("red")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(10)),
                BiomeFilter.biome()));

        //Blue Stone
        register(context, STONE_PLACED.get("blue"), configuredFeatures.getOrThrow(STONE_KEY.get("blue")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(150)),
                BiomeFilter.biome()));

        //Green Stone
        register(context, STONE_PLACED.get("green"), configuredFeatures.getOrThrow(STONE_KEY.get("green")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(150)),
                BiomeFilter.biome()));

        //Yellow Stone
        register(context, STONE_PLACED.get("yellow"), configuredFeatures.getOrThrow(STONE_KEY.get("yellow")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(150)),
                BiomeFilter.biome()));

        //Purple Stone
        register(context, STONE_PLACED.get("purple"), configuredFeatures.getOrThrow(STONE_KEY.get("purple")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(150)),
                BiomeFilter.biome()));

        //Orange Stone
        register(context, STONE_PLACED.get("orange"), configuredFeatures.getOrThrow(STONE_KEY.get("orange")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(150)),
                BiomeFilter.biome()));

        //White Stone
        register(context, STONE_PLACED.get("white"), configuredFeatures.getOrThrow(STONE_KEY.get("white")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(150)),
                BiomeFilter.biome()));

        //Brown Stone
        register(context, STONE_PLACED.get("brown"), configuredFeatures.getOrThrow(STONE_KEY.get("brown")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(10)),
                BiomeFilter.biome()));

        //Pink Stone
        register(context, STONE_PLACED.get("pink"), configuredFeatures.getOrThrow(STONE_KEY.get("pink")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(150)),
                BiomeFilter.biome()));

        //Cyan Stone
        register(context, STONE_PLACED.get("cyan"), configuredFeatures.getOrThrow(STONE_KEY.get("cyan")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(150)),
                BiomeFilter.biome()));

        //Light Gray Stone
        register(context, STONE_PLACED.get("light_gray"), configuredFeatures.getOrThrow(STONE_KEY.get("light_gray")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(10)),
                BiomeFilter.biome()));

        //Lime Stone
        register(context, STONE_PLACED.get("lime"), configuredFeatures.getOrThrow(STONE_KEY.get("lime")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(150)),
                BiomeFilter.biome()));

        //Magenta Stone
        register(context, STONE_PLACED.get("magenta"), configuredFeatures.getOrThrow(STONE_KEY.get("magenta")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.absolute(150)),
                BiomeFilter.biome()));

        //Gray Stone
        register(context, STONE_PLACED.get("gray"), configuredFeatures.getOrThrow(STONE_KEY.get("gray")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(10)),
                BiomeFilter.biome()));

        //Light Blue Stone
        register(context, STONE_PLACED.get("light_blue"), configuredFeatures.getOrThrow(STONE_KEY.get("light_blue")), List.of(
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementStones.create(),
                HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(10)),
                BiomeFilter.biome()));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
