package com.benbenlaw.colors.data;

import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.datamaps.ColorsCustomDataMaps;
import com.benbenlaw.colors.item.ColorsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static com.benbenlaw.colors.block.ColorsBlocks.*;

public class ColorsDataMaps extends DataMapProvider {

    public ColorsDataMaps(PackOutput output, CompletableFuture<HolderLookup.Provider> providerCompletableFuture) {
        super(output, providerCompletableFuture);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
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

        builder(ColorsCustomDataMaps.UNCOLORED_TO_COLORED_BLOCKS)
                .add(Blocks.STONE.builtInRegistryHolder().key(),"colors:%d_stone", false)
                .add(Blocks.COBBLESTONE.builtInRegistryHolder().key(),"colors:%d_cobblstone", false)
                .add(Blocks.GRASS_BLOCK.builtInRegistryHolder().key(),"colors:%d_grass_block", false)
                .add(Blocks.DIRT.builtInRegistryHolder().key(),"colors:%d_dirt", false)
                .add(Blocks.SAND.builtInRegistryHolder().key(),"colors:%d_sand", false)
                .add(Blocks.STONE_BRICKS.builtInRegistryHolder().key(),"colors:%d_stone_bricks", false)

                //Vanilla Blocks
                .add(Blocks.GLASS.builtInRegistryHolder().key(),"minecraft:%d_stained_glass", false)
                .add(Blocks.GLASS_PANE.builtInRegistryHolder().key(),"minecraft:%d_stained_glass", false);







    }
}
