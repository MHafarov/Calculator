package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.Column;
import com.app.calculator.constants.Dimension;
import com.app.calculator.constants.Row;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ArithmeticWindow extends Window{

    public ArithmeticWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

            stage.setTitle(text.arithmetic);

            subPanel_FirstRow.add(btn_Undo,Column.SECOND.getNumber(), Row.FIRST.getNumber());
            subPanel_FirstRow.add(btn_Redo,Column.THIRD.getNumber(),Row.FIRST.getNumber());

            subPanel_SecondRow.add(textField_ArithmeticTrigonometric, Column.FIRST.getNumber(), Row.FIRST.getNumber());

            for (int i = 0; i < list_ElementsRoundingTop.size(); i++) {
                addElementToPanel(list_ElementsRoundingTop.get(i), subPanel_ThirdRow, columns[i], Row.FIRST);
                list_ElementsRoundingTop.get(i).setAlignment(Pos.CENTER);
            }

            for (int i = 0; i < list_ElementsRoundingDown.size(); i++) {
                addElementToPanel(list_ElementsRoundingDown.get(i), subPanel_ThirdRow, columns[i], Row.SECOND);
            }

            subPanel_ThirdRow.add(label_TypeRounding,0,2, 5, 2);
            subPanel_ThirdRow.add(label_ScaleRounding,5,2,14,2);

            list_ElementsFourthRow.add(btn_MC);
            list_ElementsFourthRow.add(btn_MR);
            list_ElementsFourthRow.add(btn_MPlus);
            list_ElementsFourthRow.add(btn_MMinus);
            list_ElementsFourthRow.add(btn_MS );
            list_ElementsFourthRow.add(btn_M);

            for (int i = 0; i < list_ElementsFourthRow.size(); i++) {
                addButtonsToPanel(list_ElementsFourthRow.get(i), subPanel_FourthRow, columns[i], Row.FIRST);
            }

            list_ElementsFifthRow.add(btn_Percent);
            list_ElementsFifthRow.add(btn_Sqrt);
            list_ElementsFifthRow.add(btn_XSquared);
            list_ElementsFifthRow.add(btn_OneDivX);

            for (int i = 0; i < list_ElementsFifthRow.size(); i++) {
                addButtonsToPanel(list_ElementsFifthRow.get(i), subPanel_FifthRow, columns[i], Row.FIRST);
            }

            list_ElementsSixthRow.add(btn_CE);
            list_ElementsSixthRow.add(btn_C);
            list_ElementsSixthRow.add(btn_Backspace);
            list_ElementsSixthRow.add(btn_Div);

            for (int i = 0; i < list_ElementsSixthRow.size(); i++) {
                addButtonsToPanel(list_ElementsSixthRow.get(i), subPanel_SixthRow, columns[i], Row.FIRST);
            }

            list_ElementsSeventhRow.add(btn_Seven);
            list_ElementsSeventhRow.add(btn_Eight);
            list_ElementsSeventhRow.add(btn_Nine);
            list_ElementsSeventhRow.add(btn_Mult);

            for (int i = 0; i < list_ElementsSeventhRow.size(); i++) {
                addButtonsToPanel(list_ElementsSeventhRow.get(i), subPanel_SeventhRow, columns[i], Row.FIRST);
            }

            list_ElementsEighthRow.add(btn_Four);
            list_ElementsEighthRow.add(btn_Five);
            list_ElementsEighthRow.add(btn_Six);
            list_ElementsEighthRow.add(btn_Minus);

            for (int i = 0; i < list_ElementsEighthRow.size(); i++) {
                addButtonsToPanel(list_ElementsEighthRow.get(i), subPanel_EighthRow, columns[i], Row.FIRST);
            }

            list_ElementsNinthRow.add(btn_One);
            list_ElementsNinthRow.add(btn_Two);
            list_ElementsNinthRow.add(btn_Three);
            list_ElementsNinthRow.add(btn_Plus);

            for (int i = 0; i < list_ElementsNinthRow.size(); i++) {
                addButtonsToPanel(list_ElementsNinthRow.get(i), subPanel_NinthRow, columns[i], Row.FIRST);
            }

            list_ElementsTenthRow.add(btn_PlusMinus);
            list_ElementsTenthRow.add(btn_Zero);
            list_ElementsTenthRow.add(btn_Comma);
            list_ElementsTenthRow.add(btn_Equals);

            for (int i = 0; i < list_ElementsTenthRow.size(); i++) {
                addButtonsToPanel(list_ElementsTenthRow.get(i), subPanel_TenthRow, columns[i], Row.FIRST);
            }

            for (int i = 0; i < list_GridPanes.size(); i++) {
                addSubPanelToRoot(list_GridPanes.get(i), root, Column.FIRST, rows[i]);
            }

            Scene scene = new Scene(root, Dimension.ARITHMETIC_WINDOW.getWidth(), Dimension.ARITHMETIC_WINDOW.getHeight());
            stage.setScene(scene);

            stage.show();
        });
    }
}
