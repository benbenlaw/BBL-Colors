package com.benbenlaw.colors.mixin;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.util.ColorList;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChestRenderer.class)
public abstract class ChestRendererMixin {

    @ModifyReturnValue(method = "getCustomSprite", at = @At("RETURN"))
    private @Nullable SpriteId getCustomMaterial(@Nullable SpriteId original,
                                                 @Local(argsOnly = true) BlockEntity blockEntity,
                                                 @Local(argsOnly = true) ChestRenderState renderState) {

        // 1. Get the actual block from the state
        var block = blockEntity.getBlockState().getBlock();

        // 2. Find which color matches this block
        // (Assuming your ColorsBlocks.CHESTS map is Map<String, RegistryObject<Block>>)
        for (String color : ColorList.COLORS) {
            if (block == ColorsBlocks.CHESTS.get(color + "_chest").get()) {

                // 3. Construct the path string based on the chest type
                String suffix = switch (renderState.type) {
                    case LEFT -> "_left";
                    case RIGHT -> "_right";
                    default -> ""; // SINGLE
                };

                // 4. Return the SpriteId explicitly tied to the CHEST_SHEET atlas
                return new SpriteId(Sheets.CHEST_SHEET, Colors.identifier("entity/chest/" + color + "_chest" + suffix));
            }
        }

        return original;
    }
}