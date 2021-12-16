package utils;

public class APIPayloadConstants {

    public static String createEmployeePayload(){

        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Aaliyah\",\n" +
                "  \"emp_lastname\": \"Smith\",\n" +
                "  \"emp_middle_name\": \"Andrea\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1989-09-11\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"API Tester\"\n" +
                "}";

        return createEmployeePayload;
    }
}
