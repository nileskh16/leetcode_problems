package com.plural.spring.fundamentals.tij.demo;

import com.plural.spring.fundamentals.tij.annotations.Constraints;
import com.plural.spring.fundamentals.tij.annotations.DBTable;
import com.plural.spring.fundamentals.tij.annotations.SQLString;
import com.plural.spring.fundamentals.tij.models.Region;
import com.plural.spring.fundamentals.tij.simulations.BankTellerSimulation;
import com.plural.spring.fundamentals.tij.utils.Chopstick;
import com.plural.spring.fundamentals.tij.utils.Philosopher;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainDemo {

    public static void main(String[] args) {
        try {
//            processAnnotations(new String[]{"com.plural.spring.fundamentals.tij.models.Employee"});
            String testLine = "john_philip,john.philip@us.com,Michigan,John Philip";
            Character quote = detectQuote(testLine);
           parseCSVLine(',', quote, testLine).forEach(System.out::println);
           runCustomMap();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void runDiningPhilosophers() {
        int size = 5;
        int factor = 5;
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < size - 1; i++) {
            service.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, factor));
        }
        service.execute(new Philosopher(sticks[0], sticks[size - 1], size - 1, factor));
        try {
            TimeUnit.SECONDS.wait(5);
        } catch (InterruptedException exception) {

        }
        service.shutdown();
    }

    private static void runBankSimulator() {
        BankTellerSimulation simulation = new BankTellerSimulation();
        simulation.runBankSimulator();
    }

    private static void processAnnotations(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("No classes provided for the ");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String name : args) {
                Class<?> cl = Class.forName(name);
                DBTable dbTable = cl.getAnnotation(DBTable.class);
                if (Objects.isNull(dbTable)) continue;
                Field[] fields = cl.getDeclaredFields();
                if (fields.length == 0) continue;
                String tableName = dbTable.name();
                if (tableName.isEmpty()) tableName = cl.getName().toUpperCase();
                sb.append("CREATE TABLE ").append(tableName).append("(\n");
                for (Field declaredField : fields) {
                    sb.append(processSingleField(declaredField)).append(",\n");
                }
                sb.append(")");
                System.out.println("Final SQL query \n" + sb.toString());
            }
        }
    }

    private static String processSingleField(Field field) {
        Annotation[] annotations = field.getAnnotations();
        if (annotations.length < 1) return "";
        StringBuilder ans = new StringBuilder();
        for (Annotation annotation : annotations) {
            if (annotation instanceof SQLString) {
                SQLString sqlString = (SQLString) annotation;
                String fieldName = sqlString.name();
                if (fieldName.isEmpty()) fieldName = field.getName().toUpperCase();
                ans.append(fieldName)
                        .append(String.format(" VARCHAR(%d) ", ((SQLString) annotation).value()))
                        .append(processConstraints(sqlString.constraints()));
            }
        }
        return ans.toString();
    }

    private static String processConstraints(Constraints constraints) {
        StringBuilder sb = new StringBuilder();
        if (constraints.isPrimary()) sb.append(" PRIMARY KEY ");
        if (constraints.isUnique()) sb.append(" UNIQUE ");
        if (!constraints.isNull()) sb.append(" NOT NULL ");
        return sb.toString();
    }

    private static Character detectQuote(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 34 || line.charAt(i) == 39) return line.charAt(i);
        }
        return null;
    }

    private static List<String> parseCSVLine(Character delimiter, Character quote, String line) {
        List<String> words = new ArrayList<>();
        if (Objects.isNull(line) || line.isEmpty() || Objects.isNull(delimiter)) return words;
        int start = 0;
        boolean notInsideQuote = true;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == delimiter && notInsideQuote) {
                words.add(line.substring(start, i).replaceAll(String.valueOf(quote), ""));
                start = i + 1;
            } else if (!Objects.isNull(quote) && line.charAt(i) == quote) {
                notInsideQuote = !notInsideQuote;
            }
        }
        if (start < line.length()) words.add(line.substring(start).replaceAll(String.valueOf(quote), ""));
        return words;
    }

    private static void runCustomMap() {
        Map<Region, Integer> map = new HashMap<>();
        Region california = new Region("California", "United States", 1L);
        for (int i = 0; i < 11; i++) {
            map.put(california, 1);
        }
        System.out.println(String.format("Map Key size: %d and map value size: %d", map.keySet().size(), map.values().size()));
    }
}
