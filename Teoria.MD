# JAVA
## Dispatch
Java è single dispatch, se ho overload di metodo con classe padre e figlio l'importante è il tipo statico che gli passo

-> ``mining(DiamondPick p);  
    mining(Pick p);  
    Pick p1 = new Pick;  
    Pick p2 = new DiamondPick;  
    mining(p1);  
    mining(p2);``

chiamerà lo stesso metodo visto che confronto sul tipo statico
## V-Table
nella memoria read only è presente una v-table con una word per ogni classe, in cui è presente l'indirizzo del metodo.  
I metodi statici, final o private visto che non sono overridabili non passano per la V-table ma sono dispatchati staticamente.
Il tipo statico di un oggetto definisce cosa posso chiamare mentre alla chiamata la V-table avrà l'indirizzo corretto del metodo.

## Design Patterns
### Template Method
Una classe base definisce il comportamento generico lasciando ad alcune classi figlie l'implementazione
### Strategy Method
Una variabile (sotto oggetto) di un interfaccia che a runtime modifico per modificare il comportamento
(AttackPattern tipo statico, RangedAttack/MeleeAttack tipo dinamico)
### Factory Method
Un metodo (classe) che istanzia gli oggetti al posto di dover chiamare il costruttore, con l'obiettivo di non esporre il costruttore/rendere generico l'oggetto creato (player weapon -> sword/bow/gun tramite metodo in player generateWeapon o classe WeaponFactory)
### State Pattern
Rappresenta gli stati e le transizioni tra stati che possono avere degli oggetti. Ad esempio un player spawna in idle, se preme w passa in movimento ecc. Se implementato con switch case la logica diventa difficile da mantenere e quindi è comodo sfruttare lo strategy pattern per gli stati. Ogni stato implementerà i metodi per passare ad un altro stato in caso succedesse qualcosa. Quindi potrò avere un oggetto generico e quando accade qualcosa chiamo il metodo apposta che decide se passare ad un nuovo stato o no (se sono in idle e mi muovo cambio stato, se sono già in movement non lo cambio)
### Template method
fisso una struttura generale e delego i dettagli alle sottoclassi. Sarà un metodo final con all'interno altre funzioni che verranno overridate nelle classi figlie. Alternativamente posso avere un metodo non final dove inserisco solo le cose essenziali e poi ogni figlio lo overrida (se serve) aggiungendo super.metodo() e le funzionalità aggiuntive
### Visitor Pattern
permette di fare double dispatch (il metodo usato dipende da due tipi dinamici e non da uno). Esempio:
animale.mangia(cibo) -> single dispatch ha mangia metodo che cambia dinamicamente a seconda dell'animale su cui viene chiamato, ma non sul cibo. Con double dispatch cambia a seconda di entrambi.
avrò una interfaccia visitor con n metodi visit (nel caso dell'esempio uno per ogni cibo) dove dichiaro un metodo per ogni cibo.
Nella classe generica (in questo caso cibo) Avrò un metodo accept(Visitor v) che viene overridato in ogni figlio, chiamando al suo interno v.visit(this). Infine ogni classe su cui viene chiamato il metodo (in questo caso animale) dovrà implementare l'interfaccia visitor per creare un metodo per ogni cibo. Così l'esempio di prima diventerebbe: cibo.accept(animale), dove dentro accept accadrà animale.visit(this) tenendo conto sia del tipo di cibo che di animale. (Avrò interfaccia Visitor e Visitable)
### Observer Pattern
alcuni oggetti osservano il comportamento di un oggetto e si comportano di conseguenza
un oggetto(detto subject) mantiene la lista dei dipendenti (observers) e li notifica quando cambia stato. Ogni observer implementerà una interfaccia che gli fornisce un metodo per ricevere le notifiche (tipo un update) che verrà chiamato dal subject nel momento capiti qualcosa.
## Polimorfismo
### Di sottoclasse
deciso a runtime, sfrutta l'override dei metodi per cambiare comportamento su oggetti con lo stesso tipo statico
### Parametrico
deciso a compile time, sfrutta i generici (tramite type erasure) per evitare cast, rendendolo type safe, non cambia comportamento a discapito di tipi dinamici diversi  
spesso usato dalle collezioni (visto che il comportamento di un array di studenti e di professori dovrebbe comportarsi uguale)  
bisogna usare covarianza e controvarianza (una wildcard) perchè i generici sono invarianti (Spawner<Zombie> is-a Spawner<entity> non è vero), altrimenti si rischia di avere errori di tipo in runtime come:  
``List<Dog> dogs = new ArrayList<>();``  
``List<Animal> animals = dogs; // errore ``
#### Covarianza - Producer
``List <? extends Animal> l ``-> lista di qualcosa che estende animal  
``Animal a = l.get(0)``-> posso farlo visto che so che l'oggetto estenderà animal  
``l.add(new Cat())`` -> non posso farlo perchè non so di preciso che tipo ha l (magari è Dog)
Gli array sono covarianti, però se sbaglio rischio di avere errori a runtime  

esempio:  
``void printAnimals(List<? extends Animal> animals)``
#### Controvarianza - Consumer
``List <? super Dog> l ``-> lista di qualcosa che è padre o più di Dog  
``Animal a = l.get(0)``-> non posso farlo visto che non so se l'oggetto è animal (al massimo posso farlo con Object)  
``l.add(new Dog())`` -> posso farlo visto che Dog è super Dog  

esempio:  
``void addDogs(List<? super Dog> dogs)``
## Collezioni
si istanziano sempre col tipo più generico possibile, possibilmente un interfaccia (se non interessa l'implementazione uso Collection)
1. List, possono avere duplicati e mantiene ordine:
    - ArrayList<T> per velocità di lettura (se aggiungo ogni volta creo un nuovo array)
    - LinkedList<T> per velocità di scrittura (se leggo devo ciclare tutti i nodi)
2. Set, no duplicati e no ordine
    - HashSet (sfrutta hash, veloce)
    - LinkedHashSet (ha ordine)
    - TreeSet (ordinato secondo un albero)
3. Map, coppie chiave-valore, chiave unica e valori duplicabili
    - HashMap (usa Hash)
    - Treemap (albero)
4. Queue, FIFO
    - ArrayDeque<> (con interfaccia padre Queue)
    - LinkedList<>
    - PriorityQueue<>
5. Stack, LIFO
    - ArrayDeque<> (con interfaccia padre Dequeue)
    - LinkedList<>

usando le collezioni con classi create da utente è utile fare overriding di equals() e hashCode() di object per uguaglianza (utile per implementazioni con hash). In questo caso l uso di instanceof o getClass() è scusato
Per decidere l'ordinamento invece è utile implementare l'interfaccia comparable() o creare una classe che implementa comparator (utile per implementazioni con tree).
Queste ci devono essere sempre quando uso una collezione
## UML
contiene i nomi delle classi, i loro campi, i loro modificatori, le loro associazioni/gerarchie

 - \<\<nome\>\> -> interfaccia
 - {nome} o @nome-> classe astratta
 - \# nome -> campo protected
 - \~ nome -> campo package (visibile nel package)
 - \- nome -> campo private
 - \+ nome -> campo public
 - _ nome -> campo static

le frecce si usano con la punta verso la classe sopra nella gerarchia, con:
 + linea continua, extends
 + linea tratteggiata, implements (interfaccia)

inoltre le associazioni si usano con il rombo verso la classe che è sotto oggetto, con:
 + rombo vuoto, associazione debole (se muore l'oggetto la classe che lo contiene sopravvive)
 + rombo pieno, associazione forte (muoiono entrambi alla morte di uno)

le associazioni hanno anche la cardinalità, cioè il numero di elementi (negli esempi sotto a sinista) associato ad ogni elemento (a destra)
1. 1 - 1 per ogni oggetto c'è sotto oggetto (motore-macchina)
2. 1...* - 1 per ogni oggetto ci sono n sotto oggetti (ruote-macchina)
3. 1...* - 1...* per un oggetto ci sono n sotto oggetti e per 1 sotto oggetto ci sono n oggetti (studenti-professori)