package org.example;

import java.sql.Statement;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Contact {
    public static void main(String[] args) {

        Logger l = Logger.getLogger("kawin");
        Scanner inputobject =new Scanner(System.in);
        boolean condiction = true;
        Phone objectphone = new Phone();
        while (condiction)
        {
            l.info("enter chioce\n1 -> insert a contact\n2 -> delete a contact\n3 -> search a contact\n4 -> Display all contacats\n5 -> Exit");
            int choice = inputobject.nextInt();

            switch (choice) {
                case 1:
                    objectphone.insert();
                    break;
                case 2:
                    objectphone.delete();
                    break;
                case 3:
                     objectphone.search();
                    break;

                case 4:
                    objectphone.display();
                    break;
                case 5:
                    condiction = false;
                    break;
                default:
                    l.info("Invalid choice");
                    condiction = false;
                    break;
            }

        }
    }


}


