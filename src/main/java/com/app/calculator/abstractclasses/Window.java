package com.app.calculator.abstractclasses;

import com.app.calculator.constants.Column;
import com.app.calculator.constants.Row;
import com.app.calculator.constants.Size;
import com.app.calculator.history.History;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
    public List<Label> list_ElementsThirdRowTop;
    public List<Control> list_ElementsThirdRowDown;
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
    public Label label_Space = new Label(" ");


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

        list_ElementsThirdRowTop = new ArrayList<>();
        list_ElementsThirdRowDown = new ArrayList<>();

        list_ElementsFourthRow = new ArrayList<>();
        list_ElementsFifthRow = new ArrayList<>();
        list_ElementsSixthRow = new ArrayList<>();

        list_ElementsSeventhRow = new ArrayList<>();
        list_ElementsSeventhRowTop = new ArrayList<>();
        list_ElementsSeventhRowDown = new ArrayList<>();

        list_ElementsEighthRow = new ArrayList<>();
        list_ElementsNinthRow = new ArrayList<>();
        list_ElementsTenthRow = new ArrayList<>();
        list_ElementsEleventhRow = new ArrayList<>();
        list_ElementsTwelthRow = new ArrayList<>();

        root = new GridPane();

        root.setPadding(new Insets(Size.TEN_PIXELS.getNumber(),Size.TEN_PIXELS.getNumber(),
                Size.TEN_PIXELS.getNumber(),Size.TEN_PIXELS.getNumber()));
        root.setHgap(Size.FIVE_PIXELS.getNumber());
        root.setVgap(Size.FIVE_PIXELS.getNumber());

        columns = Column.values();
        rows = Row.values();

        for (int i = 0; i < list_GridPanes.size(); i++) {
            addSubPanelToRoot(list_GridPanes.get(i), root, Column.FIRST, rows[i]);
        }

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

    }

    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    public void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        if (command != null) {
            command.undo();
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

}
