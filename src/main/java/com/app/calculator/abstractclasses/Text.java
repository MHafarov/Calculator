package com.app.calculator.abstractclasses;

import java.util.List;

public abstract class Text {
    public Window window;
    public String calculator;
    public String theme;
    public String language;
    public String sound;
    public String arithmetic;
    public String trigonometric;
    public String convertion;
    public String memoryWindow;
    public String exit;
    public String classic;
    public String dark;
    public String animated;
    public String english;
    public String ukranian;
    public String russian;
    public String soundOff;
    public String soundOn;
    public String roundUP;
    public String mathematicalRounding;
    public String roundDown;
    public String automaticComma;
    public String noChargesAfterCommal;
    public String twoChargesAfterCommal;
    public String threeChargesAfterCommal;
    public String fourChargesAfterCommal;
    public String withoutRounding;
    public String volume;
    public String pressure;
    public String area;
    public String selectCategory;
    public List<String> list_TextLabels;
    public List<String> list_TextCmi;
    public List<String> list_TextMw;
    public List<String> list_TextMi;
    public List<String> list_TextRmi;
    public List<String> list_TextString;

    public Text() {
    }
    public void updateText(Window currentWindow, Text newText) {
        currentWindow.label_Calculator.setText(newText.calculator);
        currentWindow.label_Theme.setText(newText.theme);
        currentWindow.label_Language.setText(newText.language);
        currentWindow.label_Sound.setText(newText.sound);
        //currentWindow.label_category.setText(newText.selectCategory);

        currentWindow.cMI_ArithmeticWindow.setText(newText.arithmetic);
        currentWindow.cMI_TrigonometricWindow.setText(newText.trigonometric);
        currentWindow.cMI_ConvertionWindow.setText(newText.convertion);
        currentWindow.m_Window.text.memoryWindow = newText.memoryWindow;
        currentWindow.menuItem_Exit.setText(newText.exit);

        currentWindow.rMI_ThemeClassic.setText(newText.classic);
        currentWindow.rMI_ThemeDark.setText(newText.dark);
        currentWindow.rMI_ThemeAnimated.setText(newText.animated);
        currentWindow.rMI_LanguageEnglish.setText(newText.english);
        currentWindow.rMI_LanguageUkranian.setText(newText.ukranian);
        currentWindow.rMI_LanguageRussian.setText(newText.russian);
        currentWindow.rMI_SoundOff.setText(newText.soundOff);
        currentWindow.rMI_SoundOn.setText(newText.soundOn);



        ChangeTextRoundingPanel(currentWindow, newText);
        ChangeTextScalePanel(currentWindow, newText);






//        currentWindow.roundUP = newText.roundUP;
//        currentWindow.mathematicalRounding = newText.mathematicalRounding;
//        currentWindow.roundDown = newText.roundDown;
//        currentWindow.automaticComma = newText.automaticComma;
//        currentWindow.noChargesAfterCommal = newText.noChargesAfterCommal;
//        currentWindow.twoChargesAfterCommal = newText.twoChargesAfterCommal;
//        currentWindow.threeChargesAfterCommal = newText.threeChargesAfterCommal;
//        currentWindow.fourChargesAfterCommal = newText.fourChargesAfterCommal;
//        currentWindow.withoutRounding = newText.withoutRounding;
//        currentWindow.volume = newText.volume;
//        currentWindow.pressure = newText.pressure;
//        currentWindow.area = newText.area;







        //        list_LabelsWithText.add(label_TypeRounding);
//        list_LabelsWithText.add(label_ScaleRounding);

//
//
//        list_RmiWithText.add(rMI_ThemeClassic);
//        list_RmiWithText.add(rMI_ThemeDark);
//        list_RmiWithText.add(rMI_ThemeAnimated);
//        list_RmiWithText.add(rMI_LanguageEnglish);
//        list_RmiWithText.add(rMI_LanguageUkranian);
//        list_RmiWithText.add(rMI_LanguageRussian);
//        list_RmiWithText.add(rMI_SoundOff);
//        list_RmiWithText.add(rMI_SoundOn);
//
//        list_StringWithText.add(text.volume);
//        list_StringWithText.add(text.pressure);
//        list_StringWithText.add(text.area);



    }

    public void ChangeTextRoundingPanel(Window window, Text newText) {
        if (window.rBtn_Up.isSelected()) {
            window.label_TypeRounding.setText(newText.roundUP);
            System.out.println("Меняем ВВЕРХ " + newText.roundUP);
        }
        if (window.rBtn_FiveDivFour.isSelected()) {
            window.label_TypeRounding.setText(newText.mathematicalRounding);
            System.out.println("Меняем ВНИЗ " + newText.mathematicalRounding);

        }
        if (window.rBtn_Down.isSelected()) {
            window.label_TypeRounding.setText(newText.roundDown);
            System.out.println("Меняем ВНИЗ " + newText.roundDown);
        }
    }
    public void ChangeTextScalePanel(Window window, Text newText) {
        if (window.rBtn_A.isSelected()) {
            window.label_ScaleRounding.setText(newText.automaticComma);
            Command.scale = 11;
        }
        if (window.rBtn_Zero.isSelected()) {
            window.label_ScaleRounding.setText(newText.noChargesAfterCommal);
            Command.scale = 0;
        }
        if (window.rBtn_Two.isSelected()) {
            window.label_ScaleRounding.setText(newText.twoChargesAfterCommal);
            Command.scale = 2;
        }
        if (window.rBtn_Three.isSelected()) {
            window.label_ScaleRounding.setText(newText.threeChargesAfterCommal);
            Command.scale = 3;
        }
        if (window.rBtn_Four.isSelected()) {
            window.label_ScaleRounding.setText(newText.fourChargesAfterCommal);
            Command.scale = 4;
        }
        if (window.rBtn_F.isSelected()) {
            window.label_ScaleRounding.setText(newText.withoutRounding);
            Command.scale = 11;
        }
    }
}
