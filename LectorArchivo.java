import java.io.FileReader;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LectorArchivo {
    
    public static void leerEstudiantes(Map<String, Estudiante> estudiantesMap, MapaNacionalidad mapaNacionalidad, HashFunction hashFunction) {
       
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("res/estudiantes.json")) {

            // Parsear el archivo JSON para convertirlo en objeto
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            // Iteración para cada objeto JSON en el array de JSON
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;

                // Atributos del estudiante
                String name = (String) jsonObject.get("name");
                String phone = (String) jsonObject.get("phone");
                String email = (String) jsonObject.get("email");
                String postalZip = (String) jsonObject.get("postalZip");
                String country = (String) jsonObject.get("country");

                // object Estudiante
                Estudiante estudiante = new Estudiante(name, phone, email, postalZip, country);

                // La clave sera el email porque es el unico que no se repite
                String hashedEmail = hashFunction.hash(email);
                // Agregando el estudiante al mapa individual
                estudiantesMap.put(hashedEmail, estudiante);

                // Agregando el estudiante al mapa por nacionalidad
                mapaNacionalidad.agregarEstudiantePorNacionalidad(country, estudiante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
