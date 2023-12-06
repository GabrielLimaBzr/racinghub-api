package com.application.racinghub.common.infra.util.functions;

import java.util.InputMismatchException;

public class ValidateCPF {

    public ValidateCPF() {
    }

    public boolean isValidCPF(String CPF) {

        CPF = removeSpecialCharacters(CPF);

        /*
         * CPF numbers formed by a sequence of equal numbers are considered errors
         */
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sum, i, r, num, weight;

        try {
            /*
             * Calculation of the first check digit
             */
            sum = 0;
            weight = 10;
            for (i=0; i<9; i++) {

                /*
                 * converts the ith character of the CNPJ into a number
                 * for example, transforms the character '0' into the integer 0
                 * 48 is the position of '0' in the ASCII table
                 */
                num = (int)(CPF.charAt(i) - 48);
                sum = sum + (num * weight);
                weight = weight - 1;
            }

            r = 11 - (sum % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            /*
             * Calculation of the second check digit
             */
            sum = 0;
            weight = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sum = sum + (num * weight);
                weight = weight - 1;
            }

            r = 11 - (sum % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            /*
             * Checks whether the calculated digits match the entered digits
             */
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException exception) {
            return(false);
        }
    }

    /**
     * CPF formatted with mask 000.000.000-00
     * @param CPF
     */
    public String formatCPF(String CPF) {
        CPF = removeSpecialCharacters(CPF);
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

    private String removeSpecialCharacters(String CPF) {
        return CPF.replaceAll("\\.", "").replaceAll("-", "");
    }
}

