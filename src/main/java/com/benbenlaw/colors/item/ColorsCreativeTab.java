package com.benbenlaw.colors.item;

import com.benbenlaw.colors.Colors;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Comparator;
import java.util.function.Supplier;

import static com.benbenlaw.colors.block.ColorsBlocks.*;
import static com.benbenlaw.colors.item.ColorsItems.*;

public class ColorsCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Colors.MOD_ID);
    public static final Supplier<CreativeModeTab> CAVEOPOLIS_TAB = CREATIVE_TABS.register(Colors.MOD_ID, () -> CreativeModeTab.builder()
            .icon(() -> STONE_BLOCKS.get("white_stone").get().asItem().getDefaultInstance())
            .title(Component.translatable("creative." + Colors.MOD_ID + ".tab"))
            .displayItems((parameters, output) -> {

                //Stone Like
                STONE_BLOCKS.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = STONE_BLOCKS.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Planks
                PLANKS.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = PLANKS.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Dirt
                DIRT.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = DIRT.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Grass Block
                GRASS_BLOCK.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = GRASS_BLOCK.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Crafting Table
                CRAFTING_TABLE.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = CRAFTING_TABLE.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Tall Grass
                TALL_GRASS.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = TALL_GRASS.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Short Grass
                SHORT_GRASS.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = SHORT_GRASS.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Poppy
                POPPY.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = POPPY.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Dandelion
                DANDELION.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = DANDELION.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Leaves
                LEAVES.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = LEAVES.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Wood
                WOOD.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = WOOD.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Log
                LOGS.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = LOGS.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Bamboo
                BAMBOO.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = BAMBOO.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Sapling
                SAPLINGS.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Block block = SAPLINGS.get(color).get();
                            Item item = block.asItem();
                            output.accept(item);
                        });

                //Apples
                APPLES.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Item apple = APPLES.get(color).get();
                            output.accept(apple);
                        });

                //Spray Cans
                SPRAY_CANS.keySet().stream()
                        .sorted(Comparator.naturalOrder())
                        .forEach(color -> {
                            Item sprayCan = SPRAY_CANS.get(color).get();
                            output.accept(sprayCan);
                        });
                output.accept(GLOWSTONE_SPRAY_CAN.get());



            }).build());




}
