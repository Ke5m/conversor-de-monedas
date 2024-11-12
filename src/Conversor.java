import java.text.DecimalFormat;

public class Conversor {
    ConsultaApi consultaApi = new ConsultaApi();
    Menu menu = new Menu();
    public void convertir(String moneda1 ,String moneda2 , double cantidad){
         consultaApi.realizarConsulta(moneda1,moneda2,cantidad);

    }

    public int Opciones(){
        try {
            int seleccion = menu.leeOpcion();
            if (seleccion == 0){
                return 0;
            }
            double cantidad = menu.ingresaCantidad();

            switch (seleccion){
                case 1:
                    convertir("ARS","USD",cantidad);
                    break;
                case 2:
                    convertir("USD","ARS",cantidad);
                    break;
                case 3:
                    convertir("BRL","USD",cantidad);
                    break;
                case 4:
                    convertir("USD","BRL",cantidad);
                    break;
                case 5:
                    convertir("COP", "USD",cantidad);
                    break;
                case 6:
                    convertir("USD","COP",cantidad);
                    break;
                default:
                    System.out.println("opcion no valida.");
            }
        }catch (ExceptionCantidadInvalida e ){
            System.out.println(e.getMessage());
        }catch (ExceptionSeleccionInvalida e ){
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
