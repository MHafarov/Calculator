package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.Column;
import com.app.calculator.constants.Row;
import com.app.calculator.constants.Size;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticWindow extends Window{
    public ArithmeticWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

            this.stage.setTitle("Calculator");
            GridPane root = new GridPane();

            root.setPadding(new Insets(Size.TEN_PIXELS.getNumber(),Size.TEN_PIXELS.getNumber(),
                                       Size.TEN_PIXELS.getNumber(),Size.TEN_PIXELS.getNumber()));
            root.setHgap(Size.FIVE_PIXELS.getNumber());
            root.setVgap(Size.FIVE_PIXELS.getNumber());

            Column[] columns = Column.values();
            Row[] rows = Row.values();

            List<GridPane> listGridPanes = new ArrayList<>();
            List<Label> listElementsThirdRowTop = new ArrayList<>();
            List<Control> listElementsThirdRowDown = new ArrayList<>();
            List<Control> listElementsFourthRow = new ArrayList<>();
            List<Control> listElementsFifthRow = new ArrayList<>();
            List<Control> listElementsSixthRow = new ArrayList<>();
            List<Control> listElementsSeventhRow  = new ArrayList<>();
            List<Control> listElementsEighthRow  = new ArrayList<>();
            List<Control> listElementsNinthRow = new ArrayList<>();
            List<Control> listElementsTenthRow = new ArrayList<>();


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

            Button btnUndo = new Button();
            stretchMenuButton(btnUndo);
            addImageToButton(btnUndo, "/images/undo.png");
            subPanelFirstRow.add(btnUndo,Column.SECOND.getNumber(), Row.FIRST.getNumber());

            Button btnRedo = new Button();
            stretchMenuButton(btnRedo);
            addImageToButton(btnRedo, "/images/redo.png");
            subPanelFirstRow.add(btnRedo,Column.THIRD.getNumber(),Row.FIRST.getNumber());

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

            TextField displayField = new TextField();
            displayField.setStyle("-fx-alignment: center-right;");
            displayField.setText("0");
            GridPane.setHgrow(displayField, Priority.ALWAYS);
            GridPane.setVgrow(displayField, Priority.ALWAYS);
            subPanelSecondRow.add(displayField, Column.FIRST.getNumber(), Row.FIRST.getNumber());

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

            listElementsThirdRowTop.add(emptyLabel1);
            listElementsThirdRowTop.add(lUp);
            listElementsThirdRowTop.add(lFiveDivFour);
            listElementsThirdRowTop.add(lDown);
            listElementsThirdRowTop.add(emptyLabel6);
            listElementsThirdRowTop.add(emptyLabel7);
            listElementsThirdRowTop.add(lA);
            listElementsThirdRowTop.add(lZero);
            listElementsThirdRowTop.add(lTwo);
            listElementsThirdRowTop.add(lThree);
            listElementsThirdRowTop.add(lFour);
            listElementsThirdRowTop.add(lF);
            listElementsThirdRowTop.add(emptyLabel8);

            for (int i = 0; i < listElementsThirdRowTop.size(); i++) {
                addElementToPanel(listElementsThirdRowTop.get(i), subPanelThirdRow, columns[i], Row.FIRST);
                listElementsThirdRowTop.get(i).setAlignment(Pos.CENTER);
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

            listElementsThirdRowDown.add(emptyLabel9);
            listElementsThirdRowDown.add(rBtnUp);
            listElementsThirdRowDown.add(rBtnFiveDivFour);
            listElementsThirdRowDown.add(rBtntDown);
            listElementsThirdRowDown.add(emptyLabel14);
            listElementsThirdRowDown.add(emptyLabel15);
            listElementsThirdRowDown.add(rBtnA);
            listElementsThirdRowDown.add(rBtnZero);
            listElementsThirdRowDown.add(rBtnTwo);
            listElementsThirdRowDown.add(rBtnThree);
            listElementsThirdRowDown.add(rBtnFour);
            listElementsThirdRowDown.add(rBtnF);
            listElementsThirdRowDown.add(emptyLabel16);

            for (int i = 0; i < listElementsThirdRowDown.size(); i++) {
                addElementToPanel(listElementsThirdRowDown.get(i), subPanelThirdRow, columns[i], Row.SECOND);
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

            subPanelThirdRow.add(lMathematicalRounding,0,2, 5, 2);
            lMathematicalRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(lMathematicalRounding, Priority.ALWAYS);
            GridPane.setVgrow(lMathematicalRounding, Priority.ALWAYS);
            subPanelThirdRow.setHalignment(lMathematicalRounding, HPos.CENTER);
            subPanelThirdRow.setValignment(lMathematicalRounding, VPos.CENTER);

            Label lNoRounding = new Label("No rounding");

            subPanelThirdRow.add(lNoRounding,5,2,14,2);
            lNoRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(lNoRounding, Priority.ALWAYS);
            GridPane.setVgrow(lNoRounding, Priority.ALWAYS);
            subPanelThirdRow.setHalignment(lNoRounding, HPos.CENTER);
            subPanelThirdRow.setValignment(lNoRounding, VPos.CENTER);


            Button btnMC = new Button("MC");
            Button btnMR = new Button("MR");
            Button btnMPlus = new Button("M+");
            Button btnMMinus = new Button("M-");
            Button btnMS = new Button("MS");
            Button btnM = new Button("M");

            listElementsFourthRow.add(btnMC);
            listElementsFourthRow.add(btnMR);
            listElementsFourthRow.add(btnMPlus);
            listElementsFourthRow.add(btnMMinus);
            listElementsFourthRow.add(btnMS );
            listElementsFourthRow.add(btnM);

            for (int i = 0; i < listElementsFourthRow.size(); i++) {
                addButtonsToPanel(listElementsFourthRow.get(i), subPanelFourthRow, columns[i], Row.FIRST);
            }


            Button btnPercent = new Button("%");
            Button btnSqrt = new Button("√");
            Button btnXSquared = new Button("X²");
            Button btnOneDivX = new Button("1/X");

            listElementsFifthRow.add(btnPercent);
            listElementsFifthRow.add(btnSqrt);
            listElementsFifthRow.add(btnXSquared);
            listElementsFifthRow.add(btnOneDivX);

            for (int i = 0; i < listElementsFifthRow.size(); i++) {
                addButtonsToPanel(listElementsFifthRow.get(i), subPanelFifthRow, columns[i], Row.FIRST);
            }


            Button btnCE = new Button("CE");
            Button btnC = new Button("C");
            Button btnBackspace = new Button("←");
            Button btnDiv = new Button("÷");

            listElementsSixthRow.add(btnCE);
            listElementsSixthRow.add(btnC);
            listElementsSixthRow.add(btnBackspace);
            listElementsSixthRow.add(btnDiv);

            for (int i = 0; i < listElementsSixthRow.size(); i++) {
                addButtonsToPanel(listElementsSixthRow.get(i), subPanelSixthRow, columns[i], Row.FIRST);
            }


            Button btn7 = new Button("7");
            Button btn8 = new Button("8");
            Button btn9 = new Button("9");
            Button btnMult = new Button("╳");

            listElementsSeventhRow.add(btn7);
            listElementsSeventhRow.add(btn8);
            listElementsSeventhRow.add(btn9);
            listElementsSeventhRow.add(btnMult);

            for (int i = 0; i < listElementsSeventhRow.size(); i++) {
                addButtonsToPanel(listElementsSeventhRow.get(i), subPanelSeventhRow, columns[i], Row.FIRST);
            }


            Button btn4 = new Button("4");
            Button btn5 = new Button("5");
            Button btn6 = new Button("6");
            Button btnMinus = new Button("-");

            listElementsEighthRow.add(btn4);
            listElementsEighthRow.add(btn5);
            listElementsEighthRow.add(btn6);
            listElementsEighthRow.add(btnMinus);

            for (int i = 0; i < listElementsEighthRow.size(); i++) {
                addButtonsToPanel(listElementsEighthRow.get(i), subPanelEighthRow, columns[i], Row.FIRST);
            }


            Button btn1 = new Button("1");
            Button btn2 = new Button("2");
            Button btn3 = new Button("3");
            Button btnPlus = new Button("+");

            listElementsNinthRow.add(btn1);
            listElementsNinthRow.add(btn2);
            listElementsNinthRow.add(btn3);
            listElementsNinthRow.add(btnPlus);

            for (int i = 0; i < listElementsNinthRow.size(); i++) {
                addButtonsToPanel(listElementsNinthRow.get(i), subPanelNinthRow, columns[i], Row.FIRST);
            }

            Button btnPlusMinus = new Button("±");
            Button btn0 = new Button("0");
            Button btnComma = new Button(",");
            Button btnEquals = new Button("=");

            listElementsTenthRow.add(btnPlusMinus);
            listElementsTenthRow.add(btn0);
            listElementsTenthRow.add(btnComma);
            listElementsTenthRow.add(btnEquals);

            for (int i = 0; i < listElementsTenthRow.size(); i++) {
                addButtonsToPanel(listElementsTenthRow.get(i), subPanelTenthRow, columns[i], Row.FIRST);
            }


            Scene scene = new Scene(root, 300, 300);
            stage.setScene(scene);

            stage.show();

        });
    }

    public void addSubPanelToRoot(GridPane subPanel, GridPane root, Column column, Row row) {
        root.add(subPanel, column.getNumber(), row.getNumber());
        stretchElement(subPanel, root);
    }

    public void addElementToPanel(Control control, GridPane gridPane, Column column, Row row) {
        gridPane.add(control, column.getNumber(),row.getNumber());
        stretchElement(control, gridPane);
        control.setMaxWidth(Double.MAX_VALUE);
        control.setMaxHeight(Double.MAX_VALUE);
    }

    public void addButtonsToPanel(Control control, GridPane gridPane, Column column, Row row) {
        gridPane.add(control, column.getNumber(),row.getNumber());
        control.prefWidthProperty().bind(gridPane.widthProperty().multiply(1.0));
        stretchElement(control, gridPane);
        control.setMaxWidth(Double.MAX_VALUE);
        control.setMaxHeight(Double.MAX_VALUE);
    }

    public void stretchElement(Parent parent, GridPane gridPane) {
        GridPane.setHgrow(parent, Priority.ALWAYS);
        GridPane.setVgrow(parent, Priority.ALWAYS);
        gridPane.setHalignment(parent, HPos.CENTER);
        gridPane.setValignment(parent, VPos.CENTER);
    }
    public void stretchMenuBar(MenuBar menuBar) {
        GridPane.setHgrow(menuBar, Priority.ALWAYS);
        GridPane.setVgrow(menuBar, Priority.ALWAYS);
        menuBar.setMaxWidth(Double.MAX_VALUE);
        menuBar.setMaxHeight(Double.MAX_VALUE);
    }

    public void stretchMenuButton(Control control) {
        GridPane.setHgrow(control, Priority.ALWAYS);
        GridPane.setVgrow(control, Priority.ALWAYS);
        control.setMaxWidth(Double.MAX_VALUE);
        control.setMaxHeight(Double.MAX_VALUE);
    }
    public void addImageToButton(Button button, String imagePath) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        button.setFocusTraversable(false);
    }
    public void addImageToCheckMenuItem(CheckMenuItem checkMenu, String imagePath) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        checkMenu.setGraphic(imageView);
    }
}
