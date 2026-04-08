package UpcastingDowncasting;

public class Tecnico {
    public void ripara(Dispositivo d){
        System.out.println("riparo un d generico");
        d.avvia();
    }
    public void ripara(Smartphone s){
        System.out.println("riparo un s serios");
        s.avvia();
    }
}
