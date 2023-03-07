public class App {
    public static void main(String[] args) throws Exception {
        Repository<Professor> profRepo = new Repository<>();
        Repository<Aluno> alunoRepo = new Repository<>();

        Professor professor = new Professor("João", "Geografia");
        profRepo.salvar(new Professor("José", "Matemática"));
        profRepo.salvar(new Professor("Maria", "História"));
        profRepo.salvar(professor);
        profRepo.buscarTodos().forEach(System.out::println);
        profRepo.buscar(professor);
        profRepo.remover(professor);
        profRepo.buscarTodos().forEach(System.out::println);

        Aluno aluno1 = new Aluno("Fátima", 12345);
        Aluno aluno2 = new Aluno("Cláudio", 12346);

        alunoRepo.salvar(aluno1);
        alunoRepo.salvar(aluno2);
        alunoRepo.buscarTodos().forEach(System.out::println);



    }
}
