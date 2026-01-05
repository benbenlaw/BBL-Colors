package com.benbenlaw.colors.block.custom;

import com.benbenlaw.colors.util.ColorList;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

import static com.benbenlaw.colors.block.ColorsBlocks.*;

public class ColoredTallGrassBlock extends TallGrassBlock {
    public ColoredTallGrassBlock(Properties properties) {
        super(properties);
    }


    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return getGrownBlock(state).defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above());
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        DoublePlantBlock.placeAt(level, getGrownBlock(state).defaultBlockState(), pos, 2);
    }

    private static DoublePlantBlock getGrownBlock(BlockState state) {
        for (String color : ColorList.COLORS) {
            if (state.is(SHORT_GRASS.get(color + "_short_grass").get())) {
                return (DoublePlantBlock) TALL_GRASS.get(color + "_tall_grass").get();
            }
        }

        return (DoublePlantBlock) Blocks.TALL_GRASS;
    }
}
