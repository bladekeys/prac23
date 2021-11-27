package com.company;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String csv = "src/final_transaction_table.csv";
        String[] line;
        double sumincome = 0;
        double sumoutgo = 0;
        Map<String, Integer> map = new HashMap<>();
        String csvSplit = ", ";

        CSVReader reader = new CSVReader(new FileReader(csv));
        while ((line = reader.readNext()) != null) {
            if (line != null) {

                String[] str = Arrays.toString(line).split(csvSplit);
                String in = str[6];
                String bank = str[16];
                String out = str[5];
                double a = Double.parseDouble(in);
                double b = Double.parseDouble(out);
                sumincome = sumincome + a;
                sumoutgo = sumoutgo + b;
                if (map.containsKey(bank)) {
                    map.put(bank, map.get(bank) + Math.abs((int)b));
                } else {
                    map.put(bank, Math.abs((int)b));
                }
            }
        }
        System.out.println("Сумма расходов: = " + Math.abs((int)sumoutgo));
        System.out.println("Сумма доходов: = " + (int)sumincome);
        System.out.println("Сумма расходов по организациям");
        System.out.println(map);
    }
}
