package foundation.oop.generals;

public class GreekGeneral extends General {

    public GreekGeneral(String name) {
        super(name, 45);
    }
    public GreekGeneral(String name, int motivation) {
        super(name, motivation);
    }

    @Override
    public void punch(General otherGeneral) {
        if (this.getMotivationLevel() >= 1 && !(otherGeneral instanceof GreekGeneral)) {
            otherGeneral.bePunched((int)Math.round(this.motivation / 1.5));
        }
    }
}
