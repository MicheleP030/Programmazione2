package UpcastingDowncasting;

public class main {
    public static void main(){


    Tecnico t = new Tecnico();
    Dispositivo d = new Smartphone();
    /*
    visto che il compilatore sa che il tipo statico è dispositivo, chiama ripara su dispositivo,
    poi visto che dentro chiamo avvia sul dispositivo, nel dispositivo nella sua vtable sono connesso
    al metodo dello smartphone e quindi avvierà lo smartphone
     */

     t.ripara( d );
     t.ripara((Smartphone)d);

}
}
