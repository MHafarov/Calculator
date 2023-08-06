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

            list_ElementsFourthRow.add(btn_MC);
            list_ElementsFourthRow.add(btn_MR);
            list_ElementsFourthRow.add(btn_MPlus);
            list_ElementsFourthRow.add(btn_MMinus);
            list_ElementsFourthRow.add(btn_MS );
            list_ElementsFourthRow.add(btn_M);

            for (int i = 0; i < list_ElementsFourthRow.size(); i++) {
                addButtonsToPanel(list_ElementsFourthRow.get(i), subPanel_FourthRow, columns[i], Row.FIRST);
            }

            list_ElementsFifthRow.add(btn_XToThePowerOfY);
            list_ElementsFifthRow.add(btn_Sin);
            list_ElementsFifthRow.add(btn_Cos);
            list_ElementsFifthRow.add(btn_Tan);
            list_ElementsFifthRow.add(btn_Log);

            for (int i = 0; i < list_ElementsFifthRow.size(); i++) {
                addButtonsToPanel(list_ElementsFifthRow.get(i), subPanel_FifthRow, columns[i], Row.FIRST);
            }

            list_ElementsSixthRow.add(btn_XToThePowerOf1divY);
            list_ElementsSixthRow.add(btn_SineToThePowerOfNegativeOne);
            list_ElementsSixthRow.add(btn_CosToThePowerOfNegativeOne);
            list_ElementsSixthRow.add(btn_TanToThePowerOfNegativeOne);
            list_ElementsSixthRow.add(btn_Ln);

            for (int i = 0; i < list_ElementsSixthRow.size(); i++) {
                addButtonsToPanel(list_ElementsSixthRow.get(i), subPanel_SixthRow, columns[i], Row.FIRST);
            }

            list_ElementsSeventhRow.add(btn_Ex);
            list_ElementsSeventhRow.add(btn_Percent);
            list_ElementsSeventhRow.add(btn_Sqrt);
            list_ElementsSeventhRow.add(btn_XSquared);
            list_ElementsSeventhRow.add(btn_OneDivX);

            for (int i = 0; i < list_ElementsSeventhRow.size(); i++) {
                addButtonsToPanel(list_ElementsSeventhRow.get(i), subPanel_SeventhRow, columns[i], Row.FIRST);
            }

            list_ElementsEighthRow.add(btn_X3);
            list_ElementsEighthRow.add(btn_CE);
            list_ElementsEighthRow.add(btn_C);
            list_ElementsEighthRow.add(btn_Backspace);
            list_ElementsEighthRow.add(btn_Div);

            for (int i = 0; i < list_ElementsEighthRow.size(); i++) {
                addButtonsToPanel(list_ElementsEighthRow.get(i), subPanel_EighthRow, columns[i], Row.FIRST);
            }

            list_ElementsNinthRow.add(btn_Exp);
            list_ElementsNinthRow.add(btn_Seven);
            list_ElementsNinthRow.add(btn_Eight);
            list_ElementsNinthRow.add(btn_Nine);
            list_ElementsNinthRow.add(btn_Mult);

            for (int i = 0; i < list_ElementsNinthRow.size(); i++) {
                addButtonsToPanel(list_ElementsNinthRow.get(i), subPanel_NinthRow, columns[i], Row.FIRST);
            }

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

            list_ElementsEleventhRow.add(btn_Pi);
            list_ElementsEleventhRow.add(btn_One);
            list_ElementsEleventhRow.add(btn_Two);
            list_ElementsEleventhRow.add(btn_Three);
            list_ElementsEleventhRow.add(btn_Plus);

            for (int i = 0; i < list_ElementsEleventhRow.size(); i++) {
                addButtonsToPanel(list_ElementsEleventhRow.get(i), subPanel_EleventhRow, columns[i], Row.FIRST);
            }

            GridPane subPanel_TwelthRow = new GridPane();

            list_GridPanes.add(subPanel_TwelthRow);
            List<Control> list_ElementsTwelthRow = new ArrayList<>();

            list_ElementsTwelthRow = new ArrayList<>();

            list_ElementsTwelthRow.add(btn_Factorial);
            list_ElementsTwelthRow.add(btn_PlusMinus);
            list_ElementsTwelthRow.add(btn_Zero);
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