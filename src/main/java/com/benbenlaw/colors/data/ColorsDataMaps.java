package com.benbenlaw.colors.data;

import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.item.ColorsItems;
import com.benbenlaw.core.item.colored.ColoredItem;
import com.benbenlaw.core.util.ColorList;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

import static com.benbenlaw.colors.block.ColorsBlocks.*;

public class ColorsDataMaps extends DataMapProvider {

    public ColorsDataMaps(PackOutput output, CompletableFuture<HolderLookup.Provider> providerCompletableFuture) {
        super(output, providerCompletableFuture);
    }

    @Override
    protected void gather() {
        var compostables = this.builder(NeoForgeDataMaps.COMPOSTABLES);

        for (String type : LEAVES.keySet()) {
            compostables.add(ColorsBlocks.LEAVES.get(type).get().asItem().builtInRegistryHolder(), new Compostable(0.3f), false);
        }

        for (String type : SAPLINGS.keySet()) {
            compostables.add(ColorsBlocks.SAPLINGS.get(type).get().asItem().builtInRegistryHolder(), new Compostable(0.3f), false);
        }

        for (String type : POPPY.keySet()) {
            compostables.add(ColorsBlocks.POPPY.get(type).get().asItem().builtInRegistryHolder(), new Compostable(0.65f), false);
        }

        for (String type : DANDELION.keySet()) {
            compostables.add(ColorsBlocks.DANDELION.get(type).get().asItem().builtInRegistryHolder(), new Compostable(0.65f), false);
        }

        for (String type : TALL_GRASS.keySet()) {
            compostables.add(ColorsBlocks.TALL_GRASS.get(type).get().asItem().builtInRegistryHolder(), new Compostable(0.5f), false);
        }

        for (String type : SHORT_GRASS.keySet()) {
            compostables.add(ColorsBlocks.SHORT_GRASS.get(type).get().asItem().builtInRegistryHolder(), new Compostable(0.3f), false);
        }

        for (String type : ColorsItems.APPLES.keySet()) {
            compostables.add(ColorsItems.APPLES.get(type).get().asItem().builtInRegistryHolder(), new Compostable(0.65f), false);
        }






    }
}
