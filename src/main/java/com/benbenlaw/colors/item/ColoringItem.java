package com.benbenlaw.colors.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ARGB;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.joml.Vector3f;

public class ColoringItem extends Item {

    private final DyeColor color;

    public ColoringItem(Properties properties, DyeColor color) {
        super(properties);
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        String[] colors = {
                "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray",
                "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"
        };

        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        BlockState state = level.getBlockState(pos);

        if (!level.isClientSide()) {

            for (String colorCheck : colors) {
                if (state.getBlock().getName().toString().contains(colorCheck) && !(state.getBlock() instanceof BaseEntityBlock)) {

                    String block = state.getBlock().toString();
                    String blockString = block.replace("Block{", "").replace("}", "");
                    String newColoredBlock = blockString.replace(colorCheck, color.toString().toLowerCase());

                    Identifier newBlockResourceLocation = Identifier.tryParse(newColoredBlock);

                    if (newBlockResourceLocation != null && BuiltInRegistries.BLOCK.containsKey(newBlockResourceLocation)) {
                        Block newBlock = BuiltInRegistries.BLOCK.getValue(newBlockResourceLocation);

                        if (newBlock == state.getBlock()) {
                            return InteractionResult.FAIL;
                        }

                        BlockState newState = newBlock.defaultBlockState();
                        for (Property<?> property : state.getProperties()) {
                            if (newState.hasProperty(property)) {
                                newState = copyProperty(state, newState, property);
                            }
                        }

                        level.setBlock(pos, newState, 3);

                        int colorInt = color.getTextureDiffuseColor();

                        DustParticleOptions dust = new DustParticleOptions(colorInt, 1.0F);

                        ((ServerLevel) level).sendParticles(dust,
                                pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5,
                                12,
                                0.3, 0.3, 0.3,
                                0.05
                        );

                        if (stack.isDamageableItem()) {
                            assert player != null;
                            stack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(stack));
                        } else {
                            stack.shrink(1);
                        }
                        level.playSound(null, pos, SoundEvents.SLIME_ATTACK, SoundSource.BLOCKS, 0.5F, 1.0F);
                        return InteractionResult.SUCCESS_SERVER;

                    } else {
                        System.out.println("Failed to parse resource location: " + newColoredBlock);
                    }
                }
            }
            return InteractionResult.FAIL;
        }
        return InteractionResult.FAIL;
    }

    private <T extends Comparable<T>> BlockState copyProperty(BlockState oldState, BlockState newState, Property<T> property) {
        return newState.setValue(property, oldState.getValue(property));
    }
}