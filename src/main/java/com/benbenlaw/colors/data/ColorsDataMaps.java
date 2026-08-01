package com.benbenlaw.colors.data;

import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.datamaps.ColorsCustomDataMaps;
import com.benbenlaw.colors.item.ColorsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Strippable;

import java.util.Map;
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

        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.LOGS.entrySet()) {
            String key = entry.getKey();

            if (!key.endsWith("_log") || key.contains("stripped"))
                continue;

            builder(NeoForgeDataMaps.STRIPPABLES).add(
                    entry.getValue(),
                    new Strippable(ColorsBlocks.LOGS.get(key.replace("_log", "_stripped_log")).get()),
                    false
            );
        }
        for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.WOOD.entrySet()) {
            String key = entry.getKey();

            if (!key.endsWith("_wood") || key.contains("stripped"))
                continue;

            builder(NeoForgeDataMaps.STRIPPABLES).add(
                    entry.getValue(),
                    new Strippable(ColorsBlocks.WOOD.get(key.replace("_wood", "_stripped_wood")).get()),
                    false
            );
        }

        addColoredDataMap(Blocks.STONE, "colors:%s_stone");
        addColoredDataMap(Blocks.STONE_STAIRS, "colors:%s_stone_stairs");
        addColoredDataMap(Blocks.STONE_SLAB, "colors:%s_stone_slab");
        addColoredDataMap(Blocks.STONE_PRESSURE_PLATE, "colors:%s_stone_pressure_plate");
        addColoredDataMap(Blocks.STONE_BUTTON, "colors:%s_stone_button");

        addColoredDataMap(Blocks.COBBLESTONE, "colors:%s_cobblestone");
        addColoredDataMap(Blocks.COBBLESTONE_STAIRS, "colors:%s_cobblestone_stairs");
        addColoredDataMap(Blocks.COBBLESTONE_SLAB, "colors:%s_cobblestone_slab");
        addColoredDataMap(Blocks.COBBLESTONE_WALL, "colors:%s_cobblestone_wall");

        addColoredDataMap(Blocks.STONE_BRICKS, "colors:%s_stone_biricks");
        addColoredDataMap(Blocks.STONE_BRICK_STAIRS, "colors:%s_stone_brick_stairs");
        addColoredDataMap(Blocks.STONE_BRICK_SLAB, "colors:%s_stone_brick_slab");
        addColoredDataMap(Blocks.STONE_BRICK_WALL, "colors:%s_stone_brick_wall");

        addColoredDataMap(Blocks.PRISMARINE, "colors:%s_prismarine");
        addColoredDataMap(Blocks.PRISMARINE_STAIRS, "colors:%s_prismarine_stairs");
        addColoredDataMap(Blocks.PRISMARINE_SLAB, "colors:%s_prismarine_slab");
        addColoredDataMap(Blocks.PRISMARINE_WALL, "colors:%s_prismarine_wall");

        addColoredDataMap(Blocks.DARK_PRISMARINE, "colors:%s_dark_prismarine");
        addColoredDataMap(Blocks.DARK_PRISMARINE_STAIRS, "colors:%s_dark_prismarine_stairs");
        addColoredDataMap(Blocks.DARK_PRISMARINE_SLAB, "colors:%s_dark_prismarine_slab");

        addColoredDataMap(Blocks.PRISMARINE_BRICKS, "colors:%s_prismarine_bricks");
        addColoredDataMap(Blocks.PRISMARINE_BRICK_STAIRS, "colors:%s_prismarine_brick_stairs");
        addColoredDataMap(Blocks.PRISMARINE_BRICK_SLAB, "colors:%s_prismarine_brick_slab");

        addColoredDataMap(Blocks.GRASS_BLOCK, "colors:%s_grass_block");
        addColoredDataMap(Blocks.DIRT, "colors:%s_dirt");
        addColoredDataMap(Blocks.SAND, "colors:%s_sand");
        addColoredDataMap(Blocks.CRACKED_STONE_BRICKS, "colors:%s_cracked_stone_bricks");
        addColoredDataMap(Blocks.POPPY, "colors:%s_poppy");
        addColoredDataMap(Blocks.DANDELION, "colors:%s_dandelion");
        addColoredDataMap(Blocks.POTTED_POPPY, "colors:%s_potted_poppy");
        addColoredDataMap(Blocks.POTTED_DANDELION, "colors:%s_potted_dandelion");
        addColoredDataMap(Blocks.CHEST, "colors:%s_chest");
        addColoredDataMap(Blocks.BAMBOO_BLOCK, "colors:%s_bamboo");
        addColoredDataMap(Blocks.STRIPPED_BAMBOO_BLOCK, "colors:%s_stripped_bamboo");
        addColoredDataMap(Blocks.CRAFTING_TABLE, "colors:%s_crafting_table");
        addColoredDataMap(Blocks.SHORT_GRASS, "colors:%s_short_grass");
        addColoredDataMap(Blocks.TALL_GRASS, "colors:%s_tall_grass");
        addColoredDataMap(Blocks.SAND, "colors:%s_sand");
        addColoredDataMap(Blocks.SANDSTONE, "colors:%s_sandstone");

        //Vanilla Blocks
        addColoredDataMap(Blocks.GLASS, "minecraft:%s_stained_glass");
        addColoredDataMap(Blocks.GLASS_PANE, "minecraft:%s_stained_glass_plane");

        addColoredDataMap(Blocks.TERRACOTTA, "minecraft:%s_terracotta");
        addColoredDataMap(Blocks.SHULKER_BOX, "minecraft:%s_shulker_box");
        addColoredDataMap(Blocks.CANDLE, "minecraft:%s_candle");









    }

    public void addColoredDataMap(Block block, String template) {
        builder(ColorsCustomDataMaps.UNCOLORED_TO_COLORED_BLOCKS)
                .add(block.defaultBlockState().typeHolder(), template, false);
    }
}
