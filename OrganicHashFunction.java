class OrganicHashFunction implements HashFunction {
    @Override
    public String hash(String input) {
        // Regresa el mismo dato como llave
        return input;
    }
}