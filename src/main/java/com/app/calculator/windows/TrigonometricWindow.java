package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.Column;
import com.app.calculator.constants.Row;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class TrigonometricWindow extends Window{
    public TrigonometricWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

            this.stage.setTitle("Trigonometric");

            GridPane subPanelEleventhRow = new GridPane();
            GridPane subPanelTwelthRow = new GridPane();

            list_GridPanes.add(subPanelEleventhRow);
            list_GridPanes.add(subPanelTwelthRow);

            Button btnUndo = new Button();
            stretchMenuButton(btnUndo);
            addImageToButton(btnUndo, "/images/undo.png");
            subPanel_FirstRow.add(btnUndo,Column.SECOND.getNumber(), Row.FIRST.getNumber());

            Button btnRedo = new Button();
            stretchMenuButton(btnRedo);
            addImageToButton(btnRedo, "/images/redo.png");
            subPanel_FirstRow.add(btnRedo,Column.THIRD.getNumber(),Row.FIRST.getNumber());

            displayField = new TextField();
            displayField.setStyle("-fx-alignment: center-right;");
            displayField.setText("0");
            GridPane.setHgrow(displayField, Priority.ALWAYS);
            GridPane.setVgrow(displayField, Priority.ALWAYS);
            subPanel_SecondRow.add(displayField, Column.FIRST.getNumber(), Row.FIRST.getNumber());

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

            list_ElementsThirdRowTop.add(emptyLabel1);
            list_ElementsThirdRowTop.add(lUp);
            list_ElementsThirdRowTop.add(lFiveDivFour);
            list_ElementsThirdRowTop.add(lDown);
            list_ElementsThirdRowTop.add(emptyLabel6);
            list_ElementsThirdRowTop.add(emptyLabel7);
            list_ElementsThirdRowTop.add(lA);
            list_ElementsThirdRowTop.add(lZero);
            list_ElementsThirdRowTop.add(lTwo);
            list_ElementsThirdRowTop.add(lThree);
            list_ElementsThirdRowTop.add(lFour);
            list_ElementsThirdRowTop.add(lF);
            list_ElementsThirdRowTop.add(emptyLabel8);

            for (int i = 0; i < list_ElementsThirdRowTop.size(); i++) {
                addElementToPanel(list_ElementsThirdRowTop.get(i), subPanel_ThirdRow, columns[i], Row.FIRST);
                list_ElementsThirdRowTop.get(i).setAlignment(Pos.CENTER);
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

            list_ElementsThirdRowDown.add(emptyLabel9);
            list_ElementsThirdRowDown.add(rBtnUp);
            list_ElementsThirdRowDown.add(rBtnFiveDivFour);
            list_ElementsThirdRowDown.add(rBtntDown);
            list_ElementsThirdRowDown.add(emptyLabel14);
            list_ElementsThirdRowDown.add(emptyLabel15);
            list_ElementsThirdRowDown.add(rBtnA);
            list_ElementsThirdRowDown.add(rBtnZero);
            list_ElementsThirdRowDown.add(rBtnTwo);
            list_ElementsThirdRowDown.add(rBtnThree);
            list_ElementsThirdRowDown.add(rBtnFour);
            list_ElementsThirdRowDown.add(rBtnF);
            list_ElementsThirdRowDown.add(emptyLabel16);

            for (int i = 0; i < list_ElementsThirdRowDown.size(); i++) {
                addElementToPanel(list_ElementsThirdRowDown.get(i), subPanel_ThirdRow, columns[i], Row.SECOND);
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

            subPanel_ThirdRow.add(lMathematicalRounding,0,2, 5, 2);
            lMathematicalRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(lMathematicalRounding, Priority.ALWAYS);
            GridPane.setVgrow(lMathematicalRounding, Priority.ALWAYS);
            subPanel_ThirdRow.setHalignment(lMathematicalRounding, HPos.CENTER);
            subPanel_ThirdRow.setValignment(lMathematicalRounding, VPos.CENTER);

            Label lNoRounding = new Label("No rounding");

            subPanel_ThirdRow.add(lNoRounding,5,2,14,2);
            lNoRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(lNoRounding, Priority.ALWAYS);
            GridPane.setVgrow(lNoRounding, Priority.ALWAYS);
            subPanel_ThirdRow.setHalignment(lNoRounding, HPos.CENTER);
            subPanel_ThirdRow.setValignment(lNoRounding, VPos.CENTER);


            Button btnMC = new Button("MC");
            Button btnMR = new Button("MR");
            Button btnMPlus = new Button("M+");
            Button btnMMinus = new Button("M-");
            Button btnMS = new Button("MS");
            Button btnM = new Button("M");

            list_ElementsFourthRow.add(btnMC);
            list_ElementsFourthRow.add(btnMR);
            list_ElementsFourthRow.add(btnMPlus);
            list_ElementsFourthRow.add(btnMMinus);
            list_ElementsFourthRow.add(btnMS );
            list_ElementsFourthRow.add(btnM);

            for (int i = 0; i < list_ElementsFourthRow.size(); i++) {
                addButtonsToPanel(list_ElementsFourthRow.get(i), subPanel_FourthRow, columns[i], Row.FIRST);
            }

            // Fifth row
            Button btnXToThePowerOfY = new Button("x^y");
            Button btnSin = new Button("sin");
            Button btnCos = new Button("cos");
            Button btnTan = new Button("tan");
            Button btnLog = new Button("log");

            list_ElementsFifthRow.add(btnXToThePowerOfY);
            list_ElementsFifthRow.add(btnSin);
            list_ElementsFifthRow.add(btnCos);
            list_ElementsFifthRow.add(btnTan);
            list_ElementsFifthRow.add(btnLog);

            for (int i = 0; i < list_ElementsFifthRow.size(); i++) {
                addButtonsToPanel(list_ElementsFifthRow.get(i), subPanel_FifthRow, columns[i], Row.FIRST);
            }

            // Sixth row
            Button btnXToThePowerOf1divY = new Button("x^(1/y)");
            Button btnSineToThePowerOfNegativeOne = new Button("sin^(-1)");
            Button btnCosToThePowerOfNegativeOne = new Button("cos^(-1)");
            Button btnTanToThePowerOfNegativeOne = new Button("tan^(-1)");
            Button btnLn = new Button("ln");

            list_ElementsSixthRow.add(btnXToThePowerOf1divY);
            list_ElementsSixthRow.add(btnSineToThePowerOfNegativeOne);
            list_ElementsSixthRow.add(btnCosToThePowerOfNegativeOne);
            list_ElementsSixthRow.add(btnTanToThePowerOfNegativeOne);
            list_ElementsSixthRow.add(btnLn);

            for (int i = 0; i < list_ElementsSixthRow.size(); i++) {
                addButtonsToPanel(list_ElementsSixthRow.get(i), subPanel_SixthRow, columns[i], Row.FIRST);
            }


            Button btnEx = new Button("e^x");
            Button btnPercent = new Button("%");
            Button btnSqrt = new Button("√");
            Button btnXSquared = new Button("X²");
            Button btnOneDivX = new Button("1/X");

            list_ElementsSeventhRow.add(btnEx);
            list_ElementsSeventhRow.add(btnPercent);
            list_ElementsSeventhRow.add(btnSqrt);
            list_ElementsSeventhRow.add(btnXSquared);
            list_ElementsSeventhRow.add(btnOneDivX);

            for (int i = 0; i < list_ElementsSeventhRow.size(); i++) {
                addButtonsToPanel(list_ElementsSeventhRow.get(i), subPanel_SeventhRow, columns[i], Row.FIRST);
            }


            Button btnX3 = new Button("x^3");
            Button btnCE = new Button("CE");
            Button btnC = new Button("C");
            Button btnBackspace = new Button("←");
            Button btnDiv = new Button("÷");

            list_ElementsEighthRow.add(btnX3);
            list_ElementsEighthRow.add(btnCE);
            list_ElementsEighthRow.add(btnC);
            list_ElementsEighthRow.add(btnBackspace);
            list_ElementsEighthRow.add(btnDiv);

            for (int i = 0; i < list_ElementsEighthRow.size(); i++) {
                addButtonsToPanel(list_ElementsEighthRow.get(i), subPanel_EighthRow, columns[i], Row.FIRST);
            }


            Button btnExp = new Button("Exp");
            Button btn7 = new Button("7");
            Button btn8 = new Button("8");
            Button btn9 = new Button("9");
            Button btnMult = new Button("╳");

            list_ElementsNinthRow.add(btnExp);
            list_ElementsNinthRow.add(btn7);
            list_ElementsNinthRow.add(btn8);
            list_ElementsNinthRow.add(btn9);
            list_ElementsNinthRow.add(btnMult);

            for (int i = 0; i < list_ElementsNinthRow.size(); i++) {
                addButtonsToPanel(list_ElementsNinthRow.get(i), subPanel_NinthRow, columns[i], Row.FIRST);
            }


            Button btnMod = new Button("Mod");
            Button btn4 = new Button("4");
            Button btn5 = new Button("5");
            Button btn6 = new Button("6");
            Button btnMinus = new Button("-");

            list_ElementsTenthRow.add(btnMod);
            list_ElementsTenthRow.add(btn4);
            list_ElementsTenthRow.add(btn5);
            list_ElementsTenthRow.add(btn6);
            list_ElementsTenthRow.add(btnMinus);

            for (int i = 0; i < list_ElementsTenthRow.size(); i++) {
                addButtonsToPanel(list_ElementsTenthRow.get(i), subPanel_TenthRow, columns[i], Row.FIRST);
            }


            Button btnPi = new Button("π");
            Button btn1 = new Button("1");
            Button btn2 = new Button("2");
            Button btn3 = new Button("3");
            Button btnPlus = new Button("+");

            list_ElementsEleventhRow.add(btnPi);
            list_ElementsEleventhRow.add(btn1);
            list_ElementsEleventhRow.add(btn2);
            list_ElementsEleventhRow.add(btn3);
            list_ElementsEleventhRow.add(btnPlus);

            for (int i = 0; i < list_ElementsEleventhRow.size(); i++) {
                addButtonsToPanel(list_ElementsEleventhRow.get(i), subPanelEleventhRow, columns[i], Row.FIRST);
            }

            Button btnFactorial = new Button("n!");
            Button btnPlusMinus = new Button("±");
            Button btn0 = new Button("0");
            Button btnComma = new Button(",");
            Button btnEquals = new Button("=");

            list_ElementsTwelthRow.add(btnFactorial);
            list_ElementsTwelthRow.add(btnPlusMinus);
            list_ElementsTwelthRow.add(btn0);
            list_ElementsTwelthRow.add(btnComma);
            list_ElementsTwelthRow.add(btnEquals);

            for (int i = 0; i < list_ElementsTwelthRow.size(); i++) {
                addButtonsToPanel(list_ElementsTwelthRow.get(i), subPanelTwelthRow, columns[i], Row.FIRST);
            }

            Scene scene = new Scene(root, 300, 300);
            stage.setScene(scene);

            stage.show();
        });
    }
}