package com.benbenlaw.colors.worldgen;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.HashMap;
import java.util.Map;

import static com.benbenlaw.colors.worldgen.ColorsPlacedFeatures.STONE_PLACED;
import static com.benbenlaw.colors.worldgen.ColorsPlacedFeatures.TREE_PLACED;

public class ColorsBiomeModifiers {

    public static final Map<String, ResourceKey<BiomeModifier>> ADD_TREES = new HashMap<>();
    public static final Map<String, ResourceKey<BiomeModifier>> ADD_STONES = new HashMap<>();

    static {
        for (String color : ColorList.COLORS) {
            ADD_TREES.put(color, registerKey(color + "_tree"));
            ADD_STONES.put(color, registerKey(color + "_stone"));
        }
    }

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        //Black Tree
        context.register(ADD_TREES.get("black"), new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DARK_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("black"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Red Tree
        context.register(ADD_TREES.get("red"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("red"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Green Tree
        context.register(ADD_TREES.get("green"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("green"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Brown Tree
        context.register(ADD_TREES.get("brown"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("brown"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Blue Tree
        context.register(ADD_TREES.get("blue"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SNOWY),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("blue"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Purple Tree
        context.register(ADD_TREES.get("purple"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("purple"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Cyan Tree
        context.register(ADD_TREES.get("cyan"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SNOWY),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("cyan"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Light Gray Tree
        context.register(ADD_TREES.get("light_gray"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("light_gray"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Gray Tree
        context.register(ADD_TREES.get("gray"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("gray"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Pink Tree
        context.register(ADD_TREES.get("pink"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("pink"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Lime Tree
        context.register(ADD_TREES.get("lime"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("lime"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Yellow Tree
        context.register(ADD_TREES.get("yellow"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_DESERT),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("yellow"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Light Blue Tree
        context.register(ADD_TREES.get("light_blue"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SNOWY),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("light_blue"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Magenta Tree
        context.register(ADD_TREES.get("magenta"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("magenta"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Orange Tree
        context.register(ADD_TREES.get("orange"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_BADLANDS),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("orange"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //White Tree
        context.register(ADD_TREES.get("white"), new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SNOWY),
                HolderSet.direct(placedFeatures.getOrThrow(TREE_PLACED.get("white"))),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Stone
        for (String color : ColorList.COLORS) {
            context.register(ADD_STONES.get(color), new BiomeModifiers.AddFeaturesBiomeModifier(
                    biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                    HolderSet.direct(placedFeatures.getOrThrow(STONE_PLACED.get(color))),
                    GenerationStep.Decoration.UNDERGROUND_ORES));
        }

    }



        private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Colors.MOD_ID, name));
    }
}

