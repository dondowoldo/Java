package foundation.oop.generals;

public class RomeEmpireGeneral extends General {
    public RomeEmpireGeneral(String name, int motivation) {
        super(name, motivation);
    }
    public RomeEmpireGeneral(String name) {
        super(name, 40);
    }

    @Override
    public void punch(General otherGeneral) {
        if (this.getMotivationLevel() >= 1 && !(otherGeneral instanceof RomeEmpireGeneral)) {
            otherGeneral.bePunched((int)Math.round(this.motivation / 1.5));
        }
    }
}

