package com.jvm.study;

import org.junit.Assert;
import org.junit.Test;

public class MoimTest {
    @Test
    public void isFullTest() {
        Moim moim = new Moim();
        moim.maxNumberOfMember = 100;
        moim.numberOfCurrentEnrollment = 10;

        Assert.assertFalse(moim.isEnrollmentFull());
    }
}