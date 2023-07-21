package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.commands.InsertDigitCommand;
import com.app.calculator.constants.Column;
import com.app.calculator.constants.Row;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

            subPanel_FirstRow.add(btn_Undo,Column.SECOND.getNumber(), Row.FIRST.getNumber());
            subPanel_FirstRow.add(btn_Redo,Column.THIRD.getNumber(),Row.FIRST.getNumber());

            subPanel_SecondRow.add(displayField, Column.FIRST.getNumber(), Row.FIRST.getNumber());

            list_ElementsThirdRowTop.add(label_Space);
            list_ElementsThirdRowTop.add(label_Up);
            list_ElementsThirdRowTop.add(label_FiveDivFour);
            list_ElementsThirdRowTop.add(label_Down);
            list_ElementsThirdRowTop.add(label_Space);
            list_ElementsThirdRowTop.add(label_Space);
            list_ElementsThirdRowTop.add(label_A);
            list_ElementsThirdRowTop.add(label_Zero);
            list_ElementsThirdRowTop.add(label_Two);
            list_ElementsThirdRowTop.add(label_Three);
            list_ElementsThirdRowTop.add(label_Four);
            list_ElementsThirdRowTop.add(label_F);
            list_ElementsThirdRowTop.add(label_Space);

            for (int i = 0; i < list_ElementsThirdRowTop.size(); i++) {
                addElementToPanel(list_ElementsThirdRowTop.get(i), subPanel_ThirdRow, columns[i], Row.FIRST);
                list_ElementsThirdRowTop.get(i).setAlignment(Pos.CENTER);
            }

            label_Space.setAlignment(Pos.CENTER);
            rBtn_Up.setAlignment(Pos.CENTER);
            rBtn_FiveDivFour.setAlignment(Pos.CENTER);
            rBtn_Down.setAlignment(Pos.CENTER);
            rBtn_A.setAlignment(Pos.CENTER);
            rBtn_Zero.setAlignment(Pos.CENTER);
            rBtn_Two.setAlignment(Pos.CENTER);
            rBtn_Three.setAlignment(Pos.CENTER);
            rBtn_Four.setAlignment(Pos.CENTER);
            rBtn_F.setAlignment(Pos.CENTER);

            list_ElementsThirdRowDown.add(label_Space);
            list_ElementsThirdRowDown.add(rBtn_Up);
            list_ElementsThirdRowDown.add(rBtn_FiveDivFour);
            list_ElementsThirdRowDown.add(rBtn_Down);
            list_ElementsThirdRowDown.add(label_Space);
            list_ElementsThirdRowDown.add(label_Space);
            list_ElementsThirdRowDown.add(rBtn_A);
            list_ElementsThirdRowDown.add(rBtn_Zero);
            list_ElementsThirdRowDown.add(rBtn_Two);
            list_ElementsThirdRowDown.add(rBtn_Three);
            list_ElementsThirdRowDown.add(rBtn_Four);
            list_ElementsThirdRowDown.add(rBtn_F);
            list_ElementsThirdRowDown.add(label_Space);

            for (int i = 0; i < list_ElementsThirdRowDown.size(); i++) {
                addElementToPanel(list_ElementsThirdRowDown.get(i), subPanel_ThirdRow, columns[i], Row.SECOND);
            }

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

            subPanel_ThirdRow.add(label_MathematicalRounding,0,2, 5, 2);
            label_MathematicalRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(label_MathematicalRounding, Priority.ALWAYS);
            GridPane.setVgrow(label_MathematicalRounding, Priority.ALWAYS);
            subPanel_ThirdRow.setHalignment(label_MathematicalRounding, HPos.CENTER);
            subPanel_ThirdRow.setValignment(label_MathematicalRounding, VPos.CENTER);

            Label label_NoRounding = new Label("No rounding");

            subPanel_ThirdRow.add(label_NoRounding,5,2,14,2);
            label_NoRounding.setAlignment(Pos.CENTER);
            GridPane.setHgrow(label_NoRounding, Priority.ALWAYS);
            GridPane.setVgrow(label_NoRounding, Priority.ALWAYS);
            subPanel_ThirdRow.setHalignment(label_NoRounding, HPos.CENTER);
            subPanel_ThirdRow.setValignment(label_NoRounding, VPos.CENTER);


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


            Button btn_Percent = new Button("%");
            Button btn_Sqrt = new Button("√");
            Button btn_XSquared = new Button("X²");
            Button btn_OneDivX = new Button("1/X");

            list_ElementsFifthRow.add(btn_Percent);
            list_ElementsFifthRow.add(btn_Sqrt);
            list_ElementsFifthRow.add(btn_XSquared);
            list_ElementsFifthRow.add(btn_OneDivX);

            for (int i = 0; i < list_ElementsFifthRow.size(); i++) {
                addButtonsToPanel(list_ElementsFifthRow.get(i), subPanel_FifthRow, columns[i], Row.FIRST);
            }


            Button btn_CE = new Button("CE");
            Button btn_C = new Button("C");
            Button btn_Backspace = new Button("←");
            Button btn_Div = new Button("÷");

            list_ElementsSixthRow.add(btn_CE);
            list_ElementsSixthRow.add(btn_C);
            list_ElementsSixthRow.add(btn_Backspace);
            list_ElementsSixthRow.add(btn_Div);

            for (int i = 0; i < list_ElementsSixthRow.size(); i++) {
                addButtonsToPanel(list_ElementsSixthRow.get(i), subPanel_SixthRow, columns[i], Row.FIRST);
            }


            Button btn_Seven = new Button("7");
            Button btn_Eight = new Button("8");
            Button btn_Nine = new Button("9");
            Button btn_Mult = new Button("╳");

            list_ElementsSeventhRow.add(btn_Seven);
            list_ElementsSeventhRow.add(btn_Eight);
            list_ElementsSeventhRow.add(btn_Nine);
            list_ElementsSeventhRow.add(btn_Mult);

            for (int i = 0; i < list_ElementsSeventhRow.size(); i++) {
                addButtonsToPanel(list_ElementsSeventhRow.get(i), subPanel_SeventhRow, columns[i], Row.FIRST);
            }


            Button btn_Four = new Button("4");
            Button btn_Five = new Button("5");
            Button btn_Six = new Button("6");
            Button btn_Minus = new Button("-");

            list_ElementsEighthRow.add(btn_Four);
            list_ElementsEighthRow.add(btn_Five);
            list_ElementsEighthRow.add(btn_Six);
            list_ElementsEighthRow.add(btn_Minus);

            for (int i = 0; i < list_ElementsEighthRow.size(); i++) {
                addButtonsToPanel(list_ElementsEighthRow.get(i), subPanel_EighthRow, columns[i], Row.FIRST);
            }


            Button btn_One = new Button("1");
            Button btn_Two = new Button("2");
            Button btn_Three = new Button("3");
            Button btn_Plus = new Button("+");

            btn_One.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new InsertDigitCommand(ArithmeticWindow.this, event));
                }
            });


            list_ElementsNinthRow.add(btn_One);
            list_ElementsNinthRow.add(btn_Two);
            list_ElementsNinthRow.add(btn_Three);
            list_ElementsNinthRow.add(btn_Plus);

            for (int i = 0; i < list_ElementsNinthRow.size(); i++) {
                addButtonsToPanel(list_ElementsNinthRow.get(i), subPanel_NinthRow, columns[i], Row.FIRST);
            }

            Button btn_PlusMinus = new Button("±");
            Button btn_Zero = new Button("0");
            Button btn_Comma = new Button(",");
            Button btn_Equals = new Button("=");

            list_ElementsTenthRow.add(btn_PlusMinus);
            list_ElementsTenthRow.add(btn_Zero);
            list_ElementsTenthRow.add(btn_Comma);
            list_ElementsTenthRow.add(btn_Equals);

            for (int i = 0; i < list_ElementsTenthRow.size(); i++) {
                addButtonsToPanel(list_ElementsTenthRow.get(i), subPanel_TenthRow, columns[i], Row.FIRST);
            }


            Scene scene = new Scene(root, 300, 300);
            stage.setScene(scene);

            stage.show();

        });
    }
}
