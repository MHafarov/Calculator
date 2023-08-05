package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.commands.*;
import com.app.calculator.constants.Column;
import com.app.calculator.constants.Dimension;
import com.app.calculator.constants.Position;
import com.app.calculator.constants.Row;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class ArithmeticWindow extends Window{

    public ArithmeticWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

            this.stage.setTitle("Calculator");
            this.stage.setX(Position.ARITHMETIC_WINDOW.getHorizontal());
            this.stage.setY(Position.ARITHMETIC_WINDOW.getVertical());


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


            Button btn_Percent = new Button("%");
            Button btn_Sqrt = new Button("√");
            Button btn_XSquared = new Button("X²");
            Button btn_OneDivX = new Button("1/X");

            btn_Percent.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new PercentCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Sqrt.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new OneDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_XSquared.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new OneDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_OneDivX.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new OneDigitCommand(ArithmeticWindow.this, event));
                }
            });

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

            btn_CE.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new CAndCECommand(ArithmeticWindow.this, event));
                }
            });
            btn_C.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new CAndCECommand(ArithmeticWindow.this, event));
                }
            });
            btn_Backspace.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new EditDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Div.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new TwoDigitsCommand(ArithmeticWindow.this, event));
                }
            });

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

            btn_Seven.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new InsertDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Eight.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new InsertDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Nine.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new InsertDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Mult.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new TwoDigitsCommand(ArithmeticWindow.this, event));
                }
            });


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

            btn_Four.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new InsertDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Five.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new InsertDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Six.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new InsertDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Minus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new TwoDigitsCommand(ArithmeticWindow.this, event));
                }
            });



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

            btn_Two.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new InsertDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Three.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new InsertDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Plus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new TwoDigitsCommand(ArithmeticWindow.this, event));
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

            btn_PlusMinus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new EditDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Zero.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new InsertDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Comma.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new EditDigitCommand(ArithmeticWindow.this, event));
                }
            });
            btn_Equals.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    executeCommand(new EqualCommand(ArithmeticWindow.this, event));
                }
            });


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
