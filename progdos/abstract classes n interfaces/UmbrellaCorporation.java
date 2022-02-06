public class UmbrellaCorporation
{
    public static void main(String[] args)
    {
        employees[] company = new employees[7];
        company[0] = new lawyer("Connolly", "Mike", "Lawyer", 175000, 34, 155);
        company[1] = new lawyer("Arndt", "David", "Lawyer", 145000, 83, 155);
        company[2] = new engineer("Arient", "John", "Engineer", 129000, 120, 35, 500);
        company[3] = new engineer("Russo", "Aaron", "Engineer", 85000, 35, 35, 125);
        company[4] = new engineer("Shepard", "Sam", "Engineer", 110000, 75, 35, 500);
        company[5] = new guard("Winkler", "Kai", "Guard", 35000, 350);
        company[6] = new guard("Whalen", "Pat", "Guard", 37500, 350);
        
        for (employees person : company) {
            person.yearlypay();
            System.out.println(person);
        }
    }
}