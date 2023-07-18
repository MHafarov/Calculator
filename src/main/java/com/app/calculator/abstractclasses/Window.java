package com.app.calculator.abstractclasses;

import com.app.calculator.constants.Column;
import com.app.calculator.constants.Row;
import com.app.calculator.constants.Size;
import com.app.calculator.history.History;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import java.util.List;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public abstract class Window implements Runnable {
    protected final Stage stage;
    private History history = new History();
    public GridPane root;

    public Column[] columns;
    public Row[] rows;
    public List<GridPane> listGridPanes;
    public GridPane subPanelFirstRow;
    public GridPane subPanelSecondRow;
    public GridPane subPanelThirdRow;
    public GridPane subPanelFourthRow;
    public GridPane subPanelFifthRow;
    public GridPane subPanelSixthRow;
    public GridPane subPanelSeventhRow;
    public GridPane subPanelEighthRow;
    public GridPane subPanelNinthRow;
    public GridPane subPanelTenthRow;

    public MenuBar menuBar;
    public Menu mType;
    public Menu mTheme;
    public Menu mLanguage;
    public Menu mSound;
    public CheckMenuItem cMITrigonometricWindow;
    public CheckMenuItem cMIConvertionWindow;
    public SeparatorMenuItem sMISeparatorExit;
    public MenuItem mIExit;
    public RadioMenuItem rMIThemeClassic;
    public RadioMenuItem rMIThemeDark;
    public RadioMenuItem rMIThemeAnimated;
    public ToggleGroup groupTheme;
    public RadioMenuItem rMILanguageEnglish;
    public RadioMenuItem rMILanguageUkranian;
    public RadioMenuItem rMILanguageRussian;
    public RadioMenuItem rMISoundOff;
    public RadioMenuItem rMISoundOn;
    public ToggleGroup group;


    public ToggleGroup groupLanguage;


    public TextField displayField = new TextField();


    public Window (Stage stage) {
        this.stage = stage;

        subPanelFirstRow = new GridPane();
        subPanelSecondRow = new GridPane();
        subPanelThirdRow = new GridPane();
        subPanelFourthRow = new GridPane();
        subPanelFifthRow = new GridPane();
        subPanelSixthRow = new GridPane();
        subPanelSeventhRow = new GridPane();
        subPanelEighthRow = new GridPane();
        subPanelNinthRow = new GridPane();
        subPanelTenthRow = new GridPane();

        listGridPanes = new ArrayList<>();

        listGridPanes.add(subPanelFirstRow);
        listGridPanes.add(subPanelSecondRow);
        listGridPanes.add(subPanelThirdRow);
        listGridPanes.add(subPanelFourthRow);
        listGridPanes.add(subPanelFifthRow);
        listGridPanes.add(subPanelSixthRow);
        listGridPanes.add(subPanelSeventhRow);
        listGridPanes.add(subPanelEighthRow);
        listGridPanes.add(subPanelNinthRow);
        listGridPanes.add(subPanelTenthRow);

        root = new GridPane();

        root.setPadding(new Insets(Size.TEN_PIXELS.getNumber(),Size.TEN_PIXELS.getNumber(),
                Size.TEN_PIXELS.getNumber(),Size.TEN_PIXELS.getNumber()));
        root.setHgap(Size.FIVE_PIXELS.getNumber());
        root.setVgap(Size.FIVE_PIXELS.getNumber());

        columns = Column.values();
        rows = Row.values();

        for (int i = 0; i < listGridPanes.size(); i++) {
            addSubPanelToRoot(listGridPanes.get(i), root, Column.FIRST, rows[i]);
        }

        menuBar = new MenuBar();
        stretchMenuBar(menuBar);

        mType = new Menu("Calculator");
        mTheme = new Menu("Theme");
        mLanguage = new Menu("Language");
        mSound = new Menu("Sound");

        menuBar.getMenus().addAll(mType, mTheme, mLanguage, mSound);
        subPanelFirstRow.add(menuBar,Column.FIRST.getNumber(), Row.FIRST.getNumber());

        cMITrigonometricWindow = new CheckMenuItem("Trigonometric");
        addImageToCheckMenuItem(cMITrigonometricWindow, "/images/function.png");

        cMIConvertionWindow = new CheckMenuItem("Convertion");
        addImageToCheckMenuItem(cMIConvertionWindow, "/images/scales.png");

        sMISeparatorExit= new SeparatorMenuItem();
        mIExit = new MenuItem("Exit");
        addImageToMenuItem(mIExit, "/images/exit.png");

        mType.getItems().addAll(cMITrigonometricWindow, cMIConvertionWindow,sMISeparatorExit, mIExit);

        rMIThemeClassic = new RadioMenuItem("Classic");
        rMIThemeDark = new RadioMenuItem("Dark");
        rMIThemeAnimated = new RadioMenuItem("Animated");
        groupTheme = new ToggleGroup();
        rMIThemeClassic.setToggleGroup(groupTheme);
        rMIThemeDark.setToggleGroup(groupTheme);
        rMIThemeAnimated.setToggleGroup(groupTheme);
        mTheme.getItems().addAll(rMIThemeClassic, rMIThemeDark, rMIThemeAnimated);

        rMILanguageEnglish = new RadioMenuItem("English");
        rMILanguageUkranian = new RadioMenuItem("Українська");
        rMILanguageRussian = new RadioMenuItem("Русский");
        groupLanguage = new ToggleGroup();
        rMILanguageEnglish.setToggleGroup(groupLanguage);
        rMILanguageUkranian.setToggleGroup(groupLanguage);
        rMILanguageRussian.setToggleGroup(groupLanguage);
        rMILanguageEnglish.setSelected(true);
        mLanguage.getItems().addAll(rMILanguageEnglish, rMILanguageUkranian, rMILanguageRussian);

        rMISoundOff = new RadioMenuItem("Sound off");
        rMISoundOn = new RadioMenuItem("Sound on");
        group = new ToggleGroup();
        rMISoundOff.setToggleGroup(group);
        rMISoundOn.setToggleGroup(group);
        rMISoundOff.setSelected(true);
        mSound.getItems().addAll(rMISoundOff,rMISoundOn);

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
