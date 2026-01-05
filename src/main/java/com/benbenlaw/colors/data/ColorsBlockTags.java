package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.util.ColorList;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
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

        //Color Tags
        for (String color : ColorList.COLORS) {

            for (String type : CHESTS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(Tags.Blocks.CHESTS_WOODEN).add(CHESTS.get(type).get());
                }
            }

            for (String type : PLANKS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.PLANKS).add(PLANKS.get(type).get());
                }
            }

            for (String type : DIRT.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.DIRT).add(DIRT.get(type).get());
                }
            }

            for (String type : GRASS_BLOCK.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.DIRT).add(GRASS_BLOCK.get(type).get());
                }
            }

            for (String type : CRAFTING_TABLE.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(Tags.Blocks.PLAYER_WORKSTATIONS_CRAFTING_TABLES).add(CRAFTING_TABLE.get(type).get());

                }
            }

            for (String type : POPPY.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.SMALL_FLOWERS).add(POPPY.get(type).get());

                }
            }

            for (String type : DANDELION.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.SMALL_FLOWERS).add(DANDELION.get(type).get());

                }
            }

            for (String type : POTTED_POPPY.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.FLOWER_POTS).add(POTTED_POPPY.get(type).get());
                }
            }

            for (String type : POTTED_DANDELION.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.FLOWER_POTS).add(POTTED_DANDELION.get(type).get());

                }
            }

            for (String type : POTTED_SAPLING.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.FLOWER_POTS).add(POTTED_SAPLING.get(type).get());
                }
            }

            for (String type : LEAVES.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.LEAVES).add(LEAVES.get(type).get());
                }
            }

            for (String type : WOOD.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.MINEABLE_WITH_AXE).add(WOOD.get(type).get());
                    tag(BlockTags.LOGS_THAT_BURN).add(WOOD.get(type).get());
                }
                if (type.startsWith(color + "_stripped")) {
                    tag(Tags.Blocks.STRIPPED_WOODS).add(WOOD.get(type).get());
                }
            }

            for (String type : LOGS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.MINEABLE_WITH_AXE).add(LOGS.get(type).get());
                    tag(BlockTags.LOGS_THAT_BURN).add(LOGS.get(type).get());
                }
                if (type.startsWith(color + "_stripped")) {
                    tag(Tags.Blocks.STRIPPED_LOGS).add(LOGS.get(type).get());
                }
            }

            for (String type : CHESTS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.MINEABLE_WITH_AXE).add(CHESTS.get(type).get());
                }
            }

            for (String type : SAPLINGS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.SAPLINGS).add(SAPLINGS.get(type).get());
                }
            }
        }


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
                        .toArray(Block[]::new))

                .add(SAND.values().stream()
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