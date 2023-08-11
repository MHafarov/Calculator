package com.app.calculator.abstractclasses;

import com.app.calculator.commands.*;
import com.app.calculator.constants.*;
import com.app.calculator.history.Cash;
import com.app.calculator.history.History;
import com.app.calculator.windows.MemoryWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.List;
import javafx.stage.Stage;

import java.util.ArrayList;

public abstract class Window implements Runnable {
    public Stage stage;
    private History history = new History();
    private Cash cashTwoDigits = new Cash();
    private Cash cashEquel = new Cash();
    private Cash cashMemory = new Cash();
    public GridPane root;
    public Column[] columns;
    public Row[] rows;
    public static int stagePositionX = Position.ARITHMETIC_WINDOW.getHorizontal();
    public static int stagePositionY = Position.ARITHMETIC_WINDOW.getVertical();
    public List<GridPane> list_GridPanes;
    public GridPane subPanel_FirstRow;
    public GridPane subPanel_SecondRow;
    public GridPane subPanel_ThirdRow;
    public GridPane subPanel_FourthRow;
    public GridPane subPanel_FifthRow;
    public GridPane subPanel_SixthRow;
    public GridPane subPanel_SeventhRow;
    public GridPane subPanel_EighthRow;
    public GridPane subPanel_NinthRow;
    public GridPane subPanel_TenthRow;
    public List<Label> list_ElementsRoundingTop;
    public List<Control> list_ElementsRoundingDown;
    public List<Control> list_ElementsFourthRow;
    public List<Control> list_ElementsFifthRow;
    public List<Control> list_ElementsSixthRow;
    public List<Control> list_ElementsSeventhRow;
    public List<Label> list_ElementsSeventhRowTop;
    public List<Control> list_ElementsSeventhRowDown;
    public List<Control> list_ElementsEighthRow;
    public List<Control> list_ElementsNinthRow;
    public List<Control> list_ElementsTenthRow;
    public MenuBar menuBar;
    public Menu menu_Type;
    public Menu menu_Theme;
    public Menu menu_Language;
    public Menu menu_Sound;
    public Button btn_Undo;
    public Button btn_Redo;
    public CheckMenuItem cMI_ArithmeticWindow;
    public CheckMenuItem cMI_TrigonometricWindow;
    public CheckMenuItem cMI_ConvertionWindow;
    public SeparatorMenuItem sMI_SeparatorExit;
    public MenuItem menuItem_Exit;
    public RadioMenuItem rMI_ThemeClassic;
    public RadioMenuItem rMI_ThemeDark;
    public RadioMenuItem rMI_ThemeAnimated;
    public ToggleGroup group_Theme;
    public RadioMenuItem rMI_LanguageEnglish;
    public RadioMenuItem rMI_LanguageUkranian;
    public RadioMenuItem rMI_LanguageRussian;
    public ToggleGroup groupLanguage;
    public RadioMenuItem rMI_SoundOff;
    public RadioMenuItem rMI_SoundOn;
    public ToggleGroup group_Sound;
    public TextField displayField = new TextField();
    public Label label_Space_1 = new Label(" ");
    public Label label_Space_2 = new Label(" ");
    public Label label_Space_3 = new Label(" ");
    public Label label_Space_4 = new Label(" ");
    public Label label_Space_5 = new Label(" ");
    public Label label_Space_6 = new Label(" ");
    public Label label_Space_7 = new Label(" ");
    public Label label_Space_8 = new Label(" ");
    public Label label_Space_9 = new Label(" ");
    public Label label_Up;
    public Label label_FiveDivFour;
    public Label label_Down;
    public Label label_A;
    public Label label_Zero;
    public Label label_Two;
    public Label label_Three;
    public Label label_Four;
    public Label label_F;
    public RadioButton rBtn_Up;
    public RadioButton rBtn_FiveDivFour;
    public RadioButton rBtn_Down;
    public RadioButton rBtn_A;
    public RadioButton rBtn_Zero;
    public RadioButton rBtn_Two;
    public RadioButton rBtn_Three;
    public RadioButton rBtn_Four;
    public RadioButton rBtn_F;
    public ToggleGroup toggleGroup_Left;
    public ToggleGroup toggleGroup_Right;
    public Label label_TypeRounding;
    public Label label_ScaleRounding;
    public Button btn_MC;
    public Button btn_MR;
    public Button btn_MPlus;
    public Button btn_MMinus;
    public Button btn_MS;
    public Button btn_M;
    public Button btn_XToThePowerOfY;
    public Button btn_Sin;
    public Button btn_Cos;
    public Button btn_Tan;
    public Button btn_Log;
    public Button btn_XToThePowerOf1divY;
    public Button btn_SineToThePowerOfNegativeOne;
    public Button btn_CosToThePowerOfNegativeOne;
    public Button btn_TanToThePowerOfNegativeOne;
    public Button btn_Ln;
    public Button btn_Ex;
    public Button btn_Percent;
    public Button btn_Sqrt;
    public Button btn_XSquared;
    public Button btn_OneDivX;
    public Button btn_X3;
    public Button btn_CE;
    public Button btn_C;
    public Button btn_Backspace;
    public Button btn_Div;
    public Button btn_Exp;
    public Button btn_Seven;
    public Button btn_Eight;
    public Button btn_Nine;
    public Button btn_Mult;
    public Button btn_Mod;
    public Button btn_Four;
    public Button btn_Five;
    public Button btn_Six;
    public Button btn_Minus;
    public Button btn_Pi;
    public Button btn_One;
    public Button btn_Two;
    public Button btn_Three;
    public Button btn_Plus;
    public Button btn_Factorial;
    public Button btn_PlusMinus;
    public Button btn_Zero;
    public Button btn_Comma;
    public Button btn_Equals;
    public Button btn_ThreeSpaces;
    public boolean nextDigitShouldBeNew;
    public boolean mStageIsHide = true;
    public Stage mWindow_Stage = null;
    public MemoryWindow m_Window = null;
    Thread mWindowThread = null;
    public Window (Stage stage) {
        this.stage = stage;
        this.stage.setX(stagePositionX);
        this.stage.setY(stagePositionY);

        subPanel_FirstRow = new GridPane();
        subPanel_SecondRow = new GridPane();
        subPanel_ThirdRow = new GridPane();
        subPanel_FourthRow = new GridPane();
        subPanel_FifthRow = new GridPane();
        subPanel_SixthRow = new GridPane();
        subPanel_SeventhRow = new GridPane();
        subPanel_EighthRow = new GridPane();
        subPanel_NinthRow = new GridPane();
        subPanel_TenthRow = new GridPane();

        list_GridPanes = new ArrayList<>();

        list_GridPanes.add(subPanel_FirstRow);
        list_GridPanes.add(subPanel_SecondRow);
        list_GridPanes.add(subPanel_ThirdRow);
        list_GridPanes.add(subPanel_FourthRow);
        list_GridPanes.add(subPanel_FifthRow);
        list_GridPanes.add(subPanel_SixthRow);
        list_GridPanes.add(subPanel_SeventhRow);
        list_GridPanes.add(subPanel_EighthRow);
        list_GridPanes.add(subPanel_NinthRow);
        list_GridPanes.add(subPanel_TenthRow);

        list_ElementsRoundingTop = new ArrayList<>();
        list_ElementsRoundingDown = new ArrayList<>();

        list_ElementsFourthRow = new ArrayList<>();
        list_ElementsFifthRow = new ArrayList<>();
        list_ElementsSixthRow = new ArrayList<>();

        list_ElementsSeventhRow = new ArrayList<>();
        list_ElementsSeventhRowTop = new ArrayList<>();
        list_ElementsSeventhRowDown = new ArrayList<>();

        list_ElementsEighthRow = new ArrayList<>();
        list_ElementsNinthRow = new ArrayList<>();
        list_ElementsTenthRow = new ArrayList<>();

        root = new GridPane();

        root.setPadding(new Insets(Size.TEN_PIXELS.getNumber(),Size.TEN_PIXELS.getNumber(),
                Size.TEN_PIXELS.getNumber(),Size.TEN_PIXELS.getNumber()));
        root.setHgap(Size.FIVE_PIXELS.getNumber());
        root.setVgap(Size.FIVE_PIXELS.getNumber());

        columns = Column.values();
        rows = Row.values();

        menuBar = new MenuBar();
        stretchMenuBar(menuBar);

        menu_Type = new Menu("Calculator");
        menu_Theme = new Menu("Theme");
        menu_Language = new Menu("Language");
        menu_Sound = new Menu("Sound");

        menuBar.getMenus().addAll(menu_Type, menu_Theme, menu_Language, menu_Sound);
        subPanel_FirstRow.add(menuBar,Column.FIRST.getNumber(), Row.FIRST.getNumber());

        cMI_ArithmeticWindow = new CheckMenuItem("Arithmetic");
        addImageToCheckMenuItem(cMI_ArithmeticWindow, "/images/plusminus.png");
        cMI_ArithmeticWindow.setSelected(true);

        cMI_TrigonometricWindow = new CheckMenuItem("Trigonometric");
        addImageToCheckMenuItem(cMI_TrigonometricWindow, "/images/function.png");

        cMI_ConvertionWindow = new CheckMenuItem("Convertion");
        addImageToCheckMenuItem(cMI_ConvertionWindow, "/images/scales.png");

        sMI_SeparatorExit = new SeparatorMenuItem();
        menuItem_Exit = new MenuItem("Exit");
        addImageToMenuItem(menuItem_Exit, "/images/exit.png");

        cMI_ArithmeticWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new CheckMenuItemCommand(Window.this, event));
            }
        });
        cMI_TrigonometricWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new CheckMenuItemCommand(Window.this, event));
            }
        });
        cMI_ConvertionWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new CheckMenuItemCommand(Window.this, event));
            }
        });
        menuItem_Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new ExitCommand(Window.this, event));
            }
        });

        menu_Type.getItems().addAll(cMI_ArithmeticWindow, cMI_TrigonometricWindow,
                                    cMI_ConvertionWindow, sMI_SeparatorExit, menuItem_Exit);

        rMI_ThemeClassic = new RadioMenuItem("Classic");
        rMI_ThemeDark = new RadioMenuItem("Dark");
        rMI_ThemeAnimated = new RadioMenuItem("Animated");
        group_Theme = new ToggleGroup();
        rMI_ThemeClassic.setToggleGroup(group_Theme);
        rMI_ThemeDark.setToggleGroup(group_Theme);
        rMI_ThemeAnimated.setToggleGroup(group_Theme);
        menu_Theme.getItems().addAll(rMI_ThemeClassic, rMI_ThemeDark, rMI_ThemeAnimated);

        rMI_LanguageEnglish = new RadioMenuItem("English");
        rMI_LanguageUkranian = new RadioMenuItem("Українська");
        rMI_LanguageRussian = new RadioMenuItem("Русский");
        groupLanguage = new ToggleGroup();
        rMI_LanguageEnglish.setToggleGroup(groupLanguage);
        rMI_LanguageUkranian.setToggleGroup(groupLanguage);
        rMI_LanguageRussian.setToggleGroup(groupLanguage);
        rMI_LanguageEnglish.setSelected(true);
        menu_Language.getItems().addAll(rMI_LanguageEnglish, rMI_LanguageUkranian, rMI_LanguageRussian);

        rMI_SoundOff = new RadioMenuItem("Sound off");
        rMI_SoundOn = new RadioMenuItem("Sound on");
        group_Sound = new ToggleGroup();
        rMI_SoundOff.setToggleGroup(group_Sound);
        rMI_SoundOn.setToggleGroup(group_Sound);
        rMI_SoundOff.setSelected(true);
        menu_Sound.getItems().addAll(rMI_SoundOff, rMI_SoundOn);

        btn_Undo = new Button();
        btn_Undo.setDisable(true);
        stretchMenuButton(btn_Undo);
        addImageToButton(btn_Undo, "/images/undo.png");
        btn_Undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                undo();
            }
        });

        btn_Redo = new Button();
        btn_Redo.setDisable(true);
        stretchMenuButton(btn_Redo);
        addImageToButton(btn_Redo, "/images/redo.png");
        btn_Redo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                redo();
            }
        });

        displayField.setStyle("-fx-alignment: center-right;");
        displayField.setText("0");
        GridPane.setHgrow(displayField, Priority.ALWAYS);
        GridPane.setVgrow(displayField, Priority.ALWAYS);

        label_Up = new Label("⮤");
        label_FiveDivFour = new Label("5/4");
        label_Down  = new Label("⮧");
        label_A  = new Label("A");
        label_Zero  = new Label("0");
        label_Two  = new Label("2");
        label_Three  = new Label("3");
        label_Four  = new Label("4");
        label_F   = new Label("F");

        list_ElementsRoundingTop.add(label_Space_1);
        list_ElementsRoundingTop.add(label_Up);
        list_ElementsRoundingTop.add(label_FiveDivFour);
        list_ElementsRoundingTop.add(label_Down);
        list_ElementsRoundingTop.add(label_Space_2);
        list_ElementsRoundingTop.add(label_Space_3);
        list_ElementsRoundingTop.add(label_A);
        list_ElementsRoundingTop.add(label_Zero);
        list_ElementsRoundingTop.add(label_Two);
        list_ElementsRoundingTop.add(label_Three);
        list_ElementsRoundingTop.add(label_Four);
        list_ElementsRoundingTop.add(label_F);
        list_ElementsRoundingTop.add(label_Space_4);

        rBtn_Up = new RadioButton();
        rBtn_FiveDivFour = new RadioButton();
        rBtn_Down = new RadioButton();

        rBtn_A = new RadioButton();
        rBtn_Zero = new RadioButton();
        rBtn_Two = new RadioButton();
        rBtn_Three = new RadioButton();
        rBtn_Four = new RadioButton();
        rBtn_F = new RadioButton();


        rBtn_Up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new RoundingModeCommand(Window.this, event));
            }
        });
        rBtn_FiveDivFour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new RoundingModeCommand(Window.this, event));
            }
        });
        rBtn_Down.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new RoundingModeCommand(Window.this, event));
            }
        });

        rBtn_A.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new ScaleCommand(Window.this, event));
            }
        });
        rBtn_Zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new ScaleCommand(Window.this, event));
            }
        });
        rBtn_Two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new ScaleCommand(Window.this, event));
            }
        });
        rBtn_Three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new ScaleCommand(Window.this, event));
            }
        });
        rBtn_Four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new ScaleCommand(Window.this, event));
            }
        });
        rBtn_F.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new ScaleCommand(Window.this, event));
            }
        });

        label_Space_9.setAlignment(Pos.CENTER);
        rBtn_Up.setAlignment(Pos.CENTER);
        rBtn_FiveDivFour.setAlignment(Pos.CENTER);
        rBtn_Down.setAlignment(Pos.CENTER);
        rBtn_A.setAlignment(Pos.CENTER);
        rBtn_Zero.setAlignment(Pos.CENTER);
        rBtn_Two.setAlignment(Pos.CENTER);
        rBtn_Three.setAlignment(Pos.CENTER);
        rBtn_Four.setAlignment(Pos.CENTER);
        rBtn_F.setAlignment(Pos.CENTER);

        label_Space_1.setAlignment(Pos.CENTER);
        rBtn_Up.setAlignment(Pos.CENTER);
        rBtn_FiveDivFour.setAlignment(Pos.CENTER);
        rBtn_Down.setAlignment(Pos.CENTER);
        label_Space_2.setAlignment(Pos.CENTER);
        label_Space_3.setAlignment(Pos.CENTER);
        rBtn_A.setAlignment(Pos.CENTER);
        rBtn_Zero.setAlignment(Pos.CENTER);
        rBtn_Two.setAlignment(Pos.CENTER);
        rBtn_Three.setAlignment(Pos.CENTER);
        rBtn_Four.setAlignment(Pos.CENTER);
        rBtn_F.setAlignment(Pos.CENTER);
        label_Space_4.setAlignment(Pos.CENTER);

        list_ElementsRoundingDown.add(label_Space_5);
        list_ElementsRoundingDown.add(rBtn_Up);
        list_ElementsRoundingDown.add(rBtn_FiveDivFour);
        list_ElementsRoundingDown.add(rBtn_Down);
        list_ElementsRoundingDown.add(label_Space_6);
        list_ElementsRoundingDown.add(label_Space_7);
        list_ElementsRoundingDown.add(rBtn_A);
        list_ElementsRoundingDown.add(rBtn_Zero);
        list_ElementsRoundingDown.add(rBtn_Two);
        list_ElementsRoundingDown.add(rBtn_Three);
        list_ElementsRoundingDown.add(rBtn_Four);
        list_ElementsRoundingDown.add(rBtn_F);
        list_ElementsRoundingDown.add(label_Space_8);


        toggleGroup_Left = new ToggleGroup();
        toggleGroup_Right = new ToggleGroup();

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

        label_TypeRounding = new Label("Mathematical rounding");
        label_TypeRounding.setAlignment(Pos.CENTER);
        GridPane.setHgrow(label_TypeRounding, Priority.ALWAYS);
        GridPane.setVgrow(label_TypeRounding, Priority.ALWAYS);
        subPanel_ThirdRow.setHalignment(label_TypeRounding, HPos.CENTER);
        subPanel_ThirdRow.setValignment(label_TypeRounding, VPos.CENTER);

        label_ScaleRounding = new Label("No rounding");
        label_ScaleRounding.setAlignment(Pos.CENTER);
        GridPane.setHgrow(label_ScaleRounding, Priority.ALWAYS);
        GridPane.setVgrow(label_ScaleRounding, Priority.ALWAYS);
        subPanel_ThirdRow.setHalignment(label_ScaleRounding, HPos.CENTER);
        subPanel_ThirdRow.setValignment(label_ScaleRounding, VPos.CENTER);

        subPanel_ThirdRow.add(label_TypeRounding,0,2, 5, 2);
        subPanel_ThirdRow.add(label_ScaleRounding,5,2,14,2);

        label_TypeRounding.setPrefWidth(Dimension.ARITHMETIC_WINDOW.getWidth() / 2);
        label_ScaleRounding.setPrefWidth(Dimension.ARITHMETIC_WINDOW.getWidth() / 2);

        btn_MC = new Button("MC");
        btn_MR = new Button("MR");
        btn_MPlus = new Button("M+");
        btn_MMinus = new Button("M-");
        btn_MS = new Button("MS");
        btn_M = new Button("M");

        turnOffMCMRM();
        btn_MC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new MemoryCommand(Window.this, event));
            }
        });
        btn_MR.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new MemoryCommand(Window.this, event));
            }
        });
        btn_MPlus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new MemoryCommand(Window.this, event));
            }
        });
        btn_MMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new MemoryCommand(Window.this, event));
            }
        });
        btn_MS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new MemoryCommand(Window.this, event));
            }
        });
        btn_M.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new ShowMemoryCommand(Window.this, event));
            }
        });

        btn_XToThePowerOfY = new Button("x^y");
        btn_Sin = new Button("sin");
        btn_Cos = new Button("cos");
        btn_Tan = new Button("tan");
        btn_Log = new Button("log");


        btn_XToThePowerOfY.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new TwoDigitsCommand(Window.this, event));
            }
        });
        btn_Sin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_Cos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_Tan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_Log.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });



        btn_XToThePowerOf1divY = new Button("x^(1/y)");
        btn_SineToThePowerOfNegativeOne = new Button("arcsin");
        btn_CosToThePowerOfNegativeOne = new Button("arccos");
        btn_TanToThePowerOfNegativeOne = new Button("arctan");
        btn_Ln = new Button("ln");

        btn_XToThePowerOf1divY.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new TwoDigitsCommand(Window.this, event));
            }
        });
        btn_SineToThePowerOfNegativeOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_CosToThePowerOfNegativeOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_TanToThePowerOfNegativeOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_Ln.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });

        btn_Ex = new Button("e^x");
        btn_Percent = new Button("%");
        btn_Sqrt = new Button("√");
        btn_XSquared = new Button("X²");
        btn_OneDivX = new Button("1/X");

        btn_Ex.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_Percent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new PercentCommand(Window.this, event));
            }
        });
        btn_Sqrt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_XSquared.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_OneDivX.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });

        btn_X3 = new Button("x^3");
        btn_CE = new Button("CE");
        btn_C = new Button("C");
        btn_Backspace = new Button("←");
        btn_Div = new Button("÷");

        btn_X3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_CE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new CAndCECommand(Window.this, event));
            }
        });
        btn_C.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new CAndCECommand(Window.this, event));
            }
        });
        btn_Backspace.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new EditDigitCommand(Window.this, event));
            }
        });
        btn_Div.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new TwoDigitsCommand(Window.this, event));
            }
        });

        btn_Exp = new Button("Exp");
        btn_Seven = new Button("7");
        btn_Eight = new Button("8");
        btn_Nine = new Button("9");
        btn_Mult = new Button("╳");

        btn_Exp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new TwoDigitsCommand(Window.this, event));
            }
        });
        btn_Seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new InsertDigitCommand(Window.this, event));
            }
        });
        btn_Eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new InsertDigitCommand(Window.this, event));
            }
        });
        btn_Nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new InsertDigitCommand(Window.this, event));
            }
        });
        btn_Mult.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new TwoDigitsCommand(Window.this, event));
            }
        });

        btn_Mod = new Button("Mod");
        btn_Four = new Button("4");
        btn_Five = new Button("5");
        btn_Six = new Button("6");
        btn_Minus = new Button("-");

        btn_Mod.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new TwoDigitsCommand(Window.this, event));
            }
        });
        btn_Four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new InsertDigitCommand(Window.this, event));
            }
        });
        btn_Five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new InsertDigitCommand(Window.this, event));
            }
        });
        btn_Six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new InsertDigitCommand(Window.this, event));
            }
        });
        btn_Minus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new TwoDigitsCommand(Window.this, event));
            }
        });

        btn_Pi = new Button("π");
        btn_One = new Button("1");
        btn_Two = new Button("2");
        btn_Three = new Button("3");
        btn_Plus = new Button("+");

        btn_Pi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_One.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new InsertDigitCommand(Window.this, event));
            }
        });

        btn_Two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new InsertDigitCommand(Window.this, event));
            }
        });
        btn_Three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new InsertDigitCommand(Window.this, event));
            }
        });
        btn_Plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new TwoDigitsCommand(Window.this, event));
            }
        });

        btn_Factorial = new Button("n!");
        btn_PlusMinus = new Button("±");
        btn_Zero = new Button("0");
        btn_Comma = new Button(",");
        btn_Equals = new Button("=");

        btn_Factorial.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new OneDigitCommand(Window.this, event));
            }
        });
        btn_PlusMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new EditDigitCommand(Window.this, event));
            }
        });
        btn_Zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new InsertDigitCommand(Window.this, event));
            }
        });
        btn_Comma.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new EditDigitCommand(Window.this, event));
            }
        });
        btn_Equals.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                executeCommand(new EqualCommand(Window.this, event));
            }
        });

        btn_ThreeSpaces = new Button("   ");
        btn_ThreeSpaces.setVisible(false);

        nextDigitShouldBeNew = false;

        mWindow_Stage = new Stage();
        m_Window = new MemoryWindow(mWindow_Stage);
        mWindowThread = new Thread(m_Window);
        mWindowThread.start();
        mWindow_Stage.hide();
        mStageIsHide = true;
    }

    public void executeCommand(Command command) {
        history.push(command);
        btn_Undo.setDisable(false);
        System.out.println("H1");
        command.execute();
        System.out.println("H2");
        System.out.println("Command.roundMode " + Command.roundMode);
        System.out.println("Command.scale " + Command.scale);
        System.out.println("S " + history.history);
    }

    public void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        btn_Redo.setDisable(false);

        if (command != null) {
            command.show_PreviousNumber();
        }
    }

    public void redo() {
        if (history.isEmpty()) return;

        //System.out.println("Стек до отмены: " + history.history);

        Command command = history.next();
        btn_Undo.setDisable(false);
        //System.out.println("Стек после отмены: " + history.history);
        if (command != null) {
            command.show_CurrentNumber();
        } else {
            history.currentIndex -= 1;
        }
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

    public void addImageToMenuItem(MenuItem checkMenu, String imagePath) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        checkMenu.setGraphic(imageView);
    }
    public History getHistory() {
        return history;
    }
    public Cash getCashTwoDigits() {
        return cashTwoDigits;
    }
    public Cash getCashEquel() {
        return cashEquel;
    }
    public Cash getCashMemory() {return cashMemory;}
    public void turnOffMCMRM() {
        btn_MC.setDisable(true);
        btn_MR.setDisable(true);
    }
    public void turnOnMCMRM() {
        btn_MC.setDisable(false);
        btn_MR.setDisable(false);
    }
}
