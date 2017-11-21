package br.com.erudio.databinding;

public class MyDataBindingHelper {

    private String salutation;
    public static MyDataBindingHelper get(String salutation) {return new MyDataBindingHelper(salutation);}
    public MyDataBindingHelper(String salutation) {this.salutation = salutation;}
    public String getMessage() {return String.format("Hi %s", salutation);}
}
