package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.block.sets.StoneLikeBlocksList;
import com.benbenlaw.colors.util.ColorsTags;
import com.benbenlaw.core.util.ColorList;
import com.benbenlaw.core.util.CoreTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static com.benbenlaw.colors.block.ColorsBlocks.*;

public class ColorsBlockTags extends BlockTagsProvider {

    ColorsBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Colors.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {


        //Color Tags
        for (String color : ColorList.COLORS) {

            for (String type : StoneLikeBlocksList.STONE_BLOCKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(
                        STONE_BLOCKS.get(color + "_" + type).get(),
                        STONE_BLOCKS.get(keyPrefix + "_stairs").get(),
                        STONE_BLOCKS.get(keyPrefix + "_slab").get(),
                        STONE_BLOCKS.get(keyPrefix + "_wall").get(),
                        STONE_BLOCKS.get(keyPrefix + "_pressure_plate").get(),
                        STONE_BLOCKS.get(keyPrefix + "_button").get()
                );
            }

            for (String type : PlankLikeBlocksList.PLANKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(
                        PLANKS.get(color + "_" + type).get(),
                        PLANKS.get(keyPrefix + "_stairs").get(),
                        PLANKS.get(keyPrefix + "_slab").get(),
                        PLANKS.get(keyPrefix + "_fence").get(),
                        PLANKS.get(keyPrefix + "_fence_gate").get(),
                        PLANKS.get(keyPrefix + "_pressure_plate").get(),
                        PLANKS.get(keyPrefix + "_button").get(),
                        PLANKS.get(keyPrefix + "_trapdoor").get(),
                        PLANKS.get(keyPrefix + "_door").get()
                );
            }

            for (String type : DIRT.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(DIRT.get(type).get());
                    tag(BlockTags.DIRT).add(DIRT.get(type).get());
                }
            }

            for (String type : GRASS_BLOCK.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(GRASS_BLOCK.get(type).get());
                    tag(BlockTags.DIRT).add(GRASS_BLOCK.get(type).get());
                }
            }

            for (String type : CRAFTING_TABLE.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(CRAFTING_TABLE.get(type).get());
                    tag(Tags.Blocks.PLAYER_WORKSTATIONS_CRAFTING_TABLES).add(CRAFTING_TABLE.get(type).get());

                }
            }

            for (String type : SHORT_GRASS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(SHORT_GRASS.get(type).get());
                }
            }

            for (String type : TALL_GRASS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(TALL_GRASS.get(type).get());
                }
            }

            for (String type : POPPY.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(POPPY.get(type).get());
                    tag(BlockTags.SMALL_FLOWERS).add(POPPY.get(type).get());

                }
            }

            for (String type : DANDELION.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.FLOWERS).add(DANDELION.get(type).get());
                    tag(BlockTags.SMALL_FLOWERS).add(DANDELION.get(type).get());

                }
            }

            for (String type : POTTED_POPPY.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(POTTED_POPPY.get(type).get());
                    tag(BlockTags.FLOWER_POTS).add(POTTED_POPPY.get(type).get());
                }
            }

            for (String type : DANDELION.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(DANDELION.get(type).get());
                }
            }

            for (String type : DANDELION.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(BlockTags.FLOWERS).add(DANDELION.get(type).get());
                    tag(BlockTags.FLOWER_POTS).add(DANDELION.get(type).get());
                }
            }

            for (String type : POTTED_DANDELION.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(POTTED_DANDELION.get(type).get());
                    tag(BlockTags.FLOWER_POTS).add(POTTED_DANDELION.get(type).get());

                }
            }

            for (String type : LEAVES.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(LEAVES.get(type).get());
                    tag(BlockTags.LEAVES).add(LEAVES.get(type).get());
                }
            }

            for (String type : BAMBOO.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(BAMBOO.get(type).get());
                }
            }

            for (String type : WOOD.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(WOOD.get(type).get());
                    tag(ColorsTags.Blocks.LOG_TAGS.get(color)).add(WOOD.get(type).get());
                    tag(BlockTags.MINEABLE_WITH_AXE).add(WOOD.get(type).get());
                    tag(BlockTags.LOGS_THAT_BURN).add(WOOD.get(type).get());
                }
                if (type.startsWith(color + "_stripped")) {
                    tag(Tags.Blocks.STRIPPED_WOODS).add(WOOD.get(type).get());
                }
            }

            for (String type : LOGS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(LOGS.get(type).get());
                    tag(ColorsTags.Blocks.LOG_TAGS.get(color)).add(LOGS.get(type).get());
                    tag(BlockTags.MINEABLE_WITH_AXE).add(LOGS.get(type).get());
                    tag(BlockTags.LOGS_THAT_BURN).add(LOGS.get(type).get());
                }
                if (type.startsWith(color + "_stripped")) {
                    tag(Tags.Blocks.STRIPPED_LOGS).add(LOGS.get(type).get());
                }
            }

            for (String type : SAPLINGS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Blocks.COLOR_TAGS.get(color)).add(SAPLINGS.get(type).get());
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