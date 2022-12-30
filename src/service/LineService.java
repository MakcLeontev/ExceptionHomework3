package service;

import model.Line;
import myexception.WrongDataException;

import java.awt.*;
import java.util.ArrayList;

public class LineService {
    String line;

    public LineService(String line) {
        this.line = line;
    }

    public LineService() {
    }

    public long lengthLine(String line) {
        String[] data = line.split(" ");
        if (data.length < 6) {
            return -1;
        } else if (data.length > 6) {
            return 1;
        } else {
            return 0;
        }
    }

    public Line validate(String line) {
        String firstName = null;
        String name = null;
        String patronymic = null;
        String dateOfBirth = null;
        long phone = 0;
        char male = '0';
        int iter = 0;
        String[] data = line.split(" ");
        for (String str : data) {
            String regex = "[0-9]+";
            String regex2 = "[a-zA-Zа-яА-Я]+";
            String[] date;
            if (str.length() > 1) {
                if (str.matches(regex)) {
                    if (phone == 0)
                        try {
                            phone = Long.parseLong(str);
                        } catch (NumberFormatException e) {
                            throw new WrongDataException("телефон");
                        }
                    else {
                        throw new WrongDataException("телефон двойная запись");
                    }
                }
                if (str.matches(regex2)) {
                    if (iter == 0) {
                        firstName = str;
                    }
                    if (iter == 1) {
                        name = str;
                    }
                    if (iter == 2) {
                        patronymic = str;
                    }
                    if (iter >= 3) {
                        throw new WrongDataException("ФИО");
                    }
                    iter++;
                }
                if (str.contains(".")) {
                    int count = 0;
                    char dot = '.';
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == dot) {
                            count++;
                        }
                    }
                    if (count != 2) {
                        throw new WrongDataException("дата: проверьте формат дд.мм.гггг");
                    }
                    if (str.length() != 10) {
                        throw new WrongDataException("дата: проверьте формат дд.мм.гггг");
                    } else {
                        date = str.split("\\.");
                        if (date[0].length() != 2) {
                            throw new WrongDataException("дата: день");
                        }
                        if (date[1].length() != 2) {
                            throw new WrongDataException("дата: месяц");
                        }
                        if (date[2].length() != 4) {
                            throw new WrongDataException("дата: год");
                        }
                        try {
                            int day = Integer.parseInt(date[0]);
                            int month = Integer.parseInt(date[1]);
                            int year = Integer.parseInt(date[2]);
                            if (day < 0 || day > 31) {
                                throw new WrongDataException("дата: день");
                            }
                            if (month < 0 || month > 12) {
                                throw new WrongDataException("дата: месяц");
                            }
                            if (year < 1900 || year > 2022) {
                                throw new WrongDataException("дата: год");
                            }
                        } catch (NumberFormatException e) {
                            throw new WrongDataException("дата");
                        }
                    }
                    if (dateOfBirth == null) {
                        dateOfBirth = str;
                    } else {
                        throw new WrongDataException("дата: двойная запись");
                    }
                }
            } else if (str.toLowerCase().equals("f")) {
                if (male == '0') {
                    male = 'f';
                } else {
                    throw new WrongDataException("пол: двойная запись");
                }
            } else if (str.toLowerCase().equals("m")) {
                if (male == '0') {
                    male = 'm';
                } else {
                    throw new WrongDataException("пол: двойная запись");
                }
            } else {
                throw new WrongDataException("пол");
            }
        }
        if (firstName == null){throw new WrongDataException("ФИО");}
        if (name == null){throw new WrongDataException("ФИО");}
        if (patronymic == null){throw new WrongDataException("ФИО");}
        if (dateOfBirth == null){throw new WrongDataException("дата");}
        if (phone == 0){throw new WrongDataException("телефон");}
        if (male == '0'){throw new WrongDataException("пол");}
        return new Line(firstName, name, patronymic, dateOfBirth, phone, male);
    }
}
