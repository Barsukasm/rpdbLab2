import services.SportRentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.err.close();
        SportRentService service = new SportRentService();

        boolean exit = false;
        int r;

        service.showMenu();
        while (!exit){

            r = Integer.parseInt(reader.readLine());
            switch (r){
                case 0:{
                    exit=true;
                    break;
                }
                case 1:{
                    service.showJournal();
                    break;
                }
                case 2:{
                    service.addRecord();
                    break;
                }
                case 3:{
                    service.closeRecord();
                    break;
                }
                case 4:{
                    service.removeRecordFromJournal();
                    break;
                }
                case 5:{
                    service.searchByParams();
                    break;
                }
                case 6:{
                    service.showAge();
                    break;
                }
                case 7:{
                    service.addNewItem();
                    break;
                }
                case 8:{
                    service.showInventory();
                    break;
                }
                case 9:{
                    service.showClients();
                    break;
                }
                default:{
                    service.showMenu();
                    break;
                }
            }
        }
    }
}
