package cf.eima.app;

import java.io.*;
import java.util.Scanner;

public class sprint {

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        File relativeFile = new File("./data/employees.csv");
        try {
            Scanner sc = new Scanner(System.in);
            FileReader fileReader = new FileReader(relativeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine = bufferedReader.readLine();
            System.out.println(fileLine);
            System.out.println("Enter your name: ");
            String name = sc.nextLine();
            System.out.println("Enter expected salary: ");
            int salary = sc.nextInt();

            FileWriter fw = null;
            fw = new FileWriter(relativeFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(name);
            bw.write(salary);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
