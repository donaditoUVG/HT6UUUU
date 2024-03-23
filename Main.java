/**
 * HashMap: Los elementos que inserta en el map no tendrán un orden específico. No aceptan claves duplicadas ni valores nulos.
TreeMap: El Mapa lo ordena de forma "natural". Por ejemplo, si la clave son valores enteros (como luego veremos), los ordena de menos a mayor.
LinkedHashMap: Inserta en el Map los elementos en el orden en el que se van insertando; 
es decir, que no tiene una ordenación de los elementos como tal, por lo que esta clase realiza las búsquedas de los 
elementos de forma más lenta que las demás clases.
 */
/**
 * @author Jose Donado
 */

import java.util.Scanner;


 public class Main {
    public static void main(String[] args) {
        //HASH
        int hashFunctionType = selectHashFunction();

        // instancia de HASH
        HashFunction hashFunction = createHashFunction(hashFunctionType);

        
        String inputData = "holi";
        String hashedData = hashFunction.hash(inputData);
        System.out.println("Datos Originales: " + inputData);
        System.out.println("Datos (Después del Hash): " + hashedData);
    }

    private static int selectHashFunction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la función Hash:");
        System.out.println("1. Orgánica");
        System.out.println("2. MD5");
        System.out.println("3. SHA");
        int option = scanner.nextInt();
        scanner.close();
        return option;
    }

    //Agarra uno de los cases
    private static HashFunction createHashFunction(int hashFunctionType) {
        switch (hashFunctionType) {
            case 1:
                return new OrganicHashFunction();
            case 2:
                return new MD5HashFunction();
            case 3:
                return new SHAHashFunction();
            default:
                throw new IllegalArgumentException("Tipo de función hash no válido");
        }
    }
}









