import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(){
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu(){
        System.out.println("""
        seleccione el proceso para la conversión.
        1- Peso argentino a Dólar.
        2- Dólar a Peso argentino.
        3- Real brasileño a Dólar.
        4- Dólar a Real brasileño.
        5- Peso colombiano a Dólar.
        6- Dólar a Peso Colombiano.
        0- Salir.
        """);
    }

    public int leeOpcion()throws ExceptionSeleccionInvalida {
        try {
            int opcion = scanner.nextInt();
            if (opcion < 0 || opcion > 6) {
                throw new ExceptionSeleccionInvalida("Por favor elegir opcion valida.");
            }
            return opcion;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new ExceptionSeleccionInvalida("por favor ingresar un numero correspondiente con las opciones.");
        }
    }
    public double ingresaCantidad()throws ExceptionCantidadInvalida{
        System.out.println("ingresa la cantidad:");
        try {
            return scanner.nextDouble();
        }catch (InputMismatchException e){
            scanner.nextLine();
            throw new ExceptionCantidadInvalida("ingrese un numero valido");
        }
    }
}