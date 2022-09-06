import java.util.*;
import java.lang.*;
import java.lang.reflect.*;

class vehicle {
    public String model;
    public vehicle(String m) { model = m; }
    public String model() { return model; }
    public String toString() { return "Model: " + model; }
}

class motorcycle extends vehicle {
    private int year;
    public motorcycle(String m, int y) {
        super(m);
        year = y;
    }
    public int year() { return this.year; }
    public String toString() { return "Model: " + this.model + "\nYear: " + this.year; }
}

class car extends vehicle {
    private int mpg;
    public car(String m, int g) {
        super(m);
        mpg = g;
    }
    public int mpg() { return this.mpg; }
    public String toString() { return "Model: " + this.model + "\nMPG: " + this.mpg; }
}

class boat extends vehicle {
    private int capacity;
    public boat(String m, int c) {
        super(m);
        capacity = c;
    }
    public int capacity() { return this.capacity; }
    public String toString() { return "Model: " + this.model + "\nCapacity: " + this.capacity; }
}

public class objecttest
{
    public static void main(String[] args)
    throws ClassCastException,
    IllegalAccessException,
    InstantiationException,
    ClassNotFoundException,
    InvocationTargetException
    {
        ArrayList<Class<?>> typelist = new ArrayList<Class<?>>(Arrays.asList(Class.forName(args[0]), Class.forName(args[1]), Class.forName(args[2])));
        String[][] types = {{"motorcycle", "Iron 883", "2021"}, {"car", "Civic", "26"}, {"boat", "Bowrider", "6"}};
        //motorcycle testcar = new motorcycle(3, 2009);
        //System.out.println(typelist.get(0).cast(testcar));
        //System.out.println(typelist.get(0).getClass());
        System.out.println(" ---- My Vehicles ---- ");
        for (int x = 0; x < types.length; x += 1) {
            Class clas = Class.forName(types[x][0]);
            Constructor<?>[] unknown = clas.getConstructors();
            //vehicle harley = motorcycle.class.cast(unknown[0].newInstance(specs[x][0], Integer.parseInt(specs[x][1])));
            vehicle movingthing = vehicle.class.cast(unknown[0].newInstance(types[x][1], Integer.parseInt(types[x][2])));
            System.out.println(movingthing + "\n");
        }
    }
}
