import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Principal {
    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        Menu menu = new Menu();
        int opcion = -3;

        while (opcion !=0){
            menu.mostrarMenu();
            opcion = conversor.Opciones();
        }
            System.out.println("el programa finalizo");
    }
}

