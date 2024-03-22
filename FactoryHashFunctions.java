public class FactoryHashFunctions {
    public static HashFunction obtenerFunction(FunctionType functionType) {
        switch (functionType) {
            case ORGANIC:
                return new OrganicHashFunction();
            case MD5:
                return new MD5HashFunction();
            case SHA1:
                return new SHAHashFunction();
            default:
                throw new IllegalArgumentException("NO EXISTE DICHA FUNCION");
        }
    }
}
