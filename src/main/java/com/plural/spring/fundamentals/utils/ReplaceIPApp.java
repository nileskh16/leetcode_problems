package com.plural.spring.fundamentals.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReplaceIPApp {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide all arguments");
        }

        String filePath = args[0];
        String oldIpAddress = args[1];
        String newIpAddress = args[2];

        ReplaceIPApp replaceIPApp = new ReplaceIPApp();
        try {
            String updatedContent = replaceIPApp.replaceAddresses(filePath, oldIpAddress, newIpAddress);
            replaceIPApp.updateContent(filePath, updatedContent);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private String replaceAddresses(String filepath, String old, String updated) throws Exception {
        String content = "";
        try (FileReader fileReader = new FileReader(filepath);
             BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            StringBuilder oldBuilder = new StringBuilder("");
            while ((line = br.readLine()) != null) {
                oldBuilder.append(line).append(System.lineSeparator());
            }
            content = oldBuilder.toString();
            content = content.replaceAll(old, updated);
        } catch (IOException ex) {
            System.out.println("Could not read file " + ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        return content;
    }

    private void updateContent(String filePath, String content) throws Exception {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
            System.out.printf("File %s updated successfully.%n", filePath);
        } catch (IOException ex) {
            System.out.println("Could not read file " + ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
