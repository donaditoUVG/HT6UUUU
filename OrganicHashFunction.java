class OrganicHashFunction implements HashFunction {
    @Override
    public String hash(String input) {
        // Regresa el mismo dato como llave. No hay clavo con la lógica
        return input;
    }
}