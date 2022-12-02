/**
 Класс отвечает за координаты одной ячейки.
 Координаты целочисленные, положительные.
 **/
public class Location
{
    /** X  **/
    public int xCoord;

    /** Y  **/
    public int yCoord;


    /** Конструктор с параметрами. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Конструктор без параметров, ставит значения 0 0 **/
    public Location(){  this(0, 0);   }
    
    /** Метод сравнеия двух ячеек на равенство **/
    public boolean equals(Object obj) {
        
        // Переданный объект класса Object является реалезацией класса Location
        if (obj instanceof Location) {
            
            // Приведение из класса Object к классу Location,
            Location other = (Location) obj;
            // Проверка равенства координат. Если координаты равны, возвращает True иначе False
            if (xCoord == other.xCoord && yCoord == other.yCoord) {
                return true;
            }
        }
        return false;
    }

    /** Получение хеш-кода локации. **/
    public int hashCode() {
        int result = 17; // Берем некоторое простое число
        
        // Используем другое простое число для умножения и прибавляем координаты
        result = 37 * result + xCoord;
        result = 37 * result + yCoord;
        return result;
    }
}
