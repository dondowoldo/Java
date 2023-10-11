package foundation.oop.generals;

public class General {
    private String name;
    protected int motivation;

    public General(String name, int motivation) {
        this.motivation = motivation;
        this.name = name;
    }

    public int getMotivationLevel() {
        if (this.motivation <= 25) {
            return 0;
        } else if (this.motivation > 25 && this.motivation < 40) {
            return 1;
        } else {
            return 2;
        }
    }

    public void punch(General otherGeneral) {
        if (this.getMotivationLevel() >= 1) {
            otherGeneral.bePunched((int)Math.round(this.motivation / 1.5));
        }
    }

    public void bePunched(int damage) {
        if (Math.round(damage / (float)(this.motivation / 2)) > this.motivation) {
            this.motivation = 0;
        } else {
            this.motivation -= Math.round(damage / (float)(this.motivation / 2));
        }
    }

    @Override
    public String toString() {
        switch(this.getMotivationLevel()) {
            case 0 : return this.name + " is not motivated anymore.";
            case 1 : return this.name + " is motivated.";
            case 2 : return this.name + " is well motivated.";
        }
        return "";
    }
    public int getMotivation() {
        return motivation;
    }
}
