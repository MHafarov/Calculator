package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.Column;
import com.app.calculator.constants.Row;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.Priority;

public class ArithmeticWindow extends Window{
    public ArithmeticWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

            this.stage.setTitle("Calculator");
            GridPane root = new GridPane();
            GridPane.setHgrow(root, Priority.ALWAYS);
            GridPane.setVgrow(root, Priority.ALWAYS);

            root.setPadding(new Insets(10,10,10,10));
            root.setHgap(5);
            root.setVgap(5);

            GridPane subPanelFirstRow = new GridPane();
            addSubPanelToRoot(subPanelFirstRow, root, Column.FIRST, Row.FIRST);

            GridPane subPanelSecondRow = new GridPane();
            addSubPanelToRoot(subPanelSecondRow, root, Column.FIRST, Row.SECOND);

            GridPane subPanelThirdRow = new GridPane();
            addSubPanelToRoot(subPanelThirdRow, root, Column.FIRST, Row.THIRD);

            GridPane subPanelFourthRow = new GridPane();
            addSubPanelToRoot(subPanelFourthRow, root, Column.FIRST, Row.FOURTH);

            GridPane subPanelFifthRow = new GridPane();
            addSubPanelToRoot(subPanelFifthRow, root, Column.FIRST, Row.FIFTH);

            GridPane subPanelSixthRow = new GridPane();
            addSubPanelToRoot(subPanelSixthRow, root, Column.FIRST, Row.SIXTH);

            GridPane subPanelSeventhRow = new GridPane();
            addSubPanelToRoot(subPanelSeventhRow, root, Column.FIRST, Row.SEVENTH);

            GridPane subPanelEighthRow = new GridPane();
            addSubPanelToRoot(subPanelEighthRow, root, Column.FIRST, Row.EIGHTH);

            GridPane subPanelNinthRow = new GridPane();
            addSubPanelToRoot(subPanelNinthRow, root, Column.FIRST, Row.NINTH);

            GridPane subPanelTenthRow = new GridPane();
            addSubPanelToRoot(subPanelTenthRow, root, Column.FIRST, Row.TENTH);

            MenuBar menuBar = new MenuBar();
            menuBar.setMaxWidth(Double.MAX_VALUE);
            menuBar.setMaxHeight(Double.MAX_VALUE);
            GridPane.setHgrow(menuBar, Priority.ALWAYS);
            GridPane.setVgrow(menuBar, Priority.ALWAYS);

            Menu mType = new Menu("Calculator");
            Menu mTheme = new Menu("Theme");
            Menu mLanguage = new Menu("Language");
            Menu mSound = new Menu("Sound");

            Button btnUndo = new Button();
            Image iUndo = new Image("/images/undo.png");
            ImageView iVUndo = new ImageView(iUndo);
            btnUndo.setGraphic(iVUndo);
            btnUndo.setFocusTraversable(false);
            btnUndo.setMaxWidth(Double.MAX_VALUE);
            btnUndo.setMaxHeight(Double.MAX_VALUE);
            GridPane.setHgrow(btnUndo, Priority.ALWAYS);
            GridPane.setVgrow(btnUndo, Priority.ALWAYS);


            Button btnRedo = new Button();
            Image iRedo = new Image("/images/redo.png");
            ImageView iVRedo = new ImageView(iRedo);
            btnRedo.setGraphic(iVRedo);
            btnRedo.setFocusTraversable(false);
            btnRedo.setMaxWidth(Double.MAX_VALUE);
            btnRedo.setMaxHeight(Double.MAX_VALUE);
            GridPane.setHgrow(btnRedo, Priority.ALWAYS);
            GridPane.setVgrow(btnRedo, Priority.ALWAYS);



            CheckMenuItem cMITrigonometricWindow = new CheckMenuItem("Trigonometric");
            CheckMenuItem cMIConvertionWindow = new CheckMenuItem("Convertion");
            Image imageCMITrigonometricWindow = new Image("/images/function.png");
            Image imageCMIConvertionWindow = new Image("/images/scales.png");
            ImageView iVCMITrigonometricWindow = new ImageView(imageCMITrigonometricWindow);
            ImageView iVCMIConvertionWindow = new ImageView(imageCMIConvertionWindow);
            iVCMITrigonometricWindow.setFitWidth(20);
            iVCMITrigonometricWindow.setFitHeight(20);
            iVCMIConvertionWindow.setFitWidth(20);
            iVCMIConvertionWindow.setFitHeight(20);
            cMITrigonometricWindow.setGraphic(iVCMITrigonometricWindow);
            cMIConvertionWindow.setGraphic(iVCMIConvertionWindow);
            SeparatorMenuItem sMISeparatorExit= new SeparatorMenuItem();
            MenuItem mIExit = new MenuItem("Exit");

            RadioMenuItem rMIThemeClassic = new RadioMenuItem("Classic");
            RadioMenuItem rMIThemeDark = new RadioMenuItem("Dark");
            RadioMenuItem rMIThemeAnimated = new RadioMenuItem("Animated");
            ToggleGroup groupTheme = new ToggleGroup();
            rMIThemeClassic.setToggleGroup(groupTheme);
            rMIThemeDark.setToggleGroup(groupTheme);
            rMIThemeAnimated.setToggleGroup(groupTheme);

            RadioMenuItem rMILanguageEnglish = new RadioMenuItem("English");
            RadioMenuItem rMILanguageUkranian = new RadioMenuItem("Українська");
            RadioMenuItem rMILanguageRussian = new RadioMenuItem("Русский");
            ToggleGroup groupLanguage = new ToggleGroup();
            rMILanguageEnglish.setToggleGroup(groupLanguage);
            rMILanguageUkranian.setToggleGroup(groupLanguage);
            rMILanguageRussian.setToggleGroup(groupLanguage);
            rMILanguageEnglish.setSelected(true);


            RadioMenuItem rMISoundOff = new RadioMenuItem("Sound off");
            RadioMenuItem rMISoundOn = new RadioMenuItem("Sound on");
            ToggleGroup group = new ToggleGroup();
            rMISoundOff.setToggleGroup(group);
            rMISoundOn.setToggleGroup(group);
            rMISoundOff.setSelected(true);

            mType.getItems().addAll(cMITrigonometricWindow, cMIConvertionWindow,sMISeparatorExit, mIExit);
            mTheme.getItems().addAll(rMIThemeClassic, rMIThemeDark, rMIThemeAnimated);
            mLanguage.getItems().addAll(rMILanguageEnglish, rMILanguageUkranian, rMILanguageRussian);
            mSound.getItems().addAll(rMISoundOff,rMISoundOn);
            menuBar.getMenus().addAll(mType, mTheme, mLanguage, mSound);
            subPanelFirstRow.add(menuBar,0,0);
            subPanelFirstRow.add(btnUndo,1,0);
            subPanelFirstRow.add(btnRedo,2,0);


            TextField displayField = new TextField();
            displayField.setStyle("-fx-alignment: center-right;");
            displayField.setText("0");
            GridPane.setHgrow(displayField, Priority.ALWAYS);
            GridPane.setVgrow(displayField, Priority.ALWAYS);

            subPanelSecondRow.add(displayField, 0,0);


            Label emptyLabel1 = new Label(" ");
            addLabelToPanel(emptyLabel1, subPanelThirdRow, Column.FIRST, Row.FIRST);


            subPanelThirdRow.setHalignment(emptyLabel1, HPos.CENTER);
            subPanelThirdRow.setValignment(emptyLabel1, VPos.CENTER);

            Label lUp = new Label("⮤");
            addLabelToPanel(lUp, subPanelThirdRow, Column.SECOND, Row.FIRST);

            Label lFiveDivFour = new Label("5/4");
            addLabelToPanel(lFiveDivFour, subPanelThirdRow, Column.THIRD, Row.FIRST);

            Label lDown  = new Label("⮧");
            addLabelToPanel(lDown, subPanelThirdRow, Column.FOURTH, Row.FIRST);

            Label emptyLabel6 = new Label(" ");
            addLabelToPanel(emptyLabel6, subPanelThirdRow, Column.FIFTH, Row.FIRST);

            Label emptyLabel7 = new Label(" ");
            addLabelToPanel(emptyLabel7, subPanelThirdRow, Column.SIXTH, Row.FIRST);

            Label lA  = new Label("A");
            addLabelToPanel(lA, subPanelThirdRow, Column.SEVENTH, Row.FIRST);

            Label lZero  = new Label("0");
            addLabelToPanel(lZero, subPanelThirdRow, Column.EIGHTH, Row.FIRST);

            Label lTwo  = new Label("2");
            addLabelToPanel(lTwo, subPanelThirdRow, Column.NINTH, Row.FIRST);

            Label lThree  = new Label("3");
            addLabelToPanel(lThree, subPanelThirdRow, Column.TENTH, Row.FIRST);

            Label lFour  = new Label("4");
            addLabelToPanel(lFour, subPanelThirdRow, Column.ELEVENTH, Row.FIRST);

            Label lF   = new Label("F");
            addLabelToPanel(lF, subPanelThirdRow, Column.TWELFTH, Row.FIRST);

            Label emptyLabel8 = new Label(" ");
            addLabelToPanel(emptyLabel8, subPanelThirdRow, Column.THIRTEENTH, Row.FIRST);

            ToggleGroup toggleGroupLeft = new ToggleGroup();
            ToggleGroup toggleGroupRight = new ToggleGroup();

            Label emptyLabel9 = new Label(" ");
            addLabelToPanel(emptyLabel9, subPanelThirdRow, Column.FIRST, Row.SECOND);

            RadioButton rBtnUp = new RadioButton();
            addRadioButtonToPanel(rBtnUp , subPanelThirdRow, Column.SECOND, Row.SECOND);

            RadioButton rBtnFiveDivFour = new RadioButton();
            addRadioButtonToPanel(rBtnFiveDivFour, subPanelThirdRow, Column.THIRD, Row.SECOND);

            RadioButton rBtntDown = new RadioButton();
            addRadioButtonToPanel(rBtntDown, subPanelThirdRow, Column.FOURTH, Row.SECOND);

            Label emptyLabel14 = new Label(" ");
            addLabelToPanel(emptyLabel14, subPanelThirdRow, Column.FIFTH, Row.SECOND);

            Label emptyLabel15 = new Label(" ");
            addLabelToPanel(emptyLabel15, subPanelThirdRow, Column.SIXTH, Row.SECOND);

            RadioButton rBtnA = new RadioButton();
            addRadioButtonToPanel(rBtnA, subPanelThirdRow, Column.SEVENTH, Row.SECOND);

            RadioButton rBtnZero = new RadioButton();
            addRadioButtonToPanel(rBtnZero, subPanelThirdRow, Column.EIGHTH, Row.SECOND);

            RadioButton rBtnTwo = new RadioButton();
            addRadioButtonToPanel(rBtnTwo, subPanelThirdRow, Column.NINTH, Row.SECOND);

            RadioButton rBtnThree = new RadioButton();
            addRadioButtonToPanel(rBtnThree, subPanelThirdRow, Column.TENTH, Row.SECOND);

            RadioButton rBtnFour = new RadioButton();
            addRadioButtonToPanel(rBtnFour, subPanelThirdRow, Column.ELEVENTH, Row.SECOND);

            RadioButton rBtnF = new RadioButton();
            addRadioButtonToPanel(rBtnF, subPanelThirdRow, Column.TWELFTH, Row.SECOND);

            Label emptyLabel16 = new Label(" ");
            addLabelToPanel(emptyLabel16, subPanelThirdRow, Column.THIRTEENTH, Row.SECOND);

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

            Label mathematicalRounding = new Label("Mathematical rounding");
            mathematicalRounding.setStyle("-fx-background-color: red;");
            mathematicalRounding.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
            subPanelThirdRow.add(mathematicalRounding,0,2, 5, 2);
            mathematicalRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(mathematicalRounding, Priority.ALWAYS);
            GridPane.setVgrow(mathematicalRounding, Priority.ALWAYS);
            subPanelThirdRow.setHalignment(mathematicalRounding, HPos.CENTER);
            subPanelThirdRow.setValignment(mathematicalRounding, VPos.CENTER);

            Label noRounding = new Label("No rounding");
            noRounding.setStyle("-fx-background-color: red;");
            noRounding.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
            subPanelThirdRow.add(noRounding,5,2,14,2);
            noRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(noRounding, Priority.ALWAYS);
            GridPane.setVgrow(noRounding, Priority.ALWAYS);
            subPanelThirdRow.setHalignment(noRounding, HPos.CENTER);
            subPanelThirdRow.setValignment(noRounding, VPos.CENTER);

            Button btnMC = new Button("MC");
            addButtonToPanel(btnMC, subPanelFourthRow, Column.FIRST, Row.FIRST);
            Button btnMR = new Button("MR");
            addButtonToPanel(btnMR, subPanelFourthRow, Column.SECOND, Row.FIRST);
            Button btnMPlus = new Button("M+");
            addButtonToPanel(btnMPlus, subPanelFourthRow, Column.THIRD, Row.FIRST);
            Button btnMMinus = new Button("M-");
            addButtonToPanel(btnMMinus, subPanelFourthRow, Column.FOURTH, Row.FIRST);
            Button btnMS = new Button("MS");
            addButtonToPanel(btnMS, subPanelFourthRow, Column.FIFTH, Row.FIRST);
            Button btnM = new Button("M");
            addButtonToPanel(btnM, subPanelFourthRow, Column.SIXTH, Row.FIRST);

            ColumnConstraints cCMFirst = new ColumnConstraints();
            cCMFirst.setPercentWidth(16.67);
            ColumnConstraints cCMSecond = new ColumnConstraints();
            cCMSecond.setPercentWidth(16.67);
            ColumnConstraints cCMThird = new ColumnConstraints();
            cCMThird.setPercentWidth(16.67);
            ColumnConstraints cCMFourth = new ColumnConstraints();
            cCMFourth.setPercentWidth(16.67);
            ColumnConstraints cCMFives = new ColumnConstraints();
            cCMFives.setPercentWidth(16.67);
            ColumnConstraints cCMSixth = new ColumnConstraints();
            cCMSixth.setPercentWidth(16.67);
            subPanelFourthRow.getColumnConstraints().addAll(cCMFirst, cCMSecond, cCMThird, cCMFourth, cCMFives, cCMSixth);

            Button btnPercent = new Button("%");
            addButtonToPanel(btnPercent, subPanelFifthRow, Column.FIRST, Row.FIRST);
            Button btnSqrt = new Button("√");
            addButtonToPanel(btnSqrt, subPanelFifthRow, Column.SECOND, Row.FIRST);
            Button btnXSquared = new Button("X²");
            addButtonToPanel(btnXSquared, subPanelFifthRow, Column.THIRD, Row.FIRST);
            Button btnOneDivX = new Button("1/X");
            addButtonToPanel(btnOneDivX, subPanelFifthRow, Column.FOURTH, Row.FIRST);


            Button btnCE = new Button("CE");
            addButtonToPanel(btnCE, subPanelSixthRow, Column.FIRST, Row.FIRST);
            Button btnC = new Button("C");
            addButtonToPanel(btnC, subPanelSixthRow, Column.SECOND, Row.FIRST);
            Button btnBackspace = new Button("←");
            addButtonToPanel(btnBackspace, subPanelSixthRow, Column.THIRD, Row.FIRST);
            Button btnDiv = new Button("÷");
            addButtonToPanel(btnDiv, subPanelSixthRow, Column.FOURTH, Row.FIRST);

            Button btn7 = new Button("7");
            addButtonToPanel(btn7, subPanelSeventhRow, Column.FIRST, Row.FIRST);
            Button btn8 = new Button("8");
            addButtonToPanel(btn8, subPanelSeventhRow, Column.SECOND, Row.FIRST);
            Button btn9 = new Button("9");
            addButtonToPanel(btn9, subPanelSeventhRow, Column.THIRD, Row.FIRST);
            Button btnMult = new Button("╳");
            addButtonToPanel(btnMult, subPanelSeventhRow, Column.FOURTH, Row.FIRST);

            Button btn4 = new Button("4");
            addButtonToPanel(btn4, subPanelEighthRow, Column.FIRST, Row.FIRST);
            Button btn5 = new Button("5");
            addButtonToPanel(btn5, subPanelEighthRow, Column.SECOND, Row.FIRST);
            Button btn6 = new Button("6");
            addButtonToPanel(btn6, subPanelEighthRow, Column.THIRD, Row.FIRST);
            Button btnMinus = new Button("-");
            addButtonToPanel(btnMinus, subPanelEighthRow, Column.FOURTH, Row.FIRST);

            Button btn1 = new Button("1");
            addButtonToPanel(btn1, subPanelNinthRow, Column.FIRST, Row.FIRST);
            Button btn2 = new Button("2");
            addButtonToPanel(btn2, subPanelNinthRow, Column.SECOND, Row.FIRST);
            Button btn3 = new Button("3");
            addButtonToPanel(btn3, subPanelNinthRow, Column.THIRD, Row.FIRST);
            Button btnPlus = new Button("+");
            addButtonToPanel(btnPlus, subPanelNinthRow, Column.FOURTH, Row.FIRST);

            Button btnPlusMinus = new Button("±");
            addButtonToPanel(btnPlusMinus, subPanelTenthRow, Column.FIRST, Row.FIRST);
            Button btn0 = new Button("0");
            addButtonToPanel(btn0, subPanelTenthRow, Column.SECOND, Row.FIRST);
            Button btnComma = new Button(",");
            addButtonToPanel(btnComma, subPanelTenthRow, Column.THIRD, Row.FIRST);
            Button btnEquals = new Button("=");
            addButtonToPanel(btnEquals, subPanelTenthRow, Column.FOURTH, Row.FIRST);

            Scene scene = new Scene(root, 300, 300);
            stage.setScene(scene);

            stage.show();

        });
    }

    public void addSubPanelToRoot(GridPane subPanel, GridPane root, Column column, Row row) {
        root.add(subPanel, column.getNumber(), row.getNumber());
        GridPane.setHgrow(subPanel, Priority.ALWAYS);
        GridPane.setVgrow(subPanel, Priority.ALWAYS);
    }

    public void addButtonToPanel(Button button, GridPane gridPane, Column column, Row row) {
        gridPane.add(button, column.getNumber(),row.getNumber());
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(button, Priority.ALWAYS);
        GridPane.setVgrow(button, Priority.ALWAYS);
    }

    public void addLabelToPanel(Label label, GridPane gridPane, Column column, Row row) {
        gridPane.add(label, column.getNumber(),row.getNumber());
        GridPane.setHgrow(label, Priority.ALWAYS);
        GridPane.setVgrow(label, Priority.ALWAYS);
        label.setAlignment(Pos.CENTER);
        gridPane.setHalignment(label, HPos.CENTER);
        gridPane.setValignment(label, VPos.CENTER);
    }
    public void addRadioButtonToPanel(RadioButton radioButton, GridPane gridPane, Column column, Row row) {
        gridPane.add(radioButton,column.getNumber(),row.getNumber());
        GridPane.setHgrow(radioButton, Priority.ALWAYS);
        GridPane.setVgrow(radioButton, Priority.ALWAYS);
        gridPane.setHalignment(radioButton, HPos.CENTER);
        gridPane.setValignment(radioButton, VPos.CENTER);
    }
}
