package lezione6;

abstract public class Entity {
    //per raggruppare funzionalità
    //può avere metodi abstract
    //non possono essere istanziate(solo come classe anonima)
    //spesso ha il costruttore protected
    int x, y;

    protected void foo(){
        System.out.println("caso");
    }
    //obbligatorio da fare override, tranne se viene esteso da un abstract
    abstract public void foo2();

    protected Entity(int x,int y){
        this.x = x;
        this.y = y;
    }
}