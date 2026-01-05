package com.benbenlaw.colors.mixin;

import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.util.ColorList;
import com.benbenlaw.colors.util.ColorsMaterials;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChestRenderer.class)
public abstract class ChestRendererMixin {

    @ModifyReturnValue(method = "getCustomMaterial", at = @At("RETURN"))
    private Material getCustomMaterial(Material original, @Local(argsOnly = true) BlockEntity blockEntity, @Local(argsOnly = true) ChestRenderState renderState) {

        for (String color : ColorList.COLORS) {
            if (blockEntity.getBlockState().is(ColorsBlocks.CHESTS.get(color + "_chest").get())) {
                return switch (renderState.type) {
                    case SINGLE -> ColorsMaterials.COPPER_CHEST_LOCATION.get(ColorList.COLORS.indexOf(color));
                    case LEFT -> ColorsMaterials.COPPER_CHEST_LOCATION_LEFT.get(ColorList.COLORS.indexOf(color));
                    case RIGHT -> ColorsMaterials.COPPER_CHEST_LOCATION_RIGHT.get(ColorList.COLORS.indexOf(color));
                };
            }
        }

        return original;
    }
}