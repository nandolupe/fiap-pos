
/**
 * Classe <code>Pessoa</code>.
 *
 *
 * @category Bean.
 *
 * @author Luiz Pereira
 *
 */
public class Pessoa implements Comparable<Pessoa> {

    private String nome;
    private int idade;
    private char sexo;
    private String empresa;

    public Pessoa() {}

    public Pessoa(String nome, int idade, char sexo, String empresa) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.empresa = empresa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int compareTo(Pessoa pessoa) {
        return pessoa.getNome().compareTo(this.nome);
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", empresa=" + empresa + "]";
    }
}
