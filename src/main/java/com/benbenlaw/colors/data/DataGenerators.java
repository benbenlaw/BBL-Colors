package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
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
        generator.addProvider(true, new ColorsRecipesBuilder.Runner (packOutput, event.getLookupProvider()));

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ColorsLootTableProvider::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));

        ColorsBlockTags blockTags = new ColorsBlockTags(packOutput, lookupProvider);
        generator.addProvider(true, blockTags);

        ColorsItemTags itemTags = new ColorsItemTags(packOutput, lookupProvider);
        generator.addProvider(true, itemTags);
        generator.addProvider(true, new ColorsModelProvider(packOutput));
        generator.addProvider(true, new ColorsLangProvider(packOutput));
        generator.addProvider(true, new ColorsWorldGenProviders(packOutput, lookupProvider));
        generator.addProvider(true, new ColorsDataMaps(packOutput, lookupProvider));
        generator.addProvider(true, new ColorsRecipePriorities(packOutput, lookupProvider));


    }

    private static void trackGeneratedTintedTextures(Map<? extends StringRepresentable, Integer> colorMap, String baseTexture, String type) {
        for (var dyeColor : colorMap.keySet()) {
            // The same path that ColorsTextureProvider writes to:
            Identifier loc = Identifier.fromNamespaceAndPath(Colors.MOD_ID, type + "/" + dyeColor.getSerializedName() + "_" + baseTexture);

            //exHelper.trackGenerated(loc, PackType.CLIENT_RESOURCES, ".png", "textures");
        }
    }


}