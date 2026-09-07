package com.benbenlaw.colors.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

import javax.annotation.Nullable;

public class CustomLeafParticle extends SingleQuadParticle {

    private static final float ACCELERATION_SCALE = 0.0025F;
    private static final int INITIAL_LIFETIME = 300;

    private float rotSpeed;
    private final float spinAcceleration;
    private final float windBig;
    private final boolean swirl;
    private final boolean flowAway;
    private final double xaFlowScale;
    private final double zaFlowScale;
    private final double swirlPeriod;

    public CustomLeafParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        super(level, x, y, z, spriteSet.first());

        this.rotSpeed = (float) Math.toRadians(this.random.nextBoolean() ? -30.0F : 30.0F);
        this.spinAcceleration = (float) Math.toRadians(this.random.nextBoolean() ? -5.0F : 5.0F);
        this.windBig = 2.0F;
        this.swirl = true;
        this.flowAway = false;
        this.lifetime = INITIAL_LIFETIME;
        this.gravity = 0.07F * 1.2F * ACCELERATION_SCALE;

        float size = 1.0F * (this.random.nextBoolean() ? 0.05F : 0.075F);
        this.quadSize = size;
        this.setSize(size, size);
        this.friction = 1.0F;
        this.yd = -0.021F;

        float particleRandom = this.random.nextFloat();
        this.xaFlowScale = Math.cos(Math.toRadians(particleRandom * 60.0F)) * this.windBig;
        this.zaFlowScale = Math.sin(Math.toRadians(particleRandom * 60.0F)) * this.windBig;
        this.swirlPeriod = Math.toRadians(1000.0F + particleRandom * 3000.0F);

        this.setSpriteFromAge(spriteSet);
    }

    @Override
    protected Layer getLayer() {
        return Layer.OPAQUE;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (this.lifetime-- <= 0) {
            this.remove();
        }

        if (!this.removed) {
            float aliveTicks = (float) (INITIAL_LIFETIME - this.lifetime);
            float relativeAge = Math.min(aliveTicks / (float) INITIAL_LIFETIME, 1.0F);
            double xa = 0.0;
            double za = 0.0;

            if (this.flowAway) {
                xa += this.xaFlowScale * Math.pow(relativeAge, 1.25F);
                za += this.zaFlowScale * Math.pow(relativeAge, 1.25F);
            }

            if (this.swirl) {
                xa += relativeAge * Math.cos(relativeAge * this.swirlPeriod) * this.windBig;
                za += relativeAge * Math.sin(relativeAge * this.swirlPeriod) * this.windBig;
            }

            this.xd += xa * ACCELERATION_SCALE;
            this.zd += za * ACCELERATION_SCALE;
            this.yd -= this.gravity;

            this.rotSpeed += this.spinAcceleration / 20.0F;
            this.oRoll = this.roll;
            this.roll += this.rotSpeed / 20.0F;

            this.move(this.xd, this.yd, this.zd);

            if (this.onGround || (this.lifetime < INITIAL_LIFETIME - 1 && (this.xd == 0.0F || this.zd == 0.0F))) {
                this.remove();
            }

            if (!this.removed) {
                this.xd *= this.friction;
                this.yd *= this.friction;
                this.zd *= this.friction;
            }
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType options, ClientLevel level, double x, double y, double z,
                                                 double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            return new CustomLeafParticle(level, x, y, z, this.spriteSet);
        }
    }
}