package learn.ensmini.domain.employee.exception.enums;

import lombok.Getter;

@Getter
public enum EmployeeErrorEnums {
    NOT_FOUND_EMPLOYEE(2000);


    private final int value;

    EmployeeErrorEnums(int value) {
        this.value = value;
    }
}
