package com.benbenlaw.colors.util;

import com.benbenlaw.core.block.colored.util.IColored;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.List;
import java.util.Map;

import static com.benbenlaw.colors.block.ColorsBlocks.*;
import static com.benbenlaw.colors.item.ColorsItems.APPLES;

public class ColorHandler {

    List<Map<String, DeferredBlock<Block>>> blockGroups = List.of(
            STONE_BLOCKS, PLANKS, DIRT, GRASS_BLOCK, CRAFTING_TABLE,
            SHORT_GRASS, TALL_GRASS, DANDELION, POTTED_DANDELION,
            POPPY, POTTED_POPPY, LEAVES, WOOD, LOGS, BAMBOO, SAPLINGS
    );

    @SubscribeEvent
    public void registerBlockColors(final RegisterColorHandlersEvent.Block event) {
        for (Map<String, DeferredBlock<Block>> blocks : blockGroups) {
            blocks.values().forEach(block -> event.register(new IColored.BlockColors(), block.get()));
        }
    }

    @SubscribeEvent
    public void onItemColors(RegisterColorHandlersEvent.Item event) {
        for (Map<String, DeferredBlock<Block>> blocks : blockGroups) {
            blocks.values().forEach(block -> event.register(new IColored.ItemColors(), block.get()));
        }

        //Apples
        APPLES.values().forEach(item -> event.register(new IColored.ItemColors(), item.get()));
    }
}
