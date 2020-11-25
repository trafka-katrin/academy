package by.academy.home_work.HW_deal.validators;

public class AmericanPhoneValidator implements Validator{

    public Boolean validate(String phoneNum){
        Boolean chekPhone = false;
        if(phoneNum.matches("^\\+?1\\d{11}")){
            chekPhone = true;
        }
        return chekPhone;
    }


}
