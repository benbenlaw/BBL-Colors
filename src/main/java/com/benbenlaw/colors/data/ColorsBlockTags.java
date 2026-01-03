package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static com.benbenlaw.colors.block.ColorsBlocks.*;

public class ColorsBlockTags extends BlockTagsProvider {

    ColorsBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Colors.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        //Mineable With Pickaxe
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                STONE_BLOCKS.values().stream()
                        .map(Supplier::get)
                        .toArray(Block[]::new)
                );

        //Mineable With Axe
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(PLANKS.values().stream()
                        .map(Supplier::get)
                        .toArray(Block[]::new))

                .add(CRAFTING_TABLE.values().stream()
                        .map(Supplier::get)
                        .toArray(Block[]::new)
        );

        //Mineable With Shovel
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(DIRT.values().stream()
                        .map(Supplier::get)
                        .toArray(Block[]::new))

                .add(GRASS_BLOCK.values().stream()
                        .map(Supplier::get)
                        .toArray(Block[]::new)
        );

        //Wooden Pressure Plates
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(
                PLANKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_pressure_plate"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Wooden Buttons
        tag(BlockTags.WOODEN_BUTTONS).add(
                PLANKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_button"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Wooden Trapdoors
        tag(BlockTags.WOODEN_TRAPDOORS).add(
                PLANKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_trapdoor"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Wooden Doors
        tag(BlockTags.WOODEN_DOORS).add(
                PLANKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_door"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Wooden Fences
        tag(BlockTags.WOODEN_FENCES).add(
                PLANKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_fence"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Wooden Fence Gates
        tag(BlockTags.FENCE_GATES).add(
                PLANKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_fence_gate"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Wooden Slabs
        tag(BlockTags.WOODEN_SLABS).add(
                PLANKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_slab"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Wooden Stairs
        tag(BlockTags.WOODEN_STAIRS).add(
                PLANKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_stairs"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Stairs
        tag(BlockTags.STAIRS).add(
                STONE_BLOCKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_stairs"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Slabs
        tag(BlockTags.SLABS).add(
                STONE_BLOCKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_slab"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Walls
        tag(BlockTags.WALLS).add(
                STONE_BLOCKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_wall"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Pressure Plates
        tag(BlockTags.STONE_PRESSURE_PLATES).add(
                STONE_BLOCKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_pressure_plate"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );

        //Buttons
        tag(BlockTags.BUTTONS).add(
                STONE_BLOCKS.entrySet().stream()
                        .filter(entry -> entry.getKey().endsWith("_button"))
                        .map(entry -> entry.getValue().get())
                        .toArray(Block[]::new)
        );
    }

}