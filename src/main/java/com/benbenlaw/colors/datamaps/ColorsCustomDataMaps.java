package com.benbenlaw.colors.datamaps;

import com.benbenlaw.colors.Colors;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.datamaps.DataMapType;

import java.util.Optional;

public class ColorsCustomDataMaps {

    public static final DataMapType<Block, String> UNCOLORED_TO_COLORED_BLOCKS = DataMapType.builder(
            Colors.identifier("uncolored_to_colored_blocks"), Registries.BLOCK, Codec.STRING)
            .synced(Codec.STRING, true).build();

}
