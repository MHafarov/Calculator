package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.categories.Categories;
import com.app.calculator.constants.Element;

import java.math.BigDecimal;

public class SubCategoryCommand extends Command {

    public SubCategoryCommand(String newValue, Window window) {
        super(newValue, window);
    }
    @Override
    public boolean execute() {
        String digit_String_In = window.displayField.getText();
        BigDecimal digit_BigDecimal_In = toBigDecimal(digit_String_In);
        System.out.println("digit_BigDecimal_In " + digit_BigDecimal_In);

        // Взять название главной категории ("Volume")
        String mainCategory_String = window.comboBox_Category.getSelectionModel().getSelectedItem();
        System.out.println("mainCategory_String " + mainCategory_String);

        // Вытянуть объект главной категории из Хэш-мэпа главных категорий (Volume)
        Categories mainCategory_Category = window.categories.subCategory.get(mainCategory_String);
        System.out.println("mainCategory_Category " + mainCategory_Category);

        // Получить название входящей подкатегории (MPa)
        String unitOfMeasurement_In = window.comboBox_UnitOfMeasurement_In.getSelectionModel().getSelectedItem();
        System.out.println("1unitOfMeasurement_In " + unitOfMeasurement_In);

        // Получить название выходящей подкатегории (kgs/cm2)
        String unitOfMeasurement_Out = window.comboBox_UnitOfMeasurement_Out.getSelectionModel().getSelectedItem();
        System.out.println("2unitOfMeasurement_Out " + unitOfMeasurement_Out);

        // Получить подкатегорию (obj kgs/cm2)
        Categories subCategory_Category = mainCategory_Category.subCategory.get(unitOfMeasurement_Out);
        //                                         Volume         hashmap           "kgs/cm2"
        System.out.println("subCategory_Category " + subCategory_Category);


        try {
            // Получить коэффициент пересчета входящей категории в выходящую (obj kgs/cm2)
            BigDecimal coeficient = subCategory_Category.coeficient.get(unitOfMeasurement_In);
            //                                                obj kgs/cm2          hashmap             "MPa"

            // Получить выходящее число путем умножения входящего числа на коэффициент пересчета
            BigDecimal digit_BigDecimal_Out = digit_BigDecimal_In.multiply(coeficient);
            System.out.println("digit_BigDecimal_Out " + digit_BigDecimal_Out);

            // Преобразовать выходящее число в строку
            String digit_String_Out = toString(digit_BigDecimal_Out);
            System.out.println("digit_String_Out " + digit_String_Out);

            // Вывести на выходящий дисплей текст выходящего числа
            window.textField_Convertion_Out.setText(digit_String_Out);
        } catch (NullPointerException e) {
            System.out.println("subCategory_Category is null");
        }
        return true;
    }
}
