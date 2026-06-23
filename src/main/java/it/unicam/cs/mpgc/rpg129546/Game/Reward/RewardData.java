package it.unicam.cs.mpgc.rpg129546.Game.Reward;

public class RewardData {

    private final int xp;
    private final int gold;

    public RewardData(int xp, int gold) {
        this.xp = xp;
        this.gold = gold;
    }

    public int getXp() {
        return xp;
    }

    public int getGold() {
        return gold;
    }
}