package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.Element;

public class CategoryCommand extends Command {

    public CategoryCommand(String newValue, Window window) {
        super(newValue, window);
    }
    @Override
    public boolean execute() {
        switch (newValue) {
            case "Volume":
                window.oblist_UnitsOfMeasurement_In = window.volume.getSubCategoryKeys();
                window.oblist_UnitsOfMeasurement_Out = window.volume.getSubCategoryKeys();
                showSubCategories();
                clearInOutDisplays();
                break;
            case "Pressure":
                window.oblist_UnitsOfMeasurement_In = window.pressure.getSubCategoryKeys();
                window.oblist_UnitsOfMeasurement_Out = window.pressure.getSubCategoryKeys();
                showSubCategories();
                clearInOutDisplays();
                break;
            case "Area":
                window.oblist_UnitsOfMeasurement_In = window.area.getSubCategoryKeys();
                window.oblist_UnitsOfMeasurement_Out = window.area.getSubCategoryKeys();
                showSubCategories();
                clearInOutDisplays();
                break;
            default:
                System.out.println("switch CategoryCommand Error");
        }
        return true;
    }
    public void showSubCategories() {
        window.comboBox_UnitOfMeasurement_In.setItems(window.oblist_UnitsOfMeasurement_In);
        System.out.println("window.oblist_UnitsOfMeasurement_In ----- " + window.oblist_UnitsOfMeasurement_In);

        window.comboBox_UnitOfMeasurement_Out.setItems(window.oblist_UnitsOfMeasurement_Out);
        System.out.println("window.oblist_UnitsOfMeasurement_Out ----- " + window.oblist_UnitsOfMeasurement_Out);


        window.comboBox_UnitOfMeasurement_In.getSelectionModel().select(Element.FIRST.getNumber());
        System.out.println("comboBox_UnitOfMeasurement_In ||||| " + window.comboBox_UnitOfMeasurement_In.getSelectionModel().getSelectedItem());
        window.comboBox_UnitOfMeasurement_Out.getSelectionModel().select(Element.FIRST.getNumber());
        System.out.println("comboBox_UnitOfMeasurement_Out ||||| " + window.comboBox_UnitOfMeasurement_Out.getSelectionModel().getSelectedItem());
    }

    public void clearInOutDisplays() {
        window.setTextField(window.textField_Convertion_In, "-fx-alignment: center-left;", "0");
        window.setTextField(window.textField_Convertion_Out, "-fx-alignment: center-left;", "0");
    }
}