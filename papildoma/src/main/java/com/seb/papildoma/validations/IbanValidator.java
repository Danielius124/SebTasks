package com.seb.papildoma.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class IbanValidator implements ConstraintValidator<IbanValid, String> {
    List<String> ibanType = Arrays.asList("LT20",
            "AD24", "AE23", "AT20", "AZ28", "BA20", "BE16", "BG22", "BH22", "BR29",
            "CH21", "CR21", "CY28", "CZ24", "DE22", "DK18", "DO28", "EE20", "ES24",
            "FI18", "FO18", "FR27", "GB22", "GI23", "GL18", "GR27", "GT28", "HR21",
            "HU28", "IE22", "IL23", "IS26", "IT27", "JO30", "KW30", "KZ20", "LB28",
            "LI21", "LU20", "LV21", "MC27", "MD24", "ME22", "MK19", "MR27",
            "MT31", "MU30", "NL18", "NO15", "PK24", "PL28", "PS29", "PT25", "QA29",
            "RO24", "RS22", "SA24", "SE24", "SI19", "SK24", "SM27", "TN24", "TR26");


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean answer = false;
        int checkSum = Integer.parseInt(value.substring(2,4));
    for(int i = 0; i < ibanType.size(); i++ ){
        if(value.substring(0,2).equals(ibanType.get(i).substring(0,2)) && value.length() == Integer.parseInt(ibanType.get(i).substring(2,4)) && checkSum > 35){
            answer = true;
            break;
        }else answer = false;
    }
        System.out.println(answer);
        return answer;

    }
}
