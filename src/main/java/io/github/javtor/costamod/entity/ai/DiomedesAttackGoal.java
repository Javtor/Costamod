package io.github.javtor.costamod.entity.ai;

import io.github.javtor.costamod.entity.custom.DiomedesEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.ZombieEntity;

public class DiomedesAttackGoal
        extends MeleeAttackGoal {

    private final DiomedesEntity diomedes;
    private int ticks;

    public DiomedesAttackGoal(DiomedesEntity diomedes, double speed, boolean pauseWhenMobIdle) {
        super(diomedes, speed, pauseWhenMobIdle);
        this.diomedes = diomedes;
    }

    @Override
    public void start() {
        super.start();
        this.ticks = 0;
    }

    @Override
    public void stop() {
        super.stop();
        this.diomedes.setAttacking(false);
    }

    @Override
    public void tick() {
        super.tick();
        ++this.ticks;
        this.diomedes.setAttacking(this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2);
    }
}
