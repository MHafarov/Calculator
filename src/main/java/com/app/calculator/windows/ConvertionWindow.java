package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.*;
import javafx.application.Platform;
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
            this.stage.setX(Position.CONVERTION_WINDOW.getHorizontal());
            this.stage.setY(Position.CONVERTION_WINDOW.getVertical());

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

            ComboBox<String> combo_Box_UnitOfMeasurement_Out = new ComboBox<String>();
            ObservableList<String> oblist_UnitsOfMeasurement_Out = FXCollections.observableArrayList();
            oblist_UnitsOfMeasurement_Out.add("Meter");
            oblist_UnitsOfMeasurement_Out.add("Santimeter");
            oblist_UnitsOfMeasurement_Out.add("Kilometer");
            combo_Box_UnitOfMeasurement_Out.setItems(oblist_UnitsOfMeasurement_Out);
            combo_Box_UnitOfMeasurement_Out.getSelectionModel().select(Element.FIRST.getNumber());
            subPanel_SixthRow.getChildren().add(combo_Box_UnitOfMeasurement_Out);
            GridPane.setConstraints(combo_Box_UnitOfMeasurement_Out, Column.SECOND.getNumber(), Row.FIRST.getNumber());





//            list_ElementsSeventhRowTop.add(label_Space_10);
//            list_ElementsSeventhRowTop.add(label_Up);
//            list_ElementsSeventhRowTop.add(label_FiveDivFour);
//            list_ElementsSeventhRowTop.add(label_Down);
//            list_ElementsSeventhRowTop.add(label_Space_11);
//            list_ElementsSeventhRowTop.add(label_Space_12);
//            list_ElementsSeventhRowTop.add(label_A);
//            list_ElementsSeventhRowTop.add(label_Zero);
//            list_ElementsSeventhRowTop.add(label_Two);
//            list_ElementsSeventhRowTop.add(label_Three);
//            list_ElementsSeventhRowTop.add(label_Four);
//            list_ElementsSeventhRowTop.add(label_F);
//            list_ElementsSeventhRowTop.add(label_Space_13);

            for (int i = 0; i < list_ElementsRoundingTop.size(); i++) {
                addElementToPanel(list_ElementsRoundingTop.get(i), subPanel_SeventhRow, columns[i], Row.FIRST);
                list_ElementsRoundingTop.get(i).setAlignment(Pos.CENTER);
            }

            for (int i = 0; i < list_ElementsRoundingDown.size(); i++) {
                addElementToPanel(list_ElementsRoundingDown.get(i), subPanel_SeventhRow, columns[i], Row.SECOND);
            }


//
//            list_ElementsSeventhRowDown.add(label_Space_10);
//            list_ElementsSeventhRowDown.add(rBtn_Up);
//            list_ElementsSeventhRowDown.add(rBtn_FiveDivFour);
//            list_ElementsSeventhRowDown.add(rBtn_Down);
//            list_ElementsSeventhRowDown.add(label_Space_11);
//            list_ElementsSeventhRowDown.add(label_Space_12);
//            list_ElementsSeventhRowDown.add(rBtn_A);
//            list_ElementsSeventhRowDown.add(rBtn_Zero);
//            list_ElementsSeventhRowDown.add(rBtn_Two);
//            list_ElementsSeventhRowDown.add(rBtn_Three);
//            list_ElementsSeventhRowDown.add(rBtn_Four);
//            list_ElementsSeventhRowDown.add(rBtn_F);
//            list_ElementsSeventhRowDown.add(label_Space_13);


            ToggleGroup toggleGroup_Left = new ToggleGroup();
            ToggleGroup toggleGroup_Right = new ToggleGroup();

            rBtn_Up.setToggleGroup(toggleGroup_Left);
            rBtn_FiveDivFour.setToggleGroup(toggleGroup_Left);
            rBtn_Down.setToggleGroup(toggleGroup_Left);
            rBtn_Up.setSelected(true);

            rBtn_A.setToggleGroup(toggleGroup_Right);
            rBtn_Zero.setToggleGroup(toggleGroup_Right);
            rBtn_Two.setToggleGroup(toggleGroup_Right);
            rBtn_Three.setToggleGroup(toggleGroup_Right);
            rBtn_Four.setToggleGroup(toggleGroup_Right);
            rBtn_F.setToggleGroup(toggleGroup_Right);
            rBtn_A.setSelected(true);

            Label label_MathematicalRounding = new Label("Mathematical rounding");

            subPanel_SeventhRow.add(label_MathematicalRounding,0,2, 5, 2);
            label_MathematicalRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(label_MathematicalRounding, Priority.ALWAYS);
            GridPane.setVgrow(label_MathematicalRounding, Priority.ALWAYS);
            subPanel_SeventhRow.setHalignment(label_MathematicalRounding, HPos.CENTER);
            subPanel_SeventhRow.setValignment(label_MathematicalRounding, VPos.CENTER);

            Label label_NoRounding = new Label("No rounding");

            subPanel_SeventhRow.add(label_NoRounding,5,2,14,2);
            label_NoRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(label_NoRounding, Priority.ALWAYS);
            GridPane.setVgrow(label_NoRounding, Priority.ALWAYS);
            subPanel_SeventhRow.setHalignment(label_NoRounding, HPos.CENTER);
            subPanel_SeventhRow.setValignment(label_NoRounding, VPos.CENTER);



            Button btn_ThreeSpaces = new Button("   ");
            btn_ThreeSpaces.setVisible(false);
            Button btn_CE = new Button("CE");
            Button btn_Backspace = new Button("←");

            list_ElementsEighthRow.add(btn_ThreeSpaces);
            list_ElementsEighthRow.add(btn_CE);
            list_ElementsEighthRow.add(btn_Backspace);

            for (int i = 0; i < list_ElementsEighthRow.size(); i++) {
                addButtonsToPanel(list_ElementsEighthRow.get(i), subPanel_EighthRow, columns[i], Row.FIRST);
            }

            Button btn_Seven = new Button("7");
            Button btn_Eight = new Button("8");
            Button btn_Nine = new Button("9");

            list_ElementsNinthRow.add(btn_Seven);
            list_ElementsNinthRow.add(btn_Eight);
            list_ElementsNinthRow.add(btn_Nine);

            for (int i = 0; i < list_ElementsNinthRow.size(); i++) {
                addButtonsToPanel(list_ElementsNinthRow.get(i), subPanel_NinthRow, columns[i], Row.FIRST);
            }

            Button btn_Four = new Button("4");
            Button btn_Five = new Button("5");
            Button btn_Six = new Button("6");

            list_ElementsTenthRow.add(btn_Four);
            list_ElementsTenthRow.add(btn_Five);
            list_ElementsTenthRow.add(btn_Six);

            for (int i = 0; i < list_ElementsTenthRow.size(); i++) {
                addButtonsToPanel(list_ElementsTenthRow.get(i), subPanel_TenthRow, columns[i], Row.FIRST);
            }

            GridPane subPanel_EleventhRow = new GridPane();
            list_GridPanes.add(subPanel_EleventhRow);
            List<Control> list_ElementsEleventhRow = new ArrayList<>();

            Button btn_One = new Button("1");
            Button btn_Two = new Button("2");
            Button btn_Three = new Button("3");



            list_ElementsEleventhRow.add(btn_One);
            list_ElementsEleventhRow.add(btn_Two);
            list_ElementsEleventhRow.add(btn_Three);

            for (int i = 0; i < list_ElementsEleventhRow.size(); i++) {
                addButtonsToPanel(list_ElementsEleventhRow.get(i), subPanel_EleventhRow, columns[i], Row.FIRST);
            }

            GridPane subPanel_TwelthRow = new GridPane();
            list_GridPanes.add(subPanel_TwelthRow);

            List<Control> list_ElementsTwelthRow = new ArrayList<>();

            Button btn_Zero = new Button("0");
            Button btn_Comma = new Button(",");

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