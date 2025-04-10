package src;

import src.models.address.Address;
import src.models.pet.Pet;
import src.models.pet.Sex;
import src.models.pet.Type;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        File file = new File("formulario.txt");
        Scanner scanner = new Scanner(System.in);
        final String NOT_INFORMED = "NÃO INFORMADO";

        Scanner asksFile;
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
                    } else if (hasNumbersOrSpecialCharacters(name)) {
                        throw new RuntimeException("O nome do pet só pode conter letras");
                    }

                    // 2. Qual o tipo do pet (Cachorro/Gato)?
                    System.out.print(asksFile.nextLine());
                    Type type;

                    try {
                        type = Type.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        // TODO pegar os valores do Enum sem precisar escrever na string
                        throw new RuntimeException("O tipo do pet só pode ser " + String.join(", ", Type.values()));
                    }

                    // 3. Qual o sexo do animal?
                    System.out.print(asksFile.nextLine());
                    Sex sex;
                    try {
                        sex = Sex.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        // TODO pegar os valores do Enum sem precisar escrever na string
                        throw new RuntimeException("O sexo do pet só pode ser Macho ou Femea");
                    }

                    // 4. Qual endereço e bairro que ele foi encontrado?
                    System.out.println(asksFile.nextLine());
                    System.out.print(asksFile.nextLine());
                    String houseNumber = scanner.nextLine();

                    if (houseNumber.isEmpty()) {
                        houseNumber = NOT_INFORMED;
                    } else {
                        try {
                            Integer.parseInt(houseNumber);
                        } catch (NumberFormatException e) {
                            throw new NumberFormatException("O número da casa deve ser um número inteiro");
                        }
                    }

                    System.out.print(asksFile.nextLine());
                    String city = scanner.nextLine();

                    System.out.print(asksFile.nextLine());
                    String street = scanner.nextLine();

                    System.out.print(asksFile.nextLine());
                    String neighborhood = scanner.nextLine();

                    // 5. Qual a idade em anos aproximada do pet?
                    System.out.print(asksFile.nextLine());
                    String ageString = scanner.nextLine();

                    if (ageString.isEmpty()) {
                        ageString = NOT_INFORMED;
                    } else {
                        try {
                            double age = Double.parseDouble(ageString.replace(',', '.'));

                            if (age <= 0 || age > 20) {
                                throw new RuntimeException("A idade deve ser entre 0.1 e 20 anos.");
                            }
                        } catch (NumberFormatException e) {
                            throw new NumberFormatException("A idade deve ser um número inteiro");
                        }
                    }

                    // 6. Qual o peso em kilos aproximado do pet?
                    System.out.print(asksFile.nextLine());
                    String weightString = scanner.nextLine();

                    if (weightString.isEmpty()) {
                        weightString = NOT_INFORMED;
                    } else {
                        try {
                            double weight = Double.parseDouble(weightString.replace(',', '.'));

                            if (weight < 0.5 || weight > 60.0) {
                                throw new RuntimeException("O peso deve ser um número entre 0.5kg e 60kg");
                            }

                        } catch (NumberFormatException e) {
                            throw new NumberFormatException("O peso deve ser um número decimal");
                        }
                    }

                    // 7. Qual a raça do pet?
                    System.out.print(asksFile.nextLine());
                    String breed = scanner.nextLine();

                    if (hasNumbersOrSpecialCharacters(breed) && !breed.isEmpty()) {
                        throw new RuntimeException("A raça somente deve conter letras.");
                    }

                    Address address = new Address(houseNumber, city, street, neighborhood);
                    Pet pet = new Pet(name, type, sex, address, ageString, weightString, breed);

                    try {
                        savePetFile(pet);
                    } catch (IOException e) {
                        throw new RuntimeException("Erro ao criar arquivo do pet");
                    }

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

    public static boolean hasNumbersOrSpecialCharacters(String string) {
        return !string.matches("^[ a-zA-Z]+$");
    }

    public static void savePetFile(Pet pet) throws IOException {
        String fileName = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm").format(LocalDateTime.now()) + " - " +
                            pet.getName().toUpperCase().replaceAll("\\s", "") + ".txt";

        Path fileFolder = Paths.get("petsCadastrados");
        if (Files.notExists(fileFolder)) {
            Files.createDirectory(fileFolder);
        }

        Path filePath = Paths.get(fileFolder.toString(), fileName);
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }

//        Um metódo para escrever no arquivo
//        try (BufferedWriter bw = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
//
//        };
    }
}