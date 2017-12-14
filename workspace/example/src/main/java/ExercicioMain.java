import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Classe <code>ExercicioMain</code>.
 *
 *
 * @category Main
 *
 * @author Luiz Pereira
 *
 */
public class ExercicioMain {

    /**
     * Metodo main.
     *
     * @param args
     *
     */
    public static void main(String[] args) {

        ArrayList<Pessoa> pessoaList = new ArrayList<Pessoa>();
        pessoaList.add(new Pessoa("João Garcia", 20, 'M', "AIK Enterprises"));
        pessoaList.add(new Pessoa("Maria Martins", 44, 'F', "Simples"));
        pessoaList.add(new Pessoa("Henrique Fernando", 43, 'M', "AIK Enterprises"));
        pessoaList.add(new Pessoa("Inácio Luís", 33, 'M', "Magazine André"));
        pessoaList.add(new Pessoa("Fernando Ferreira", 87, 'M', "Casas Recife"));

        // A.
        System.out.println("Removendo item 3 da lista...");
        Collections.shuffle(pessoaList);
        pessoaList.remove(2);

        // B.
        System.out.println("\n Ordenando A -> Z");
        Collections.sort(pessoaList);
        listar(pessoaList);

        System.out.println("\n Ordenando Z -> A");
        // C.
        Collections.reverse(pessoaList);
        listar(pessoaList);

    }

    /**
     * Metodo listar.
     *
     * @param pessoaList
     *
     */
    private static void listar(List<Pessoa> pessoaList) {
        for (Pessoa pessoa : pessoaList) {
            System.out.println(pessoa);
        }
    }
}
