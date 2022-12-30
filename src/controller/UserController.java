package controller;

import model.Line;
import myexception.WrongDataException;
import service.FileService;
import service.LineService;


public class UserController {
    LineService lineService = new LineService();
    FileService fileService = new FileService();

    public UserController() {
    }

    public void createRecord(String line) {
        long er = lineService.lengthLine(line);
        Line record = new Line();
        if (er == -1) {
            throw new WrongDataException("код ошибки -1:Введено мало данных, проверьте");
        } else if (er == 1) {
            throw new WrongDataException("код ошибки 1:Введено много данных, проверьте");
        } else {
            record = lineService.validate(line);
        }
        if (fileService.availabilityFile(record.getFirstName())) {
            fileService.writeFile(record.getFirstName(), record.toString());
        } else {
            fileService.createFile(record.getFirstName());
            fileService.writeFile(record.getFirstName(), record.toString());
        }
    }
}
