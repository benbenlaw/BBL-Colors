package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.core.block.colored.util.ColorMap;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Colors.MOD_ID)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //Generate Textures FIRST!
        generator.addProvider(true,  new ColorsTextureProvider(packOutput));

        /*
        String[] baseTextures = new String[] {
                "apple", "sapling", "bamboo_mosaic_door", "bamboo_plank_door",
                "asteroid", "asteroid_bricks", "asteroid_tiles", "bamboo",
                "bamboo_top", "bamboo_mosaic", "bamboo_mosaic_door_bottom",
                "bamboo_mosaic_door_top", "bamboo_mosaic_trapdoor", "bamboo_planks",
                "bamboo_plank_door_bottom", "bamboo_plank_door_top", "bamboo_plank_trapdoor",
                "bamboo_top", "braid", "bricks", "chaotic", "cobblestone", "cobblestone_bricks",
                "cracked_stone_bricks", "crafting_table", "crafting_table_side", "crafting_table_top",
                "dandelion", "dark_prismarine", "dirt", "encased", "encased_connected",
                "grass_block_side", "grass_block_side_snow", "grass_block_top", "grass_block_top_snow",
                "leaves", "log", "log_top", "marble", "marble_bricks", "mosaic", "planks",
                "plank_door_bottom", "plank_door_top", "plank_door", "plank_trapdoor", "polished",
                "poppy", "prismarine", "prismarine_bricks", "road", "short_grass", "stone",
                "stone_bricks", "stripped_bamboo", "stripped_bamboo_top",
                "stripped_log", "stripped_log_top", "tall_grass_bottom", "tall_grass_top",
                "tiles", "triple", "plank_sign", "bamboo_plank_sign", "bamboo_mosaic_sign", "plank_hanging_sign",
                "bamboo_plank_hanging_sign", "bamboo_mosaic_hanging_sign"
        };

        // Tell the existing file helper about all the textures we are going to generate, so it doesn't think they are missing when validating models.
        for (String base : baseTextures) {
            trackGeneratedTintedTextures(existingFileHelper, ColorMap.COLOR_MAP, base, "block");
            trackGeneratedTintedTextures(existingFileHelper, ColorMap.COLOR_MAP, base, "item");
        }

         */

        generator.addProvider(true, new ColorsRecipesBuilder.Runner (packOutput, event.getLookupProvider()));

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ColorsLootTableProvider::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));

        ColorsBlockTags blockTags = new ColorsBlockTags(packOutput, lookupProvider);
        generator.addProvider(true, blockTags);

        ColorsItemTags itemTags = new ColorsItemTags(packOutput, lookupProvider);
        generator.addProvider(true, itemTags);
        generator.addProvider(true, new ColorsItemModelProvider(packOutput));

        generator.addProvider(true, new ColorsBlockStatesProvider(packOutput));
        generator.addProvider(true, new ColorsLangProvider(packOutput));
        generator.addProvider(true, new ColorsWorldGenProviders(packOutput, lookupProvider));
        generator.addProvider(true, new ColorsDataMaps(packOutput, lookupProvider));


    }

    private static void trackGeneratedTintedTextures(Map<? extends StringRepresentable, Integer> colorMap, String baseTexture, String type) {
        for (var dyeColor : colorMap.keySet()) {
            // The same path that ColorsTextureProvider writes to:
            Identifier loc = Identifier.fromNamespaceAndPath(Colors.MOD_ID, type + "/" + dyeColor.getSerializedName() + "_" + baseTexture);

            exHelper.trackGenerated(loc, PackType.CLIENT_RESOURCES, ".png", "textures");
        }
    }


}