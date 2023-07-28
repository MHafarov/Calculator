package com.app.calculator.abstractclasses;

import com.app.calculator.constants.Column;
import com.app.calculator.constants.Row;
import com.app.calculator.constants.Size;
import com.app.calculator.history.History;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import java.util.List;
import javafx.stage.Stage;

import java.util.ArrayList;

public abstract class Window implements Runnable {
    protected final Stage stage;



    private History history = new History();
    public GridPane root;

    public Column[] columns;
    public Row[] rows;
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
    public List<Control> list_ElementsEleventhRow;
    public List<Control> list_ElementsTwelthRow;
    public MenuBar menuBar;
    public Menu menu_Type;
    public Menu menu_Theme;
    public Menu menu_Language;
    public Menu menu_Sound;

    public Button btn_Undo;
    public Button btn_Redo;


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
    public Label label_Space_10 = new Label(" ");
    public Label label_Space_11 = new Label(" ");
    public Label label_Space_12 = new Label(" ");
    public Label label_Space_13 = new Label(" ");
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

    public Label label_MathematicalRounding;
    public Label label_NoRounding;
    public boolean previousCommandWasSimple;


    public Window (Stage stage) {
        this.stage = stage;

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

        cMI_TrigonometricWindow = new CheckMenuItem("Trigonometric");
        addImageToCheckMenuItem(cMI_TrigonometricWindow, "/images/function.png");

        cMI_ConvertionWindow = new CheckMenuItem("Convertion");
        addImageToCheckMenuItem(cMI_ConvertionWindow, "/images/scales.png");

        sMI_SeparatorExit = new SeparatorMenuItem();
        menuItem_Exit = new MenuItem("Exit");
        addImageToMenuItem(menuItem_Exit, "/images/exit.png");

        menu_Type.getItems().addAll(cMI_TrigonometricWindow, cMI_ConvertionWindow, sMI_SeparatorExit, menuItem_Exit);

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

        label_MathematicalRounding = new Label("Mathematical rounding");
        label_MathematicalRounding.setAlignment(Pos.CENTER);
        GridPane.setHgrow(label_MathematicalRounding, Priority.ALWAYS);
        GridPane.setVgrow(label_MathematicalRounding, Priority.ALWAYS);
        subPanel_ThirdRow.setHalignment(label_MathematicalRounding, HPos.CENTER);
        subPanel_ThirdRow.setValignment(label_MathematicalRounding, VPos.CENTER);

        label_NoRounding = new Label("No rounding");
        label_NoRounding.setAlignment(Pos.CENTER);
        GridPane.setHgrow(label_NoRounding, Priority.ALWAYS);
        GridPane.setVgrow(label_NoRounding, Priority.ALWAYS);
        subPanel_ThirdRow.setHalignment(label_NoRounding, HPos.CENTER);
        subPanel_ThirdRow.setValignment(label_NoRounding, VPos.CENTER);

        System.out.println("Конструктор Window выполнен");

        previousCommandWasSimple = false;

    }

    public void executeCommand(Command command) {
        history.push(command);
        btn_Undo.setDisable(false);
        command.execute();
    }

    public void undo() {
        if (history.isEmpty()) return;

        //System.out.println("Стек до отмены: " + history.history);

        Command command = history.pop();
        btn_Redo.setDisable(false);
       //System.out.println("Стек после отмены: " + history.history);
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

}
