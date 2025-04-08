package br.com.luizgmelo.desafiocadastro.service;

import br.com.luizgmelo.desafiocadastro.model.PetSex;
import br.com.luizgmelo.desafiocadastro.model.PetType;

public class ValidateService {
    final String NOT_INFORMED = "NÃO INFORMADO";

    public void validateName(String name) {
        if (name.isEmpty()) {
            throw new RuntimeException("O nome do pet é um campo obrigatório");
        } else if (hasNumbersOrSpecialCharacters(name)) {
            throw new RuntimeException("O nome do pet só pode conter letras");
        }
    }

    public PetType validateType(String typeString) {
        PetType type;
        try {
            type = PetType.valueOf(typeString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("O tipo do pet só pode ser Cachorro ou Gato");
        }
        return type;
    }

    public PetSex validateSex(String sexString) {
        PetSex sex;
        try {
            sex = PetSex.valueOf(sexString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("O sexo do pet só pode ser Macho ou Femea");
        }
        return sex;
    }

    public void validateInteger(String string, String errorMessage) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(errorMessage);
        }
    }

    public void validateAge(String ageString) {
        try {
            double age = Double.parseDouble(ageString.replace(',', '.'));

            if (age <= 0 || age > 20) {
                throw new RuntimeException("A idade deve ser entre 0.1 e 20 anos.");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("A idade deve ser um número inteiro");
        }
    }

    public void validateWeight(String weightString) {
        try {
            double weight = Double.parseDouble(weightString.replace(',', '.'));

            if (weight < 0.5 || weight > 60.0) {
                throw new RuntimeException("O peso deve ser um número entre 0.5kg e 60kg");
            }

        } catch (NumberFormatException e) {
            throw new NumberFormatException("O peso deve ser um número decimal");
        }
    }

    public void validateBreed(String breed) {
        if (hasNumbersOrSpecialCharacters(breed)) {
            throw new RuntimeException("A raça somente deve conter letras.");
        }
    }

    public boolean hasNumbersOrSpecialCharacters(String string) {
        return !string.matches("^[ a-zA-Z]+$");
    }
}