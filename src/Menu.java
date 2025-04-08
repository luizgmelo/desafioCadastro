package src;

public class Menu {
    private final String MENU ="""
1. Cadastrar um novo pet
2. Alterar os dados do pet cadastrado
3. Deletar um pet cadastrado
4. Listar todos os pets cadastrados
5. Listar pets por algum critério (idade, nome, raça)
6. Sair
""";

    public void showMenu() {
        System.out.println(MENU);
        System.out.print("Digite uma das opções acima: ");
    }
}
