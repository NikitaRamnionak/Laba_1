package bsu.rfe.java.group7.lab2.Ramnenok.varС1;

public class Sandwich extends Food
{
    private String filling1 = null;
    private String filling2 = null;
    private Double calories = 0.0;

    public Sandwich(String filling1, String filling2)                       // конструктор
    {
        super("Бутерброд");
        this.filling1 = filling1;
        this.filling2 = filling2;
        par1 = filling1;
        par2 = filling2;
    }
    public String getFilling1()
    {
        return filling1;
    }
    public String getFilling2()
    {
        return filling2;
    }
    public boolean equals(Object arg0)  // переопределние метода сравнения
    {
        if (super.equals(arg0))
        {
            if (!(arg0 instanceof Sandwich)) return false;
            if (!(par1.equals(((Sandwich)arg0).par1))) return false;
            return par2.equals(((Sandwich)arg0).par2);
        } else
            return false;
    }
    public Double calculateCalories()
    {
        calories = 0.0;
        if(filling1.equals("сыр") || filling2.equals("сыр"))
            calories += 40.0;
        if(filling1.equals("помидор") || filling2.equals("помидор"))
            calories += 20.0;
        if(filling1.equals("ветчина") || filling2.equals("ветчина")) {
            calories += 40.0;
        }
        return calories;
    }
    public String toString()
    {
        return super.toString() + " c начинкой: " + filling1 + " и " + filling2;
    }
    public void consume()
    {                      // метод: что произошло с объектом
        System.out.println(this + " съеден");
    }
}