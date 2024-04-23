import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        try{
            int operacion = 0;
            String monedaBase = "";
            String monedaCambio = "";

            while (operacion != 7) {
                // prueba del while
                System.out.println("Escriba una operación del 1 al 6, 7 para salir: ");
                System.out.println("Peso arg a dolares 1");
                operacion = Integer.valueOf(lectura.nextLine());

                if(operacion != 7){
                    switch(operacion) {
                        case 1:
                            monedaBase = "ARS";
                            monedaCambio = "USD";
                            break;
                        case 2:
                            monedaBase = "PKR";
                            monedaCambio = "USD";
                            break;
                        case 3:
                            // code block
                            break;
                        case 4:
                            // code block
                            break;
                        case 5:
                            // code block
                            break;
                        case 6:
                            // code block
                            break;
                        default:
                            System.out.println("No es una operación de cambio valida");
                    }

//                    System.out.println("Escriba el tipo de moneda base: ");
//                    var monedaBase = lectura.nextLine();
//                    System.out.println("Escriba el tipo de moneda de cambio: ");
//                    var monedaCambio = lectura.nextLine();
                    System.out.println("Escriba el monto a cambiar: ");
                    var monto = Double.valueOf(lectura.nextLine());

                    Moneda moneda = consulta.buscaValorMoneda(monedaBase,monedaCambio, monto);
                    System.out.println("El valor de cambio de " + "$"
                            + monto + " " +  monedaBase + " es de: " + moneda.conversion_result() + " " + monedaCambio);
                }

            }


        } catch (NumberFormatException e){
            System.out.println("Número no encontrado "+e.getMessage());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
