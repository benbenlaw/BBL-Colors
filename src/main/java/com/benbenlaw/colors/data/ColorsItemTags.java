package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.sets.PlankLikeBlocksList;
import com.benbenlaw.colors.block.sets.StoneLikeBlocksList;
import com.benbenlaw.colors.item.ColorsItems;
import com.benbenlaw.colors.util.ColorsTags;
import com.benbenlaw.core.util.CoreTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static com.benbenlaw.colors.block.ColorsBlocks.*;
import static com.benbenlaw.colors.item.ColorsItems.APPLES;
import static com.benbenlaw.colors.item.ColorsItems.SPRAY_CANS;

public class ColorsItemTags extends ItemTagsProvider {

    ColorsItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Colors.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

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