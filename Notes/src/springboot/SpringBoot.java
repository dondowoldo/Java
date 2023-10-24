package springboot;

public class SpringBoot {
    public static void main(String[] args) {
        /*
        MATERIAL REVIEW
        Spring = knihovna // SpringBoot = framework

        Headery : - Součást requestu i response
                  - Udává např jakého typu jsou zobrazovaná data nebo jakým způsobem se mají zobrazit.

        HTTP Request Metody:
            GET : Požadavek pro zobrazení dat na daném URL.
            POST:
            DELETE:
            UPDATE:
            PATCH:

        HTTPS Response
            HTTP status kódy : https://http.cat


        Gradle = kompilátor / package manager
            - buildgradle -> dependencies

        Anotace :
            - Mají už v sobě zabudovanou nějakou funkcionalitu
        @SpringBootApplication - Hlavní anotace classy - obsahuje main metodu (Kde se aplikace spouští)
        @GetMapping - Přijímá GET
        @RequestMapping - Přijímá GET i POST
        @ResponseBody - Anotace, která výsledek metody vrátí do <body>
        @RestController  - Už má v sobě ResponseBody, takže vracíme vždy jen data a nemůžeme vracet html
        @RequestParam("q") String query
            - Pokud chceme zachovat funkcionalitu i bez parametru, uděláme ze String query Optional<String>


        -End pointy budou vždy metody !

        Controller Class : Kontroluje requesty a responsy (Umí je přijímat a odesílat) - Můžeme jich mít víc
            - používá anotaci @Controller
            - každá metoda v Controlleru = 1 endpoint




















         */
















    }
}
