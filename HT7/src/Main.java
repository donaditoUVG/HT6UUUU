package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Crear un diccionario
        BinarySearchTree<String, String, String> dictionary = new BinarySearchTree<>();

        // Leer el archivo diccionario.txt y construir diccionario
        buildDictionary(dictionary, "C:\\Users\\josep\\OneDrive - UVG\\SEMESTRE III\\Poo\\HT6\\HT6UUUU\\HT7\\src\\diccionario.txt");

        // Imprimir el diccionario en orden (in-order)
        printDictionaryInOrder(dictionary.getRoot());
    }

    private static void buildDictionary(BinarySearchTree<String, String, String> dictionary, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String key = parts[0].trim();
                String value = parts[1].trim() + " (" + parts[2].trim() + ")";
                dictionary.insert(key, value, null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printDictionaryInOrder(TreeNode<String, String, String> node) {
        if (node != null) {
            printDictionaryInOrder(node.getLeft());
            System.out.println("Inglés: " + node.getKey() + ", Francés: " + node.getValue() + ", Español: " + node.getFrenchValue());
            printDictionaryInOrder(node.getRight());
        }
    }
}
