public class AbstractsAndInterfaces {
    public static void main(String[] args) {

    }

    /*
    SRP = Single Responsibility Principle
        = Každý objekt, metoda,.. reší jen JEDNU věc.

    Note :
        Každá classa může dědit POUZE z jednoho předka, ale může implementovat kolik chce Interfaců.

    ////////////   Abstract class   /////////////
    + Implementace a metody


    - Slouží jako šablona pro derrived classy
    - Nemůžeme je instanciovat
    - Můžeme definovat abstraktní metody (bez těla), které musí obsahovat každá derrived classa
    - Používá se jako forma protekce programu kdy se náš kód rozšiřuje a jasně definujeme pro ostatní programátory
        co každá derrived classa musí obsahovat (jinak neprojde přes kompilaci)

    Abstraktní metoda příklad :
    abstract void absorb(double water)
    __________________________________________________________________________________________________________________

    ////////////   Interface //////////////
    + Definuje požadavky

    - klíčové slovo "implements"
    - vše co definujeme v interface je automaticky public
    - proměnné jsou automaticky public static final (KONSTANTA)
    __________________________________________________________
    /**
                >  Můžeme takto přidat název / popis metod/interfacu a popisek pak bude viditelný v classe
    */              // která daný interface implementuje.

    // __________________________________________________________

    /*  List<InterfaceName> example = new ArrayList<>();        // List objektů, které implemenujou daný Interface.
            for (InterfaceName)

    */




}
