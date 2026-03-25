package com.benbenlaw.colors.util;

import com.benbenlaw.colors.Colors;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.chest.ChestModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector3fc;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ColoredChestSpecialRenderer implements NoDataSpecialModelRenderer {

    public static final Map<String, Identifier> TEXTURES = ColorList.getColors().stream().collect(
            Collectors.toMap(Function.identity(), color -> Colors.identifier(color + "_chest"))
    );

    private final SpriteGetter sprites;
    private final ChestModel model;
    private final SpriteId sprite;
    private final float openness;

    public ColoredChestSpecialRenderer(SpriteGetter sprites, ChestModel model, SpriteId sprite, float openness) {
        this.sprites = sprites;
        this.model = model;
        this.sprite = sprite;
        this.openness = openness;
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, int overlayCoords, boolean hasFoil, int outlineColor) {
        submitNodeCollector.submitModel(this.model, this.openness, poseStack, lightCoords, overlayCoords, -1, this.sprite, this.sprites, outlineColor, (ModelFeatureRenderer.CrumblingOverlay)null);
    }

    public void getExtents(Consumer<Vector3fc> p_470834_) {
        PoseStack posestack = new PoseStack();
        this.model.setupAnim(this.openness);
        this.model.root().getExtentsForGui(posestack, p_470834_);
    }
}
