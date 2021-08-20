package com.jvm.study;

public class Moim {
    int maxNumberOfMember;
    int numberOfCurrentEnrollment;

    public boolean isEnrollmentFull() {
        if (numberOfCurrentEnrollment == 0) {
            return false;
        }

        if (numberOfCurrentEnrollment < maxNumberOfMember) {
            return false;
        }

        return true;
    }
}
