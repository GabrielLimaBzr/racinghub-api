package com.application.racinghub.common.infra.util.functions;

import java.util.Objects;

public class ValidateDocument {

    private final ValidateCPF validateCPF = new ValidateCPF();
    private final ValidateCNPJ validateCNPJ = new ValidateCNPJ();

    public ValidateDocument() {
    }

    public boolean isValidDocument(String document) {
        document = removeSpecialCharacters(document);
        return switch (document.length()) {
            case 11 -> validateCPF.isValidCPF(document);
            case 14 -> validateCNPJ.isValidCNPJ(document);
            default -> false;
        };
    }

    public String documentType(String document) {
        document = removeSpecialCharacters(document);
        if (validateCPF.isValidCPF(document)) return "CPF";
        if (validateCNPJ.isValidCNPJ(document)) return "CNPJ";
        return null;
    }


    public String formatDocument(String document) {
        if (Objects.equals(documentType(document), "CPF")) return validateCPF.formatCPF(document);
        if (Objects.equals(documentType(document), "CNPJ")) return validateCNPJ.formatCNPJ(document);
        throw new IllegalArgumentException("O valor informado não corresponde a um CPF ou CNPJ válido");
    }


    public String removeSpecialCharacters(String document) {
        return document.replaceAll("\\.", "")
                .replaceAll("/", "")
                .replaceAll("-", "");
    }
}
