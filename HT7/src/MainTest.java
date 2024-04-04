package src;


import org.junit.Test;

public class MainTest {
    
    @Test
    public void testTranslateText() {
        // ARBOLES CON EJEMPLOSS
        BinarySearchTree<String, String, String> englishTree = new BinarySearchTree<>();
        englishTree.insert("dog", "perro", "chien");
        englishTree.insert("house", "casa", "maison");
        
        BinarySearchTree<String, String, String> spanishTree = new BinarySearchTree<>();
        spanishTree.insert("perro", "dog", "chien");
        spanishTree.insert("casa", "house", "maison");
        
        BinarySearchTree<String, String, String> frenchTree = new BinarySearchTree<>();
        frenchTree.insert("chien", "dog", "perro");
        frenchTree.insert("maison", "house", "casa");
        
        // PALABRAS EN INGLÉS
        String filePath = "test.txt";
        
        // iNSTANCIA  de Main
        Main main = new Main();
        
      
    }
}

