package myVersion;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;

    public Hotel() {
        this.quartos = new ArrayList<>();
        inicializarQuartos();
    }

    public List<TipoQuarto> getTiposQuarto() {
        List<TipoQuarto> tiposQuarto = new ArrayList<>();
        for (Quarto quarto : quartos) {
            TipoQuarto tipoQuarto = quarto.getTipo();
            if (!tiposQuarto.contains(tipoQuarto)) {
                tiposQuarto.add(tipoQuarto);
            }
        }
        return tiposQuarto;
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public List<Quarto> getQuartosDisponiveis() {
        List<Quarto> quartosDisponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (quarto.getStatus() == StatusQuarto.DISPONIVEL) {
                quartosDisponiveis.add(quarto);
            }
        }
        return quartosDisponiveis;
    }

    public Quarto buscarQuartoPorNumero(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    private void inicializarQuartos() {
        TipoQuarto suitePresidencial = new TipoQuarto("Suíte Presidencial", 500.00, 4);
        TipoQuarto suiteExecutiva = new TipoQuarto("Suíte Executiva", 300.00, 2);
        TipoQuarto suiteEconomica = new TipoQuarto("Suíte Econômica", 200.00, 2);

        for (int i = 1; i <= 5; i++) {
            Quarto quarto = new Quarto(i, suitePresidencial);
            adicionarQuarto(quarto);
        }

        for (int i = 6; i <= 20; i++) {
            Quarto quarto = new Quarto(i, suiteExecutiva);
            adicionarQuarto(quarto);
        }

        for (int i = 21; i <= 50; i++) {
            Quarto quarto = new Quarto(i, suiteEconomica);
            adicionarQuarto(quarto);
        }
    }
}
