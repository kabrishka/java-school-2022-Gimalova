package ru.croc.task15.tests;

import org.testng.annotations.Test;
import ru.croc.task15.OrganisationWork;

import static org.testng.AssertJUnit.assertEquals;

public class OrganisationWorkTest {

    @Test
    private void getProcessingTimeTest(){
        String filePath = "src/ru/croc/task15/res/Configuration.txt";
        int programAnswer =  OrganisationWork.getWorkTime(filePath);
        int correctAnswer = 6;

        assertEquals(correctAnswer, programAnswer);
    }
}
