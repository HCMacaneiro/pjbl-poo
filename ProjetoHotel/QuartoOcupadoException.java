// Lançada quando tentamos fazer check-in em um quarto já ocupado

public class QuartoOcupadoException extends Exception {
    public QuartoOcupadoException(String message) {
        super(message);
    }
}