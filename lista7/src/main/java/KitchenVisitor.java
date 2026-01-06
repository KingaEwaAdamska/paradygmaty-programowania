package lista7.java;

import lista7.scala.*;
import java.util.ArrayList;
import java.util.List;

public class KitchenVisitor {
    private List<Spoon> spoons = new ArrayList<>();
    private List<Fork> forks = new ArrayList<>();
    private List<Plate> plates = new ArrayList<>();
    private List<Bowl> bowls = new ArrayList<>();
    private List<Pan> pans = new ArrayList<>();

    public void visit(Spoon spoon) {
        spoons.add(spoon);
    }
    
    public void visit(Fork fork) {
        forks.add(fork);
    }
    
    public void visit(Plate plate) {
        plates.add(plate);
    }
    
    public void visit(Bowl bowl) {
        bowls.add(bowl);
    }
    
    public void visit(Pan pan) {
        pans.add(pan);
    }
    
    public void sort(List<KitchenUtensil> items) {
        for (KitchenUtensil item : items) {
            item.accept(this);
        }
    }
    
    public List<Spoon> getSpoons() {return spoons;}
    public List<Fork> getForks() {return forks;}
    public List<Plate> getPlates() {return plates;}
    public List<Bowl> getBowls() {return bowls;}
    public List<Pan> getPans() {return pans;}

    public <T> List<T> extract(List<T> source, int amount) {
        int toTake = Math.min(source.size(), amount);
        List<T> taken = new ArrayList<>(source.subList(0, toTake));
        source.subList(0, toTake).clear();
        return taken;
    }

    public void displayCount() {
        int totalSpoons = spoons.size();
        int totalForks = forks.size();
        int totalPlates = plates.size();
        int totalBowls = bowls.size();
        int totalPans = pans.size();
        
        System.out.println("=== Liczba nieposortowanych sztućców/naczyń ===");
        System.out.println("Łyżki: " + totalSpoons);
        System.out.println("Widelce: " + totalForks);
        System.out.println("Talerze: " + totalPlates);
        System.out.println("Miseczki: " + totalBowls);
        System.out.println("Patelnie: " + totalPans);
        System.out.println("Łącznie: " + 
            (totalSpoons + totalForks + totalPlates + totalBowls + totalPans));
        System.out.println("==============================================");
    }
}
