package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.Column;
import com.app.calculator.constants.Element;
import com.app.calculator.constants.Row;
import com.app.calculator.constants.Size;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
            GridPane root = new GridPane();

            root.setPadding(new Insets(Size.TEN_PIXELS.getNumber(),Size.TEN_PIXELS.getNumber(),
                    Size.TEN_PIXELS.getNumber(),Size.TEN_PIXELS.getNumber()));
            root.setHgap(Size.FIVE_PIXELS.getNumber());
            root.setVgap(Size.FIVE_PIXELS.getNumber());

            Column[] columns = Column.values();
            Row[] rows = Row.values();

            List<GridPane> listGridPanes = new ArrayList<>();
            List<Label> listElementsSeventhRowTop = new ArrayList<>();
            List<Control> listElementsSeventhRowDown = new ArrayList<>();
            List<Control> listElementsEighthRow = new ArrayList<>();
            List<Control> listElementsNinthRow  = new ArrayList<>();
            List<Control> listElementsTenthRow  = new ArrayList<>();
            List<Control> listElementsEleventhRow = new ArrayList<>();
            List<Control> listElementsTwelthRow = new ArrayList<>();


            GridPane subPanelFirstRow = new GridPane();
            GridPane subPanelSecondRow = new GridPane();
            GridPane subPanelThirdRow = new GridPane();
            GridPane subPanelFourthRow = new GridPane();
            GridPane subPanelFifthRow = new GridPane();
            GridPane subPanelSixthRow = new GridPane();
            GridPane subPanelSeventhRow = new GridPane();
            GridPane subPanelEighthRow = new GridPane();
            GridPane subPanelNinthRow = new GridPane();
            GridPane subPanelTenthRow = new GridPane();
            GridPane subPanelEleventhRow = new GridPane();
            GridPane subPanelTwelthRow = new GridPane();

            listGridPanes.add(subPanelFirstRow);
            listGridPanes.add(subPanelSecondRow);
            listGridPanes.add(subPanelThirdRow);
            listGridPanes.add(subPanelFourthRow);
            listGridPanes.add(subPanelFifthRow);
            listGridPanes.add(subPanelSixthRow);
            listGridPanes.add(subPanelSeventhRow);
            listGridPanes.add(subPanelEighthRow);
            listGridPanes.add(subPanelNinthRow);
            listGridPanes.add(subPanelTenthRow);
            listGridPanes.add(subPanelEleventhRow);
            listGridPanes.add(subPanelTwelthRow);

            for (int i = 0; i < listGridPanes.size(); i++) {
                addSubPanelToRoot(listGridPanes.get(i), root, Column.FIRST, rows[i]);
            }

            MenuBar menuBar = new MenuBar();
            stretchMenuBar(menuBar);

            Menu mType = new Menu("Calculator");
            Menu mTheme = new Menu("Theme");
            Menu mLanguage = new Menu("Language");
            Menu mSound = new Menu("Sound");

            menuBar.getMenus().addAll(mType, mTheme, mLanguage, mSound);
            subPanelFirstRow.add(menuBar,Column.FIRST.getNumber(), Row.FIRST.getNumber());

            CheckMenuItem cMITrigonometricWindow = new CheckMenuItem("Trigonometric");
            addImageToCheckMenuItem(cMITrigonometricWindow, "/images/function.png");

            CheckMenuItem cMIConvertionWindow = new CheckMenuItem("Convertion");
            addImageToCheckMenuItem(cMIConvertionWindow, "/images/scales.png");

            SeparatorMenuItem sMISeparatorExit= new SeparatorMenuItem();
            MenuItem mIExit = new MenuItem("Exit");

            mType.getItems().addAll(cMITrigonometricWindow, cMIConvertionWindow,sMISeparatorExit, mIExit);

            RadioMenuItem rMIThemeClassic = new RadioMenuItem("Classic");
            RadioMenuItem rMIThemeDark = new RadioMenuItem("Dark");
            RadioMenuItem rMIThemeAnimated = new RadioMenuItem("Animated");
            ToggleGroup groupTheme = new ToggleGroup();
            rMIThemeClassic.setToggleGroup(groupTheme);
            rMIThemeDark.setToggleGroup(groupTheme);
            rMIThemeAnimated.setToggleGroup(groupTheme);
            mTheme.getItems().addAll(rMIThemeClassic, rMIThemeDark, rMIThemeAnimated);

            RadioMenuItem rMILanguageEnglish = new RadioMenuItem("English");
            RadioMenuItem rMILanguageUkranian = new RadioMenuItem("Українська");
            RadioMenuItem rMILanguageRussian = new RadioMenuItem("Русский");
            ToggleGroup groupLanguage = new ToggleGroup();
            rMILanguageEnglish.setToggleGroup(groupLanguage);
            rMILanguageUkranian.setToggleGroup(groupLanguage);
            rMILanguageRussian.setToggleGroup(groupLanguage);
            rMILanguageEnglish.setSelected(true);
            mLanguage.getItems().addAll(rMILanguageEnglish, rMILanguageUkranian, rMILanguageRussian);

            RadioMenuItem rMISoundOff = new RadioMenuItem("Sound off");
            RadioMenuItem rMISoundOn = new RadioMenuItem("Sound on");
            ToggleGroup group = new ToggleGroup();
            rMISoundOff.setToggleGroup(group);
            rMISoundOn.setToggleGroup(group);
            rMISoundOff.setSelected(true);
            mSound.getItems().addAll(rMISoundOff,rMISoundOn);


            ComboBox<String> cBCategory = new ComboBox<String>();
            ObservableList<String> listCategory = FXCollections.observableArrayList();
            listCategory.add("Volume");
            listCategory.add("Length");
            listCategory.add("Weight and mass");
            cBCategory.setItems(listCategory);
            cBCategory.getSelectionModel().select(Element.FIRST.getNumber());
            Label lSelectCategory = new Label("Select Category: ");
            subPanelSecondRow.getChildren().add(lSelectCategory);
            GridPane.setConstraints(lSelectCategory, Column.FIRST.getNumber(), Row.FIRST.getNumber());
            subPanelSecondRow.getChildren().add(cBCategory);
            GridPane.setConstraints(cBCategory, Column.SECOND.getNumber(), Row.FIRST.getNumber());

            TextField DisplayFieldIn = new TextField();
            DisplayFieldIn.setStyle("-fx-alignment: center-left;");
            DisplayFieldIn.setText("0");
            GridPane.setHgrow(DisplayFieldIn, Priority.ALWAYS);
            GridPane.setVgrow(DisplayFieldIn, Priority.ALWAYS);
            subPanelThirdRow.add(DisplayFieldIn, Column.FIRST.getNumber(), Row.FIRST.getNumber());

            ComboBox<String> cBUnitOfMeasurementIn = new ComboBox<String>();
            ObservableList<String> listUnitsOfMeasurementIn = FXCollections.observableArrayList();
            listUnitsOfMeasurementIn.add("Meter");
            listUnitsOfMeasurementIn.add("Santimeter");
            listUnitsOfMeasurementIn.add("Kilometer");
            cBUnitOfMeasurementIn.setItems(listUnitsOfMeasurementIn);
            cBUnitOfMeasurementIn.getSelectionModel().select(Element.FIRST.getNumber());
            subPanelFourthRow.getChildren().add(cBUnitOfMeasurementIn);
            GridPane.setConstraints(cBUnitOfMeasurementIn, Column.SECOND.getNumber(), Row.FIRST.getNumber());

            TextField DisplayFieldOut = new TextField();
            DisplayFieldOut.setStyle("-fx-alignment: center-left;");
            DisplayFieldOut.setText("0");
            GridPane.setHgrow(DisplayFieldOut, Priority.ALWAYS);
            GridPane.setVgrow(DisplayFieldOut, Priority.ALWAYS);
            subPanelFifthRow.add(DisplayFieldOut, Column.FIRST.getNumber(), Row.FIRST.getNumber());

            ComboBox<String> cBUnitOfMeasurementOut = new ComboBox<String>();
            ObservableList<String> listUnitsOfMeasurementOut = FXCollections.observableArrayList();
            listUnitsOfMeasurementOut.add("Meter");
            listUnitsOfMeasurementOut.add("Santimeter");
            listUnitsOfMeasurementOut.add("Kilometer");
            cBUnitOfMeasurementOut.setItems(listUnitsOfMeasurementOut);
            cBUnitOfMeasurementOut.getSelectionModel().select(Element.FIRST.getNumber());
            subPanelSixthRow.getChildren().add(cBUnitOfMeasurementOut);
            GridPane.setConstraints(cBUnitOfMeasurementOut, Column.SECOND.getNumber(), Row.FIRST.getNumber());

            Label emptyLabel1 = new Label(" ");
            Label lUp = new Label("⮤");
            Label lFiveDivFour = new Label("5/4");
            Label lDown  = new Label("⮧");
            Label emptyLabel6 = new Label(" ");
            Label emptyLabel7 = new Label(" ");
            Label lA  = new Label("A");
            Label lZero  = new Label("0");
            Label lTwo  = new Label("2");
            Label lThree  = new Label("3");
            Label lFour  = new Label("4");
            Label lF   = new Label("F");
            Label emptyLabel8 = new Label(" ");

            listElementsSeventhRowTop.add(emptyLabel1);
            listElementsSeventhRowTop.add(lUp);
            listElementsSeventhRowTop.add(lFiveDivFour);
            listElementsSeventhRowTop.add(lDown);
            listElementsSeventhRowTop.add(emptyLabel6);
            listElementsSeventhRowTop.add(emptyLabel7);
            listElementsSeventhRowTop.add(lA);
            listElementsSeventhRowTop.add(lZero);
            listElementsSeventhRowTop.add(lTwo);
            listElementsSeventhRowTop.add(lThree);
            listElementsSeventhRowTop.add(lFour);
            listElementsSeventhRowTop.add(lF);
            listElementsSeventhRowTop.add(emptyLabel8);

            for (int i = 0; i < listElementsSeventhRowTop.size(); i++) {
                addElementToPanel(listElementsSeventhRowTop.get(i), subPanelSeventhRow, columns[i], Row.FIRST);
                listElementsSeventhRowTop.get(i).setAlignment(Pos.CENTER);
            }

            Label emptyLabel9 = new Label(" ");
            RadioButton rBtnUp = new RadioButton();
            RadioButton rBtnFiveDivFour = new RadioButton();
            RadioButton rBtntDown = new RadioButton();
            Label emptyLabel14 = new Label(" ");
            Label emptyLabel15 = new Label(" ");
            RadioButton rBtnA = new RadioButton();
            RadioButton rBtnZero = new RadioButton();
            RadioButton rBtnTwo = new RadioButton();
            RadioButton rBtnThree = new RadioButton();
            RadioButton rBtnFour = new RadioButton();
            RadioButton rBtnF = new RadioButton();
            Label emptyLabel16 = new Label(" ");

            emptyLabel9.setAlignment(Pos.CENTER);
            rBtnUp.setAlignment(Pos.CENTER);
            rBtnFiveDivFour.setAlignment(Pos.CENTER);
            rBtntDown.setAlignment(Pos.CENTER);
            emptyLabel14.setAlignment(Pos.CENTER);
            emptyLabel15.setAlignment(Pos.CENTER);
            rBtnA.setAlignment(Pos.CENTER);
            rBtnZero.setAlignment(Pos.CENTER);
            rBtnTwo.setAlignment(Pos.CENTER);
            rBtnThree.setAlignment(Pos.CENTER);
            rBtnFour.setAlignment(Pos.CENTER);
            rBtnF.setAlignment(Pos.CENTER);
            emptyLabel16.setAlignment(Pos.CENTER);

            listElementsSeventhRowDown.add(emptyLabel9);
            listElementsSeventhRowDown.add(rBtnUp);
            listElementsSeventhRowDown.add(rBtnFiveDivFour);
            listElementsSeventhRowDown.add(rBtntDown);
            listElementsSeventhRowDown.add(emptyLabel14);
            listElementsSeventhRowDown.add(emptyLabel15);
            listElementsSeventhRowDown.add(rBtnA);
            listElementsSeventhRowDown.add(rBtnZero);
            listElementsSeventhRowDown.add(rBtnTwo);
            listElementsSeventhRowDown.add(rBtnThree);
            listElementsSeventhRowDown.add(rBtnFour);
            listElementsSeventhRowDown.add(rBtnF);
            listElementsSeventhRowDown.add(emptyLabel16);

            for (int i = 0; i < listElementsSeventhRowDown.size(); i++) {
                addElementToPanel(listElementsSeventhRowDown.get(i), subPanelSeventhRow, columns[i], Row.SECOND);
            }

            ToggleGroup toggleGroupLeft = new ToggleGroup();
            ToggleGroup toggleGroupRight = new ToggleGroup();

            rBtnUp.setToggleGroup(toggleGroupLeft);
            rBtnFiveDivFour.setToggleGroup(toggleGroupLeft);
            rBtntDown.setToggleGroup(toggleGroupLeft);
            rBtnUp.setSelected(true);

            rBtnA.setToggleGroup(toggleGroupRight);
            rBtnZero.setToggleGroup(toggleGroupRight);
            rBtnTwo.setToggleGroup(toggleGroupRight);
            rBtnThree.setToggleGroup(toggleGroupRight);
            rBtnFour.setToggleGroup(toggleGroupRight);
            rBtnF.setToggleGroup(toggleGroupRight);
            rBtnA.setSelected(true);

            Label lMathematicalRounding = new Label("Mathematical rounding");

            subPanelSeventhRow.add(lMathematicalRounding,0,2, 5, 2);
            lMathematicalRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(lMathematicalRounding, Priority.ALWAYS);
            GridPane.setVgrow(lMathematicalRounding, Priority.ALWAYS);
            subPanelSeventhRow.setHalignment(lMathematicalRounding, HPos.CENTER);
            subPanelSeventhRow.setValignment(lMathematicalRounding, VPos.CENTER);

            Label lNoRounding = new Label("No rounding");

            subPanelSeventhRow.add(lNoRounding,5,2,14,2);
            lNoRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(lNoRounding, Priority.ALWAYS);
            GridPane.setVgrow(lNoRounding, Priority.ALWAYS);
            subPanelSeventhRow.setHalignment(lNoRounding, HPos.CENTER);
            subPanelSeventhRow.setValignment(lNoRounding, VPos.CENTER);



            Button emptyButton = new Button("   ");
            emptyButton.setVisible(false);
            Button btnCE = new Button("CE");
            Button btnBackspace = new Button("←");

            listElementsEighthRow.add(emptyButton);
            listElementsEighthRow.add(btnCE);
            listElementsEighthRow.add(btnBackspace);

            for (int i = 0; i < listElementsEighthRow.size(); i++) {
                addButtonsToPanel(listElementsEighthRow.get(i), subPanelEighthRow, columns[i], Row.FIRST);
            }

            Button btn7 = new Button("7");
            Button btn8 = new Button("8");
            Button btn9 = new Button("9");

            listElementsNinthRow.add(btn7);
            listElementsNinthRow.add(btn8);
            listElementsNinthRow.add(btn9);

            for (int i = 0; i < listElementsNinthRow.size(); i++) {
                addButtonsToPanel(listElementsNinthRow.get(i), subPanelNinthRow, columns[i], Row.FIRST);
            }

            Button btn4 = new Button("4");
            Button btn5 = new Button("5");
            Button btn6 = new Button("6");

            listElementsTenthRow.add(btn4);
            listElementsTenthRow.add(btn5);
            listElementsTenthRow.add(btn6);

            for (int i = 0; i < listElementsTenthRow.size(); i++) {
                addButtonsToPanel(listElementsTenthRow.get(i), subPanelTenthRow, columns[i], Row.FIRST);
            }


            Button btn1 = new Button("1");
            Button btn2 = new Button("2");
            Button btn3 = new Button("3");

            listElementsEleventhRow.add(btn1);
            listElementsEleventhRow.add(btn2);
            listElementsEleventhRow.add(btn3);

            for (int i = 0; i < listElementsEleventhRow.size(); i++) {
                addButtonsToPanel(listElementsEleventhRow.get(i), subPanelEleventhRow, columns[i], Row.FIRST);
            }

            Button emptyButton2 = new Button("   ");
            emptyButton2.setVisible(false);
            Button btn0 = new Button("0");
            Button btnComma = new Button(",");

            listElementsTwelthRow.add(emptyButton2);
            listElementsTwelthRow.add(btn0);
            listElementsTwelthRow.add(btnComma);

            for (int i = 0; i < listElementsTwelthRow.size(); i++) {
                addButtonsToPanel(listElementsTwelthRow.get(i), subPanelTwelthRow, columns[i], Row.FIRST);
            }


            Scene scene = new Scene(root, 300, 300);
            stage.setScene(scene);

            stage.show();
        });
    }
}