package ru.croc.task15.tests;

import org.testng.annotations.Test;
import ru.croc.task15.OrganisationWork;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class OrganisationWorkTest {

    @Test
    private void getProcessingTimeTest() throws IOException {
        String filePath = "src/ru/croc/task15/res/Configuration.txt";
        int programAnswer =  OrganisationWork.parseFromFile(filePath).getTimeOfAppProcess();
        int correctAnswer = 6;

        assertEquals(correctAnswer, programAnswer);
    }
}
