package com.benbenlaw.colors.worldgen;

import com.benbenlaw.colors.config.WorldGenConfig;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.stream.Stream;

public class PlacementStones extends PlacementModifier {

    private static final PlacementStones INSTANCE = new PlacementStones();
    public static final MapCodec<PlacementModifier> CODEC = MapCodec.unit(() -> INSTANCE);


    @Override
    public Stream<BlockPos> getPositions(PlacementContext placementContext, RandomSource random, BlockPos pos) {
        if (WorldGenConfig.shouldColoredStoneSpawn.get()) {
            return Stream.of(pos);
        } else {
            return Stream.empty();
        }
    }

    public static PlacementStones create() {
        return INSTANCE;
    }

    @Override
    public PlacementModifierType<?> type() {
        return ColorsWorldGen.STONES_PLACEMENT.get();
    }
}
