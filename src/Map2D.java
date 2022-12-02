/**
 * Класс является картой ячеек по которым перемщается алгоритм A*
 * Класс является представление простой двумерной карты наполненой квадратными ячейками
 * Каждая ячейка определяет стоймость прохождения этой ячейки
 **/
public class Map2D
{
    /** Ширина карты. **/
    private int width;

    /** Высота карты **/
    private int height;

    /**
     * Двумерный массив реалезующий карту данных для алгоритма
     **/
    private int[][] cells;

    /** Локация старта. **/
    private Location start;

    /** Локация финиша. **/
    private Location finish;


    /** Создание через конструкто новой 2D карты с определенной высотой и ширной  **/
    public Map2D(int width, int height)
    {   // Если ширина и высота меньше нуля, вызовем ошибку о недопустимых значениях
        if (width <= 0 || height <= 0)
        {
            throw new IllegalArgumentException(
                    "width and height must be positive values; got " + width +
                    "x" + height);
        }
        // Если ошибка не вызвалась, значить значения подходящие и устанавливаем их
        this.width = width;
        this.height = height;
        // Инициализируем пустую карту
        cells = new int[width][height];
        
        // Создаем локации старта и конца по умолчанию
        start = new Location(0, height / 2);
        finish = new Location(width - 1, height / 2);
    }


    /**
     * Этот воспомогательный метож проверяет спецификацию координат. То есть
     * Что они положительные и при этом меньше ширины или высоты. При некоректности
     * прокидывает ошибку <code>IllegalArgumentException</code>.
     **/
    private void checkCoords(int x, int y)
    {
        if (x < 0 || x > width)
        {
            throw new IllegalArgumentException("x must be in range [0, " + 
                    width + "), got " + x);
        }
        
        if (y < 0 || y > height)
        {
            throw new IllegalArgumentException("y must be in range [0, " + 
                    height + "), got " + y);
        }
    }    
    
    /** Возвращает ширину карты. **/
    public int getWidth()
    {
        return width;
    }
    
    /** Возвращает высоту карты. **/
    public int getHeight()
    {
        return height;
    }
    
    /**
     * Возвращает true, если указанные координаты содержатся на карте.
     **/
    public boolean contains(int x, int y)
    {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }
    
    
    /** Возвращает true, если указанная локация содержтся на карте. **/
    public boolean contains(Location loc)
    {
        return contains(loc.xCoord, loc.yCoord);
    }
    
    /** Возвращает сохраненную стоймость для координат **/
    public int getCellValue(int x, int y)
    {
        checkCoords(x, y);
        return cells[x][y];
    }
    
    /** Возвращает сохраненную стоймость для заданной локации **/
    public int getCellValue(Location loc) { return getCellValue(loc.xCoord, loc.yCoord); }
    
    /** Устанавливает стоимость для заданной ячейки **/
    public void setCellValue(int x, int y, int value)
    {
        checkCoords(x, y);
        cells[x][y] = value;
    }
    
    /**
     * Возвращает локацию старта
     **/
    public Location getStart()
    {
        return start;
    }
    
    /**
     * Устанавливает переданную локацию как локацию старта
     **/
    public void setStart(Location loc)
    {   // Если локация пустая, то вызываем ошибку о нулевом указателя
        if (loc == null)
            throw new NullPointerException("loc cannot be null");
        
        start = loc;
    }

    /**
     * Возвращает локацию финиша
     **/
    public Location getFinish()
    {
        return finish;
    }
    
    /**
     * Устанавливает переданную локацию как локацию финиша
     **/
    public void setFinish(Location loc)
    { // Если локация пустая, то вызываем ошибку о нулевом указателя
        if (loc == null)
            throw new NullPointerException("loc cannot be null");
        
        finish = loc;
    }
}
