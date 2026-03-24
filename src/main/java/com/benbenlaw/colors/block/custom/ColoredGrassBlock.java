package com.benbenlaw.colors.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.lighting.LightEngine;

public class ColoredGrassBlock extends GrassBlock implements BonemealableBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    private final Block DIRT_BLOCK;
    private final Block SHORT_GRASS_BLOCK;
    private final ResourceKey<ConfiguredFeature<?, ?>> VEGETATION_PLACEMENT;


    public ColoredGrassBlock(Properties properties, ResourceKey<ConfiguredFeature<?, ?>> vegetationPlacements, Block dirt, Block shortGrassBlock) {
        super(properties);
        VEGETATION_PLACEMENT = vegetationPlacements;
        DIRT_BLOCK = dirt;
        SHORT_GRASS_BLOCK = shortGrassBlock;
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.FALSE).setValue(SNOWY, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT, SNOWY);
    }

    private static boolean canBeGrass(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = levelReader.getBlockState(blockpos);
        if (blockstate.is(Blocks.SNOW) && blockstate.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (blockstate.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(state, blockstate, Direction.UP, 1);
            return i < 15;
        }
    }

    private static boolean canPropagate(BlockState p_56828_, LevelReader p_56829_, BlockPos p_56830_) {
        BlockPos blockpos = p_56830_.above();
        return canBeGrass(p_56828_, p_56829_, p_56830_) && !p_56829_.getFluidState(blockpos).is(FluidTags.WATER);
    }

    @Override
    protected void randomTick(BlockState p_222508_, ServerLevel p_222509_, BlockPos p_222510_, RandomSource p_222511_) {
        if (!canBeGrass(p_222508_, p_222509_, p_222510_)) {
            if (!p_222509_.isAreaLoaded(p_222510_, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            p_222509_.setBlockAndUpdate(p_222510_, DIRT_BLOCK.defaultBlockState());
        } else {
            if (!p_222509_.isAreaLoaded(p_222510_, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            if (p_222509_.getMaxLocalRawBrightness(p_222510_.above()) >= 9) {
                BlockState blockstate = this.defaultBlockState();

                for (int i = 0; i < 4; i++) {
                    BlockPos blockpos = p_222510_.offset(p_222511_.nextInt(3) - 1, p_222511_.nextInt(5) - 3, p_222511_.nextInt(3) - 1);
                    if (p_222509_.getBlockState(blockpos).is(DIRT_BLOCK) && canPropagate(blockstate, p_222509_, blockpos)) {
                        p_222509_.setBlockAndUpdate(
                                blockpos, blockstate.setValue(SNOWY, Boolean.valueOf(p_222509_.getBlockState(blockpos.above()).is(Blocks.SNOW)))
                        );
                    }
                }
            }
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        // HolderLookup for configured features
        HolderLookup<ConfiguredFeature<?, ?>> lookup = level.holderLookup(Registries.CONFIGURED_FEATURE);

        // Get your vegetation feature
        Holder<ConfiguredFeature<?, ?>> featureHolder = lookup.getOrThrow(VEGETATION_PLACEMENT);

        System.out.println(featureHolder);

        // Place directly above if the clicked block matches
        if (level.getBlockState(pos).is(state.getBlock()) && level.getBlockState(pos.above()).isAir()) {
            featureHolder.value().place(level, level.getChunkSource().getGenerator(), random, pos.above());
        }

        // Controlled spread
        for (int i = 0; i < 128; ++i) {
            BlockPos spreadPos = pos.offset(
                    random.nextInt(5) - 2,
                    random.nextInt(3) - 1,
                    random.nextInt(5) - 2
            );

            BlockState spreadState = level.getBlockState(spreadPos);

            if (spreadState.is(state.getBlock()) && random.nextFloat() < 0.3F) {
                BlockPos abovePos = spreadPos.above();
                if (level.getBlockState(abovePos).isAir()) {
                    System.out.println("Spreading to: " + abovePos);
                    featureHolder.value().place(level, level.getChunkSource().getGenerator(), random, abovePos);
                }
            }
        }
    }





}