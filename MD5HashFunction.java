import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *Implementa la interfaz HashFunction. Esta implementación la obtuve gracias a ChatGPT, que a su vez la obtuvo de un repositorio.
 el prompt fue: crea clases de implementación de la función Hash Organica, MD5 y SHA-1 para el código contiguo.
 */

class MD5HashFunction implements HashFunction {
    //Sobrescribeee
    @Override
    public String hash(String input) {
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}