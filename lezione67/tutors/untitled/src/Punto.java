public class Punto {
    private int x,y,z;
    private static int numeroPunti = 0;
    public Punto(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
        numeroPunti++;
    }

    public static int getNumeroPunti(){
        return numeroPunti;
    }

    @Override
    public String toString() {
        return "[" + x + ", "+ y + ", "+ z + "]";
    }
}
