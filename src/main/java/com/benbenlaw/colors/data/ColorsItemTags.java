package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.block.sets.StoneLikeBlocksList;
import com.benbenlaw.colors.item.ColorsItems;
import com.benbenlaw.colors.util.ColorsTags;
import com.benbenlaw.core.util.ColorList;
import com.benbenlaw.core.util.CoreTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static com.benbenlaw.colors.block.ColorsBlocks.*;
import static com.benbenlaw.colors.item.ColorsItems.APPLES;
import static com.benbenlaw.colors.item.ColorsItems.SPRAY_CANS;

public class ColorsItemTags extends ItemTagsProvider {

    ColorsItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags.contentsGetter(), Colors.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        //Color Tags
        for (String color : ColorList.COLORS) {

            for (String type : PlankLikeBlocksList.PLANKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                tag(CoreTags.Items.COLOR_TAGS.get(color)).add(
                        PLANKS.get(color + "_" + type).get().asItem(),
                        PLANKS.get(keyPrefix + "_stairs").get().asItem(),
                        PLANKS.get(keyPrefix + "_slab").get().asItem(),
                        PLANKS.get(keyPrefix + "_fence").get().asItem(),
                        PLANKS.get(keyPrefix + "_fence_gate").get().asItem(),
                        PLANKS.get(keyPrefix + "_pressure_plate").get().asItem(),
                        PLANKS.get(keyPrefix + "_button").get().asItem(),
                        PLANKS.get(keyPrefix + "_trapdoor").get().asItem(),
                        PLANKS.get(keyPrefix + "_door").get().asItem()
                );

                tag(ItemTags.PLANKS).add(PLANKS.get(color + "_" + type).get().asItem());
            }

            for (String type : StoneLikeBlocksList.STONE_BLOCKS) {

                String singularType = type.endsWith("s") ? type.substring(0, type.length() - 1) : type;
                String keyPrefix = color + "_" + singularType;

                tag(CoreTags.Items.COLOR_TAGS.get(color)).add(
                        STONE_BLOCKS.get(color + "_" + type).get().asItem(),
                        STONE_BLOCKS.get(keyPrefix + "_stairs").get().asItem(),
                        STONE_BLOCKS.get(keyPrefix + "_slab").get().asItem(),
                        STONE_BLOCKS.get(keyPrefix + "_wall").get().asItem(),
                        STONE_BLOCKS.get(keyPrefix + "_pressure_plate").get().asItem(),
                        STONE_BLOCKS.get(keyPrefix + "_button").get().asItem()
                );
            }

            for (String type : ColorsItems.PLANKS.keySet()) {
                if (type.endsWith(color + "_hanging_sign")) {
                    tag(ItemTags.HANGING_SIGNS).add(ColorsItems.PLANKS.get(type).get().asItem());
                }
                else if (type.endsWith(color + "_sign")) {
                    tag(ItemTags.SIGNS).add(ColorsItems.PLANKS.get(type).get().asItem());
                }
            }

            for (String type : DIRT.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(DIRT.get(type).get().asItem());
                    tag(ItemTags.DIRT).add(DIRT.get(type).get().asItem());
                }
            }

            for (String type : GRASS_BLOCK.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(GRASS_BLOCK.get(type).get().asItem());
                    tag(ItemTags.DIRT).add(GRASS_BLOCK.get(type).get().asItem());

                }
            }

            for (String type : CRAFTING_TABLE.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(CRAFTING_TABLE.get(type).get().asItem());
                    tag(Tags.Items.PLAYER_WORKSTATIONS_CRAFTING_TABLES).add(CRAFTING_TABLE.get(type).get().asItem());
                }
            }

            for (String type : TALL_GRASS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(TALL_GRASS.get(type).get().asItem());
                }
            }

            for (String type : SHORT_GRASS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(SHORT_GRASS.get(type).get().asItem());
                }
            }

            for (String type : POPPY.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(POPPY.get(type).get().asItem());
                    tag(ItemTags.SMALL_FLOWERS).add(POPPY.get(type).get().asItem());

                }
            }

            for (String type : DANDELION.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(DANDELION.get(type).get().asItem());
                    tag(ItemTags.SMALL_FLOWERS).add(DANDELION.get(type).get().asItem());
                }
            }

            for (String type : LEAVES.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(LEAVES.get(type).get().asItem());
                    tag(ItemTags.LEAVES).add(LEAVES.get(type).get().asItem());
                }
            }

            for (String type : BAMBOO.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(BAMBOO.get(type).get().asItem());
                }
            }

            for (String type : WOOD.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(WOOD.get(type).get().asItem());
                    tag(ColorsTags.Items.LOG_TAGS.get(color)).add(WOOD.get(type).get().asItem());
                    tag(ItemTags.LOGS_THAT_BURN).add(WOOD.get(type).get().asItem());
                }
                if (type.startsWith(color + "_stripped")) {
                    tag(Tags.Items.STRIPPED_WOODS).add(WOOD.get(type).get().asItem());
                }
            }

            for (String type : LOGS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(LOGS.get(type).get().asItem());
                    tag(ColorsTags.Items.LOG_TAGS.get(color)).add(LOGS.get(type).get().asItem());
                    tag(ItemTags.LOGS_THAT_BURN).add(LOGS.get(type).get().asItem());
                }
                if (type.startsWith(color + "_stripped")) {
                    tag(Tags.Items.STRIPPED_LOGS).add(LOGS.get(type).get().asItem());
                }
            }

            //Saplings
            for (String type : SAPLINGS.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(SAPLINGS.get(type).get().asItem());
                    tag(ItemTags.SAPLINGS).add(SAPLINGS.get(type).get().asItem());
                }
            }

            //Apple
            for (String type : APPLES.keySet()) {
                if (type.startsWith(color + "_")) {
                    tag(CoreTags.Items.COLOR_TAGS.get(color)).add(APPLES.get(type).get().asItem());
                }
            }

            //Wooden Pressure Plates
            tag(ItemTags.WOODEN_PRESSURE_PLATES).add(
                    PLANKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_pressure_plate"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );

            //Wooden Buttons
            tag(ItemTags.WOODEN_BUTTONS).add(
                    PLANKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_button"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );

            //Wooden Trapdoors
            tag(ItemTags.WOODEN_TRAPDOORS).add(
                    PLANKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_trapdoor"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );

            //Wooden Doors
            tag(ItemTags.WOODEN_DOORS).add(
                    PLANKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_door"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );

            //Wooden Fences
            tag(ItemTags.WOODEN_FENCES).add(
                    PLANKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_fence"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );

            //Wooden Fence Gates
            tag(ItemTags.FENCE_GATES).add(
                    PLANKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_fence_gate"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );

            //Wooden Slabs
            tag(ItemTags.WOODEN_SLABS).add(
                    PLANKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_slab"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );

            //Wooden Stairs
            tag(ItemTags.WOODEN_STAIRS).add(
                    PLANKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_stairs"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );

            //Stairs
            tag(ItemTags.STAIRS).add(
                    STONE_BLOCKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_stairs"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );

            //Slabs
            tag(ItemTags.SLABS).add(
                    STONE_BLOCKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_slab"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );

            //Walls
            tag(ItemTags.WALLS).add(
                    STONE_BLOCKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_wall"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );


            //Buttons
            tag(ItemTags.BUTTONS).add(
                    STONE_BLOCKS.entrySet().stream()
                            .filter(entry -> entry.getKey().endsWith("_button"))
                            .map(entry -> Item.BY_BLOCK.get(entry.getValue().get()))
                            .filter(Objects::nonNull)
                            .toArray(Item[]::new)
            );
        }

        //Spray Cans
        tag(Tags.Items.DYES_BLACK).add(SPRAY_CANS.get("black_spray_can").get());
        tag(Tags.Items.DYES_BLUE).add(SPRAY_CANS.get("blue_spray_can").get());
        tag(Tags.Items.DYES_GREEN).add(SPRAY_CANS.get("green_spray_can").get());
        tag(Tags.Items.DYES_RED).add(SPRAY_CANS.get("red_spray_can").get());
        tag(Tags.Items.DYES_YELLOW).add(SPRAY_CANS.get("yellow_spray_can").get());
        tag(Tags.Items.DYES_PURPLE).add(SPRAY_CANS.get("purple_spray_can").get());
        tag(Tags.Items.DYES_ORANGE).add(SPRAY_CANS.get("orange_spray_can").get());
        tag(Tags.Items.DYES_LIGHT_BLUE).add(SPRAY_CANS.get("light_blue_spray_can").get());
        tag(Tags.Items.DYES_LIME).add(SPRAY_CANS.get("lime_spray_can").get());
        tag(Tags.Items.DYES_PINK).add(SPRAY_CANS.get("pink_spray_can").get());
        tag(Tags.Items.DYES_CYAN).add(SPRAY_CANS.get("cyan_spray_can").get());
        tag(Tags.Items.DYES_LIGHT_GRAY).add(SPRAY_CANS.get("light_gray_spray_can").get());
        tag(Tags.Items.DYES_GRAY).add(SPRAY_CANS.get("gray_spray_can").get());
        tag(Tags.Items.DYES_BROWN).add(SPRAY_CANS.get("brown_spray_can").get());
        tag(Tags.Items.DYES_MAGENTA).add(SPRAY_CANS.get("magenta_spray_can").get());
        tag(Tags.Items.DYES_WHITE).add(SPRAY_CANS.get("white_spray_can").get());

    }
}