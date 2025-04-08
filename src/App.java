package src;

import src.models.address.Address;
import src.models.pet.Pet;
import src.models.pet.Sex;
import src.models.pet.Type;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String[] args) {
        File file = new File("src/formulario.txt");
        Scanner asksFile = null;
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        List<String> answers = new ArrayList<>();
        String NOT_INFORMED = "NÃO INFORMADO";

        try {
            asksFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Não foi possível encontrar o arquivo formulario.txt");
        }

        int option;
        do {
            menu.showMenu();

            while (!scanner.hasNextInt()) {
                System.out.println("\nDigite apenas o número da opção.\n");
                menu.showMenu();
                scanner.next();
            }

            option = scanner.nextInt();
            System.out.print("\n");

            switch (option) {
                case 1:

                    scanner.nextLine();
                    // 1. Qual o nome e sobrenome do pet?
                    System.out.print(asksFile.nextLine());
                    String name = scanner.nextLine();

                    if (name.isEmpty()) {
                        throw new RuntimeException("O nome do pet é um campo obrigatório");
                    } else if (hasOnlyAlphabetical(name)) {
                        throw new RuntimeException("O nome do pet só pode conter letras");
                    }

                    // 2. Qual o tipo do pet (Cachorro/Gato)?
                    System.out.print(asksFile.nextLine());
                    Type type;
                    try {
                        type = Type.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException("O tipo do pet só pode ser Cachorro ou Gato");
                    }

                    // 3. Qual o sexo do animal?
                    System.out.print(asksFile.nextLine());
                    Sex sex;
                    try {
                        sex = Sex.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException("O sexo do pet só pode ser Macho ou Femea");
                    }
                    // 4. Qual endereço e bairro que ele foi encontrado?
                    System.out.println(asksFile.nextLine());
                    System.out.print(asksFile.nextLine());
                    int houseNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print(asksFile.nextLine());
                    String city = scanner.nextLine();
                    System.out.print(asksFile.nextLine());
                    String street = scanner.nextLine();
                    System.out.print(asksFile.nextLine());
                    String neighborhood = scanner.nextLine();
                    // 5. Qual a idade em anos aproximada do pet?
                    System.out.print(asksFile.nextLine());
                    String age = scanner.nextLine();

                    if (age.isEmpty()) {
                        age = NOT_INFORMED;
                    }

//                    int age;
//                    try {
//                        age = (int) ageString;
//                    } catch (NumberFormatException e) {
//                        throw new RuntimeException("A idade deve ser um número inteiro");
//                    }

                    // 6. Qual o peso em kilos aproximado do pet?
                    System.out.print(asksFile.nextLine());
                    String weight = scanner.nextLine(); // 2.2kg 2,2kg

                    if (weight.isEmpty()) {
                        weight = NOT_INFORMED;
                    }





                    // 7.
                    scanner.nextLine();
                    System.out.print(asksFile.nextLine());
                    String breed = scanner.nextLine();

                    Address address = new Address(houseNumber, city, street, neighborhood);
                    Pet pet = new Pet(name, type, sex, address, age, weight, breed);

                    System.out.println(pet);

                    break;
                case 2:
                    System.out.println("Você escolheu a opção 2");
                    break;
                case 3:
                    System.out.println("Você escolheu a opção 3");
                    break;
                case 4:
                    System.out.println("Você escolheu a opção 4");
                    break;
                case 5:
                    System.out.println("Você escolheu a opção 5");
                    break;
                case 6:
                    System.out.println("Você escolheu a opção 6");
                    break;
                default:
                    System.out.println("Opção inválida por favor digite um número entre 1 e 6");

                System.out.print("\n");
            }
        } while (option < 1 || option > 6);
    }

    public static boolean hasOnlyAlphabetical(String string) {
        return !string.matches("^[a-zA-Z]+$");
    }
}