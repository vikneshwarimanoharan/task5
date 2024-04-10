package task5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserInterface {
    public String findPetName(String fileName) {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (hasExactlyTwoVowels(line)) {
                    return line;
                }
            }

        } catch (FileNotFoundException e) {
            return "Please give the correct file name";
        } catch (IOException e) {
            return "Error occurred while reading the names from file";
        }
        return ""; // Return empty string if no such name found
    }

    private boolean hasExactlyTwoVowels(String name) {
        int vowelCount = 0;
        for (char ch : name.toLowerCase().toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
        return vowelCount == 2;
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        String fileName = "pet_names.txt"; // Provide the file name here
        String petName = ui.findPetName(fileName);
        System.out.println(petName);
    }
}
