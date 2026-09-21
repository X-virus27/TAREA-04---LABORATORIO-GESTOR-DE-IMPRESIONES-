import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LaboratorioImpresiones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> pendientes = new ArrayDeque<>(); 
        Deque<String> historial = new ArrayDeque<>();  
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n--- Gestor de Impresiones ---");
            System.out.println("1. Registrar nuevo documento");
            System.out.println("2. Imprimir siguiente documento");
            System.out.println("3. Recuperar y reimprimir último documento");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            if (opcion == 1) {
                System.out.print("Nombre del documento (ej. reporte.pdf): ");
                String doc = scanner.nextLine();
                pendientes.offerLast(doc);
                System.out.println("Documento '" + doc + "' enviado a la cola de impresión.");
                
            } else if (opcion == 2) {
                if (!pendientes.isEmpty()) {
                    String doc = pendientes.pollFirst();
                    historial.push(doc);
                    System.out.println("Impreso exitosamente: " + doc);
                } else {
                    System.out.println("No hay documentos pendientes para imprimir.");
                }
                
            } else if (opcion == 3) {
                if (!historial.isEmpty()) {
                    String recuperado = historial.pop();
                    pendientes.addFirst(recuperado);
                    System.out.println("Recuperado '" + recuperado + "'. Se imprimirá de nuevo como prioridad.");
                } else {
                    System.out.println("El historial está vacío. No hay nada que recuperar.");
                }
                
            } else if (opcion != 4) {
                System.out.println("Opción no válida.");
            }
        }
        
        System.out.println("Apagando impresora...");
        scanner.close();
    }
}