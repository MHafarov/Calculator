package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ArithmeticWindow extends Window{
    public ArithmeticWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

            this.stage.setTitle("Calculator");
            GridPane root = new GridPane();
            root.setPadding(new Insets(10,10,10,10));
            root.setHgap(5);
            root.setVgap(5);

            MenuBar menuBar = new MenuBar();

            Menu mType = new Menu("Calculator");
            Menu mTheme = new Menu("Theme");
            Menu mLanguage = new Menu("Language");
            Menu mSound = new Menu("Sound");
            Button btnUndo = new Button("Undo");
            Button btnRedo = new Button("Redo");





            CheckMenuItem cMITrigonometricWindow = new CheckMenuItem("Trigonometric");
            CheckMenuItem cMIConvertionWindow = new CheckMenuItem("Convertion");

           // Image newImage = MyImageUtils.getImage("/org/o7planning/javafx/icon/new-16.png");
           // newItem.setGraphic(new ImageView(newImage));
            SeparatorMenuItem separator= new SeparatorMenuItem();
            MenuItem exitItem = new MenuItem("Exit");

            RadioMenuItem rMIThemeClassic = new RadioMenuItem("Classic");
            RadioMenuItem rMIThemeDark = new RadioMenuItem("Dark");
            RadioMenuItem rMIThemeAnimated = new RadioMenuItem("Animated");

            ToggleGroup groupTheme = new ToggleGroup();
            rMIThemeClassic.setToggleGroup(groupTheme);
            rMIThemeDark.setToggleGroup(groupTheme);
            rMIThemeAnimated.setToggleGroup(groupTheme);

            // CheckMenuItem

            RadioMenuItem rMILanguageEnglish = new RadioMenuItem("English");
            RadioMenuItem rMILanguageUkranian = new RadioMenuItem("Українська");
            RadioMenuItem rMILanguageRussian = new RadioMenuItem("Русский");

            ToggleGroup groupLanguage = new ToggleGroup();
            rMILanguageEnglish.setToggleGroup(groupLanguage);
            rMILanguageUkranian.setToggleGroup(groupLanguage);
            rMILanguageRussian.setToggleGroup(groupLanguage);

            //Image buildImage = MyImageUtils.getImage("/org/o7planning/javafx/icon/build-16.png");
            //buildItem.setGraphic(new ImageView(buildImage));
            rMILanguageEnglish.setSelected(true);

            // RadioMenuItem
            RadioMenuItem rMISoundOff = new RadioMenuItem("Sound off");
            RadioMenuItem rMISoundOn = new RadioMenuItem("Sound on");

            ToggleGroup group = new ToggleGroup();
            rMISoundOff.setToggleGroup(group);
            rMISoundOn.setToggleGroup(group);
            rMISoundOff.setSelected(true);

            // Add menuItems to the Menus
            mType.getItems().addAll(cMITrigonometricWindow, cMIConvertionWindow,separator, exitItem);
            mTheme.getItems().addAll(rMIThemeClassic, rMIThemeDark, rMIThemeAnimated);
            mLanguage.getItems().addAll(rMILanguageEnglish, rMILanguageUkranian, rMILanguageRussian);
            mSound.getItems().addAll(rMISoundOff,rMISoundOn);

            // Add Menus to the MenuBar
            menuBar.getMenus().addAll(mType, mTheme, mLanguage, mSound);







            TextField displayField = new TextField();
            displayField.setText("0");

            ToggleGroup toggleGroupLeft = new ToggleGroup();
            ToggleGroup toggleGroupRight = new ToggleGroup();

            RadioButton rBtnUp = new RadioButton("⮤");
            RadioButton rBtnFiveDivFour = new RadioButton("5/4");
            RadioButton rBtntDown = new RadioButton("⮧");

            RadioButton rBtnA = new RadioButton("A");
            RadioButton rBtnZero = new RadioButton("0");
            RadioButton rBtnTwo = new RadioButton("2");
            RadioButton rBtnThree = new RadioButton("3");
            RadioButton rBtnFour = new RadioButton("4");
            RadioButton rBtnF = new RadioButton("F");

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
            Label noRounding = new Label("No rounding");

            Button btnMC = new Button("MC");
            Button btnMR = new Button("MR");
            Button btnMPlus = new Button("M+");
            Button btnMMinus = new Button("M-");
            Button btnMS = new Button("MS");
            Button btnM = new Button("M");
            Button btnPercent = new Button("%");
            Button btnSqrt = new Button("√");
            Button btnXSquared = new Button("X²");
            Button btnOneDivX = new Button("1/X");
            Button btnCE = new Button("CE");
            Button btnC = new Button("C");
            Button btnBackspace = new Button("←");
            Button btnDiv = new Button("÷");
            Button btn7 = new Button("7");
            Button btn8 = new Button("8");
            Button btn9 = new Button("9");
            Button btnMult = new Button("╳");
            Button btn4 = new Button("4");
            Button btn5 = new Button("5");
            Button btn6 = new Button("6");
            Button btnMinus = new Button("-");
            Button btn1 = new Button("1");
            Button btn2 = new Button("2");
            Button btn3 = new Button("3");
            Button btnPlus = new Button("+");
            Button btnPlusMinus = new Button("±");
            Button btn0 = new Button("0");
            Button btnComma = new Button(",");
            Button btnEquals = new Button("=");


            GridPane.setConstraints(menuBar, 0,0);

            GridPane.setConstraints(displayField, 0,1);

            GridPane.setConstraints(rBtnUp, 0,2);
            GridPane.setConstraints(rBtnFiveDivFour, 1,2);
            GridPane.setConstraints(rBtntDown, 2,2);

            GridPane.setConstraints(rBtnA, 3,2);
            GridPane.setConstraints(rBtnZero, 4,2);
            GridPane.setConstraints(rBtnTwo, 5,2);
            GridPane.setConstraints(rBtnThree, 6,2);
            GridPane.setConstraints(rBtnFour, 7,2);
            GridPane.setConstraints(rBtnF, 8,2);

            GridPane.setConstraints(mathematicalRounding, 0,3);
            GridPane.setConstraints(noRounding, 1,3);

            GridPane.setConstraints(btnMC, 0,4);
            GridPane.setConstraints(btnMR, 1,4 );
            GridPane.setConstraints(btnMPlus, 2,4);
            GridPane.setConstraints(btnMMinus, 3,4);
            GridPane.setConstraints(btnMS, 4,4);
            GridPane.setConstraints(btnM, 5,4);
            GridPane.setConstraints(btnPercent, 0,5);
            GridPane.setConstraints(btnSqrt, 1,5);
            GridPane.setConstraints(btnXSquared, 2,5);
            GridPane.setConstraints(btnOneDivX, 3,5);
            GridPane.setConstraints(btnCE, 0,6);
            GridPane.setConstraints(btnC, 1,6);
            GridPane.setConstraints(btnBackspace, 2,6);
            GridPane.setConstraints(btnDiv, 3,6);
            GridPane.setConstraints(btn7, 0,7);
            GridPane.setConstraints(btn8, 1,7);
            GridPane.setConstraints(btn9, 2,7);
            GridPane.setConstraints(btnMult, 3,7);
            GridPane.setConstraints(btn4, 0,8);
            GridPane.setConstraints(btn5, 1,8);
            GridPane.setConstraints(btn6, 2,8);
            GridPane.setConstraints(btnMinus, 3,8);
            GridPane.setConstraints(btn1, 0,9);
            GridPane.setConstraints(btn2, 1,9);
            GridPane.setConstraints(btn3, 2,9);
            GridPane.setConstraints(btnPlus, 3,9);
            GridPane.setConstraints(btnPlusMinus, 0,10);
            GridPane.setConstraints(btn0, 1,10);
            GridPane.setConstraints(btnComma, 2,10);
            GridPane.setConstraints(btnEquals, 3,10);



            root.getChildren().add(menuBar);

            root.getChildren().add(displayField);

            root.getChildren().addAll(rBtnUp,rBtnFiveDivFour,rBtntDown);
            root.getChildren().addAll(rBtnA, rBtnZero, rBtnTwo, rBtnThree, rBtnFour, rBtnF);

            root.getChildren().add(mathematicalRounding);
            root.getChildren().add(noRounding);

            root.getChildren().add(btnMC);
            root.getChildren().add(btnMR);
            root.getChildren().add(btnMPlus);
            root.getChildren().add(btnMMinus);
            root.getChildren().add(btnMS);
            root.getChildren().add(btnM);
            root.getChildren().add(btnPercent);
            root.getChildren().add(btnSqrt);
            root.getChildren().add(btnXSquared);
            root.getChildren().add(btnOneDivX);
            root.getChildren().add(btnCE);
            root.getChildren().add(btnC);
            root.getChildren().add(btnBackspace);
            root.getChildren().add(btnDiv);
            root.getChildren().add(btn7);
            root.getChildren().add(btn8);
            root.getChildren().add(btn9);
            root.getChildren().add(btnMult);
            root.getChildren().add(btn4);
            root.getChildren().add(btn5);
            root.getChildren().add(btn6);
            root.getChildren().add(btnMinus);
            root.getChildren().add(btn1);
            root.getChildren().add(btn2);
            root.getChildren().add(btn3);
            root.getChildren().add(btnPlus);
            root.getChildren().add(btnPlusMinus);
            root.getChildren().add(btn0);
            root.getChildren().add(btnComma);
            root.getChildren().add(btnEquals);

            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);


            stage.show();
        });
    }
}
