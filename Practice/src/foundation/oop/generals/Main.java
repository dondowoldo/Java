package foundation.oop.generals;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //Nero Claudius Drusus with 28 motivation punches Leonidas who has 20 motivation.
    //The damage will be 28/1.5=19 (after round up). Leonidas will
    // suffer 19/(20/2)=2 damage (after round up).
    //After the fight, the motivations will be the following:
    // - Nero Claudius Drusus: 28
    // - Leonidas: 18
    //Note: Always round up the decimal numbers.
    public static void main(String[] args) {
        General nero = new GreekGeneral("Nero", 28);
        General anotherNero = new GreekGeneral("anotherNero", 24);
        General otherOtherNero = new GreekGeneral("otherOtherNero", 22);
        General leonidas = new RomeEmpireGeneral("Leonidas", 50);
        General anotherLeonidas = new RomeEmpireGeneral("anotherLeonidas", 24);
        General otherOtherLeonidas = new RomeEmpireGeneral("otherOtherLeonidas", 19);
        General justSomeGeneral1 = new General("Randomak", 23);
        General justSomeGeneral2 = new General("Dalsi Randomak", 18);
        General justSomeGeneral3 = new General("A jeste jeden", 26);

        List<General> listOfGenerals = new ArrayList<>();
        listOfGenerals.add(nero);
        listOfGenerals.add(anotherNero);
        listOfGenerals.add(anotherLeonidas);
        listOfGenerals.add(otherOtherNero);
        listOfGenerals.add(justSomeGeneral1);
        listOfGenerals.add(leonidas);
        listOfGenerals.add(justSomeGeneral2);
        listOfGenerals.add(otherOtherLeonidas);
        listOfGenerals.add(justSomeGeneral3);

        Fight fight = new Fight(listOfGenerals);
        fight.startFight();
    }
}
