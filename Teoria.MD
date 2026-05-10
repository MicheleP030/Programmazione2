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