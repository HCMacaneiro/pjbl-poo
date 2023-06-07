// Lançada quando tentamos fazer check-out de um quarto vazio.

public class QuartoVazioException extends Exception {
    public QuartoVazioException(String message) {
        super(message);
    }
}