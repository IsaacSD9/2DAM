package com.example.ejemplosdiu;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.binding.NumberBinding;
public class PrincipalBill {
    public static void main(String[] args) {

//        Bill electricBill = new Bill();
//
//        electricBill.amountDueProperty().addListener(new ChangeListener(){
//            @Override public void changed(ObservableValue o,Object oldVal,
//                                          Object newVal){
//                System.out.println("Electric bill has changed!");
//            }
//        });
//
//        electricBill.setAmountDue(100.00);

        IntegerProperty num1 = new SimpleIntegerProperty(2);
        IntegerProperty num2 = new SimpleIntegerProperty(5);
        num1.bindBidirectional(num2);

        NumberBinding sum = num1.add(num2);
//        System.out.println(sum.getValue());
//        num1.set(2);
        System.out.println(sum.getValue());


    }
}