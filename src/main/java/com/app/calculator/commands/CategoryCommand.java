package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.categories.Area;
import com.app.calculator.categories.Pressure;
import com.app.calculator.categories.Volume;
import com.app.calculator.constants.Element;
import com.app.calculator.windowsCollection.WindowCollection;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CategoryCommand extends Command {

    public CategoryCommand(String newValue, Window window) {
        super(newValue, window);
    }
    @Override
    public boolean execute() {
        switch (newValue) {
            case "Volume":
                window.obList_UnitsOfMeasurement_In = window.volume.getSubCategoryKeys();
                window.comboBox_UnitOfMeasurement_In.setItems(window.obList_UnitsOfMeasurement_In);
                window.oblist_UnitsOfMeasurement_Out = window.volume.getSubCategoryKeys();
                window.combo_Box_UnitOfMeasurement_Out.setItems(window.oblist_UnitsOfMeasurement_Out);
                window.comboBox_UnitOfMeasurement_In.getSelectionModel().select(Element.FIRST.getNumber());
                window.combo_Box_UnitOfMeasurement_Out.getSelectionModel().select(Element.FIRST.getNumber());
                break;
            case "Pressure":
                window.obList_UnitsOfMeasurement_In = window.pressure.getSubCategoryKeys();
                window.comboBox_UnitOfMeasurement_In.setItems(window.obList_UnitsOfMeasurement_In);
                window.oblist_UnitsOfMeasurement_Out = window.pressure.getSubCategoryKeys();
                window.combo_Box_UnitOfMeasurement_Out.setItems(window.oblist_UnitsOfMeasurement_Out);
                window.comboBox_UnitOfMeasurement_In.getSelectionModel().select(Element.SECOND.getNumber());
                window.combo_Box_UnitOfMeasurement_Out.getSelectionModel().select(Element.SECOND.getNumber());
                break;
            case "Area":
                window.obList_UnitsOfMeasurement_In = window.area.getSubCategoryKeys();
                window.comboBox_UnitOfMeasurement_In.setItems(window.obList_UnitsOfMeasurement_In);
                window.oblist_UnitsOfMeasurement_Out = window.area.getSubCategoryKeys();
                window.combo_Box_UnitOfMeasurement_Out.setItems(window.oblist_UnitsOfMeasurement_Out);
                window.comboBox_UnitOfMeasurement_In.getSelectionModel().select(Element.THIRD.getNumber());
                window.combo_Box_UnitOfMeasurement_Out.getSelectionModel().select(Element.THIRD.getNumber());
                break;
            default:
                System.out.println("switch CategoryCommand Error");
        }
        return true;
    }
}