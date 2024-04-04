package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Crear árboles binarios de búsqueda para cada idioma
        BinarySearchTree<String, String, String> englishTree = new BinarySearchTree<>();
        BinarySearchTree<String, String, String> spanishTree = new BinarySearchTree<>();
        BinarySearchTree<String, String, String> frenchTree = new BinarySearchTree<>();

        // Leer el archivo de asociaciones y construir los árboles
        buildTrees(englishTree, spanishTree, frenchTree, "C:\\\\Users\\\\josep\\\\OneDrive - UVG\\\\SEMESTRE III\\\\Poo\\\\HT6\\\\HT6UUUU\\\\HT7\\\\src\\\\diccionario.txt");

        // Imprimir las palabras en los tres idiomas usando el recorrido in-order
        System.out.println("Inglés:");
        englishTree.inOrderTraversal();
        System.out.println("\nEspañol:");
        spanishTree.inOrderTraversal();
        System.out.println("\nFrancés:");
        frenchTree.inOrderTraversal();

        System.out.println("Para mostar las traducciones de otras palabras modifica el archivo de texto, diccionario.txt. Siuu");
    }

    private static void buildTrees(BinarySearchTree<String, String, String> englishTree,
                                    BinarySearchTree<String, String, String> spanishTree,
                                    BinarySearchTree<String, String, String> frenchTree,
                                    String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String englishWord = parts[0].trim();
                String spanishWord = parts[1].trim();
                String frenchWord = parts[2].trim();

                englishTree.insert(englishWord, spanishWord, frenchWord);
                spanishTree.insert(spanishWord, englishWord, frenchWord);
                frenchTree.insert(frenchWord, englishWord, spanishWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
