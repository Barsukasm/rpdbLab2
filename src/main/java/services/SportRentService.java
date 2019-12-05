package services;

import dao.*;
import models.Clients;
import models.Inventory;
import models.Rents;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class SportRentService {
    private ClientsDao clientsDao = new ClientsDaoImp();
    private InventoryDao inventoryDao = new InventoryDaoImpl();
    private RentsDao rentsDao = new RentsDaoImpl();

    public SportRentService(){}

    public void showMenu(){
        System.out.println("1. Просмотр журнала проката");
        System.out.println("2. Добавление новой записи журнала проката");
        System.out.println("3. Закрытие записи журнала проката");
        System.out.println("4. Удаление записи из журнала проката");
        System.out.println("5. Поиск снаряжение по типу и размеру");
        System.out.println("6. Просмотр износа снаряжение");
        System.out.println("7. Добавить новое снаряжение");
        System.out.println("8. Просмотр всего снаряжения");
        System.out.println("9. Просмотр списка клиентов");
        System.out.println("0. Выход");
        System.out.println("Любое дугое число - вывод данного меню");
    }

//  1. Просмотр журнала проката
    public void showJournal(){
        List<Rents> journal = rentsDao.showAllRecords();
        for (Rents record : journal) {
            System.out.println("=================================");
            System.out.println(record);
        }
    }

//  2. Добавление новой записи журнала проката
    public void addRecord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Введите номер предмета ");
        int id_item = Integer.parseInt(reader.readLine());
        System.out.println("Введите id клиента ");
        int id_client = Integer.parseInt(reader.readLine());
        System.out.println("Введите имя ");
        String firstName = reader.readLine();
        System.out.println("Введите фамилию ");
        String lastName = reader.readLine();

        rentsDao.addRent(id_client,firstName,lastName,id_item);
    }

//  3. Закрытие записи журнала проката
    public void closeRecord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите номер записи ");
        int id_rent = Integer.parseInt(reader.readLine());

        rentsDao.closeRent(id_rent);
    }

//  4. Удаление записи из журнала проката
    public void removeRecordFromJournal() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите номер записи ");
        int id_rent = Integer.parseInt(reader.readLine());

        rentsDao.removeRecord(id_rent);
    }

//  5. Поиск снаряжение по типу и размеру
    public void searchByParams() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите желаемый тип снаряжения ");
        String type = reader.readLine();
        System.out.println("Введите желаемый размер (0 - если не хотите искать по данному параметру) ");
        int size = Integer.parseInt(reader.readLine());

        List<Inventory> items = inventoryDao.search(size, type);
        for(Inventory item : items){
            System.out.println("=================================================");
            System.out.println(item);
        }
    }

//  6. Просмотр износа снаряжение
    public void showAge(){
        List<Inventory> items = inventoryDao.showAge();
        LocalDate curDate = LocalDate.now();
        for(Inventory item : items){
            System.out.println("=================================================");
            System.out.println(item);
            Period p = item.getDateProd().until(curDate);
            System.out.println("Износ - "+ p.getYears() + " лет, "+p.getMonths()+ " месяцев, "+p.getDays()+" дней.");
        }
    }

//  7. Добавить новое снаряжение
    public void addNewItem() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите тип снаряжения ");
        String type = reader.readLine();
        System.out.println("Введите размер снаряжения ");
        int size = Integer.parseInt(reader.readLine());

        Inventory item = new Inventory(LocalDate.now(),type,size);

        inventoryDao.addItem(item);
    }

//  8. Просмотр всего снаряжения
    public void showInventory(){
        List<Inventory> items = inventoryDao.showInventory();
        for(Inventory item : items){
            System.out.println("=================================================");
            System.out.println(item);
        }
    }

//  9. Просмотр списка клиентов
    public void showClients(){
        List<Clients> clients = clientsDao.showAllClients();
        for(Clients client : clients){
            System.out.println("=================================================");
            System.out.println(client);
        }
    }
}
