package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Jose Donado
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        

        // Preguntar al usuario qué idioma desea usar como clave
        System.out.println("¿Qué idioma desea utilizar para traducir el texto? (inglés / español / francés)");
        String languageChoice = scanner.nextLine().trim().toLowerCase();

        // Crear los árboles binarios de búsqueda para cada idioma
        BinarySearchTree<String, String, String> englishTree = new BinarySearchTree<>();
        BinarySearchTree<String, String, String> spanishTree = new BinarySearchTree<>();
        BinarySearchTree<String, String, String> frenchTree = new BinarySearchTree<>();

        // Leer el archivo de diccionario y construir los árboles
        buildDictionaries(englishTree, spanishTree, frenchTree, "C:\\\\Users\\\\josep\\\\OneDrive - UVG\\\\SEMESTRE III\\\\Poo\\\\HT6\\\\HT6UUUU\\\\HT7\\\\src\\\\diccionario.txt");

        // Imprimir las palabras en los tres idiomas usando el recorrido in-order
        System.out.println("Las palabras registradas son: ");
        System.out.println("Inglés:");
        englishTree.inOrderTraversal();
        System.out.println("\nEspañol:");
        spanishTree.inOrderTraversal();
        System.out.println("\nFrancés:");
        frenchTree.inOrderTraversal();

        // Procesar el archivo de texto y traducir las palabras según la elección del usuario
        System.out.println("------------------------------");
        System.out.println("La traducción es:");
        translateText(languageChoice, englishTree, spanishTree, frenchTree, "C:\\\\Users\\\\josep\\\\OneDrive - UVG\\\\SEMESTRE III\\\\Poo\\\\HT6\\\\HT6UUUU\\\\HT7\\\\src\\\\texto.txt");
    }

    private static void buildDictionaries(BinarySearchTree<String, String, String> englishTree,
                                          BinarySearchTree<String, String, String> spanishTree,
                                          BinarySearchTree<String, String, String> frenchTree,
                                          String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String englishWord = parts[0].trim().toLowerCase();
                String spanishWord = parts[1].trim().toLowerCase();
                String frenchWord = parts[2].trim().toLowerCase();

                englishTree.insert(englishWord, spanishWord, frenchWord);
                spanishTree.insert(spanishWord, englishWord, frenchWord);
                frenchTree.insert(frenchWord, englishWord, spanishWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void translateText(String languageChoice,
                                  BinarySearchTree<String, String, String> englishTree,
                                  BinarySearchTree<String, String, String> spanishTree,
                                  BinarySearchTree<String, String, String> frenchTree,
                                  String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                String translation = null;
                // Convertir la palabra a minúsculas antes de buscar su traducción
                String lowercaseWord = word.toLowerCase();
                switch (languageChoice) {
                    case "inglés":
                        translation = englishTree.find(lowercaseWord);
                        break;
                    case "español":
                        translation = spanishTree.find(lowercaseWord);
                        System.out.println("*The");
                        break;
                    case "francés":
                        translation = frenchTree.find(lowercaseWord);
                        break;
                }
                if (translation != null) {
                    System.out.print(translation + " ");
                } else {
                    System.out.print("*" + word + "* ");
                }
            }
            System.out.println(); // Nueva línea para cada línea del texto
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}




}
