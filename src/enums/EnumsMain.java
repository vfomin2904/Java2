package enums;

public class EnumsMain {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
    }

    public static String getWorkingHours(DayOfWeek day){
        if(day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)){
            return "Сегодня выходной";
        }
        return String.valueOf((5 - day.ordinal())*8);
    }
}
