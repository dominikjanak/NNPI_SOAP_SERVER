package cz.nnpia.dominikjanak.webservice.producer.repository;

import cz.dominikjanak.webservices.quotes.Quote;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Component
public class QuoteRepository {
    private static final Map<Integer, Quote> quotes = new HashMap<>();

    @PostConstruct
    public void initData() {
        String[] qText = {
                "Počítač bez Cobolu a Fortranu je jako čokoládový dort bez kečupu a hořčice.",
                "Většina lidí neopouští společnosti, ale manažery.",
                "Nejsem náročný, mám velmi jednoduchý vkus. Spokojím se vždy s tím nejlepším.",
                "Někdo mlčí, protože neví, a někdo mlčí, protože ví své.",
                "Každý, s kým se v životě potkám, mě v něčem předstihuje. Tak se od něho učím.",
                "Když nemám co dělat, pracuji.",
                "Skutečně volní jsme jen v našich snech, ve zbytku času potřebujeme plat.",
                "Tož demokracii bychom už měli, teď ještě nějaké ty demokraty.",
                "Člověk nebyl stvořen pro porážku. Dá se zničit, ale ne porazit.",
                "Úspěch není výsledkem samovznícení. Zapálit se musíte sami.",
                "Na tomto světě se nedá nic považovat za jistotu. Kromě smrti a daní.",
                "Abyste dokázali něco úžasného, potřebujete dvě věci: plán a nedostatek času.",
                "Úspěch je mizerný učitel. Svádí chytré lidi myslet si, že nemohou prohrát.",
                "Buď slušný k lidem, když jdeš nahoru, mohl bys je potkat, až půjdeš dolů.",
                "Pokud se dva vždy shodnou, jeden z nich je přebytečný.",
                "Miřte na měsíc. I když minete, skončíte mezi hvězdami.",
                "V byznysu je jistá jedna věc: vy i okolí budete dělat chyby.",
                "Budujte vlastní sny, nebo si vás někdo jiný najme na to, abyste vybudovali ty jeho.",
                "Lidé, kteří nedokázali to, co chtěli, ti budou říkat, že nic nedokážeš ani ty.",
                "Snažme se žít tak, aby naší smrti litoval i majitel pohřební služby.",
                "Nikdy nedělejte rozhodnutí, když se vám chce čurat.",
                "Jak by se vám líbila práce, kde pokaždé, když uděláte chybu, tak se rozsvítí červené světlo a 18000 lidí začne pískat?",
                "Kdybych dostal devět hodin na to, abych porazil strom, prvních šest bych brousil sekeru.",
                "ět procent lidí myslí; 10 procent lidí si myslí, že myslí a dalších 85 procent by raději zemřelo, než by mysleli."
        };
        String[] qAuthor = {
                "Neznámý autor",
                "Jonas Ridderstrale",
                "Oscar Wilde",
                "Miroslav Horníček",
                "Ralph Waldo Emerson",
                "Karel Čapek",
                "Terry Pratchett",
                "Tomáš Garrigue Masaryk",
                "Ernest Hemingway",
                "Arnold Glasow",
                "Benjamin Franklin",
                "Leonard Bernstein",
                "Bill Gates",
                "John Osborne",
                "Ben Bernanke",
                "Les Brown",
                "Richard Branson",
                "Farrah Gray",
                "Will Smith",
                "Mark Twain",
                "Leonard Cohen",
                "Jacques Plante",
                "Abraham Lincoln",
                "Thomas Alva Edison"
        };

        for(int i = 0; i < qText.length; i++ ){
            Quote q = new Quote();
            q.setId(i);
            q.setAuthor(qAuthor[i]);
            q.setIsPublished(true);
            q.setQuote(qText[i]);
            quotes.put(i, q);
        }
    }

    public Quote findQuote(int id) {
        return quotes.get(id);
    }
}

