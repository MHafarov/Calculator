package com.app.calculator.text;

import com.app.calculator.abstractclasses.Text;
import com.app.calculator.abstractclasses.Window;

public class TextRussian extends Text {
    public TextRussian(Window window){
        this.window = window;
        this.calculator = "Калькулятор";
        this.theme = "Тема";
        this.language = "Язык";
        this.sound = "Звук";
        this.arithmetic = "Арифметический";
        this.trigonometric = "Тригонометрический";
        this.convertion = "Перевод единиц";
        this.memoryWindow = "Окно памяти";
        this.exit = "Выход";
        this.classic = "Классическая";
        this.dark = "Темная";
        this.animated = "Анимированная";
        this.english = "Английский";
        this.ukranian = "Украинский";
        this.russian = "Русский";
        this.soundOff = "Звук выключен";
        this.soundOn = "Звук включен";
        this.roundUP = "Округление вверх";
        this.mathematicalRounding = "Математическое округление";
        this.roundDown = "Округление вниз";
        this.automaticComma = "Запятая ставится автоматически";
        this.noChargesAfterCommal = "Нет знаков после запятой";
        this.twoChargesAfterCommal = "Два знака после запятой";
        this.threeChargesAfterCommal = "Три знака после запятой";
        this.fourChargesAfterCommal = "Четыре знака после запятой";
        this.withoutRounding = "Без округления";
        this.volume = "Объем";
        this.pressure = "Давление";
        this.area = "Площадь";
        this.selectCategory = "Виберите Категорию: ";
        initList();
//        chooseText(this.window, this);
//
//        System.out.println("this.calculator " + this.calculator);
//        for(String x: list_TextLabels) {
//            System.out.println("list_TextButtons i " + x);
//        }
//        System.out.println("list_TextButtons i " + list_TextLabels.size());
    }
}