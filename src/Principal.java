import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        try{
            int primerOperacion = 100;
            String monedaBase = "";
            int segundaOperacion;
            String monedaCambio = "";


            String header = """
                    *--------------------------------------------------*
                    *               Conversor de monedas               *
                    *--------------------------------------------------*
                    * 1) ARS - Argentina     | 6) JPY - Japón          *
                    * 2) USD - United States | 7) CLP - Chile          *
                    * 3) BRL - Brasil        | 8) EUR - Unión Europea  *
                    * 4) PEN - Perú          | 9) UYU - Uruguay        *
                    * 5) COP - Colombia      | 10) PYG - Paraguay      *
                    *--------------------------------------------------*
                    *               Escriba 0 para SALIR               *
                    *--------------------------------------------------*
                    """;

            while (primerOperacion != 0) {
                System.out.println(header);
                System.out.println("""
                        #######
                            Escriba el número de la MONEDA BASE o 0 para SALIR:
                        #######
                        """);
                primerOperacion = Integer.valueOf(lectura.nextLine());

                String codigoMonedaUno = CodigosMoneda.obtenerCodigo(primerOperacion);

                if (primerOperacion !=0 && codigoMonedaUno != null){
                    monedaBase = codigoMonedaUno;

                    System.out.println("""
                        #######
                            Escriba el número de la MONEDA DE CAMBIO:
                        #######
                        """);

                    segundaOperacion = Integer.valueOf(lectura.nextLine());
                    String codigoMonedaDos = CodigosMoneda.obtenerCodigo(segundaOperacion);

                    if (segundaOperacion !=0 && codigoMonedaDos != null ) {
                        monedaCambio = codigoMonedaDos;

                        System.out.println("Escriba el monto a cambiar: ");
                        var monto = Double.valueOf(lectura.nextLine());


                        Moneda moneda = consulta.buscaValorMoneda(monedaBase,monedaCambio, monto);

                        String valorFinal = String.format("%.2f", Double.valueOf(moneda.conversion_result()));

                        System.out.println("*--------------------------------------------------*");
                        System.out.println("El valor de cambio de " + "$"
                                + monto + " " +  monedaBase + " es de: " + valorFinal + " " + monedaCambio);
                        System.out.println("*--------------------------------------------------*");
                        System.out.println();
                    } else if (codigoMonedaDos == null){
                        System.out.println("""
                                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                ~ El segundo código de moneda no es valido ~
                                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                """);
                    }

                } else if (primerOperacion != 0 && codigoMonedaUno == null) {
                    System.out.println("""
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                            ~ El código de moneda no es valido ~
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                            """);
                }

                {

                }
            }
            System.out.println("""
                    *--------------------------------------------------*
                    *       Muchas gracias por usar nuestra app        *
                    *--------------------------------------------------*
                    """);

        } catch (NumberFormatException e){
            System.out.println("Ingreso un valor no valido "+e.getMessage());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
