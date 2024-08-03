package com.app.calculator.abstractclasses;

import java.util.ArrayList;
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

        this.list_TextLabels = new ArrayList<>();
        this.list_TextCmi = new ArrayList<>();
        this.list_TextMw = new ArrayList<>();
        this.list_TextMi = new ArrayList<>();
        this.list_TextRmi = new ArrayList<>();
        this.list_TextString = new ArrayList<>();
    }
    public void initList() {
        this.list_TextLabels.clear();
        this.list_TextCmi.clear();
        this.list_TextMw.clear();
        this.list_TextMi.clear();
        this.list_TextRmi.clear();
        this.list_TextString.clear();

        list_TextLabels.add(calculator);
        list_TextLabels.add(theme);
        list_TextLabels.add(language);
        list_TextLabels.add(sound);
       // list_TextLabels.add(selectCategory);

        list_TextCmi.add(arithmetic);
        list_TextCmi.add(trigonometric);
        list_TextCmi.add(convertion);

        list_TextMw.add(memoryWindow);

        list_TextMi.add(exit);

        list_TextRmi.add(classic);
        list_TextRmi.add(dark);
        list_TextRmi.add(animated);
        list_TextRmi.add(english);
        list_TextRmi.add(ukranian);
        list_TextRmi.add(russian);
        list_TextRmi.add(soundOff);
        list_TextRmi.add(soundOn);

//        list_TextLabels.add(roundUP);
//        list_TextLabels.add(mathematicalRounding);
//        list_TextLabels.add(roundDown);
//        list_TextLabels.add(automaticComma);
//        list_TextLabels.add(noChargesAfterCommal);
//        list_TextLabels.add(twoChargesAfterCommal);
//        list_TextLabels.add(threeChargesAfterCommal);
//        list_TextLabels.add(fourChargesAfterCommal);
//        list_TextLabels.add(withoutRounding);

        list_TextString.add(volume);
        list_TextString.add(pressure);
        list_TextString.add(area);

        System.out.println("Внутри initList " + list_TextLabels.size());
    }


    public void chooseText(Window currentWindow, Text newText) {

        for (int i = 0; i < window.list_LabelsWithText.size(); i++) {
            System.out.println("current 1 " + window.list_LabelsWithText.get(i).getText());
            System.out.println("new 1 " + newText.list_TextLabels.get(i));
            window.list_LabelsWithText.get(i).setText(newText.list_TextLabels.get(i));
        }
        for (int i = 0; i < window.list_CmiWithText.size(); i++) {
            System.out.println("current 2 " + window.list_CmiWithText.get(i).getText());
            System.out.println("new 2 " + newText.list_TextCmi.get(i));
            window.list_CmiWithText.get(i).setText(newText.list_TextCmi.get(i));
        }
        for (int i = 0; i < window.list_MwWithText.size(); i++) {
            System.out.println("current 3 " + window.list_MwWithText.get(i).stage.getTitle());
            System.out.println("new 3 " + newText.list_TextMw.get(i));
            window.list_MwWithText.get(i).stage.setTitle(newText.list_TextMw.get(i));
        }
        for (int i = 0; i < window.list_MiWithText.size(); i++) {
            System.out.println("current 4 " + window.list_MiWithText.get(i).getText());
            System.out.println("new 4 " + newText.list_TextMi.get(i));
            window.list_MiWithText.get(i).setText(newText.list_TextMi.get(i));
        }
        for (int i = 0; i < window.list_RmiWithText.size(); i++) {
            System.out.println("current 5 " + window.list_RmiWithText.get(i).getText());
            System.out.println("new 5 " + newText.list_TextRmi.get(i));
            window.list_RmiWithText.get(i).setText(newText.list_TextRmi.get(i));
        }
        for (int i = 0; i < window.list_StringWithText.size(); i++) {
            System.out.println("current 6 " + window.list_StringWithText.get(i));
            System.out.println("new 6 " + newText.list_TextString.get(i));
            window.list_StringWithText.set(i, newText.list_TextString.get(i));
        }

    }
}
