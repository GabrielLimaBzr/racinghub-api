package com.application.racinghub.common.infra.util;


import com.application.racinghub.common.infra.util.functions.ValidateCNPJ;
import com.application.racinghub.common.infra.util.functions.ValidateCPF;
import com.application.racinghub.common.infra.util.functions.ValidateDocument;
import com.application.racinghub.common.infra.util.functions.ValidateEmail;

public class Utils {

    private static final ValidateEmail validateEmail = new ValidateEmail();
    private static final ValidateCPF validateCPF = new ValidateCPF();
    private static final ValidateCNPJ validateCNPJ = new ValidateCNPJ();
    private static final ValidateDocument validateDocument= new ValidateDocument();

    public static boolean isValidEmail(String email) {
        return validateEmail.isValidEmail(email);
    }

    public static boolean isValidCPF(String CPF) {
        return validateCPF.isValidCPF(CPF);
    }

    public static boolean isValidCNPJ(String CNPJ) {
        return validateCNPJ.isValidCNPJ(CNPJ);
    }

    /**
     * checks whether the value entered corresponds to a valid CPF or CNPJ
     * @param document
     */
    public static boolean isValidDocument(String document) {
        return validateDocument.isValidDocument(document);
    }

    /**
     * checks whether the value entered is of the CPF type or CNPJ type.
     * If it doesn't match either, null is returned.
     * @param document
     * @return CPF, CNPJ or null
     */
    public static String documentType(String document) {
        return validateDocument.documentType(document);
    }

    /**
     * CPF formatted with mask 000.000.000-00.<br>
     * CNPJ formatted with mask 00.000.000/0000-00.<br><br>
     * If the value entered does not correspond to a valid CPF or CNPJ,
     * an IllegalArgumentException is returned.
     *
     * @param document
     */
    public static String formatDocument(String document) {
        return validateDocument.formatDocument(document);
    }

    public static String removeSpecialCharacters(String document) {
        return validateDocument.removeSpecialCharacters(document);
    }
}
