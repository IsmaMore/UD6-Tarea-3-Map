import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public static void mostrarMapa(){
        System.out.println(
                "                                      ###############                                    " + "\n" +
                "          --------------------------> #  5-Bosque   #                 N                  " + "\n" +
                "          |                           ###############                 ^                  " + "\n" +
                "          |                                  ^                    O <- -> E              " + "\n" +
                "          |                                  |                        ⌄                  " + "\n" +
                "          |                                  |                        S                  " + "\n" +
                "          ⌄                                  ⌄                                           " + "\n" +
                "   ###############                    ###############                    ############### " + "\n" +
                "   #   2-Playa   # <----------------- #  1-Montaña  # <----------------> # 3-Edificio  # " + "\n" +
                "   ###############                    ###############                    ############### " + "\n" +
                "          ^                                  ^                                           " + "\n" +
                "          |                                  |                                           " + "\n" +
                "          |                                  |                                           " + "\n" +
                "          |                                  ⌄                                           " + "\n" +
                "          |                           ###############                                    " + "\n" +
                "          --------------------------- #  4-Puente   #                                    " + "\n" +
                "                                      ###############                                    " + "\n"
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Ubicacion> ubicaciones = new HashMap<>();
        Ubicacion ob1 = new Ubicacion(0, "Estás sentado en la clase de programación");
        Ubicacion ob2 = new Ubicacion(1, "Estás en la cima de una montaña");
        Ubicacion ob3 = new Ubicacion(2, "Estás bañándote en la playa");
        Ubicacion ob4 = new Ubicacion(3, "Estás dentro de un edificio muy alto");
        Ubicacion ob5 = new Ubicacion(4, "Estás de pie en un puente");
        Ubicacion ob6 = new Ubicacion(5, "Estás en un bosque");

        ob2.addExit("N", 5);
        ob2.addExit("S", 4);
        ob2.addExit("E", 3);
        ob2.addExit("O", 2);
        ob3.addExit("N", 5);
        ob4.addExit("O", 1);
        ob5.addExit("N", 1);
        ob5.addExit("O", 2);
        ob6.addExit("S", 1);
        ob6.addExit("O", 2);

        ubicaciones.put(1, ob2);
        ubicaciones.put(2, ob3);
        ubicaciones.put(3, ob4);
        ubicaciones.put(4, ob5);
        ubicaciones.put(5, ob6);

        for (int i = 1; i <= ubicaciones.size(); i++){
            ubicaciones.get(i).addExit("Q", 0);
        }

        int ubicacion = 1;
        String dir;

        do {
            mostrarMapa();
            System.out.println(ubicaciones.get(ubicacion).getDescripcion());
            System.out.print("Tus salidas son ");
            Ubicacion aux = ubicaciones.get(ubicacion);
            int cont = 1;
            for (String key: aux.getExits().keySet()){
                System.out.print(key);
                if (cont < aux.getExits().size()){
                    System.out.print(", ");
                }else {
                    System.out.println();
                }
                cont++;
            }
            do {
                System.out.print("Dirección: ");
                dir = sc.next().toUpperCase();
                if (aux.getExits().containsKey(dir)){
                    ubicacion = aux.getExits().get(dir);
                }else {
                    System.out.println("Error: '" + dir + "' No está dentro de los posibles movimientos");
                }
            }while (!aux.getExits().containsKey(dir));
        }while (!dir.equalsIgnoreCase("Q"));
    }
}
