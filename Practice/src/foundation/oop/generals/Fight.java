package foundation.oop.generals;

import java.util.ArrayList;
import java.util.List;

public class Fight {
    private List<General> listOfGenerals;

    public Fight(List<General> listOfGenerals) {
        this.listOfGenerals = listOfGenerals;
    }

    public List<General> forTheEmpire() {
        List<General> motivatedEmpireGenerals = new ArrayList<>();
        for (General g : listOfGenerals) {
            if (g instanceof RomeEmpireGeneral && g.getMotivationLevel() == 2) {
                motivatedEmpireGenerals.add(g);
            }
        }
        return motivatedEmpireGenerals;
    }

    public void startFight() {
        List<General> romeEmpire = forTheEmpire();
        for (General r : romeEmpire) {
            for (General g : this.listOfGenerals) {
                if (g instanceof GreekGeneral) {
                    r.punch(g);
                    g.punch(r);
                }
            }
        }
        int greekMotivation = 0;
        int romanMotivation = 0;
        for (General g : this.listOfGenerals) {
            if (g instanceof GreekGeneral) {
                greekMotivation += g.getMotivation();
            } else if (g instanceof  RomeEmpireGeneral) {
                romanMotivation += g.getMotivation();
            }
        }
        if (greekMotivation > romanMotivation) {
            for (General g : this.listOfGenerals) {
                if (g instanceof GreekGeneral) {
                    System.out.println(g);
                }
            }
        } else {
            for (General r : this.listOfGenerals) {
                if (r instanceof RomeEmpireGeneral) {
                    System.out.println(r);
                }
            }
        }
    }
}
