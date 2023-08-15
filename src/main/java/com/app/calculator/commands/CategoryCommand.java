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
                window.obList_UnitsOfMeasurement_In = window.volume.getSubCategoryKeys();
                window.oblist_UnitsOfMeasurement_Out = window.volume.getSubCategoryKeys();
                showSubCategories();
                break;
            case "Pressure":
                window.obList_UnitsOfMeasurement_In = window.pressure.getSubCategoryKeys();
                window.oblist_UnitsOfMeasurement_Out = window.pressure.getSubCategoryKeys();
                showSubCategories();
                break;
            case "Area":
                window.obList_UnitsOfMeasurement_In = window.area.getSubCategoryKeys();
                window.oblist_UnitsOfMeasurement_Out = window.area.getSubCategoryKeys();
                showSubCategories();
                break;
            default:
                System.out.println("switch CategoryCommand Error");
        }
        return true;
    }
    public void showSubCategories() {
        window.comboBox_UnitOfMeasurement_In.setItems(window.obList_UnitsOfMeasurement_In);
        window.comboBox_UnitOfMeasurement_Out.setItems(window.oblist_UnitsOfMeasurement_Out);
        window.comboBox_UnitOfMeasurement_In.getSelectionModel().select(Element.FIRST.getNumber());
        window.comboBox_UnitOfMeasurement_Out.getSelectionModel().select(Element.FIRST.getNumber());
    }
}