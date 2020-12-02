package by.academy.home_work.HW_3__deal.validators;

public class BelarusPhoneValidator {
    public Boolean validate(String phoneNum){
        Boolean chekPhone = false;
        if(phoneNum.matches("^\\+?375( (?=\\())?( |-|\\((?=\\d{2}\\)))?\\d{2}( |-|(?<=\\(\\d{2})\\))?" +
                                    "( |-(?!\\d ))?\\d[ -]?(\\d((?<!-\\d) |(?<! \\d)-)?){5}\\d$")){
            chekPhone = true;
        }
        return chekPhone;
    }

}
