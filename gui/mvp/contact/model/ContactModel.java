package gui.mvp.contact.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactModel
{
    private long nextId = 0;
    private Map<Long, Contact> contacts;

    public ContactModel()
    {
        contacts = new HashMap<>();
        createSampleData();
    }

    public List<Contact> searchContacts(String[] keywords)
    {
        List<Contact> matches = new ArrayList<Contact>();
        if(keywords == null || keywords.length == 0)
        {
            matches.addAll(contacts.values());
        }
        else
        {
            for(Contact contact: contacts.values())
            {
                for(String keyword: keywords)
                {
                    keyword = keyword.toLowerCase();
                    if (contact.getFirstName().toLowerCase().contains(keyword) ||
                        contact.getLastName().toLowerCase().contains(keyword))
                    {
                        matches.add(contact);
                        break;
                    }
                }
            }
        }
        return matches;
    }

    public void updateContact(Contact updatedContact)
    {
        contacts.put(updatedContact.getId(), updatedContact);
    }

    private void createContact(String firstName, String lastName,
                               String mailAddress)
    {
        Contact contact = new Contact(nextId, firstName, lastName, 
                                      mailAddress);
        contacts.put(contact.getId(), contact);
        nextId++;
    }

    private void createSampleData()
    {
        createContact("Britta", "Herres", "B.Herres@hochschule-trier.de");
        createContact("David", "Schuster", "schustd@hochschule-trier.de");
        createContact("Christian", "Aboagye", "aboagyec@hochschule-trier.de");
        createContact("Kevin", "Adam", "adamkev@hochschule-trier.de");
        createContact("Lukas", "Alt", "altl@hochschule-trier.de");
        createContact("Ingmar", "Andresen", "andresei@hochschule-trier.de");
        createContact("Jan Erik", "Antes", "antesj@hochschule-trier.de");
        createContact("Peer", "Arimond", "arimondp@hochschule-trier.de");
        createContact("Lena", "Arnolds", "arnoldsl@hochschule-trier.de");
        createContact("Daniel", "Bach", "bachd@hochschule-trier.de");
        createContact("Andreas Manuel", "Baron", "barona@hochschule-trier.de");
        createContact("Frederik", "Bauer", "bauerf@hochschule-trier.de");
        createContact("Bastian", "Becker", "beckerb@hochschule-trier.de");
        createContact("Philipp", "Befard", "befardp@hochschule-trier.de");
        createContact("Lindita", "Beka", "bekal@hochschule-trier.de");
        createContact("Andreas", "Bender", "bendera@hochschule-trier.de");
        createContact("Alexander", "Berns", "bernsa@hochschule-trier.de");
        createContact("Marius", "Bettendorf", "bettendm@hochschule-trier.de");
        createContact("Jonathan", "Blimke", "blimkej@hochschule-trier.de");
        createContact("Joe", "Boesen", "boesenjo@hochschule-trier.de");
        createContact("Manuel", "Bohrer", "bohrerm@hochschule-trier.de");
        createContact("David", "Bolt", "boltd@hochschule-trier.de");
        createContact("Marco", "Borkowitz", "borkowim@hochschule-trier.de");
        createContact("Michael", "Brand", "brandm@hochschule-trier.de");
        createContact("Stephan", "Brandt", "brandts@hochschule-trier.de");
        createContact("Ayla Christina", "Brettle", "A.Brettle@hochschule-trier.de");
        createContact("Florian", "Bruch", "bruchf@hochschule-trier.de");
        createContact("Kevin", "Bruns", "brunsk@hochschule-trier.de");
        createContact("David", "Büchel", "buecheld@hochschule-trier.de");
        createContact("Sandra", "Chowdhury", "chowdhus@hochschule-trier.de");
        createContact("Dirk", "Clemens", "clemensd@hochschule-trier.de");
        createContact("Berkan", "Colak", "colakb@hochschule-trier.de");
        createContact("Patrick", "Cudaj", "cudajp@hochschule-trier.de");
        createContact("Minh Duc", "Dao", "daomi@hochschule-trier.de");
        createContact("Carlos Antonio", "De Sa e Matos", "desaemac@hochschule-trier.de");
        createContact("Dennis", "Dellwo", "dellwod@hochschule-trier.de");
        createContact("Arthur", "Deutsch", "deutscha@hochschule-trier.de");
        createContact("Büsra", "Dikenli", "dikenlib@hochschule-trier.de");
        createContact("Roshan", "Dindoyal", "dindoyar@hochschule-trier.de");
        createContact("Philipp", "Dippel", "dippelp@hochschule-trier.de");
        createContact("Dana", "Düllmann", "duellmad@hochschule-trier.de");
        createContact("Mateo", "Egey", "egeym@hochschule-trier.de");
        createContact("Julia", "Eiden", "eidenju@hochschule-trier.de");
        createContact("Vincenz", "Eigebrecht", "eigebrev@hochschule-trier.de");
        createContact("Sharif", "El Deib", "eldeibsh@hochschule-trier.de");
        createContact("Otmane", "El-Guendouz", "elgueno@hochschule-trier.de");
        createContact("Simon", "Feldermann", "felderms@hochschule-trier.de");
        createContact("Lucas", "Fischer", "fischerl@hochschule-trier.de");
        createContact("Maximilian", "Flesch", "fleschm@hochschule-trier.de");
        createContact("Markus", "Fojtzik", "fojtzikm@hochschule-trier.de");
        createContact("Pavlo", "Fomin", "fominp@hochschule-trier.de");
        createContact("Malte", "Foucher", "foucherm@hochschule-trier.de");
        createContact("Johann", "Franz", "J.Franz@hochschule-trier.de");
        createContact("Tobias", "Friedrich", "friedrt@hochschule-trier.de");
        createContact("Nadine", "Fritsche", "fritschn@hochschule-trier.de");
        createContact("Stefan", "Fuhrmann", "fuhrmans@hochschule-trier.de");
        createContact("Karl-Stefan", "Fürst", "fuerstk@hochschule-trier.de");
        createContact("Christian", "Gavenea", "gaveneac@hochschule-trier.de");
        createContact("Nik", "Gebhardt", "gebhardn@hochschule-trier.de");
        createContact("Maik", "Geib", "geibm@hochschule-trier.de");
        createContact("Marcel", "Geißler", "geisslm@hochschule-trier.de");
        createContact("Tobias", "Gepp", "geppt@hochschule-trier.de");
        createContact("Phillip", "Gleiche", "gleichep@hochschule-trier.de");
        createContact("Nikolaus", "Göbels", "goebelsn@hochschule-trier.de");
        createContact("Moritz", "Goertz", "goertzm@hochschule-trier.de");
        createContact("Philip", "Gorecki", "goreckip@hochschule-trier.de");
        createContact("Benjamin", "Groß", "grossb@hochschule-trier.de");
        createContact("Maximilian", "Groß", "grossmax@hochschule-trier.de");
        createContact("Fabian", "Grosch", "groschf@hochschule-trier.de");
        createContact("Florian", "Großmann", "grossmaf@hochschule-trier.de");
        createContact("Tim", "Grundmanns", "grundmat@hochschule-trier.de");
        createContact("Nicole", "Guzicki", "guzickin@hochschule-trier.de");
        createContact("Joseph", "Haas", "haasjo@hochschule-trier.de");
        createContact("Carolina", "Haase", "haasec@hochschule-trier.de");
        createContact("Georg", "Haberlach", "haberlag@hochschule-trier.de");
        createContact("Lukas", "Hagenauer", "hagenaul@hochschule-trier.de");
        createContact("Pajtim", "Hajrizi", "hajrizip@hochschule-trier.de");
        createContact("Samer Alexander", "Hamadi", "hamadis@hochschule-trier.de");
        createContact("André", "Hannmann", "hannmana@hochschule-trier.de");
        createContact("Jens", "Hartmer", "hartmerj@hochschule-trier.de");
        createContact("Martin", "Heinz", "heinzma@hochschule-trier.de");
        createContact("Julia", "Hennemann", "hennemaj@hochschule-trier.de");
        createContact("Georgij", "Hergenräder", "hergenrg@hochschule-trier.de");
        createContact("Andreas", "Hergert", "hergerta@hochschule-trier.de");
        createContact("Johannes", "Heß", "hessj@hochschule-trier.de");
        createContact("Lennart", "Hillebrandt", "hillebrl@hochschule-trier.de");
        createContact("Ralf", "Hinderks", "hinderkr@hochschule-trier.de");
        createContact("Hermann", "Hockemeier", "hockemeh@hochschule-trier.de");
        createContact("Anton", "Hofmann", "hofmanna@hochschule-trier.de");
        createContact("Johannes", "Holbach", "J.Holbach@hochschule-trier.de");
        createContact("Adrian", "Holody", "holodya@hochschule-trier.de");
        createContact("Christian", "Hölz", "hoelzc@hochschule-trier.de");
        createContact("Michael", "Horne", "hornem@hochschule-trier.de");
        createContact("Yannik", "Hupfer", "hupfery@hochschule-trier.de");
        createContact("Adrian", "Ille", "illea@hochschule-trier.de");
        createContact("Özkan", "Isik", "isiko@hochschule-trier.de");
        createContact("Maximilian", "Jacobs", "jacobsma@hochschule-trier.de");
        createContact("Tomas", "Jähner", "jaehnert@hochschule-trier.de");
        createContact("Jerome", "Jähnig", "jaehnigj@hochschule-trier.de");
        createContact("Karolina", "John", "johnk@hochschule-trier.de");
        createContact("Lucas", "Junglen", "junglenl@hochschule-trier.de");
        createContact("Thomas", "Jürgensen", "juergent@hochschule-trier.de");
        createContact("Kai", "Kegeler", "kegelerk@hochschule-trier.de");
        createContact("Elisabeth", "Keib", "keibe@hochschule-trier.de");
        createContact("Sophia", "Keil", "keils@hochschule-trier.de");
        createContact("Martin", "Keren", "kerenm@hochschule-trier.de");
        createContact("Pascal", "Keul", "keulp@hochschule-trier.de");
        createContact("Erting", "Kha", "khae@hochschule-trier.de");
        createContact("Olivier", "Kiefer", "kiefero@hochschule-trier.de");
        createContact("Markus", "Klein", "kleinma@hochschule-trier.de");
        createContact("Leonard", "Kolz", "kolzl@hochschule-trier.de");
        createContact("Andreas", "Kopper", "koppera@hochschule-trier.de");
        createContact("Andreas", "Koster", "kostera@hochschule-trier.de");
        createContact("Anton", "Krapp", "krappa@hochschule-trier.de");
        createContact("Annika", "Kremer", "kremera@hochschule-trier.de");
        createContact("Jan-Felix", "Krull", "krullj@hochschule-trier.de");
        createContact("Kevin", "Küchler", "kuechlek@hochschule-trier.de");
        createContact("Marina", "Kuhn", "kuhnmar@hochschule-trier.de");
        createContact("Andre", "Lafleur", "lafleura@hochschule-trier.de");
        createContact("Melisande", "Lauer", "lauerm@hochschule-trier.de");
        createContact("Erik", "Lautenschläger", "lautense@hochschule-trier.de");
        createContact("Dennis", "Legierse", "legiersd@hochschule-trier.de");
        createContact("Erik", "Lemm", "lemme@hochschule-trier.de");
        createContact("David", "Liebemann", "liebemad@hochschule-trier.de");
        createContact("Philipp", "Lippold", "lippoldp@hochschule-trier.de");
        createContact("Max Gabriel", "Löhe", "loehem@hochschule-trier.de");
        createContact("Jan", "Lohmann", "lohmannj@hochschule-trier.de");
        createContact("Robin", "Lorenz", "lorenzr@hochschule-trier.de");
        createContact("Hans-Baldung", "Luley", "luleyh@hochschule-trier.de");
        createContact("Moritz", "Malburg", "malburm@hochschule-trier.de");
        createContact("Sandra Franziska", "Mandl", "mandls@hochschule-trier.de");
        createContact("Ahmet-Tahir", "Mazineler", "mazinela@hochschule-trier.de");
        createContact("Tobias", "Meier", "meiert@hochschule-trier.de");
        createContact("Jason", "Merse", "merseja@hochschule-trier.de");
        createContact("Kevin", "Meßmer", "messmerk@hochschule-trier.de");
        createContact("Grigorij", "Mestetschkin", "mestetsg@hochschule-trier.de");
        createContact("Kim Carine", "Michels", "michelk@hochschule-trier.de");
        createContact("Björn", "Möbes", "moebesb@hochschule-trier.de");
        createContact("Jonas", "Müller", "muellejo@hochschule-trier.de");
        createContact("Sandro", "Mund", "munds@hochschule-trier.de");
        createContact("Sandra", "Naguszewski", "naguszes@hochschule-trier.de");
        createContact("Robert", "Naumann", "naumannr@hochschule-trier.de");
        createContact("Marius", "Nellesen", "nellesem@hochschule-trier.de");
        createContact("Michael", "Nellesen", "nellesm@hochschule-trier.de");
        createContact("Tobias", "Neuhaus", "neuhaust@hochschule-trier.de");
        createContact("Marcel", "Neumann", "neumannm@hochschule-trier.de");
        createContact("Philipp", "Neymann", "neymannp@hochschule-trier.de");
        createContact("Thilo", "Nienhaus", "nienhaut@hochschule-trier.de");
        createContact("Fabian", "Noack", "noackf@hochschule-trier.de");
        createContact("Jonas", "Noesges", "noesgesj@hochschule-trier.de");
        createContact("Patrick", "Ohm", "ohmp@hochschule-trier.de");
        createContact("Rebecca Vanessa", "Pene Made", "penemadr@hochschule-trier.de");
        createContact("Eduard", "Penner", "pennere@hochschule-trier.de");
        createContact("Markus", "Penner", "pennerm@hochschule-trier.de");
        createContact("Dominik", "Petersdorf", "petersdd@hochschule-trier.de");
        createContact("Clarissa", "Philipp", "philippc@hochschule-trier.de");
        createContact("Oliver", "Piatkowski", "piatkowo@hochschule-trier.de");
        createContact("Bennet", "Pieper", "pieperb@hochschule-trier.de");
        createContact("Robin", "Plewka", "plewkar@hochschule-trier.de");
        createContact("Dominique", "Pohl", "pohld@hochschule-trier.de");
        createContact("Andre Joel", "Quantz", "quantza@hochschule-trier.de");
        createContact("Matthias", "Quarz", "quarzm@hochschule-trier.de");
        createContact("Pascal", "Quindeau", "quindeap@hochschule-trier.de");
        createContact("Peter", "Raber", "raberp@hochschule-trier.de");
        createContact("Johannes", "Ranalletta", "ranallej@hochschule-trier.de");
        createContact("Philipp", "Rath", "rathp@hochschule-trier.de");
        createContact("Dominik", "Rausch", "rauschdo@hochschule-trier.de");
        createContact("Florian", "Rech", "rechf@hochschule-trier.de");
        createContact("Christian", "Reinartz", "reinartc@hochschule-trier.de");
        createContact("Daniel", "Reiners", "reinersd@hochschule-trier.de");
        createContact("Daniel", "Reintanz", "reintand@hochschule-trier.de");
        createContact("Marwin", "Rieger", "riegerm@hochschule-trier.de");
        createContact("Dennis", "Rietzel", "rietzeld@hochschule-trier.de");
        createContact("David", "Rind", "rindd@hochschule-trier.de");
        createContact("Andre", "Roden", "rodenan@hochschule-trier.de");
        createContact("Niklas", "Rumpf", "rumpfn@hochschule-trier.de");
        createContact("Matthias", "Rzeznik", "rzeznikm@hochschule-trier.de");
        createContact("Julien", "Saevecke", "saeveckj@hochschule-trier.de");
        createContact("Sinan", "Sagunc", "saguncs@hochschule-trier.de");
        createContact("Bacher", "Said", "saidb@hochschule-trier.de");
        createContact("Malte", "Schababerle", "schababm@hochschule-trier.de");
        createContact("Tobias", "Schale", "schalet@hochschule-trier.de");
        createContact("Pascal", "Scheiwen", "scheiwep@hochschule-trier.de");
        createContact("Maximilian", "Scherer", "scherema@hochschule-trier.de");
        createContact("Oliver", "Schillaci", "schillao@hochschule-trier.de");
        createContact("Marcel", "Schillen", "schillem@hochschule-trier.de");
        createContact("Thomas", "Schmidt", "schmith@hochschule-trier.de");
        createContact("David", "Schmitt", "schmitd@hochschule-trier.de");
        createContact("Daniel", "Schnitzius", "schnitzd@hochschule-trier.de");
        createContact("Sarah", "Schöler", "schoeles@hochschule-trier.de");
        createContact("Alexander", "Schonk", "schonka@hochschule-trier.de");
        createContact("Peter", "Schramm", "schrammp@hochschule-trier.de");
        createContact("Amin", "Schubhan", "schubhaa@hochschule-trier.de");
        createContact("Selina", "Schuler", "schulers@hochschule-trier.de");
        createContact("Thomas", "Schulte", "schultet@hochschule-trier.de");
        createContact("Paul", "Schultz", "schultzp@hochschule-trier.de");
        createContact("Sebastian", "Schwaab", "schwaabs@hochschule-trier.de");
        createContact("David", "Siepen", "siepend@hochschule-trier.de");
        createContact("Dominique", "Simone", "simoned@hochschule-trier.de");
        createContact("Dario", "Sljukic", "sljukicd@hochschule-trier.de");
        createContact("Franjo", "Spahija", "spahijaf@hochschule-trier.de");
        createContact("Marco Alexander", "Spiess", "spiessm@hochschule-trier.de");
        createContact("Lucas", "Spiller", "spillerl@hochschule-trier.de");
        createContact("Albert", "Stefan", "stefana@hochschule-trier.de");
        createContact("Joé", "Steffen", "steffej@hochschule-trier.de");
        createContact("Moritz", "Steffes", "steffesm@hochschule-trier.de");
        createContact("Bianca", "Steffes", "steffesb@hochschule-trier.de");
        createContact("Mike", "Stein", "steinm@hochschule-trier.de");
        createContact("Janik", "Steuer", "steuerj@hochschule-trier.de");
        createContact("Fabian", "Strang", "strangf@hochschule-trier.de");
        createContact("Aude", "Takam Nana", "takamnaa@hochschule-trier.de");
        createContact("Armand Aime", "Tcheunkeu Wandja", "tcheunka@hochschule-trier.de");
        createContact("Daniela", "Thelen", "thelend@hochschule-trier.de");
        createContact("Tobias", "Thierbach", "thierbat@hochschule-trier.de");
        createContact("Angelika", "Thomä", "thomaea@hochschule-trier.de");
        createContact("Jens Guan Su", "Tien", "tienj@hochschule-trier.de");
        createContact("Pascal", "Vilfan", "vilfanpa@hochschule-trier.de");
        createContact("Marie", "von Gäßler", "vongaesm@hochschule-trier.de");
        createContact("Kevin", "Wagner", "wagnek@hochschule-trier.de");
        createContact("Nikolai", "Wagner", "wagnern@hochschule-trier.de");
        createContact("Katharina", "Wanner", "wannerk@hochschule-trier.de");
        createContact("Vanessa", "Warnatsch", "warnatsv@hochschule-trier.de");
        createContact("Patrick", "Weber", "webep@hochschule-trier.de");
        createContact("Maximilian", "Weber", "webermax@hochschule-trier.de");
        createContact("Sebastian", "Weichelt", "weichels@hochschule-trier.de");
        createContact("Tom", "Weiland", "weilandt@hochschule-trier.de");
        createContact("Marc", "Weiler", "weilerma@hochschule-trier.de");
        createContact("Markus", "Weinand", "weinandm@hochschule-trier.de");
        createContact("Justin", "Weinberg", "weinbj@hochschule-trier.de");
        createContact("Janina", "Weingartner", "weingarj@hochschule-trier.de");
        createContact("Marius", "Weise", "weisem@hochschule-trier.de");
        createContact("Julian", "Wellmann", "wellmanj@hochschule-trier.de");
        createContact("Yannik", "Wendelberger", "wendelby@hochschule-trier.de");
        createContact("Svenja", "Wesche", "wesches@hochschule-trier.de");
        createContact("Karen Alexandra", "Wessiepe", "wessiepk@hochschule-trier.de");
        createContact("Armin", "Willer", "willera@hochschule-trier.de");
        createContact("Fabrice", "Winzen", "winzenf@hochschule-trier.de");
        createContact("Tillman", "Witte", "witteti@hochschule-trier.de");
        createContact("Alexander", "Wolters", "woltersa@hochschule-trier.de");
        createContact("Jannik", "Zabel", "zabelj@hochschule-trier.de");
        createContact("Matthias", "Zagolla", "zagollam@hochschule-trier.de");
        createContact("Daniela", "Zenke", "zenked@hochschule-trier.de");
        createContact("Johannes", "Zhorschel", "zhorschj@hochschule-trier.de");
        createContact("Patricia", "Zimmer", "zimmerpa@hochschule-trier.de");
        createContact("Hanna", "Zimmer", "zimmerh@hochschule-trier.de");
    }
}
