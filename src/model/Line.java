package model;

public class Line {
    String firstName;
    String name;
    String patronymic;
    String dateOfBirth;
    long phone;
    char male;

    public Line(String firstName, String name, String patronymic, String dateOfBirth, long phone, char male) {
        this.firstName = firstName;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.male = male;
    }

    public Line() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public char getMale() {
        return male;
    }

    public void setMale(char male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return "<" + firstName + "><"
                + name + "><"
                + patronymic + "><"
                + dateOfBirth + "><"
                + phone + "><"
                + male + ">";
    }
}
