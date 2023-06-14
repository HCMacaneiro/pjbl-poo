public class Hospede extends Pessoa {
    private String cpf;
    private String telefone;

    public Hospede(String nome, String cpf, String telefone) throws HospedeException {
        super(nome);
        if (cpf == null || cpf.equals("")) {
            throw new HospedeException("AVISO: CPF do cliente não pode ser nulo...");
        }
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
