public enum FunctionType {
    ORGANIC("Organic"),
    MD5("MD5"),
    SHA1("SHA-1");

    private final String typeName;

    FunctionType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
