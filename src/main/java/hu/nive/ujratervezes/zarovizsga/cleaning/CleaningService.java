package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    private List<Clenable> cleanables = new ArrayList<>();

    public void add(Clenable cleanable){
    cleanables.add(cleanable);
    }

    public List<Clenable> getCleanables() {
        return new ArrayList<>(cleanables);
    }

    public int cleanAll(){
        int price = 0;
        for (Clenable c : cleanables){
            price+=c.clean();
        }
        cleanables.clear();
        return price;
    }

    public int cleanOnlyOffices(){
        int price = 0;
        Iterator<Clenable> iterator = cleanables.iterator();
        while(iterator.hasNext()) {
            Clenable clenable = iterator.next();

            if(clenable.getType() == BuildingType.OFFICE){
                price+=clenable.clean();
                iterator.remove();
            }

        }
        return price;
    }

    public List<Clenable> findByAddressPart(String address){
        List<Clenable> result = new ArrayList<>();

        for(Clenable c : cleanables){
            if(c.getAddress().contains(address)){
                result.add(c);
            }

        }return result;
    }

    public String getAddresses(){
        if(cleanables.size()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cleanables.get(0).getAddress());

        for (int i = 1; i <cleanables.size();i++) {
            sb.append(", ").append(cleanables.get(i).getAddress());
        }
        return sb.toString();
    }

}
