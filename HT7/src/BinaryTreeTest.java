package src;
/**
 * @author Jose Donado
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testInsertAndFind() {
        // a partir de un árbol binario vacío
        BinaryTree<String, String, String> tree = new BinaryTree<>();
        
        // Asociaciones del arbol test
        tree.insert("dog", "perro", "chien");
        tree.insert("house", "casa", "maison");
        tree.insert("tree", "árbol", "arbre");
        
        // ¿SON LAS MISMAS ASOCIACIONES?
        assertEquals("perro", tree.find("dog"));
        assertEquals("casa", tree.find("house"));
        assertEquals("árbol", tree.find("tree"));
        
        // bUSCAR ASOCIACION INEXISTENTE EN EL ARBOL 
        assertEquals(null, tree.find("cat"));
    }
}

