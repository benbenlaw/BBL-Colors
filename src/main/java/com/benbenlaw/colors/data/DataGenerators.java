package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Colors.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ColorsRecipesBuilder(packOutput, event.getLookupProvider()));

        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ColorsLootTableProvider::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));

        ColorsBlockTags blockTags = new ColorsBlockTags(packOutput, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);

        ColorsItemTags itemTags = new ColorsItemTags(packOutput, lookupProvider, blockTags, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), itemTags);
//
        generator.addProvider(event.includeClient(), new ColorsItemModelProvider(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ColorsBlockStatesProvider(packOutput, event.getExistingFileHelper()));

        generator.addProvider(event.includeClient(), new ColorsLangProvider(packOutput, event.getExistingFileHelper()));
//
        generator.addProvider(event.includeServer(), new ColorsWorldGenProviders(packOutput, lookupProvider));
//
        //generator.addProvider(event.includeServer(), new CaveopolisDataMapProvider(packOutput, lookupProvider));

    }
}