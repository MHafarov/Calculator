package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.Column;
import com.app.calculator.constants.Dimension;
import com.app.calculator.constants.Position;
import com.app.calculator.constants.Row;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TrigonometricWindow extends Window{
    public TrigonometricWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

            this.stage.setTitle("Trigonometric");
            this.stage.setX(Position.TRIGONOMETRIC_WINDOW.getHorizontal());
            this.stage.setY(Position.TRIGONOMETRIC_WINDOW.getVertical());

            subPanel_FirstRow.add(btn_Undo,Column.SECOND.getNumber(), Row.FIRST.getNumber());
            subPanel_FirstRow.add(btn_Redo,Column.THIRD.getNumber(),Row.FIRST.getNumber());

            subPanel_SecondRow.add(displayField, Column.FIRST.getNumber(), Row.FIRST.getNumber());

            for (int i = 0; i < list_ElementsRoundingTop.size(); i++) {
                addElementToPanel(list_ElementsRoundingTop.get(i), subPanel_ThirdRow, columns[i], Row.FIRST);
                list_ElementsRoundingTop.get(i).setAlignment(Pos.CENTER);
            }

            for (int i = 0; i < list_ElementsRoundingDown.size(); i++) {
                addElementToPanel(list_ElementsRoundingDown.get(i), subPanel_ThirdRow, columns[i], Row.SECOND);
            }

//            subPanel_ThirdRow.add(label_TypeRounding,0,2, 5, 2);
//            subPanel_ThirdRow.add(label_ScaleRounding,5,2,14,2);


            Button btn_MC = new Button("MC");
            Button btn_MR = new Button("MR");
            Button btn_MPlus = new Button("M+");
            Button btn_MMinus = new Button("M-");
            Button btn_MS = new Button("MS");
            Button btn_M = new Button("M");

            list_ElementsFourthRow.add(btn_MC);
            list_ElementsFourthRow.add(btn_MR);
            list_ElementsFourthRow.add(btn_MPlus);
            list_ElementsFourthRow.add(btn_MMinus);
            list_ElementsFourthRow.add(btn_MS );
            list_ElementsFourthRow.add(btn_M);

            for (int i = 0; i < list_ElementsFourthRow.size(); i++) {
                addButtonsToPanel(list_ElementsFourthRow.get(i), subPanel_FourthRow, columns[i], Row.FIRST);
            }

            // Fifth row
            Button btn_XToThePowerOfY = new Button("x^y");
            Button btn_Sin = new Button("sin");
            Button btn_Cos = new Button("cos");
            Button btn_Tan = new Button("tan");
            Button btn_Log = new Button("log");

            list_ElementsFifthRow.add(btn_XToThePowerOfY);
            list_ElementsFifthRow.add(btn_Sin);
            list_ElementsFifthRow.add(btn_Cos);
            list_ElementsFifthRow.add(btn_Tan);
            list_ElementsFifthRow.add(btn_Log);

            for (int i = 0; i < list_ElementsFifthRow.size(); i++) {
                addButtonsToPanel(list_ElementsFifthRow.get(i), subPanel_FifthRow, columns[i], Row.FIRST);
            }

            // Sixth row
            Button btn_XToThePowerOf1divY = new Button("x^(1/y)");
            Button btn_SineToThePowerOfNegativeOne = new Button("sin^(-1)");
            Button btn_CosToThePowerOfNegativeOne = new Button("cos^(-1)");
            Button btn_TanToThePowerOfNegativeOne = new Button("tan^(-1)");
            Button btn_Ln = new Button("ln");

            list_ElementsSixthRow.add(btn_XToThePowerOf1divY);
            list_ElementsSixthRow.add(btn_SineToThePowerOfNegativeOne);
            list_ElementsSixthRow.add(btn_CosToThePowerOfNegativeOne);
            list_ElementsSixthRow.add(btn_TanToThePowerOfNegativeOne);
            list_ElementsSixthRow.add(btn_Ln);

            for (int i = 0; i < list_ElementsSixthRow.size(); i++) {
                addButtonsToPanel(list_ElementsSixthRow.get(i), subPanel_SixthRow, columns[i], Row.FIRST);
            }


            Button btn_Ex = new Button("e^x");
            Button btn_Percent = new Button("%");
            Button btn_Sqrt = new Button("√");
            Button btn_XSquared = new Button("X²");
            Button btn_OneDivX = new Button("1/X");

            list_ElementsSeventhRow.add(btn_Ex);
            list_ElementsSeventhRow.add(btn_Percent);
            list_ElementsSeventhRow.add(btn_Sqrt);
            list_ElementsSeventhRow.add(btn_XSquared);
            list_ElementsSeventhRow.add(btn_OneDivX);

            for (int i = 0; i < list_ElementsSeventhRow.size(); i++) {
                addButtonsToPanel(list_ElementsSeventhRow.get(i), subPanel_SeventhRow, columns[i], Row.FIRST);
            }


            Button btn_X3 = new Button("x^3");
            Button btn_CE = new Button("CE");
            Button btn_C = new Button("C");
            Button btn_Backspace = new Button("←");
            Button btn_Div = new Button("÷");

            list_ElementsEighthRow.add(btn_X3);
            list_ElementsEighthRow.add(btn_CE);
            list_ElementsEighthRow.add(btn_C);
            list_ElementsEighthRow.add(btn_Backspace);
            list_ElementsEighthRow.add(btn_Div);

            for (int i = 0; i < list_ElementsEighthRow.size(); i++) {
                addButtonsToPanel(list_ElementsEighthRow.get(i), subPanel_EighthRow, columns[i], Row.FIRST);
            }


            Button btn_Exp = new Button("Exp");
            Button btn_Seven = new Button("7");
            Button btn_Eight = new Button("8");
            Button btn_Nine = new Button("9");
            Button btn_Mult = new Button("╳");

            list_ElementsNinthRow.add(btn_Exp);
            list_ElementsNinthRow.add(btn_Seven);
            list_ElementsNinthRow.add(btn_Eight);
            list_ElementsNinthRow.add(btn_Nine);
            list_ElementsNinthRow.add(btn_Mult);

            for (int i = 0; i < list_ElementsNinthRow.size(); i++) {
                addButtonsToPanel(list_ElementsNinthRow.get(i), subPanel_NinthRow, columns[i], Row.FIRST);
            }


            Button btn_Mod = new Button("Mod");
            Button btn_Four = new Button("4");
            Button btn_Five = new Button("5");
            Button btn_Six = new Button("6");
            Button btn_Minus = new Button("-");

            list_ElementsTenthRow.add(btn_Mod);
            list_ElementsTenthRow.add(btn_Four);
            list_ElementsTenthRow.add(btn_Five);
            list_ElementsTenthRow.add(btn_Six);
            list_ElementsTenthRow.add(btn_Minus);

            for (int i = 0; i < list_ElementsTenthRow.size(); i++) {
                addButtonsToPanel(list_ElementsTenthRow.get(i), subPanel_TenthRow, columns[i], Row.FIRST);
            }

            GridPane subPanel_EleventhRow = new GridPane();
            list_GridPanes.add(subPanel_EleventhRow);

            List<Control> list_ElementsEleventhRow = new ArrayList<>();


            Button btn_Pi = new Button("π");
            Button btn_One = new Button("1");
            Button btn_Two = new Button("2");
            Button btn_Three = new Button("3");
            Button btn_Plus = new Button("+");

            list_ElementsEleventhRow.add(btn_Pi);
            list_ElementsEleventhRow.add(btn_One);
            list_ElementsEleventhRow.add(btn_Two);
            list_ElementsEleventhRow.add(btn_Three);
            list_ElementsEleventhRow.add(btn_Plus);

            for (int i = 0; i < list_ElementsEleventhRow.size(); i++) {
                addButtonsToPanel(list_ElementsEleventhRow.get(i), subPanel_EleventhRow, columns[i], Row.FIRST);
            }

            Button btn_Factorial = new Button("n!");
            Button btn_PlusMinus = new Button("±");
            Button btn_0 = new Button("0");
            Button btn_Comma = new Button(",");
            Button btn_Equals = new Button("=");

            GridPane subPanel_TwelthRow = new GridPane();

            list_GridPanes.add(subPanel_TwelthRow);
            List<Control> list_ElementsTwelthRow = new ArrayList<>();

            list_ElementsTwelthRow = new ArrayList<>();

            list_ElementsTwelthRow.add(btn_Factorial);
            list_ElementsTwelthRow.add(btn_PlusMinus);
            list_ElementsTwelthRow.add(btn_0);
            list_ElementsTwelthRow.add(btn_Comma);
            list_ElementsTwelthRow.add(btn_Equals);

            for (int i = 0; i < list_ElementsTwelthRow.size(); i++) {
                addButtonsToPanel(list_ElementsTwelthRow.get(i), subPanel_TwelthRow, columns[i], Row.FIRST);
            }

            for (int i = 0; i < list_GridPanes.size(); i++) {
                addSubPanelToRoot(list_GridPanes.get(i), root, Column.FIRST, rows[i]);
            }

            Scene scene = new Scene(root, Dimension.TRIGONOMETRIC_WINDOW.getWidth(), Dimension.TRIGONOMETRIC_WINDOW.getHeight());
            stage.setScene(scene);

            //stage.show();
            System.out.println("Метод show()");
        });
    }
}