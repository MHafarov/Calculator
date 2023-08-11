package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.commands.CategoryCommand;
import com.app.calculator.commands.CheckMenuItemCommand;
import com.app.calculator.constants.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ConvertionWindow extends Window{
    public ConvertionWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

            this.stage.setTitle("Convertion");

            ComboBox<String> comboBox_Category = new ComboBox<String>();
            ObservableList<String> observablelist_Category = FXCollections.observableArrayList();
            observablelist_Category.add("Volume");
            observablelist_Category.add("Length");
            observablelist_Category.add("Weight and mass");
            comboBox_Category.setItems(observablelist_Category);
            comboBox_Category.getSelectionModel().select(Element.FIRST.getNumber());
            Label list_SelectCategory = new Label("Select Category: ");
            subPanel_SecondRow.getChildren().add(list_SelectCategory);
            GridPane.setConstraints(list_SelectCategory, Column.FIRST.getNumber(), Row.FIRST.getNumber());
            subPanel_SecondRow.getChildren().add(comboBox_Category);
            GridPane.setConstraints(comboBox_Category, Column.SECOND.getNumber(), Row.FIRST.getNumber());

            comboBox_Category.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    executeCommand(new CategoryCommand());
                }
            });





            TextField textField_In = new TextField();
            textField_In.setStyle("-fx-alignment: center-left;");
            textField_In.setText("0");
            GridPane.setHgrow(textField_In, Priority.ALWAYS);
            GridPane.setVgrow(textField_In, Priority.ALWAYS);
            subPanel_ThirdRow.add(textField_In, Column.FIRST.getNumber(), Row.FIRST.getNumber());

            ComboBox<String> comboBox_UnitOfMeasurement_In = new ComboBox<String>();
            ObservableList<String> obList_UnitsOfMeasurement_In = FXCollections.observableArrayList();
            obList_UnitsOfMeasurement_In.add("Meter");
            obList_UnitsOfMeasurement_In.add("Santimeter");
            obList_UnitsOfMeasurement_In.add("Kilometer");
            comboBox_UnitOfMeasurement_In.setItems(obList_UnitsOfMeasurement_In);
            comboBox_UnitOfMeasurement_In.getSelectionModel().select(Element.FIRST.getNumber());
            subPanel_FourthRow.getChildren().add(comboBox_UnitOfMeasurement_In);
            GridPane.setConstraints(comboBox_UnitOfMeasurement_In, Column.SECOND.getNumber(), Row.FIRST.getNumber());

            TextField DisplayField_Out = new TextField();
            DisplayField_Out.setStyle("-fx-alignment: center-left;");
            DisplayField_Out.setText("0");
            GridPane.setHgrow(DisplayField_Out, Priority.ALWAYS);
            GridPane.setVgrow(DisplayField_Out, Priority.ALWAYS);
            subPanel_FifthRow.add(DisplayField_Out, Column.FIRST.getNumber(), Row.FIRST.getNumber());
            DisplayField_Out.setEditable(false);

            ComboBox<String> combo_Box_UnitOfMeasurement_Out = new ComboBox<String>();
            ObservableList<String> oblist_UnitsOfMeasurement_Out = FXCollections.observableArrayList();
            oblist_UnitsOfMeasurement_Out.add("Meter");
            oblist_UnitsOfMeasurement_Out.add("Santimeter");
            oblist_UnitsOfMeasurement_Out.add("Kilometer");
            combo_Box_UnitOfMeasurement_Out.setItems(oblist_UnitsOfMeasurement_Out);
            combo_Box_UnitOfMeasurement_Out.getSelectionModel().select(Element.FIRST.getNumber());
            subPanel_SixthRow.getChildren().add(combo_Box_UnitOfMeasurement_Out);
            GridPane.setConstraints(combo_Box_UnitOfMeasurement_Out, Column.SECOND.getNumber(), Row.FIRST.getNumber());

            for (int i = 0; i < list_ElementsRoundingTop.size(); i++) {
                addElementToPanel(list_ElementsRoundingTop.get(i), subPanel_SeventhRow, columns[i], Row.FIRST);
                list_ElementsRoundingTop.get(i).setAlignment(Pos.CENTER);
            }

            for (int i = 0; i < list_ElementsRoundingDown.size(); i++) {
                addElementToPanel(list_ElementsRoundingDown.get(i), subPanel_SeventhRow, columns[i], Row.SECOND);
            }
            subPanel_SeventhRow.add(label_TypeRounding,0,2, 5, 2);
            subPanel_SeventhRow.add(label_ScaleRounding,5,2,14,2);

            list_ElementsEighthRow.add(btn_ThreeSpaces);
            list_ElementsEighthRow.add(btn_CE);
            list_ElementsEighthRow.add(btn_Backspace);

            for (int i = 0; i < list_ElementsEighthRow.size(); i++) {
                addButtonsToPanel(list_ElementsEighthRow.get(i), subPanel_EighthRow, columns[i], Row.FIRST);
            }

            list_ElementsNinthRow.add(btn_Seven);
            list_ElementsNinthRow.add(btn_Eight);
            list_ElementsNinthRow.add(btn_Nine);

            for (int i = 0; i < list_ElementsNinthRow.size(); i++) {
                addButtonsToPanel(list_ElementsNinthRow.get(i), subPanel_NinthRow, columns[i], Row.FIRST);
            }

            list_ElementsTenthRow.add(btn_Four);
            list_ElementsTenthRow.add(btn_Five);
            list_ElementsTenthRow.add(btn_Six);

            for (int i = 0; i < list_ElementsTenthRow.size(); i++) {
                addButtonsToPanel(list_ElementsTenthRow.get(i), subPanel_TenthRow, columns[i], Row.FIRST);
            }

            GridPane subPanel_EleventhRow = new GridPane();
            list_GridPanes.add(subPanel_EleventhRow);
            List<Control> list_ElementsEleventhRow = new ArrayList<>();

            list_ElementsEleventhRow.add(btn_One);
            list_ElementsEleventhRow.add(btn_Two);
            list_ElementsEleventhRow.add(btn_Three);

            for (int i = 0; i < list_ElementsEleventhRow.size(); i++) {
                addButtonsToPanel(list_ElementsEleventhRow.get(i), subPanel_EleventhRow, columns[i], Row.FIRST);
            }

            GridPane subPanel_TwelthRow = new GridPane();
            list_GridPanes.add(subPanel_TwelthRow);

            List<Control> list_ElementsTwelthRow = new ArrayList<>();

            list_ElementsTwelthRow.add(btn_ThreeSpaces );
            list_ElementsTwelthRow.add(btn_Zero);
            list_ElementsTwelthRow.add(btn_Comma);

            for (int i = 0; i < list_ElementsTwelthRow.size(); i++) {
                addButtonsToPanel(list_ElementsTwelthRow.get(i), subPanel_TwelthRow, columns[i], Row.FIRST);
            }

            for (int i = 0; i < list_GridPanes.size(); i++) {
                addSubPanelToRoot(list_GridPanes.get(i), root, Column.FIRST, rows[i]);
            }

            Scene scene = new Scene(root, Dimension.CONVERTION_WINDOW.getWidth(), Dimension.CONVERTION_WINDOW.getHeight());
            stage.setScene(scene);

            //stage.show();
        });
    }
}