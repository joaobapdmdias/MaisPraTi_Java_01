public class Main {
    public static void main(String[] args) throws Exception {

        Objetos.setValor2(300);

        Objetos obj1 = new Objetos(10);
        obj1.setValor1(20);
        Objetos.setValor2(200);

        System.out.println("valores são " + obj1.getValor1() + " e " + obj1.calcula());

        Objetos obj2 = new Objetos(11);
        obj2.setValor1(21);
        Objetos.setValor2(201);

        System.out.println("valores são " + obj2.getValor1() + " e " + obj2.calcula());

        Objetos.setValor2(30);
        System.out.println("valores são " + obj1.getValor1() + " e " + obj1.calcula());
        System.out.println("valores são " + obj2.getValor1() + " e " + obj2.calcula());

        System.err.println("Este objeto e: " + obj1);
        System.err.println("Este objeto e: " + obj2);


    }
}
