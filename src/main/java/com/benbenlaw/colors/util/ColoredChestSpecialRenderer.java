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
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
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

    private final MaterialSet materials;
    private final ChestModel model;
    private final Material material;
    private final float openness;

    public ColoredChestSpecialRenderer(MaterialSet p_434968_, ChestModel p_479602_, Material p_388350_, float p_386750_) {
        this.materials = p_434968_;
        this.model = p_479602_;
        this.material = p_388350_;
        this.openness = p_386750_;
    }

    public void submit(ItemDisplayContext displayContext, PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, int packedOverlay, boolean hasFoil, int outlineColor) {
        nodeCollector.submitModel(this.model, this.openness, poseStack, this.material.renderType(RenderTypes::entitySolid), packedLight, packedOverlay, -1, this.materials.get(this.material), outlineColor, (ModelFeatureRenderer.CrumblingOverlay)null);
    }

    public void getExtents(Consumer<Vector3fc> p_470834_) {
        PoseStack posestack = new PoseStack();
        this.model.setupAnim(this.openness);
        this.model.root().getExtentsForGui(posestack, p_470834_);
    }

}
